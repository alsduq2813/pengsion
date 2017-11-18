package spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.bean.Payment;
import spring.bean.Reservation;

@Repository("ReserveDao")
public class ReserveDaoImpl implements ReserveDao{
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private PensionDao pensionDao;
	
	private ResultSetExtractor<Reservation> extractor = new ResultSetExtractor<Reservation>() {
		public Reservation extractData(ResultSet rs) throws SQLException, DataAccessException{
			//rs.next()가 이루어지지 않은 상태로 들어오기 때문에 내가 직접 처리해야 한다
			if(rs.next())
				return new Reservation(rs);
			else
				return null;
		}
	};
	private ResultSetExtractor<Payment> extractor2 = new ResultSetExtractor<Payment>() {
		public Payment extractData(ResultSet rs) throws SQLException, DataAccessException{
			//rs.next()가 이루어지지 않은 상태로 들어오기 때문에 내가 직접 처리해야 한다
			if(rs.next())
				return new Payment(rs);
			else
				return null;
		}
	};
	
	
	public int reserveation_insert(HttpServletRequest request, String[] ids, String id) {
		
		String sql = "select payment_seq.nextval from dual";
		int payment_no = jdbcTemplate.queryForObject(sql, Integer.class);
		
		Payment payment = new Payment();
		payment.setPayment_no(payment_no);
		String pension_no = request.getParameter("pension_no");
		payment.setPension_no(pension_no == null?0:Integer.parseInt(pension_no));
		payment.setMember_no(memberDao.member_no(id));
		payment.setPension_name(pensionDao.nameSearch(payment.getPension_no()));
		payment.setGuest_name(request.getParameter("user_name"));
		payment.setMobile01(request.getParameter("mobile01"));
		payment.setMobile02(request.getParameter("mobile02"));
		String payment_price = request.getParameter("total");
		payment.setPayment_price(payment_price == null?0:Integer.parseInt(payment_price));
		payment.setPayment_method(request.getParameter("payment_method"));
		payment.setPayment_condition("waiting");
		log.debug("payment:{}", payment);
		sql = "insert into payment values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, sysdate)";
		Object[] args = {
				payment.getPayment_no(), payment.getPension_no(), payment.getMember_no(),
				payment.getPension_name(), payment.getGuest_name(),
				payment.getMobile01(), payment.getMobile02(),
				payment.getPayment_price(), payment.getPayment_method(),
				payment.getPayment_condition()
		};
		boolean result2 = jdbcTemplate.update(sql, args)>0;
		
		
		
		List<Reservation> reservation_list = new ArrayList<Reservation>();
		int count = 0;
		for(int i = 0; i<ids.length;i++) {
			Reservation reservation = new Reservation();
			sql = "select reservation_seq.nextval from dual";
			int reservation_no = jdbcTemplate.queryForObject(sql, Integer.class);
			
			String room_no = request.getParameter(ids[i]+"room_no");
			reservation.setRoom_no(room_no == null?0:Integer.parseInt(room_no));
			reservation.setPayment_no(payment_no);
			reservation.setReservation_no(reservation_no);
			reservation.setRoom_name(request.getParameter(ids[i]+"room_name"));
			reservation.setCheckin(request.getParameter(ids[i]+"checkin"));
			String room_price = request.getParameter(ids[i]+"price");
			reservation.setRoom_price(room_price == null?0:Integer.parseInt(room_price));
			String adult = request.getParameter(ids[i]+"adult");
			reservation.setAdult(adult == null?0:Integer.parseInt(adult));
			String child = request.getParameter(ids[i]+"child");
			reservation.setChild(child == null?0:Integer.parseInt(child));
			String baby = request.getParameter(ids[i]+"baby");
			reservation.setBaby(baby == null?0:Integer.parseInt(baby));
			String add_adult = request.getParameter(ids[i]+"add_adult");
			reservation.setAdd_adult(add_adult == null?0:Integer.parseInt(add_adult));
			String add_child = request.getParameter(ids[i]+"add_child");
			reservation.setAdd_child(add_child == null?0:Integer.parseInt(add_child));
			String add_baby = request.getParameter(ids[i]+"add_baby");
			reservation.setAdd_baby(add_baby == null?0:Integer.parseInt(add_baby));
			reservation_list.add(reservation);
			sql = "insert into reservation values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Object[] args2 = {
					reservation.getRoom_no(), reservation.getPayment_no(), reservation.getReservation_no(),
					reservation.getRoom_name(), reservation.getCheckin(), reservation.getRoom_price(),
					reservation.getAdult(), reservation.getChild(), reservation.getBaby(),
					reservation.getAdd_adult(), reservation.getAdd_child(), reservation.getAdd_baby()
			};
			log.debug("reservation:{}", reservation);
			boolean result1 = jdbcTemplate.update(sql, args2)>0;
			if(result1) {
				count++;
			}
		}
		
		
		
		if(count == ids.length && result2) {
			return payment_no;
		}
		return 0;
	}

	public void pcEdit(int reservation_no, String payment_condition) {
		String sql = "update reservation set payment_condition=? where reservation_no=?";
		Object[] args = {payment_condition, reservation_no};
		jdbcTemplate.update(sql, args);
	}

	public Reservation info(int reservation_no) {
		String sql = "select * from reservation where reservation_no=?";
		Object[] args = {reservation_no};
		return jdbcTemplate.query(sql, args, extractor);
	}

	@Override
	public Payment payment_info(int payment_no) {
		String sql = "select * from payment where payment_no=?";
		Object[] args = {payment_no};
		return jdbcTemplate.query(sql, args, extractor2);
	}

	@Override
	public List<Reservation> reservation_list(int payment_no) {
		String sql = "select * from reservation where payment_no=?";
		Object[] args = {payment_no};
		RowMapper<Reservation> mapper = (rs, index)->{
			return new Reservation(rs);
		};
		
		return jdbcTemplate.query(sql, args, mapper);
	}
	
}

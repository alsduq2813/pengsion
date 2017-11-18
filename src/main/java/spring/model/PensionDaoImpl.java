package spring.model;


import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.bean.Pension;
import spring.bean.Reservation;
import spring.bean.Room;
import spring.bean.State;

@Repository("pensionDao")
public class PensionDaoImpl implements PensionDao{
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ServletContext servletContext;
	
	
	private ResultSetExtractor<Pension> extractor = new ResultSetExtractor<Pension>() {
		public Pension extractData(ResultSet rs) throws SQLException, DataAccessException{
			//rs.next()가 이루어지지 않은 상태로 들어오기 때문에 내가 직접 처리해야 한다
			if(rs.next())
				return new Pension(rs);
			else
				return null;
		}
	};
	
	private ResultSetExtractor<Room> extractor2 = new ResultSetExtractor<Room>() {
		public Room extractData(ResultSet rs) throws SQLException, DataAccessException{
			//rs.next()가 이루어지지 않은 상태로 들어오기 때문에 내가 직접 처리해야 한다
			if(rs.next())
				return new Room(rs);
			else
				return null;
		}
	};
	
	private ResultSetExtractor<Reservation> extractor3 = new ResultSetExtractor<Reservation>() {
		public Reservation extractData(ResultSet rs) throws SQLException, DataAccessException{
			//rs.next()가 이루어지지 않은 상태로 들어오기 때문에 내가 직접 처리해야 한다
			if(rs.next())
				return new Reservation(rs);
			else
				return null;
		}
	};
	
	
	@Override
	public int insert(int company_no, MultipartHttpServletRequest mRequest) {
		String sql = "select pension_seq.nextval from dual";
		int pension_no = jdbcTemplate.queryForObject(sql, Integer.class);
		sql ="insert into pension values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, ?, ?, ?, 0)";
		
		Pension pension = new Pension(mRequest, company_no);
		Long time = System.currentTimeMillis();

		
		Object[] args = {
				company_no, pension_no, pension.getPension_name(),
				pension.getPhone(), pension.getPickup(), pension.getGuide(), pension.getCaution(),
				pension.getBank(), pension.getAccount(), pension.getDepositor(), pension.getPeak_start(),
				pension.getPeak_end(), "["+pension_no+"]"+"("+time+")"+pension.getPhoto1(), 
				"["+pension_no+"]"+"("+time+")"+pension.getPhoto2(), "["+pension_no+"]"+"("+time+")"+pension.getPhoto3(), 
				"["+pension_no+"]"+"("+time+")"+pension.getPhoto4(), "["+pension_no+"]"+"("+time+")"+pension.getPhoto5(), 
				pension.getLocation01(), pension.getLocation02(), pension.getLocation03()
		};
		
		boolean result = jdbcTemplate.update(sql, args)>0;
		if(result) {
			
		}
		
		
		// TODO Auto-generated method stub
		return 0;
	}
	
//	public int insert(int company_no, Pension pension) {
//		String sql = "select pension_seq.nextval from dual";
//		int pension_no = jdbcTemplate.queryForObject(sql, Integer.class);
//		
//		sql ="insert into pension values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?, ?, 0, ?, ?, ?)";
//
//		Long time = System.currentTimeMillis();
//		Object[] args = {
//				company_no, pension_no, pension.getPension_name(),
//				pension.getPhone(), pension.getPickup(), pension.getGuide(), pension.getCaution(),
//				pension.getBank(), pension.getAccount(), pension.getDepositor(), pension.getPeak_start(),
//				pension.getPeak_end(), "["+pension_no+"]"+"("+time+")"+pension.getPhoto1(), 
//				"["+pension_no+"]"+"("+time+")"+pension.getPhoto2(), "["+pension_no+"]"+"("+time+")"+pension.getPhoto3(), 
//				"["+pension_no+"]"+"("+time+")"+pension.getPhoto4(), "["+pension_no+"]"+"("+time+")"+pension.getPhoto5(), 
//				pension.getLocation01(), pension.getLocation02(), pension.getLocation03()
//		};
//		jdbcTemplate.update(sql, args);
//		return pension_no;
//	}


	@Override
	public List<Pension> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public Pension info(int pension_no) {
		String sql = "select * from pension where pension_no=?";
		Object[] args = {pension_no};
		return jdbcTemplate.query(sql, extractor, args);
	}

	public List<Pension> list_latest() {
		String sql = "select * from pension order by read desc";
		RowMapper<Pension> mapper = (rs, index)->{
			return new Pension(rs);
		};
		return jdbcTemplate.query(sql, mapper);
	}

	
	public void plusRead(int pension_no) {
		String sql = "update pension set read=read+1 where pension_no=?";
		Object[] args = {pension_no};
		jdbcTemplate.update(sql, args);
	}

	public List<Pension> myPension(int company_no) {
		String sql = "select * from pension where company_no=?";
		Object[] args = {company_no};
		RowMapper<Pension> mapper = (rs, index)->{
			return new Pension(rs);
		};
		return jdbcTemplate.query(sql, args, mapper);
	}


	@Override
	public void update(MultipartHttpServletRequest mRequest, Pension pension) throws IllegalStateException, IOException {
		String sql = "update pension set pension_name=?, location01=?, location02=?, location03=?, phone=?,"
				+ " pickup=?, guide=?, caution=?, bank=?, account=?, depositor=?, peak_start=?, peak_end=?,"
				+ " photo1=?, photo2=?, photo3=?, photo4=?, photo5=? where pension_no=?";
		String phone01 = mRequest.getParameter("mobile1");
		String phone02 = mRequest.getParameter("mobile2");
		String phone03 = mRequest.getParameter("mobile3");
		
		MultipartFile photo1 = mRequest.getFile("photo1");
		MultipartFile photo2 = mRequest.getFile("photo2");
		MultipartFile photo3 = mRequest.getFile("photo3");
		MultipartFile photo4 = mRequest.getFile("photo4");
		MultipartFile photo5 = mRequest.getFile("photo5");
		String p1 = photo1.getOriginalFilename();
		String p2 = photo2.getOriginalFilename();
		String p3 = photo3.getOriginalFilename();
		String p4 = photo4.getOriginalFilename();
		String p5 = photo5.getOriginalFilename();
		
		Long time = System.currentTimeMillis();
		String pension_no = mRequest.getParameter("pension_no"); 
		
		String path = servletContext.getRealPath("/upload")+"/"+"["+pension.getPension_no()+"]"+pension.getPension_name();
		
		File new_file = new File(path);
		
		if(!new_file.exists()) {
			new_file.mkdirs();
		}
				 
		File old_file;
		if(p1.equals("")) {
			p1 = mRequest.getParameter("origin_p1");
		}else {
			old_file = new File(path, mRequest.getParameter("origin_p1"));
			if(old_file.exists()) {
				old_file.delete();
			}
			p1 = "["+pension_no+"]"+"("+time+")"+p1;
			new_file = new File(path, p1);
			photo1.transferTo(new_file);
		}
		if(p2.equals("")) {
			p2 = mRequest.getParameter("origin_p2");
		}else {
			old_file = new File(path, mRequest.getParameter("origin_p2"));
			if(old_file.exists()) {
				old_file.delete();
			}
			p2 = "["+pension_no+"]"+"("+time+")"+p2;
			new_file = new File(path, p2);
			photo2.transferTo(new_file);
		}
		if(p3.equals("")) {
			p3 = mRequest.getParameter("origin_p3");
		}else {
			old_file = new File(path, mRequest.getParameter("origin_p3"));
			if(old_file.exists()) {
				old_file.delete();
			}
			p3 = "["+pension_no+"]"+"("+time+")"+p3;
			new_file = new File(path, p3);
			photo3.transferTo(new_file);
		}
		if(p4.equals("")) {
			p4 = mRequest.getParameter("origin_p4");
		}else {
			old_file = new File(path, mRequest.getParameter("origin_p4"));
			if(old_file.exists()) {
				old_file.delete();
			}
			p4 = "["+pension_no+"]"+"("+time+")"+p4;
			new_file = new File(path, p4);
			photo4.transferTo(new_file);
		}
		if(p5.equals("")) {
			p5 = mRequest.getParameter("origin_p5");
		}else {
			old_file = new File(path, mRequest.getParameter("origin_p5"));
			if(old_file.exists()) {
				old_file.delete();
			}
			p5 = "["+pension_no+"]"+"("+time+")"+p5;
			new_file = new File(path, p5);
			photo5.transferTo(new_file);
		}
		
		Object[] args = {
				mRequest.getParameter("pension_name"),
				mRequest.getParameter("loc01"),
				mRequest.getParameter("loc02"),
				mRequest.getParameter("loc03"),
				phone01+"-"+phone02+"-"+phone03,
				mRequest.getParameter("pickup"),
				mRequest.getParameter("guide"),
				mRequest.getParameter("caution"),
				mRequest.getParameter("bank"),
				mRequest.getParameter("account"),
				mRequest.getParameter("depositor"),
				mRequest.getParameter("peak_start"),
				mRequest.getParameter("peak_end"),
				p1, p2, p3, p4, p5,
				pension_no
		};
		jdbcTemplate.update(sql, args);
	}
	
	 @Override
	   public int companycheck(int pension_no) {
	      String sql = "select company_no from pension where pension_no=?";
	      Object [] args = { pension_no};
	      int Pno = jdbcTemplate.queryForObject(sql, args, Integer.class);
	      return Pno;
	   }


	   @Override
	   public int companycheck(String id) {
	      String sql = "select company_no from company where id=?";
	      Object [] args = {id};
	      int Cno = jdbcTemplate.queryForObject(sql, args, Integer.class);
	      return Cno;
	   }


	@Override
	public Map<String, List<State>> state(int pension_no) {
		String sql = "select * from pension where pension_no=?";
		Object[] args = {pension_no};
		Pension pension = jdbcTemplate.query(sql, extractor, args);
		
		sql = "select * from room where pension_no=?";
		RowMapper<Room> mapper = (rs, index)->{
			return new Room(rs);
		};
		List<Room> room_list = jdbcTemplate.query(sql, args, mapper);

		String[] peak_end = pension.getPeak_end().split("-");
		Calendar c1 = Calendar.getInstance();
		c1.set(Integer.parseInt(peak_end[0]), Integer.parseInt(peak_end[1])-1, Integer.parseInt(peak_end[2]));
		Date d1 = new Date(c1.getTimeInMillis());
		
		Date today = new Date();
		
		String[] peak_start = pension.getPeak_start().split("-");
		Calendar c2 = Calendar.getInstance();
		c2.set(Integer.parseInt(peak_start[0]), Integer.parseInt(peak_start[1])-1, Integer.parseInt(peak_start[2]));
		Date d2 = new Date(c2.getTimeInMillis());
		
		SimpleDateFormat format01 = new SimpleDateFormat("yy/MM/dd");
		SimpleDateFormat format02 = new SimpleDateFormat("EEE요일");
		int dayCount = 7;				//표시할 날짜 수
		Map<String, List<State>> reserve_state_list = new HashMap<String, List<State>>();
		log.debug("시작지점:{}", System.currentTimeMillis());

		for(int j = 0; j<room_list.size();j++) {
			List<State> state_list = new ArrayList<State>();
			log.debug("1지점:{}", j+"//"+System.currentTimeMillis());

			for(int i = 0;i<dayCount;i++) {
				State state = new State();
				state.setRoom_no(room_list.get(j).getRoom_no());
				log.debug("2지점:{}", i+"//"+System.currentTimeMillis());

				if(d1.getTime() >= today.getTime()+((long)1000*60*60*24*i) && d2.getTime() <= today.getTime()+((long)1000*60*60*24*i)) {
					state.setSeason("성수기");
				}else {
					state.setSeason("비수기");
				}
				log.debug("3지점:{}", i+"//"+System.currentTimeMillis());

				state.setDate(format01.format(today.getTime()+((long)1000*60*60*24*i)));
				state.setDay(format02.format(today.getTime()+((long)1000*60*60*24*i)));
				if(state.getDay().equals("토요일") && state.getSeason().equals("성수기")) {
					state.setPrice(room_list.get(j).getPeak_weekend());
				} else if (!state.getDay().equals("토요일") && state.getSeason().equals("성수기")) {
					state.setPrice(room_list.get(j).getPeak_weekday());
				} else if (state.getDay().equals("토요일") && state.getSeason().equals("비수기")) {
					state.setPrice(room_list.get(j).getOff_weekend());
				} else {
					state.setPrice(room_list.get(j).getOff_weekday());
				}
				log.debug("4지점:{}", i+"//"+System.currentTimeMillis());

				state.setAdd_adult(room_list.get(j).getAdd_adult());
				state.setAdd_child(room_list.get(j).getAdd_child());
				state.setAdd_baby(room_list.get(j).getAdd_baby());
				state.setGuest(room_list.get(j).getGuest());
				state.setMax_guest(room_list.get(j).getMax_guest());
				log.debug("5지점:{}", i+"//"+System.currentTimeMillis());

				SimpleDateFormat format03 = new SimpleDateFormat("yy/MM/dd");
				String check_day = format03.format(today.getTime()+((long)1000*60*60*24*i));
				sql = "select count(*) from reservation where room_no=? and checkin=?";
				Object[] args2 = {room_list.get(j).getRoom_no(), check_day};
				int count = jdbcTemplate.queryForObject(sql, args2, Integer.class);
				log.debug("6지점:{}", i+"//"+System.currentTimeMillis());

				if(count > 0) {
					state.setReservation("완료");
				} else {
					state.setReservation("가능");
				}
				log.debug("7지점:{}", i+"//"+System.currentTimeMillis());

				state_list.add(state);
			}
			log.debug("8지점:{}", j+"//"+System.currentTimeMillis());

			reserve_state_list.put(room_list.get(j).getRoom_name(), state_list);
		}
		log.debug("끝지점:{}", System.currentTimeMillis());

		return reserve_state_list;
	}

	public List<Reservation> reserveList(int pension_no) {
		String sql = "select * from reservation where pension_no=?";
		Object[] args = {pension_no};
		RowMapper<Reservation> mapper = (rs, index)->{
			return new Reservation(rs);
		};
		return jdbcTemplate.query(sql, args, mapper);
	}


	public String nameSearch(int pension_no) {
		String sql = "select pension_name from pension where pension_no=?";
		Object[] args = {pension_no};
		return jdbcTemplate.queryForObject(sql, args, String.class);
	}


	



	


}

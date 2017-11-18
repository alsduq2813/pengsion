package spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.bean.Company;
import spring.bean.Member;
import spring.bean.Payment;
import spring.bean.Reservation;

@Repository(value="UserDao")
public class MemberDaoImpl implements MemberDao{
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<Member> mapper = new RowMapper<Member>() {
		@Override
		public Member mapRow(ResultSet rs, int index) throws SQLException {
			return new Member(rs);
		}
	};
	
	private ResultSetExtractor<Member> extractor = new ResultSetExtractor<Member>() {
		public Member extractData(ResultSet rs) throws SQLException, DataAccessException{
			//rs.next()가 이루어지지 않은 상태로 들어오기 때문에 내가 직접 처리해야 한다
			if(rs.next())
				return new Member(rs);
			else
				return null;
		}
	};
	
	private ResultSetExtractor<Company> extractor2 = new ResultSetExtractor<Company>() {
		public Company extractData(ResultSet rs) throws SQLException, DataAccessException{
			//rs.next()가 이루어지지 않은 상태로 들어오기 때문에 내가 직접 처리해야 한다
			if(rs.next()) {
				return new Company(rs);
			}else
				return null;
		}
	};
	
	//회원 가입 메소드
		public void insert(Member member){
			String sql = "select member_seq.nextval from dual";
			int member_no = jdbcTemplate.queryForObject(sql, Integer.class);
			sql = "insert into member values(?, ?, ?, ?, ?, ?, sysdate, 5000, '일반', ?)";
			Object[] args = {member_no, member.getId(), member.getName(), member.getPw(), member.getEmail(), member.getMobile(), member.getAgree()};
			jdbcTemplate.update(sql, args);
		}

		public boolean login(String id, String pw){
			String sql = "select count(*) from member where id=? and pw=?";
			Object[] args = {id, pw};
			int count = jdbcTemplate.queryForObject(sql, args, Integer.class);
			return count > 0;
		}
		
		public boolean login_company(String id, String pw) {
			String sql = "select count(*) from company where id=? and pw=?";
			Object[] args = {id, pw};
			int count = jdbcTemplate.queryForObject(sql, args, Integer.class);
			return count > 0;		}
		
		public String findId(String type, String name, String email) {
			String sql;
			
			if(type.equals("user")) {
				sql = "select id from member where name=? and email=?";
			}else {
				sql = "select id from company where name=? and email=?";
			}
			
			Object[] args = {name, email};
			
			return jdbcTemplate.queryForObject(sql, args, String.class);
		}

		public Member info(String id) {
			String sql = "select * from member where id=?";
			Object[] args = {id};
			return jdbcTemplate.query(sql, extractor, args);
		}
		
		public Company info2(String id) {
			String sql = "select * from company where id=?";
			Object[] args = {id};
			return jdbcTemplate.query(sql, extractor2, args);
		}

		public void edit(Member member) {
			String sql = "update member set pw=?, name=?, phone=?, email=? where id=?";
			Object[] args = {member.getPw(), member.getName(), member.getMobile(), member.getEmail(), member.getId()};
			jdbcTemplate.update(sql, args);
		}
		
		public void edit(Company company) {
			String sql = "update company set pw=?, name=?, company_name=?, crn=?, "
					+ "location01=?, location02=?, location03=?, phone=?, mobile=?,  email=?, domain=? where id=?";
			Object[] args = {
					company.getPw(), company.getName(), company.getCompany_name(),
					company.getCrn(), company.getLocation01(), company.getLocation02(), company.getLocation03(),
					company.getPhone(), company.getMobile(), company.getEmail(), company.getDomain(), company.getId()};
			jdbcTemplate.update(sql, args);
		}

		public void insert(Company company) {
			String sql = "select company_seq.nextval from dual";
			int company_no = jdbcTemplate.queryForObject(sql, Integer.class);
			sql = "insert into company values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, ?)";
			Object[] args = {company_no, company.getDomain(), company.getPhone(), company.getCrn(), company.getCompany_name(), company.getEmail(), company.getId(), company.getPw(), company.getName(), company.getMobile(), company.getAgree(), company.getLocation01(), company.getLocation02(), company.getLocation03()};
			jdbcTemplate.update(sql, args);
		}

		public boolean unregister_m(String id, String pw) {
			String sql = "delete member where id=? and pw=?";
			Object[] args = {id, pw};
			return jdbcTemplate.update(sql, args) > 0;
		}
		
		public boolean unregister_c(String id, String pw) {
			String sql = "delete company where id=? and pw=?";
			Object[] args = {id, pw};
			return jdbcTemplate.update(sql, args) > 0;
		}

		public List<Reservation> myReservation(int member_no) {
			String sql = "select * from reservation where member_no=?";
			Object[] args = {member_no};
			RowMapper<Reservation> mapper = (rs, index)->{
				return new Reservation(rs);
			};
			return jdbcTemplate.query(sql, mapper, args);
		}

		public void useMileage(String id, int useMileage) {
			String sql = "update member set mileage=mileage-"+useMileage+" where id=?";
			Object[] args = {id};
			jdbcTemplate.update(sql, args);
		}

		public int member_no(String id) {
			String sql = "select member_no from member where id=?";
			Object[] args = {id};
			return jdbcTemplate.queryForObject(sql, args, Integer.class);
		}

		@Override
		public List<Payment> myPaymentList(int member_no) {
			String sql = "select * from payment where member_no=? order by payment_no desc";
			Object[] args = {member_no};
			RowMapper<Payment> mapper = (rs, index)->{
				return new Payment(rs);
			};
			return jdbcTemplate.query(sql, args, mapper);
		}
		
		public boolean comCk(String id) {
            String sql = "select * from company where id=?";
            Object[] args = {id};
            return jdbcTemplate.update(sql, args) > 0;
         }

		@Override
		public int checkId(String id, String member_type) {
			String sql;
			if(member_type.equals("user")) {
				log.debug("유저");
				sql = "select * from member where id=?";
			}else {
				log.debug("컴패니");
				sql = "select * from company where id=?";
			}
			Object[] args = {id};
			log.debug("count:{}", jdbcTemplate.update(sql, args));
			return jdbcTemplate.update(sql, args);
		}
}

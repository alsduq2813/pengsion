package spring.model;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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
import spring.bean.Room;

@Repository("RoomDao")
public class RoomDaoImpl implements RoomDao{
	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	   private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private ServletContext servletContext;
	
	private ResultSetExtractor<Room> extractor = new ResultSetExtractor<Room>() {
		public Room extractData(ResultSet rs) throws SQLException, DataAccessException{
			//rs.next()가 이루어지지 않은 상태로 들어오기 때문에 내가 직접 처리해야 한다
			if(rs.next())
				return new Room(rs);
			else
				return null;
		}
	};
	

	@Override
	public int insert(Room room) {
		String sql = "select room_seq.nextval from dual";
		int room_no = jdbcTemplate.queryForObject(sql, Integer.class);
		
		sql ="insert into room values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '가능', ?, ?, ?, ?, ?)";
		Long time = System.currentTimeMillis();

		Object[] args = {
				room.getPension_no(), room_no, room.getRoom_name(), room.getStructure(),
				room.getAdd_adult(), 	room.getAdd_child(), room.getAdd_baby(), 
				room.getFacilities(), room.getSpecialnote(),
				room.getOff_weekday(), room.getOff_weekend(), room.getPeak_weekday(), room.getPeak_weekend(),
				room.getGuest(), room.getMax_guest(), 
				"["+room.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+room.getPhoto1(), 
				"["+room.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+room.getPhoto2(), "["+room.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+room.getPhoto3(), 
				"["+room.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+room.getPhoto4(), "["+room.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+room.getPhoto5()
		};
		jdbcTemplate.update(sql, args);
		return room_no;
	}
	
	@Override
	public Room info(int room_no) {
		String sql = "select * from room where room_no=?";
		Object[] args = {room_no};
		return jdbcTemplate.query(sql, extractor, args);
	}

	@Override
	public List<Room> list(int pension_no) {
		String sql = "select * from room where pension_no=?";
		Object[] args = {pension_no};
		RowMapper<Room> mapper = (rs, index)->{
			return new Room(rs);
		};
		return jdbcTemplate.query(sql, args, mapper);
	}
	
	
	public List<Pension> list_latest() {
		String sql = "select * from pension order by read desc";
		RowMapper<Pension> mapper = (rs, index)->{
			return new Pension(rs);
		};
		return jdbcTemplate.query(sql, mapper);
	}
	
	@Override
	public void update(MultipartHttpServletRequest mRequest, Pension pension, int room_no) throws IllegalStateException, IOException {
		String sql = "update room set room_name=?, structure=?, add_adult=?, add_child=?, add_baby=?, "
				+ "off_weekday=?, off_weekend=?, peak_weekday=?, peak_weekend=?, facilities=?, "
				+ "specialnote=?, guest=?, max_guest=?, photo1=?, photo2=?, photo3=?, photo4=?, photo5=? "
				+ "where room_no=?";
		
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
		
		String path = servletContext.getRealPath("/upload")+"/"+"["+pension.getPension_no()+"]"
				+pension.getPension_name()+"/"+mRequest.getParameter("room_name");
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
			p1 = "["+pension.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+p1;
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
			p2 = "["+pension.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+p2;
			new_file = new File(path, p2);
			photo2.transferTo(new_file);
		}
		if(p3.equals("")) {
			p3 = mRequest.getParameter("origin_p3");
		}else {
			old_file = new File(path, mRequest.getParameter("origin_p3"));
			log.debug(mRequest.getParameter("origin_p3"));
			if(old_file.exists()) {
				old_file.delete();
			}
			p3 = "["+pension.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+p3;
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
			p4 = "["+pension.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+p4;
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
			p5 = "["+pension.getPension_no()+"]"+"["+room_no+"]"+"("+time+")"+p5;
			new_file = new File(path, p5);
			photo5.transferTo(new_file);
		}
		

		Object[] args = {
				mRequest.getParameter("room_name"),
				mRequest.getParameter("structure"),
				mRequest.getParameter("add_adult"),
				mRequest.getParameter("add_child"),
				mRequest.getParameter("add_baby"),
				mRequest.getParameter("off_weekday"),
				mRequest.getParameter("off_weekend"),
				mRequest.getParameter("peak_weekday"),
				mRequest.getParameter("peak_weekend"),
				mRequest.getParameter("facilities"),
				mRequest.getParameter("specialnote"),
				mRequest.getParameter("guest"),
				mRequest.getParameter("max_guest"),
				p1, p2, p3, p4, p5,
				room_no
		};
		jdbcTemplate.update(sql, args);
	}
	
	//펜션 검색- 지역/도시검색
			@Override
			public List<Integer> locationcheck(String search) {
				String sql = "select pension_no from pension where location02 like '%'||?||'%'";
				RowMapper<Integer> mapper = (rs, index)->{
					return rs.getInt("pension_no");
				};
				List<Integer> pension= jdbcTemplate.query(sql, mapper, search);
				return pension;
			}


			@Override
			public List<Integer> peoplecheck(int number, int people) {
				String sql = "select room_no from room where pension_no=? and max_guest>=?";
				RowMapper<Integer> mapper = (rs, index)->{
					return rs.getInt("room_no");
				};
				List<Integer> RoomNo = jdbcTemplate.query(sql, mapper, number, people);
				return RoomNo;
			}


			@Override
			public int reservecheck(int room_no, String date) {
				String sql = "select room_no from reservation where room_no=? and checkin=?";
				RowMapper<Integer> mapper = (rs, index)->{
					return rs.getInt("room_no");
				};
				List<Integer> RoomNo = jdbcTemplate.query(sql, mapper, room_no ,date);
				for(int num : RoomNo) {
					if(num == room_no)
						return room_no=0;
				}
				return room_no;
			}

			@Override
			public Room Roominfo(int room_no) {
				String sql = "select * from room where room_no =?";
				Object[] args = {room_no};
				RowMapper<Room> mapper = (rs, index)->{
					return new Room(rs);
				};
				List<Room> room= jdbcTemplate.query(sql, args, mapper);
				Room r1 = room.get(0);
				return r1;
			}

			@Override
			public int checked(int room_no) {
				String sql = "select pension_no from room where room_no=?";
				return jdbcTemplate.queryForObject(sql, Integer.class, room_no);
			}
			
			public List<Room> list(){
				String sql = "select * from room";
				RowMapper<Room> mapper = (rs, index)->{
					return new Room(rs);
				};
				return jdbcTemplate.query(sql, mapper);
			}
			
			public List<Pension> search(){
				String sql = "select pension.pension_name from pension, room where pension.pension_no = room.pension_no order by read desc";
				RowMapper<Pension> mapper = (rs, index)->{
					return new Pension(rs);
				};
				return jdbcTemplate.query(sql, mapper);
			}

}

package spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class Room {
	private int pension_no;
	private int room_no;
	private String room_name;
	private String structure;
	private int add_adult;
	private int add_child;
	private int add_baby;
	private String facilities;
	private String specialnote;
	private int off_weekday;
	private int off_weekend;
	private int peak_weekday;
	private int peak_weekend;
	private int guest;
	private int max_guest;
	private String reservation;
	private String photo1;
	private String photo2;
	private String photo3;
	private String photo4;
	private String photo5;
	
	
	public Room(MultipartHttpServletRequest mRequest) {
		String pension_no = mRequest.getParameter("pension_no");
		setPension_no(pension_no == null?0:Integer.parseInt(pension_no));
		String room_no = mRequest.getParameter("room_no");
		setRoom_no(room_no == null?0:Integer.parseInt(room_no));
		setRoom_name(mRequest.getParameter("room_name"));
		setStructure(mRequest.getParameter("structure"));
		String add_adult = mRequest.getParameter("add_adult");
		setAdd_adult(add_adult == null?0:Integer.parseInt(add_adult));
		String add_child = mRequest.getParameter("add_child");
		setAdd_child(add_child == null?0:Integer.parseInt(add_child));
		String add_baby = mRequest.getParameter("add_baby");
		setAdd_baby(add_baby == null?0:Integer.parseInt(add_baby));
		setFacilities(mRequest.getParameter("facilities"));
		setSpecialnote(mRequest.getParameter("specialnote"));
		String off_weekday = mRequest.getParameter("off_weekday");
		setOff_weekday(off_weekday == null?0:Integer.parseInt(off_weekday));
		String off_weekend = mRequest.getParameter("off_weekend");
		setOff_weekend(off_weekend == null?0:Integer.parseInt(off_weekend));
		String peak_weekday = mRequest.getParameter("peak_weekday");
		setPeak_weekday(peak_weekday == null?0:Integer.parseInt(peak_weekday));
		String peak_weekend = mRequest.getParameter("peak_weekend");
		setPeak_weekend(peak_weekend == null?0:Integer.parseInt(peak_weekend));
		String guest = mRequest.getParameter("guest");
		setGuest(guest == null?0:Integer.parseInt(guest));
		String max_guest = mRequest.getParameter("max_guest");
		setMax_guest(max_guest == null?0:Integer.parseInt(max_guest));
		setReservation(mRequest.getParameter("reservation"));
		MultipartFile photo1 = mRequest.getFile("photo1");
		setPhoto1(photo1.getOriginalFilename());
		MultipartFile photo2 = mRequest.getFile("photo2");
		setPhoto2(photo2.getOriginalFilename());
		MultipartFile photo3 = mRequest.getFile("photo3");
		setPhoto3(photo3.getOriginalFilename());
		MultipartFile photo4 = mRequest.getFile("photo4");
		setPhoto4(photo4.getOriginalFilename());
		MultipartFile photo5 = mRequest.getFile("photo5");
		setPhoto5(photo5.getOriginalFilename());
	}
	
	public Room(ResultSet rs) throws SQLException {
		setPension_no(rs.getInt("pension_no"));
		setRoom_no(rs.getInt("room_no"));
		setRoom_name(rs.getString("room_name"));
		setStructure(rs.getString("structure"));
		setAdd_adult(rs.getInt("add_adult"));
		setAdd_child(rs.getInt("add_child"));
		setAdd_baby(rs.getInt("add_baby"));
		setFacilities(rs.getString("facilities"));
		setSpecialnote(rs.getString("specialnote"));
		setOff_weekday(rs.getInt("off_weekday"));
		setOff_weekend(rs.getInt("off_weekend"));
		setPeak_weekday(rs.getInt("peak_weekday"));
		setPeak_weekend(rs.getInt("peak_weekend"));
		setGuest(rs.getInt("guest"));
		setMax_guest(rs.getInt("max_guest"));
		setReservation(rs.getString("reservation"));
		setPhoto1(rs.getString("photo1"));
		setPhoto2(rs.getString("photo2"));
		setPhoto3(rs.getString("photo3"));
		setPhoto4(rs.getString("photo4"));
		setPhoto5(rs.getString("photo5"));
	}
	
	
	public int getPension_no() {
		return pension_no;
	}
	public void setPension_no(int pension_no) {
		this.pension_no = pension_no;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public int getAdd_adult() {
		return add_adult;
	}
	public void setAdd_adult(int add_adult) {
		this.add_adult = add_adult;
	}
	public int getAdd_child() {
		return add_child;
	}
	public void setAdd_child(int add_child) {
		this.add_child = add_child;
	}
	public int getAdd_baby() {
		return add_baby;
	}
	public void setAdd_baby(int add_baby) {
		this.add_baby = add_baby;
	}
	public String getFacilities() {
		return facilities;
	}
	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}
	public String getSpecialnote() {
		return specialnote;
	}
	public void setSpecialnote(String specialnote) {
		this.specialnote = specialnote;
	}
	public int getOff_weekday() {
		return off_weekday;
	}
	public void setOff_weekday(int off_weekday) {
		this.off_weekday = off_weekday;
	}
	public int getOff_weekend() {
		return off_weekend;
	}
	public void setOff_weekend(int off_weekend) {
		this.off_weekend = off_weekend;
	}
	public int getPeak_weekday() {
		return peak_weekday;
	}
	public void setPeak_weekday(int peak_weekday) {
		this.peak_weekday = peak_weekday;
	}
	public int getPeak_weekend() {
		return peak_weekend;
	}
	public void setPeak_weekend(int peak_weekend) {
		this.peak_weekend = peak_weekend;
	}
	public int getGuest() {
		return guest;
	}
	public void setGuest(int guest) {
		this.guest = guest;
	}
	public int getMax_guest() {
		return max_guest;
	}
	public void setMax_guest(int max_guest) {
		this.max_guest = max_guest;
	}
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public String getPhoto1() {
		return photo1;
	}
	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}
	public String getPhoto2() {
		return photo2;
	}
	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}
	public String getPhoto3() {
		return photo3;
	}
	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}
	public String getPhoto4() {
		return photo4;
	}
	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}
	public String getPhoto5() {
		return photo5;
	}
	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}
	@Override
	public String toString() {
		return "Room [pension_no=" + pension_no + ", room_no=" + room_no + ", room_name=" + room_name + ", structure="
				+ structure + ", add_adult=" + add_adult + ", add_child=" + add_child + ", add_baby=" + add_baby
				+ ", facilities=" + facilities + ", specialnote=" + specialnote + ", off_weekday=" + off_weekday
				+ ", off_weekend=" + off_weekend + ", peak_weekday=" + peak_weekday + ", peak_weekend=" + peak_weekend
				+ ", guest=" + guest + ", max_guest=" + max_guest + ", reservation=" + reservation + ", photo1="
				+ photo1 + ", photo2=" + photo2 + ", photo3=" + photo3 + ", photo4=" + photo4 + ", photo5=" + photo5
				+ "]";
	}
	
}

package spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class Reservation {
	private int room_no;
	private int payment_no;
	private int reservation_no;
	private String room_name;
	private String checkin;
	private int room_price;
	private int adult;
	private int child;
	private int baby;
	private int add_adult;
	private int add_child;
	private int add_baby;
	
	
	public Reservation() {
		super();
	}
	
	public Reservation(String[] ids, HttpServletRequest request) {
		String room_no = request.getParameter("room_no");
		setRoom_no(room_no == null?0:Integer.parseInt(room_no));
		String payment_no = request.getParameter("payment_no");
		setPayment_no(payment_no == null?0:Integer.parseInt(payment_no));
		String reservation_no = request.getParameter("reservation_no");
		setReservation_no(reservation_no == null?0:Integer.parseInt(reservation_no));
		setRoom_name(request.getParameter("room_name"));
		setCheckin(request.getParameter("checkin"));
		String room_price = request.getParameter("room_price");
		setRoom_price(room_price == null?0:Integer.parseInt(room_price));
		String adult = request.getParameter("adult");
		setAdult(adult == null?0:Integer.parseInt(adult));
		String child = request.getParameter("child");
		setChild(child == null?0:Integer.parseInt(child));
		String baby = request.getParameter("baby");
		setBaby(baby == null?0:Integer.parseInt(baby));
		String add_adult = request.getParameter("add_adult");
		setAdd_adult(add_adult == null?0:Integer.parseInt(add_adult));
		String add_child = request.getParameter("add_child");
		setAdd_child(add_child == null?0:Integer.parseInt(add_child));
		String add_baby = request.getParameter("add_baby");
		setAdd_baby(add_baby == null?0:Integer.parseInt(add_baby));
	}
	
	public Reservation(ResultSet rs) throws SQLException {
		setRoom_no(rs.getInt("room_no"));
		setPayment_no(rs.getInt("payment_no"));
		setReservation_no(rs.getInt("reservation_no"));
		setRoom_name(rs.getString("room_name"));
		setCheckin(rs.getString("checkin"));
		setRoom_price(rs.getInt("room_price"));
		setAdult(rs.getInt("adult"));
		setChild(rs.getInt("child"));
		setBaby(rs.getInt("baby"));
		setAdd_adult(rs.getInt("add_adult"));
		setAdd_child(rs.getInt("add_child"));
		setAdd_baby(rs.getInt("add_baby"));
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

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public int getPayment_no() {
		return payment_no;
	}

	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}

	public int getReservation_no() {
		return reservation_no;
	}

	public void setReservation_no(int reservation_no) {
		this.reservation_no = reservation_no;
	}

	public String getRoom_name() {
		return room_name;
	}

	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}

	public String getCheckin() {
		return checkin;
	}
	public String getDate() {
		return checkin.substring(0, 10);
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public int getRoom_price() {
		return room_price;
	}

	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}

	public int getAdult() {
		return adult;
	}

	public void setAdult(int adult) {
		this.adult = adult;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public int getBaby() {
		return baby;
	}

	public void setBaby(int baby) {
		this.baby = baby;
	}

	@Override
	public String toString() {
		return "Reservation [room_no=" + room_no + ", payment_no=" + payment_no + ", reservation_no=" + reservation_no
				+ ", room_name=" + room_name + ", checkin=" + checkin + ", room_price=" + room_price + ", adult="
				+ adult + ", child=" + child + ", baby=" + baby + ", add_adult=" + add_adult + ", add_child="
				+ add_child + ", add_baby=" + add_baby + "]";
	}

	
	
	


}

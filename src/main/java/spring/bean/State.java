package spring.bean;

public class State {
	private int room_no;
	private String season;
	private String date;
	private String day;
	private int price;
	private int add_adult;
	private int add_child;
	private int add_baby;
	private int guest;
	private int max_guest;
	private String reservation;
	
	public State() {
		super();
	}
	
	public State(Room room) {
		setRoom_no(room.getRoom_no());
		setAdd_adult(room.getAdd_adult());
		setAdd_child(room.getAdd_child());
		setAdd_baby(room.getAdd_baby());
		setGuest(room.getGuest());
		setMax_guest(room.getMax_guest());
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
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getReservation() {
		return reservation;
	}
	public void setReservation(String reservation) {
		this.reservation = reservation;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getRoom_id() {
		String room_id = String.valueOf(room_no)+date.substring(0, 2)+date.substring(3, 5)+date.substring(6, 8);
		return room_id;
	}


	@Override
	public String toString() {
		return "State [room_no=" + room_no + ", season=" + season + ", date=" + date
				+ ", day=" + day + ", price=" + price + ", add_adult=" + add_adult + ", add_child=" + add_child
				+ ", add_baby=" + add_baby + ", guest=" + guest + ", max_guest=" + max_guest + ", reservation="
				+ reservation + "]";
	}


	
	
	
	
	
}

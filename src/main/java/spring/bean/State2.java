package spring.bean;

public class State2 {
	private String state_id;
	private String pension_name;
	private int room_no;
	private String room_name;
	private String user_name;
	private String mobile01;
	private String mobile02;
	private String date;
	private int guest;
	private int max_guest;
	private int price;
	private int add_adult;
	private int add_child;
	private int add_baby;
	private int adult;
	private int child;
	private int baby;
	private int tot;
	




	@Override
	public String toString() {
		return "State2 [state_id=" + state_id + ", pension_name=" + pension_name + ", room_no=" + room_no
				+ ", room_name=" + room_name + ", user_name=" + user_name + ", mobile01=" + mobile01 + ", mobile02="
				+ mobile02 + ", date=" + date + ", guest=" + guest + ", max_guest=" + max_guest + ", price=" + price
				+ ", add_adult=" + add_adult + ", add_child=" + add_child + ", add_baby=" + add_baby + ", adult="
				+ adult + ", child=" + child + ", baby=" + baby + ", tot=" + tot + "]";
	}



	public State2() {
		super();
	}
	
	
	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getPension_name() {
		return pension_name;
	}
	public void setPension_name(String pension_name) {
		this.pension_name = pension_name;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getMobile01() {
		return mobile01;
	}
	public void setMobile01(String mobile01) {
		this.mobile01 = mobile01;
	}
	public String getMobile02() {
		return mobile02;
	}
	public void setMobile02(String mobile02) {
		this.mobile02 = mobile02;
	}
	public String getState_id() {
		return state_id;
	}
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
}

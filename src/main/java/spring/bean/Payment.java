package spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class Payment {
	private int payment_no;
	private int pension_no;
	private int member_no;
	private String pension_name;
	private String guest_name;
	private String mobile01;
	private String mobile02;
	private int payment_price;
	private String payment_method;
	private String payment_condition;
	private String payment_reg;
	private String reserve_reg;
	
	public Payment() {
		super();
	}
	
	public Payment(HttpServletRequest request) {
		String payment_no = request.getParameter("payment_no");
		setPayment_no(payment_no == null?0:Integer.parseInt(payment_no));
		String pension_no = request.getParameter("pension_no");
		setPension_no(pension_no == null?0:Integer.parseInt(pension_no));
		String member_no = request.getParameter("member_no");
		setMember_no(member_no == null?0:Integer.parseInt(member_no));
		setPension_name(request.getParameter("pension_name"));
		setGuest_name(request.getParameter("guest_name"));
		setMobile01(request.getParameter("mobile01"));
		setMobile02(request.getParameter("mobile02"));
		String payment_price = request.getParameter("payment_price");
		setPayment_price(payment_price == null?0:Integer.parseInt(payment_price));
		setPayment_method(request.getParameter("payment_method"));
		setPayment_condition(request.getParameter("payment_condition"));
		setPayment_reg(request.getParameter("payment_reg"));
		setReserve_reg(request.getParameter("reserve_reg"));
	}
	
	
	public Payment(ResultSet rs)  throws SQLException{
		setPayment_no(rs.getInt("payment_no"));
		setPension_no(rs.getInt("pension_no"));
		setMember_no(rs.getInt("member_no"));
		setPension_name(rs.getString("pension_name"));
		setGuest_name(rs.getString("guest_name"));
		setMobile01(rs.getString("mobile01"));
		setMobile02(rs.getString("mobile02"));
		setPayment_price(rs.getInt("payment_price"));
		setPayment_method(rs.getString("payment_method"));
		setPayment_condition(rs.getString("payment_condition"));
		setPayment_reg(rs.getString("payment_reg"));
		setReserve_reg(rs.getString("reserve_reg"));
	}
	
	
	
	public int getPayment_no() {
		return payment_no;
	}
	public void setPayment_no(int payment_no) {
		this.payment_no = payment_no;
	}
	public int getPension_no() {
		return pension_no;
	}
	public void setPension_no(int pension_no) {
		this.pension_no = pension_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getPension_name() {
		return pension_name;
	}
	public void setPension_name(String pension_name) {
		this.pension_name = pension_name;
	}
	public String getGuest_name() {
		return guest_name;
	}
	public void setGuest_name(String guest_name) {
		this.guest_name = guest_name;
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
	public int getPayment_price() {
		return payment_price;
	}
	public void setPayment_price(int payment_price) {
		this.payment_price = payment_price;
	}
	public String getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(String payment_method) {
		this.payment_method = payment_method;
	}
	public String getPayment_condition() {
		return payment_condition;
	}
	public void setPayment_condition(String payment_condition) {
		this.payment_condition = payment_condition;
	}
	public String getPayment_reg() {
		return payment_reg;
	}
	public void setPayment_reg(String payment_reg) {
		this.payment_reg = payment_reg;
	}
	public String getReserve_reg() {
		return reserve_reg.substring(0, 19);
	}
	public void setReserve_reg(String reserve_reg) {
		this.reserve_reg = reserve_reg;
	}




	@Override
	public String toString() {
		return "Payment [payment_no=" + payment_no + ", pension_no=" + pension_no + ", member_no=" + member_no
				+ ", pension_name=" + pension_name + ", guest_name=" + guest_name + ", mobile01=" + mobile01
				+ ", mobile02=" + mobile02 + ", payment_price=" + payment_price + ", payment_method=" + payment_method
				+ ", payment_condition=" + payment_condition + ", payment_reg=" + payment_reg + ", reserve_reg="
				+ reserve_reg + "]";
	}
	
	
	
}

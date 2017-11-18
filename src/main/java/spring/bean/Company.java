package spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public class Company {
	private int company_no;
	private String domain;
	private String phone;
	private String crn;
	private String company_name;
	private String location01;
	private String location02;
	private String location03;
	private String email;
	private String id;
	private String pw;
	private String name;
	private String mobile;
	private String reg;
	private String agree;
	
	public Company() {
		super();
	}
	public Company(HttpServletRequest request) {
		String company_no = request.getParameter("company_no");
		setCompany_no(company_no == null?0:Integer.parseInt(company_no));
		setDomain(request.getParameter("domain"));
		String phone01 = request.getParameter("phone01");
		String phone02 = request.getParameter("phone02");
		String phone03 = request.getParameter("phone03");
		setPhone(phone01+"-"+phone02+"-"+phone03);
		setCrn(request.getParameter("crn"));
		setCompany_name(request.getParameter("company_name"));
		setLocation01(request.getParameter("loc01"));
		setLocation02(request.getParameter("loc02"));
		setLocation03(request.getParameter("loc03"));
		String email01 = request.getParameter("email01");
		String email02 = request.getParameter("email02");
		setEmail(email01+"@"+email02);
		setId(request.getParameter("id"));
		setPw(request.getParameter("pw3"));
		setName(request.getParameter("name"));
		String mobile01 = request.getParameter("mobile01");
		String mobile02 = request.getParameter("mobile02");
		String mobile03 = request.getParameter("mobile03");
		setMobile(mobile01+"-"+mobile02+"-"+mobile03);
		setReg(request.getParameter("reg"));
		setAgree(request.getParameter("agree"));
	}
	
	public Company(ResultSet rs) throws SQLException {
		setCompany_no(rs.getInt("company_no"));
		setDomain(rs.getString("domain"));
		setPhone(rs.getString("phone"));
		setCrn(rs.getString("crn"));
		setCompany_name(rs.getString("company_name"));
		setLocation01(rs.getString("location01"));
		setLocation02(rs.getString("location02"));
		setLocation03(rs.getString("location03"));
		setEmail(rs.getString("email"));
		setId(rs.getString("id"));
		setPw(rs.getString("pw"));
		setName(rs.getString("manager_name"));
		setMobile(rs.getString("mobile"));
		setReg(rs.getString("reg"));
		setAgree(rs.getString("agree"));
	}
	
	
	public String getLocation01() {
		return location01;
	}
	public void setLocation01(String location01) {
		this.location01 = location01;
	}
	public String getLocation02() {
		return location02;
	}
	public void setLocation02(String location02) {
		this.location02 = location02;
	}
	public String getLocation03() {
		return location03;
	}
	public void setLocation03(String location03) {
		this.location03 = location03;
	}
	public int getCompany_no() {
		return company_no;
	}
	public void setCompany_no(int company_no) {
		this.company_no = company_no;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getPhone() {
		return phone;
	}
	public String getPhone01() {
		String[] temp = phone.split("-");
		return temp[0];
	}
	public String getPhone02() {
		String[] temp = phone.split("-");
		return temp[1];
	}
	public String getPhone03() {
		String[] temp = phone.split("-");
		return temp[2];
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCrn() {
		return crn;
	}
	public void setCrn(String crn) {
		this.crn = crn;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public String getEmail() {
		return email;
	}
	public String getEmail01() {
		int idx = email.indexOf("@");
		return email.substring(0, idx);
	}
	public String getEmail02() {
		int idx = email.indexOf("@");
		return email.substring(idx+1);
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public String getMobile01() {
		return mobile.substring(0, 3);
	}
	public String getMobile02() {
		return mobile.substring(4, 8);
	}
	public String getMobile03() {
		return mobile.substring(9, 13);
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getReg() {
		return reg;
	}
	public String getDate() {
		return reg.substring(0, 10);
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}
	@Override
	public String toString() {
		return "Company [company_no=" + company_no + ", domain=" + domain + ", phone=" + phone + ", crn=" + crn
				+ ", company_name=" + company_name + ", location01=" + location01 + ", location02=" + location02
				+ ", location03=" + location03 + ", email=" + email + ", id=" + id + ", pw=" + pw + ", name="
				+ name + ", mobile=" + mobile + ", reg=" + reg + ", agree=" + agree + "]";
	}
	
	
}

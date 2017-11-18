package spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Member {
	private Logger log = LoggerFactory.getLogger(getClass());

	private int member_no;
	private String id;
	private String name;
	private String pw;
	private String email;
	private String mobile;
	private String reg;
	private int mileage;
	private String grade;
	private String agree;
	
	public Member() {
		super();
	}
	
	public Member(HttpServletRequest request) {
		String member_no = request.getParameter("member_no");
		setMember_no(member_no == null?0:Integer.parseInt(member_no));
		setId(request.getParameter("id"));
		setName(request.getParameter("name"));
		setPw(request.getParameter("pw3"));
		String email01 = request.getParameter("email01");
		String email02 = request.getParameter("email02");
		setEmail(email01+"@"+email02);
		String mobile01 = request.getParameter("mobile01");
		String mobile02 = request.getParameter("mobile02");
		String mobile03 = request.getParameter("mobile03");
		setMobile(mobile01+"-"+mobile02+"-"+mobile03);
		setReg(request.getParameter("reg"));
		String mileage = request.getParameter("mileage");
		setMileage(mileage == null?0:Integer.parseInt(mileage));
		setGrade(request.getParameter("grade"));
		setAgree(request.getParameter("agree"));
	}
	
	public Member(ResultSet rs) throws SQLException {
		setMember_no(rs.getInt("member_no"));
		setId(rs.getString("id"));
		setName(rs.getString("name"));
		setPw(rs.getString("pw"));
		setEmail(rs.getString("email"));
		setMobile(rs.getString("phone"));
		setReg(rs.getString("reg"));
		setMileage(rs.getInt("mileage"));
		setGrade(rs.getString("grade"));
		setAgree(rs.getString("agree"));
	}
	
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getAgree() {
		return agree;
	}
	public void setAgree(String agree) {
		this.agree = agree;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
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
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Member [member_no=" + member_no + ", id=" + id + ", name=" + name + ", pw=" + pw + ", email=" + email
				+ ", mobile=" + mobile + ", reg=" + reg + ", mileage=" + mileage + ", grade=" + grade + ", agree=" + agree
				+ "]";
	}
	
}

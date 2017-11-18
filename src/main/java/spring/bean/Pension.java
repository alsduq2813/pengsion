package spring.bean;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class Pension {
	public int company_no;
	public int pension_no;
	public String pension_name;
	public String location01;
	public String location02;
	public String location03;
	public String phone;
	public String pickup;
	public String guide;
	public String caution;
	public String bank;
	public String account;
	public String depositor;
	public String peak_start;
	public String peak_end;
	public String reg;
	public String photo1;
	public String photo2;
	public String photo3;
	public String photo4;
	public String photo5;
	public int read;
	
	
	public Pension(MultipartHttpServletRequest mRequest, int company_no) {
		setCompany_no(company_no);
		setPension_name(mRequest.getParameter("pension_name"));
		setLocation01(mRequest.getParameter("loc01"));
		setLocation02(mRequest.getParameter("loc02"));
		setLocation03(mRequest.getParameter("loc03"));
		String phone01 = mRequest.getParameter("mobile1");
		String phone02 = mRequest.getParameter("mobile2");
		String phone03 = mRequest.getParameter("mobile3");
		setPhone(phone01+"-"+phone02+"-"+phone03);
		setPickup(mRequest.getParameter("pickup"));
		setGuide(mRequest.getParameter("guide"));
		setCaution(mRequest.getParameter("caution"));
		setBank(mRequest.getParameter("bank"));
		setAccount(mRequest.getParameter("account"));
		setDepositor(mRequest.getParameter("depositor"));
		setPeak_start(mRequest.getParameter("peak_start"));
		setPeak_end(mRequest.getParameter("peak_end"));
		setReg(mRequest.getParameter("reg"));
		
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
		
		String read = mRequest.getParameter("read");
		setRead(read == null?0:Integer.parseInt(read));
	}
	
	public Pension(ResultSet rs) throws SQLException {
		setCompany_no(rs.getInt("company_no"));
		setPension_no(rs.getInt("pension_no"));
		setPension_name(rs.getString("pension_name"));
		setLocation01(rs.getString("location01"));
		setLocation02(rs.getString("location02"));
		setLocation03(rs.getString("location03"));
		setPhone(rs.getString("phone"));
		setPickup(rs.getString("pickup"));
		setGuide(rs.getString("guide"));
		setCaution(rs.getString("caution"));
		setBank(rs.getString("bank"));
		setAccount(rs.getString("account"));
		setDepositor(rs.getString("depositor"));
		setPeak_start(rs.getString("peak_start"));
		setPeak_end(rs.getString("peak_end"));
		setReg(rs.getString("reg"));
		setPhoto1(rs.getString("photo1"));
		setPhoto2(rs.getString("photo2"));
		setPhoto3(rs.getString("photo3"));
		setPhoto4(rs.getString("photo4"));
		setPhoto5(rs.getString("photo5"));
		setRead(rs.getInt("read"));
	}

	public Pension() {
		super();
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

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getCompany_no() {
		return company_no;
	}
	public void setCompany_no(int company_no) {
		this.company_no = company_no;
	}
	public int getPension_no() {
		return pension_no;
	}
	public void setPension_no(int pension_no) {
		this.pension_no = pension_no;
	}
	public String getPension_name() {
		return pension_name;
	}
	public void setPension_name(String pension_name) {
		this.pension_name = pension_name;
	}
	public String getPhone() {
		return phone;
	}
	public String getPhone01() {
		String[] phone_no = phone.split("-");
		return phone_no[0];
	}
	public String getPhone02() {
		String[] phone_no = phone.split("-");
		return phone_no[1];
	}
	public String getPhone03() {
		String[] phone_no = phone.split("-");
		return phone_no[2];
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPickup() {
		return pickup;
	}
	public void setPickup(String pickup) {
		this.pickup = pickup;
	}
	public String getGuide() {
		return guide;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	public String getCaution() {
		return caution;
	}
	public void setCaution(String caution) {
		this.caution = caution;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getDepositor() {
		return depositor;
	}
	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}
	public String getPeak_start() {
		return peak_start.substring(0, 10);
	}
	public void setPeak_start(String peak_start) {
		this.peak_start = peak_start;
	}
	public String getPeak_end() {
		return peak_end.substring(0, 10);
	}
	public void setPeak_end(String peak_end) {
		this.peak_end = peak_end;
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
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	
	

	

}

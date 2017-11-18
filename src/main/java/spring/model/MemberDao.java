package spring.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import spring.bean.Company;
import spring.bean.Member;
import spring.bean.Payment;
import spring.bean.Reservation;

@Repository
public interface MemberDao {
	void insert(Member member);
	boolean login(String id, String pw);
	String findId(String type, String name, String email);
	Member info(String id);
	void edit(Member member);
	void edit(Company company);
	void insert(Company company);
	boolean login_company(String id, String pw);
	boolean unregister_m(String id, String pw);
	boolean unregister_c(String id, String pw);
	Company info2(String id);
	List<Reservation> myReservation(int member_no);
	void useMileage(String id, int useMileage);
	int member_no(String id);
	List<Payment> myPaymentList(int member_no);
	boolean comCk(String id);
	int checkId(String id, String member_type);

}

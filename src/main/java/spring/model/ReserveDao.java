package spring.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Repository;

import spring.bean.Payment;
import spring.bean.Reservation;

@Repository
public interface ReserveDao {
	int reserveation_insert(HttpServletRequest request, String[] ids, String id);
	void pcEdit(int reservation_no, String payment_condition);
	Reservation info(int reservation_no);
	Payment payment_info(int payment_no);
	List<Reservation> reservation_list(int payment_no);

}

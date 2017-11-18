package spring.model;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.bean.Pension;
import spring.bean.Reservation;
import spring.bean.State;

@Repository
public interface PensionDao {

	List<Pension> list();
	int insert(int company_no, MultipartHttpServletRequest mRequest);
//	int insert(int company_no, Pension pension);
	Pension info(int pension_no);
	List<Pension> list_latest();

	void plusRead(int pension_no);
	List<Pension> myPension(int company_no);
	void update(MultipartHttpServletRequest mRequest, Pension pension)throws IllegalStateException, IOException;
	int companycheck(int pension_no);
	int companycheck(String id);
	Map<String, List<State>> state(int pension_no);
	List<Reservation> reserveList(int pension_no);
	String nameSearch(int pension_no);
}
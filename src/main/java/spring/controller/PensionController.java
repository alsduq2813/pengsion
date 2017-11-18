package spring.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.bean.Answer;
import spring.bean.Company;
import spring.bean.Pension;
import spring.bean.Question;
import spring.bean.Room;
import spring.bean.State;
import spring.model.MemberDao;
import spring.model.MiniDao;
import spring.model.PensionDao;
import spring.model.RoomDao;

@Controller
@RequestMapping("/pension")
public class PensionController {
	
	@Autowired
	private PensionDao pensionDao;
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MiniDao miniDao;

	@Autowired
	private ServletContext servletContext;
	
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	
	@RequestMapping("/pension_register")
	public String pension_register() {
		return "pension/pension_register";
	}
	
	@RequestMapping(value="/pension_register", method=RequestMethod.POST)
	public String register(MultipartHttpServletRequest mRequest, HttpSession session) throws IllegalStateException, IOException {
		String id = (String)session.getAttribute("userId");
		Company company = memberDao.info2(id);
		log.debug("company.getCompany_no:{}",company.getCompany_no());
		int company_no = company.getCompany_no();
		int pension_no = pensionDao.insert(company_no, mRequest);
		
//		int pension_no = pensionDao.insert(company_no, pension);
//		
//		
//		MultipartFile photo1 = mRequest.getFile("photo1");
//		MultipartFile photo2 = mRequest.getFile("photo2");
//		MultipartFile photo3 = mRequest.getFile("photo3");
//		MultipartFile photo4 = mRequest.getFile("photo4");
//		MultipartFile photo5 = mRequest.getFile("photo5");
//		
//		pension = pensionDao.info(pension_no);
//		log.debug(pension.toString());
//		
//		String path = servletContext.getRealPath("/upload")+"/"+"["+pension.getPension_no()+"]"+pension.getPension_name();
//		
//		File target = new File(path);
//		if(!target.exists()) {
//			target.mkdirs();
//		}
//		
//		
//		target = new File(path, pension.getPhoto1());
//		photo1.transferTo(target);
//		target = new File(path, pension.getPhoto2());
//		photo2.transferTo(target);
//		target = new File(path, pension.getPhoto3());
//		photo3.transferTo(target);
//		target = new File(path, pension.getPhoto4());
//		photo4.transferTo(target);
//		target = new File(path, pension.getPhoto5());
//		photo5.transferTo(target);
		
		log.debug("저장 완료");
		
		return "redirect:success";
	}
	
	@RequestMapping("/success")
	public String success() {
		return "pension/success";
	}
	
	@RequestMapping("pension/answer_list")
	public String answerList() {
		return "pension/answer_list";
	}
	
	
	@RequestMapping("/imglook")
	public String imgLook() {
		return "pension/imglook";
	}
	
	@RequestMapping("/management")
	public String management(HttpSession session, Model model) {
		String id = (String)session.getAttribute("userId");
		Company company = memberDao.info2(id);
		
		List<Pension> list = pensionDao.myPension(company.getCompany_no());
		model.addAttribute("company", company);
		model.addAttribute("pension_list", list);
		return "pension/management";
	}
	
	
	@RequestMapping("/pension_edit")
	public String pEdit(@RequestParam int pension_no, Model model) {
		Pension pension = pensionDao.info(pension_no);
		model.addAttribute("pension", pension);
		return "pension/pension_edit";
	}
	
	@RequestMapping(value="/pension_edit", method=RequestMethod.POST)
	public String pEdit(MultipartHttpServletRequest mRequest, @RequestParam int pension_no) throws IllegalStateException, IOException {
		Pension pension = pensionDao.info(pension_no);
		pensionDao.update(mRequest, pension);
		return "redirect:success";
	}
	
	@RequestMapping("/pension_info")
	public String pInfo(@RequestParam int pension_no, HttpSession session, Model model) {
		String id = (String)session.getAttribute("userId");
		int no1 = pensionDao.companycheck(id);
		int no2 = pensionDao.companycheck(pension_no);
		if(no1 == no2) {
			Pension pension = pensionDao.info(pension_no);
			List<Room> room_list = roomDao.list(pension_no);
			model.addAttribute("pension", pension);
			model.addAttribute("room_list", room_list);
			return "pension/pension_info";
		}else
			return "redirect:pension/management";
	}
	
	
	@RequestMapping("/reserve")
	public String reserve(@RequestParam int pension_no, Model model, HttpSession session, HttpServletRequest request) {
		Pension pension = pensionDao.info(pension_no);
		List<Room> room_list = roomDao.list(pension_no);
		model.addAttribute("pension", pension);
		model.addAttribute("room_list", room_list);
		
		int dayCount = 14;				//표시할 날짜 수
		Map<String, List<State>> reserve_state_list = pensionDao.state(pension_no);
		
		model.addAttribute("reserve_state_list", reserve_state_list);
		model.addAttribute("dayCount", dayCount);		//표시할 날짜 수
		
		
		
		int count = 0;
		Enumeration<String> check = session.getAttributeNames();
		while(check.hasMoreElements()){
			if(check.nextElement().equals(String.valueOf(pension_no))){
				count++;
			}
		}
		if(count==0){
			pensionDao.plusRead(pension_no);
			session.setAttribute(String.valueOf(pension_no), pension_no);
		}
		List<Answer> alist = miniDao.alist();
	    session.setAttribute("Alist", alist);
		List<Question> list = miniDao.list(pension_no);
		session.setAttribute("Qlist", list);
		
		return "pension/reserve";
	}
	
	
}


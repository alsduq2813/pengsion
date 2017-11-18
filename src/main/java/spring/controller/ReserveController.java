package spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import spring.bean.Member;
import spring.bean.Payment;
import spring.bean.Reservation;
import spring.bean.State2;
import spring.model.MemberDao;
import spring.model.MiniDao;
import spring.model.PensionDao;
import spring.model.ReserveDao;
import spring.model.RoomDao;

@Controller
@RequestMapping("/reservation")
public class ReserveController {

	@Autowired
	MemberDao memberDao;
	
	@Autowired
	ReserveDao reserveDao;
	
	@Autowired
	PensionDao pensionDao;
	
	@Autowired
	RoomDao roomDao;
	
	@Autowired
	MiniDao miniDao;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	

	@RequestMapping("/reserving")
	public String reserving(HttpSession session, HttpServletRequest request, @RequestParam int pension_no, Model model) {
		String[] ids = request.getParameterValues("id");
		Map<String, List<State2>> state_map = new HashMap<String, List<State2>>();
		for(int i = 0; i<ids.length;i++) {
			State2 state = new State2();
			state.setState_id(ids[i]);
			String room_no = request.getParameter(ids[i]+"room_no");
			log.debug("no:{}", room_no);
			state.setRoom_no(room_no == null?0:Integer.parseInt(room_no));
			state.setRoom_name(request.getParameter(ids[i]+"room_name"));
			state.setDate(request.getParameter(ids[i]+"date"));
			String guest = request.getParameter(ids[i]+"guest");
			state.setGuest(guest == null?0:Integer.parseInt(guest));
			String max_guest = request.getParameter(ids[i]+"max_guest");
			state.setMax_guest(max_guest == null?0:Integer.parseInt(max_guest));
			String price = request.getParameter(ids[i]+"price");
			state.setPrice(price == null?0:Integer.parseInt(price));
			String add_adult = request.getParameter(ids[i]+"add_adult");
			state.setAdd_adult(add_adult == null?0:Integer.parseInt(add_adult));
			String add_child = request.getParameter(ids[i]+"add_child");
			state.setAdd_child(add_child == null?0:Integer.parseInt(add_child));
			String add_baby = request.getParameter(ids[i]+"add_baby");
			state.setAdd_baby(add_baby == null?0:Integer.parseInt(add_baby));
			String adult = request.getParameter(ids[i]+"adult");
			state.setAdult(adult == null?0:Integer.parseInt(adult));
			String child = request.getParameter(ids[i]+"child");
			state.setChild(child == null?0:Integer.parseInt(child));
			String baby = request.getParameter(ids[i]+"baby");
			state.setBaby(baby == null?0:Integer.parseInt(baby));
			String tot = request.getParameter(ids[i]+"tot");
			state.setTot(tot == null?0:Integer.parseInt(tot));
			List<State2> state_list = new ArrayList<State2>();
			state_list.add(state);
			state_map .put(ids[i], state_list);
		}
		int total = Integer.parseInt(request.getParameter("total"));
		
		String id = (String)session.getAttribute("userId");
		Member member = memberDao.info(id);
		model.addAttribute("member", member);
		model.addAttribute("total", total);
		model.addAttribute("state_map", state_map);
		model.addAttribute("pension_no", pension_no);
		return "reservation/reserving";
	}
	
	@RequestMapping("reserving02")
	public String reserving02(HttpServletRequest request, HttpSession session, Model model, @RequestParam int useMileage) {
		String[] ids = request.getParameterValues("id");
		String id = (String)session.getAttribute("userId");
		int total = Integer.parseInt(request.getParameter("total"));
		int payment_no = reserveDao.reserveation_insert(request, ids, id);
		if(payment_no != 0) {
			memberDao.useMileage(id, useMileage);
		}
		Payment payment = reserveDao.payment_info(payment_no);
		List<Reservation> reservation_list = reserveDao.reservation_list(payment_no);
		model.addAttribute("payment", payment);
		model.addAttribute("reservation_list", reservation_list);
		return "reservation/reservation_info";
	}
	
	@RequestMapping(value="reserve_list", method=RequestMethod.GET)
	public String reserveList(@RequestParam int pension_no, Model model) {
		List<Reservation> reservation_list = pensionDao.reserveList(pension_no);
		model.addAttribute("reservation_list", reservation_list);
		return "reservation/reserve_list";
	}
	
	@RequestMapping(value="reserve_list", method=RequestMethod.POST)
	public String reserveList(@RequestParam int reservation_no, @RequestParam int pension_no, HttpServletRequest request, Model model) {
		String payment_condition = request.getParameter("payment_condition");
		reserveDao.pcEdit(reservation_no, payment_condition);
		List<Reservation> reservation_list = pensionDao.reserveList(pension_no);
		model.addAttribute("reservation_list", reservation_list);
		return "redirect:reserve_list?pension_no="+pension_no;
	}
	
	@RequestMapping("/reservation_info")
	public String customer(@RequestParam int payment_no, Model model) {
		List<Reservation> reservation_list = reserveDao.reservation_list(payment_no);
		Payment payment = reserveDao.payment_info(payment_no);
		model.addAttribute("payment", payment);
		model.addAttribute("reservation_list", reservation_list);
		return "reservation/reservation_info";
	}
	
	
	
	
}

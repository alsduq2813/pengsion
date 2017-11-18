package spring.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.bean.Company;
import spring.bean.Member;
import spring.bean.Payment;
import spring.model.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MemberDao memberDao;
	

	@RequestMapping("/user_register01")
	public String user_register01() {
		return "member/user_register01";
		
	}
	
	@RequestMapping(value="/user_register02", method=RequestMethod.GET)
	public String user_register02_1(HttpServletRequest request, Model model) {
		if(request.getParameter("checkbox")==null) {
			model.addAttribute("agree", "안함");
		}else {
			model.addAttribute("agree", "동의");
		}
		return "member/user_register02";
	}
	
	@RequestMapping(value="/user_register02", method=RequestMethod.POST)
	public String user_register02_2(HttpServletRequest request) {
		log.debug("여기");
		String member_type = request.getParameter("member_type");
		if(member_type.equals("user")) {
			Member member = new Member(request);
			memberDao.insert(member);
		}else {
			Company company = new Company(request);
			log.debug("company:{}", company);
			memberDao.insert(company);
		}
			
		return "redirect:user_register03";
	}
	
	@RequestMapping("/user_register03")
	public String user_register03() {
		return "member/user_register03";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, Model model) {
		return "member/user_login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam(required=true) String id,
			@RequestParam(required=true) String pw,
			@RequestParam(required=false) String save,
			@RequestParam(required=true) String member_type,
			HttpSession session,
			HttpServletResponse response) throws IOException {
		
		if(member_type.equals("user")) {
			boolean result = memberDao.login(id, pw);
			if(result) {
				session.setAttribute("userId", id);
				session.setAttribute("loginFlag", true);
				session.setAttribute("companyFlag", false);
				Cookie c = new Cookie("save", id);
				c.setMaxAge(save==null?0:2419200);
				response.addCookie(c);
				return "redirect:/";
			}else {
				response.sendError(500);
				return null;
			}
		}else {
			boolean result = memberDao.login_company(id, pw);
			if(result) {
				session.setAttribute("userId", id);
				session.setAttribute("loginFlag", true);
				session.setAttribute("companyFlag", true);
				Cookie c = new Cookie("save", id);
				c.setMaxAge(save==null?0:2419200);
				response.addCookie(c);
				return "redirect:/";
			}else {
				response.sendError(500);
				return null;
			}
		}
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/myinfo")
	public String myinfo(HttpSession session, Model model) {
		String id = (String)session.getAttribute("userId");
		
		Member member = memberDao.info(id);
		model.addAttribute("member", member);
		
		List<Payment> myPaymentList =memberDao.myPaymentList(member.getMember_no());
		model.addAttribute("myPaymentList", myPaymentList);
		return "member/myinfo";
	}
	
	@RequestMapping("/mileage")
	public String mileage() {
		return "member/mileage";
	}
	
	@RequestMapping("/edit")
	public String edit(HttpSession session, Model model) {
		String id = (String)session.getAttribute("userId");
		if((boolean) session.getAttribute("companyFlag")) {
			Company company = memberDao.info2(id);
			model.addAttribute("info", company);
		}else {
			Member member = memberDao.info(id);
			model.addAttribute("info", member);
		}
		return "member/edit";
	}
	
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String edit(HttpServletRequest request, HttpSession session) {
		
		boolean companyFlag = (boolean)session.getAttribute("companyFlag");
		if(companyFlag) {
			Company company = new Company(request);
			memberDao.edit(company);
			return "redirect:/pension/management";
		}else {
			Member member = new Member(request);
			memberDao.edit(member);
			return "redirect:myinfo";
		}
		
		
		
		
	}
	
	@RequestMapping(value="/unregister", method=RequestMethod.GET)
	public String unregister() {
		return "member/unregister";
	}
	
	@RequestMapping(value="/unregister", method=RequestMethod.POST)
	public String unregister(@RequestParam String pw, HttpSession session, HttpServletResponse response) throws IOException {
		String id = (String)session.getAttribute("userId");
		boolean companyFlag = (boolean)session.getAttribute("companyFlag");
		log.debug(pw);
		if(companyFlag) {
			boolean result = memberDao.unregister_c(id, pw);
			if(result) {
				session.invalidate();
				return "redirect:goodbye";
			}else {
				response.sendError(500);
				return null;
			}
		}else {
			boolean result = memberDao.unregister_m(id, pw);
			if(result) {
				session.invalidate();
				return "redirect:goodbye";
			}else {
				response.sendError(500);
				return null;
			}
		}
		
		
		
	}
	
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "member/goodbye";
	}
	
	@RequestMapping("/findid")
	public String findid() {
		return "member/findid";
	}
	
	@RequestMapping(value="findid", method=RequestMethod.POST)
	public String findid(String type, String name, String email, RedirectAttributes ra) {
		String findedId = memberDao.findId(type, name, email);
		ra.addAttribute("findedId", findedId);
		return "redirect:findid01";
	}
	
	@RequestMapping("/findid01")
	public String findid01(HttpServletRequest request, Model model) {
		String findedId = request.getParameter("findedId");
		model.addAttribute("findedId", findedId);
		return "member/findid01";
	}
	
	@RequestMapping("/findpw")
	public String findpw() {
		return "member/findpw";
	}
	
	@RequestMapping(value="findpw", method=RequestMethod.POST)
	public String findpw(String type, String id, String name, String email) {
		return "redirect:findpw01";
	}
	
	@RequestMapping("/findpw01")
	public String findpw01() {
		return "member/findpw01";
	}
	
	@ResponseBody
	@RequestMapping("/checkId")
	public String checkId(HttpServletRequest request) {
		String id = request.getParameter("id");
		String member_type = request.getParameter("member_type");
		int count = memberDao.checkId(id, member_type);
		log.debug("count:{}", count);
		
		return String.valueOf(count);
	}
	


	
}

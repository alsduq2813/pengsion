package spring.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.bean.Pension;
import spring.model.PensionDao;

@Controller
public class HomeController {
	@Autowired
	private PensionDao pensionDao;
	
	@Autowired
	private ServletContext servletContext;
	
	private Logger log = LoggerFactory.getLogger(getClass());

	
	@RequestMapping("/")
	public String home(Model model) {
		List<Pension> list_latest = pensionDao.list_latest();
		model.addAttribute("list_latest", list_latest);
		
		String path = servletContext.getRealPath("/upload");
		log.debug(path);
		return "home";
	}
	
	
}

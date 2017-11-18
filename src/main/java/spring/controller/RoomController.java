package spring.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.bean.Pension;
import spring.bean.Room;
import spring.model.PensionDao;
import spring.model.RoomDao;

@Controller
@RequestMapping("/room")
public class RoomController {
	
	@Autowired
	private RoomDao roomDao;
	
	@Autowired
	private PensionDao pensionDao;

	@Autowired
	private ServletContext servletContext;
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping("/room_register")
	public String room_register(@RequestParam int pension_no, Model model) {
		model.addAttribute("pension_no", pension_no);
		return "room/room_register";
	}
	
	@RequestMapping(value="/room_register", method=RequestMethod.POST)
	public String room_register(MultipartHttpServletRequest mRequest) throws IllegalStateException, IOException {
		Room room = new Room(mRequest);
		int room_no = roomDao.insert(room);
		
		
		MultipartFile photo1 = mRequest.getFile("photo1");
		MultipartFile photo2 = mRequest.getFile("photo2");
		MultipartFile photo3 = mRequest.getFile("photo3");
		MultipartFile photo4 = mRequest.getFile("photo4");
		MultipartFile photo5 = mRequest.getFile("photo5");
		

		room = roomDao.info(room_no);
		Pension pension = pensionDao.info(room.getPension_no());
		
		String path = servletContext.getRealPath("/upload")+"/"+"["+pension.getPension_no()+"]"
		+pension.getPension_name()+"/"+room.getRoom_name();
		
		File target = new File(path);
		if(!target.exists()) {
			target.mkdirs();
		}
		
		target = new File(path, room.getPhoto1());
		photo1.transferTo(target);
		target = new File(path, room.getPhoto2());
		photo2.transferTo(target);
		target = new File(path, room.getPhoto3());
		photo3.transferTo(target);
		target = new File(path, room.getPhoto4());
		photo4.transferTo(target);
		target = new File(path, room.getPhoto5());
		photo5.transferTo(target);
		log.debug("저장 완료");
		return "redirect:success";
	}
	
	@RequestMapping("/success")
	public String success() {
		return "room/success";
	}
	
	@RequestMapping("/room_info")
	public String roomInfo(@RequestParam int room_no, Model model) {
		Room room = roomDao.info(room_no);
		Pension pension = pensionDao.info(room.getPension_no());
		model.addAttribute("room", room);
		model.addAttribute("pension", pension);
		return "room/room_info";
	}
	
	@RequestMapping("/room_info2")
	public String roomInfo2(@RequestParam int room_no, Model model) {
		Room room = roomDao.info(room_no);
		Pension pension = pensionDao.info(room.getPension_no());
		model.addAttribute("room", room);
		model.addAttribute("pension", pension);
		return "room/room_info2";
	}
	
	@RequestMapping("/room_edit")
	public String roomEdit(@RequestParam int room_no, Model model) {
		Room room = roomDao.info(room_no);
		Pension pension = pensionDao.info(room.getPension_no());
		model.addAttribute("room", room);
		model.addAttribute("pension", pension);
		return "room/room_edit";
	}
	
	@RequestMapping(value="/room_edit", method=RequestMethod.POST)
	public String roomEdit(MultipartHttpServletRequest mRequest, @RequestParam int pension_no, @RequestParam int room_no, Model model) throws IllegalStateException, IOException {
		Pension pension = pensionDao.info(pension_no);
		roomDao.update(mRequest, pension, room_no);
		model.addAttribute("room_no", room_no);
		return "room/success";
	}
	
	
	//펜션 검색
			@RequestMapping(value="/searchlist", method=RequestMethod.POST)
			public String searchPension(HttpServletRequest request, Model model) {
				String search = request.getParameter("city");
				List<Integer> list = roomDao.locationcheck(search);
				log.debug(list.toString());
				
				//==>지역 검색으로 펜션번호를 list로 출력
				int people = Integer.parseInt(request.getParameter("people"));
				List<Integer> nolist = null;
				List<Integer> nlist = new ArrayList<>();
				for(int number:list) {
					//System.out.println("number="+number);
					nolist = roomDao.peoplecheck(number, people);
					if(nolist != null) {
						for(int num:nolist) {
							//System.out.println("room_no:"+num);
							nlist.add(num);
						}
					}
				}
				log.debug(nlist.toString());
				
				
				//==>예약 테이블에서 해당 객실번호가 존재하는지 검사
				String date= request.getParameter("date");

					System.out.println(date);
					List<Integer> plist = new ArrayList<>();
					int num;
					for(int no : nlist) {
						num = roomDao.reservecheck(no,date);
						if(num != 0)
						plist.add(num);
					}
					model.addAttribute("plist", plist);
					log.debug(plist.toString());
					
					List<Pension> pension = new ArrayList<>();
					Pension p;
					
					
					List<Room> roomInfo= new ArrayList<>();
					Room room;
					int a;
					int b =0;
					for(int number : plist) {
						room = roomDao.Roominfo(number);
						roomInfo.add(room);
						a = roomDao.checked(number);
						if(a != b) {
						p = pensionDao.info(a);
						pension.add(p);
						b=a;
						}
						
					}
					log.debug(roomInfo.toString());
					model.addAttribute("roomInfo", roomInfo);
					log.debug(pension.toString());
					model.addAttribute("pensionInfo", pension);

				return "room/searchlist";
			}
	
	
	@RequestMapping("/searchlist")
	public String searchPension(Model model) {
		List<Pension> pension = pensionDao.list_latest();
		//List<Pension> pension = roomDao.search();
		List<Room> roomInfo = roomDao.list();

		model.addAttribute("roomInfo", roomInfo);
		model.addAttribute("pensionInfo", pension);
		
		return "room/searchlist";
	}
	
}


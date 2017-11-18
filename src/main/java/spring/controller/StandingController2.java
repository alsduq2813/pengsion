package spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import spring.bean.Questionboard;
import spring.model.QuestionboardDao;

@Controller
@RequestMapping("/standing")
public class StandingController2 {
   private Logger log = LoggerFactory.getLogger(getClass());
   
   
   @Autowired
   private QuestionboardDao questionboardDao;
   

   
   @RequestMapping("/standing2")
   public String standing2() {
      return "standing/standing2";
   }
   
   @RequestMapping("/reservesystem")
   public String reservesystem() {
      return "standing/reservesystem";
   }
   @RequestMapping("/questionboard")
   public String questionboard() {
      return "standing/questionboard";
   }
//   @RequestMapping("/questionregister")
//   public String questionregister() {
//      return "standing/questionregister";
//   }
   
   
   //게시판 상수
   private final int boardsize = 10;//게시판 1p에 표시할 글 개수
   private final int blocksize = 10;//게시판 1p에 표시할 링크 개수
   
   @RequestMapping("/questionboardlist")
   public String questionboardlist(HttpServletRequest request, Model model) {
      String pageStr = request.getParameter("page");
      int pageNo;
      try{
         pageNo = Integer.parseInt(pageStr);
         if(pageNo <= 0) throw new Exception();
      }catch(Exception e){
         pageNo = 1;
      }
      
      int count;
         count = questionboardDao.getBoardCount();
      int start = pageNo * boardsize - boardsize + 1;
      int end = start + boardsize - 1;
      
      int blocktotal = (count - 1) / boardsize + 1;
      int blockstart = (pageNo - 1) / blocksize * blocksize + 1;
      int blockend = blockstart + blocksize - 1;
      if(blockend > blocktotal) blockend = blocktotal;
      
      List<Questionboard> list = questionboardDao.list(start, end);

      //전달할 데이터 첨부
      model.addAttribute("pageStr", pageStr);
      model.addAttribute("pageNo", pageNo);
      model.addAttribute("start", start);
      model.addAttribute("end", end);
      model.addAttribute("count", count);
      model.addAttribute("blocktotal", blocktotal);
      model.addAttribute("blockstart", blockstart);
      model.addAttribute("blockend", blockend);
      model.addAttribute("list", list);
      
      return "standing/questionboardlist";
   }
   
   
   
// 상세보기
   
   
   @RequestMapping("/questionboarddetail")   //연결
   public String process(@RequestParam int boardno, Model model) {
/*      int boardno = Integer.parseInt(request.getParameter("no"));   //위에서 파마리터 받아서 필요x

*/      

       Questionboard questionboard =  questionboardDao.detail(boardno);   //detail 뽑아옴
       
     /*  BoardDAO bdao = new BoardDAO();
      BoardDTO bdto = bdao.detail(no);*/
//                                 첨부할것
      model.addAttribute("questionboard", questionboard);
      /*
      ReplyboardDAO rdao = new ReplyboardDAO();
      List<ReplyboardDTO> list = rdao.list(no);
     
      request.setAttribute("replycount", bdao.checkParent(no));
      request.setAttribute("list", list);*/
      
      System.out.println(questionboard.getBoardno());
      
      return "standing/questionboarddetail";
   }
   
   // 수정 비밀번호
   @RequestMapping("/questionboardeditpw")
   public String editpw(@RequestParam int boardno, @RequestParam String next, Model model){
      model.addAttribute("boardno", boardno);
      model.addAttribute("next", next);
      log.debug("여기4");
      return "standing/questionboardeditpw";
   }
   
   
   //비밀번호 체크
   @RequestMapping(value="/questionboardeditpw", method=RequestMethod.POST)
   public String pw(@RequestParam int boardno, @RequestParam String next, @RequestParam String pw, RedirectAttributes ra) {
      ra.addAttribute("boardno", boardno);
      log.debug("여기3");
      
      boolean result = questionboardDao.pwCheck(boardno, pw);
      
      if(result) {
    	  log.debug("여기");
         return "redirect:questionboardedit";
      }else {
         return "redirect:questionboardeditpw";
      }
   }
   
// 삭제 비밀번호
   @RequestMapping("/questionboarddeletepw/{boardno}")
   public String deletepw(@PathVariable int boardno, Model model){
      model.addAttribute("boardno", boardno);
      return "standing/questionboarddeletepw";
   }
   
   // 삭제 비밀번호
   @RequestMapping(value="/questionboarddeletepw", method=RequestMethod.POST)
   public String deletepw(@RequestParam int boardno, @RequestParam String pw){
      System.out.println(boardno+pw);
      boolean result = questionboardDao.pwCheck(boardno, pw);
      System.out.println(result);
      if(result) {
         questionboardDao.delete(boardno);
         System.out.println("delete됨?");
         return "redirect:questionboardlist";
      }else {
         return "redirect:standing/questionboardeditpw";
      }
   }
   
   
   //수정
   @RequestMapping("/questionboardedit")
   public String edit(@RequestParam int boardno, Model model){
	   log.debug("여기2");
      Questionboard questionboard = questionboardDao.detail(boardno);
      model.addAttribute("questionboard", questionboard);
      return "standing/questionboardedit";
   }
   
   
   //-------------------------------------------------------------------------
   //삭제기능
     
/*   @RequestMapping(value="/questionboardeditpw", method=RequestMethod.POST)
   public String delete(@RequestParam int boardno, @RequestParam String next, @RequestParam String pw, RedirectAttributes ra) {
      ra.addAttribute("boardno", boardno);
      
      boolean result = questionboardDao.pwCheck(boardno, pw);
      
      if(result) {
         if(next.equals("questionboardedit")) {
            return "/standing/questionboardlist";
         }else {
            return "redirect:questionboardeditpw";
         }
      }else {
         return "/standing/questionboardeditpw";
      }
   }*/

}
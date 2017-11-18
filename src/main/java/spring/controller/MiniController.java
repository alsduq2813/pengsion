package spring.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.bean.Answer;
import spring.bean.Question;
import spring.model.MemberDao;
import spring.model.MiniDao;

@Controller
@RequestMapping("/mini")
public class MiniController {
   
   @Autowired
   private ServletContext servletContext;
   
   @Autowired
   private MiniDao miniDao;
   
   @Autowired
   private MemberDao memberDao;
   
   private Logger log = LoggerFactory.getLogger(getClass());
   
   
   @RequestMapping("/ask")
   public String miniask(@RequestParam int pension_no, @RequestParam int no, HttpSession session) {
      session.setAttribute("no", pension_no);
      String id = (String)session.getAttribute("userId");
      log.debug(id);
      if(id == null) {
         return "redirect:/";
      }
      boolean loginFlag = (boolean) session.getAttribute("loginFlag");
      boolean companyFlag = (boolean) session.getAttribute("companyFlag");
         if(no >0 && companyFlag) {
            Question q = miniDao.questionInfo(no);
            session.setAttribute("qInfo", q);
            session.setAttribute("qno", no);
            return "pension/miniask";   
         }else if(no ==0 && companyFlag){
            return "redirect:/";
         }else if(no == 0 && loginFlag){
            return "pension/miniask";
      }
      return "redirect:/";
   }
   
   @RequestMapping(value ="/ask", method=RequestMethod.POST)
   public String QandA(@RequestParam int pension_no, @RequestParam int question_no, HttpServletRequest request, HttpSession session) {
      String id = (String)session.getAttribute("userId");
      String title = request.getParameter("title");
      log.debug("title="+title);
      if(title != null) {
      //회원 질문 처리
         log.debug("a");
         Question question = new Question(request, id);
         log.debug(question.toString());
         miniDao.insert(question);
      }else {
         log.debug("b");
         Answer answer = new Answer(request, question_no);
         log.debug("dd"+answer.toString());
         miniDao.insert(answer);
      }
      log.debug("완료");
         

      return "redirect:/pension/reserve?pension_no="+pension_no;
      
      
   }
   
   @RequestMapping("/delete")
   public String delete(@RequestParam int pension_no, @RequestParam int question_no, HttpSession session) {
      String id = (String)session.getAttribute("userId");
      log.debug(id);
      if(id == null)
         return "redirect:/pension/reserve?pension_no="+pension_no;
      //miniDao.delete(question_no, id);
      
      return "redirect:/pension/reserve?pension_no="+pension_no;
   }
   

}
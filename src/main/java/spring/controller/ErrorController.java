package spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
   private Logger log = LoggerFactory.getLogger(getClass());
   
   @RequestMapping("/error")
   public String error() {
      return "error";
   }

}
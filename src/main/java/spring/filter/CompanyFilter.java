package spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebFilter("/*")
public class CompanyFilter implements Filter{
	
	private Logger log = LoggerFactory.getLogger(getClass());

	//폐쇄할 페이지 명단을 설정
	//startsWith
	
	private String[] closepage3 = new String[] {
			"/pension/pension_register", "/pension/pension_edit", "/pension/pension_info", "/pension/management", 
			"/room/room_register", "/room/room_edit", "/room/room_info"
	};

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponse response = (HttpServletResponse)arg1;
		HttpSession session = request.getSession();

		//사용자 요청 URL을 분석하여 명단에 없으면 로그인 검사 수행
		String url = request.getRequestURI();
		url = url.substring(request.getContextPath().length());
		//home.it, login.it, sign.it 검사
		
		boolean flag = true;
		for(int i=0; i<closepage3.length; i++) {
			if(closepage3[i].equals(url)) {
				flag = false;
				break;
			}
		}
		
		if(!flag && session.getAttribute("companyFlag").equals(false)) {
			log.debug("컴퍼니필터 작동");
			response.sendRedirect(request.getContextPath()+"/member/login");
			return;
		}
		
		arg2.doFilter(arg0, arg1);//전달!
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}

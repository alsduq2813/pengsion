package spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Question {
	public int pension_no;
	public int question_no;
	public String title;
	public String detail;
	public String id;
	public String reg;
	public int read;
	public int answer;
	public String date;
	
	public String getDate() {
		String d = this.getReg().substring(0, 16);
		return d;
	}

	public Question (ResultSet rs) throws SQLException {
		setPension_no(rs.getInt("pension_no"));
		setQuestion_no(rs.getInt("question_no"));
		setTitle(rs.getString("title"));
		setDetail(rs.getString("detail"));
		setId(rs.getString("id"));
		setReg(rs.getString("reg"));
		setRead(rs.getInt("read"));
		setAnswer(rs.getInt("answer"));
	}
	
	@Override
	public String toString() {
		return "Question [pension_no=" + pension_no + ", question_no=" + question_no + ", title=" + title + ", detail="
				+ detail + ", id=" + id + ", reg=" + reg + ", read=" + read + ", answer=" + answer + ", log=" + log
				+ "]";
	}

	private Logger log = LoggerFactory.getLogger(getClass());
	
	public Question (HttpServletRequest request, String id) {
		String pension_no = request.getParameter("pension_no");
		setPension_no(pension_no == null?0:Integer.parseInt(pension_no));
		//String question_no = request.getParameter("question_no");
		//setQuestion_no(pension_no == null?0:Integer.parseInt(question_no));
		setQuestion_no(0);
		setTitle(request.getParameter("title"));
		setDetail(request.getParameter("detail"));
		//setId(request.getParameter("id")== null?id:request.getParameter("id"));
		setId(id);
		
		setRead(0);
		setAnswer(0);
		//String read = request.getParameter("read");
		//setRead(read == null?0:Integer.parseInt(read));
		//String answer = request.getParameter("answer");
		//setAnswer(answer == null?0:Integer.parseInt(answer));	
	}
	
	public Question() {
		super();
	}
	
	public int getPension_no() {
		return pension_no;
	}
	public void setPension_no(int pension_no) {
		this.pension_no = pension_no;
	}
	public int getQuestion_no() {
		return question_no;
	}
	public void setQuestion_no(int question_no) {
		this.question_no = question_no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReg() {
		return reg;
	}
	public void setReg(String reg) {
		this.reg = reg;
	}
	public int getRead() {
		return read;
	}
	public void setRead(int read) {
		this.read = read;
	}
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	

}

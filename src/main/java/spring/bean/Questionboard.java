package spring.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Questionboard {
   private int boardno;
   private String writer;
   private String title;
   private String detail;
   private String pw;
   private String reg;
   
   
   public Questionboard(ResultSet rs) throws SQLException{
      setBoardno(rs.getInt("boardno"));
      setWriter(rs.getString("writer"));
      setTitle(rs.getString("title"));
      setDetail(rs.getString("detail"));
      setPw(rs.getString("pw"));
      setReg(rs.getString("reg"));
      
      
   }
   public Questionboard() {
      super();
   }
   
   @Override
   public String toString() {
      return "questionboard [boardno=" + boardno + ", writer=" + writer + ", title=" + title + ", detail=" + detail
            + ", pw=" + pw + ", reg=" + reg + "]";
   }
   public int getBoardno() {
      return boardno;
   }
   public void setBoardno(int boardno) {
      this.boardno = boardno;
   }
   public String getWriter() {
      return writer;
   }
   public void setWriter(String writer) {
      this.writer = writer;
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
   public String getPw() {
      return pw;
   }
   public void setPw(String pw) {
      this.pw = pw;
   }
   public String getReg() {
      return reg;
   }
   public String getDate() {
	   return reg.substring(0, 10);
   }
   public void setReg(String reg) {
      this.reg = reg;
   }
   
   
}
   
   
   
   

   
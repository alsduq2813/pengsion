package spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.bean.Questionboard;

@Repository("QuestionboardDao")
public class QuestionboardDaolmpl implements QuestionboardDao {

   @Autowired
   private JdbcTemplate jdbcTemplate;
   
   private ResultSetExtractor<Questionboard> extractor = new ResultSetExtractor<Questionboard>() {
      public Questionboard extractData(ResultSet rs) throws SQLException, DataAccessException{
         //rs.next()가 이루어지지 않은 상태로 들어오기 때문에 내가 직접 처리해야 한다
         if(rs.next())
            return new Questionboard(rs);
         else
            return null;
      }
   };

   // @Override
   // public void insert(String writer, String title, String detail, String pw) {
   // String sql="insert into questionboard values(questionboard_seq.nextval,?,?,
   // ?, ?)";
   // jdbcTemplate.update(sql, writer, title, detail, pw);
   // }
   @Override
   public void insert(Questionboard q) {
      String sql = "insert into questionboard values(questionboard_seq.nextval, ?, ?, ?, ?, sysdate)";
      Object[] args = { q.getWriter(), q.getTitle(), q.getDetail(), q.getPw() };
      jdbcTemplate.update(sql, args);

   }

   @Override
   public List<Questionboard> list(int start, int end) {
      String sql = "select * from (" + "select rownum as rn, A.* from ("
      // + "select * from board order by no desc"
            + "select * from questionboard order by boardno desc" // board를 조회하는데
            + ")A" + ") where rn between ? and ?";
      // String sql="select * from questionboard order by boardno desc";
      Object[] args = { start, end };
      RowMapper<Questionboard> mapper = (rs, index) -> {
         return new Questionboard(rs);
      };
      return jdbcTemplate.query(sql, mapper, args);

   }

   public int getBoardCount() {
      String sql = "select count(*) from questionboard";
      return jdbcTemplate.queryForObject(sql, Integer.class);
   }

   public Questionboard detail(int boardno) {
      String sql = "select * from questionboard where boardno=?";
      Object[] args = {boardno};
      return jdbcTemplate.query(sql, extractor, args);
      
      
   }



   @Override
   public void edit(Questionboard questionboard) {
      String sql = "update questionboard set title=?, detail=?, pw=? where no=?";
      Object[] args = {questionboard.getTitle(), questionboard.getDetail(),
            questionboard.getPw()
      };
      jdbcTemplate.update(sql, args);
   }

   public boolean pwCheck(int boardno, String pw) {
      String sql = "select count(*) from questionboard where boardno=? and pw=?";
      Object[] args = {boardno, pw};
      int count = jdbcTemplate.queryForObject(sql, args, Integer.class);
      return count > 0;
   }

   @Override
   public void delete(int boardno) {
      String sql = "delete questionboard where boardno=?";
      Object[] args = {boardno};
      jdbcTemplate.update(sql, args);
   }

   


  }
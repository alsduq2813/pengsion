package spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import spring.bean.Answer;
import spring.bean.Question;

@Repository(value="miniDao")
public class MiniDaoImpl implements MiniDao{
   private Logger log = LoggerFactory.getLogger(getClass());

   @Autowired
   private JdbcTemplate jdbcTemplate;
   
   @Autowired
   private ServletContext servletContext;
   
   private ResultSetExtractor<Question> extractor = new ResultSetExtractor<Question>() {
      public Question extractData(ResultSet rs) throws SQLException, DataAccessException{
         //rs.next()媛� �씠猷⑥뼱吏�吏� �븡�� �긽�깭濡� �뱾�뼱�삤湲� �븣臾몄뿉 �궡媛� 吏곸젒 泥섎━�빐�빞 �븳�떎
         if(rs.next())
            return new Question(rs);
         else
            return null;
      }
   };
   
   private ResultSetExtractor<Answer> extractor1 = new ResultSetExtractor<Answer>() {
      public Answer extractData(ResultSet rs) throws SQLException, DataAccessException{
         //rs.next()媛� �씠猷⑥뼱吏�吏� �븡�� �긽�깭濡� �뱾�뼱�삤湲� �븣臾몄뿉 �궡媛� 吏곸젒 泥섎━�빐�빞 �븳�떎
         if(rs.next())
            return new Answer(rs);
         else
            return null;
      }
   };


   //吏덈Ц �삱由ш린
   @Override
   public void insert(Question question) {
      String sql = "select question_seq.nextval from dual";
      int   question_no = jdbcTemplate.queryForObject(sql,Integer.class);
      
      sql = "insert into question values(?,?,?,?,?,sysdate, 0, 0)";
      Object[] args = {
            question.getPension_no(), question_no, question.getTitle(), 
            question.getDetail(), question.getId()
      };
      jdbcTemplate.update(sql, args);
   }

   //�빐�떦 紐⑸줉 爰쇰궡�삤湲�
   @Override
   public List<Question> list(int pension_no) {
      String sql = "select * from question where pension_no=? order by reg desc";
      RowMapper<Question> mapper = (rs, index)->{
         return new Question(rs);
      };
      return jdbcTemplate.query(sql, mapper, pension_no);
   }
   
   //�떟湲��떖湲�
      public void insert(Answer answer) {
         String sql = "select answer_seq.nextval from dual";
         int   answer_no = jdbcTemplate.queryForObject(sql,Integer.class);
         
         sql ="insert into answer values(?, ?, ?, sysdate)";
         Object[] args = {
               answer.getQuestion_no(), answer_no, 
               answer.getDetail()
         };
         jdbcTemplate.update(sql, args);
         
      }

      //�뙎湲� 由ъ뒪�듃 
      public List<Answer> alist() {
         String sql = "select * from answer order by reg desc";
         RowMapper<Answer> mapper = (rs, index)->{
            return new Answer(rs);
         };
         return jdbcTemplate.query(sql, mapper);
      }

      @Override
      public Question questionInfo(int no) {
         String sql = "select * from question where question_no =?";
         RowMapper<Question> mapper = (rs, index)->{
            return new Question(rs);
         };
         List<Question> a = jdbcTemplate.query(sql, mapper, no);
         return a.get(0);
      }

   
   

}
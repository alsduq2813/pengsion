package spring.model;

import java.util.List;

import org.springframework.stereotype.Repository;

import spring.bean.Questionboard;

@Repository
public interface QuestionboardDao {
//   void insert(String writer, String title, String detail, String pw);
   List<Questionboard> list(int start, int end);
   void insert(Questionboard q);
   int getBoardCount();
   Questionboard detail(int boardno);
   void edit(Questionboard questionboard);
boolean pwCheck(int boardno, String pw);
   void delete(int boardno);

}
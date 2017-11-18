package spring.model;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.bean.Pension;
import spring.bean.Room;

@Repository
public interface RoomDao {
	int insert(Room room);
	Room info(int room_no);
	List<Room> list(int pension_no);
	public void update(MultipartHttpServletRequest mRequest, Pension pension, int room_no) throws IllegalStateException, IOException;
	//펜션 검색
	List<Integer> locationcheck(String search);
	List<Integer> peoplecheck(int number, int people);
	int reservecheck(int room_no,String date);
		
	//룸 리스트 꺼내기
	Room Roominfo(int room_no);
	int checked(int room_no);
	List<Room> list();
	List<Pension> search();
}

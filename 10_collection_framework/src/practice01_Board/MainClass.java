package practice01_Board;

import java.util.List;

public class MainClass {

  public static void main(String[] args) {
    
    BoardService boardService = new BoardService();
    
    List<BoardVo> boardList = boardService.getBoardList();  // BoardVo 3개가 저장되어있는 목록
    
    // 하나씩 출력하기
    // toString 활용하기
    for(int i = 0, size = boardList.size() ; i < size ; i++) {
      System.out.println(boardList.get(i));
    }
    
    // getter 활용하기 : get(i) 메소드는 List 꺼 
    for(int i = 0, size = boardList.size() ; i < size ; i++) {
      System.out.println("번호 : " + boardList.get(i).getBoardNo());               
      System.out.println("제목 : " + boardList.get(i).getTitle());               
      System.out.println("작성자 : " + boardList.get(i).getWriter());               
      System.out.println("작성일자 : " + boardList.get(i).getCreatedAt());               
         
    }
    

  }

}

package practice03_Member;

public class MainClass {

  public static void main(String[] args) {

    // 임의의 정보를 가지는 Member 1명을 만들고, 정보 출력하기
    
    // 생성자의 필드값을 받아와서 바로 초기화
    Address address = new Address("12345", "aaa", "bbb", "ccc", "ddd", true); // ctrl + space 눌러 constructor 선택 후 tap키로 매개변수끼리 왓다갓다 할 수 있음 
    Contact contact = new Contact("02", "010");
    
    // default 생성자 + setter
    Member member = new Member();
    member.setId("elsa");
    member.setAddress(address);
    member.setContact(contact);
  
    // 정보 출력 getter
    System.out.println("아이디 : " + member.getId());
    System.out.println("우편번호 : "+ member.getAddress().getPostCode());
    System.out.println("도로명 : " + member.getAddress().getRoadAddress());
    System.out.println("지번 : " + member.getAddress().getJibunAddress());
    System.out.println("상세 : " + member.getAddress().getDetailAddress());
    System.out.println("추가 : " + member.getAddress().getExtraAddress());
    System.out.println("기본 주소 여부 : " + member.getAddress().isBasicAddress());
    System.out.println("집전화 : " + member.getContact().getTel());
    System.out.println("휴대전화 : " + member.getContact().getMobile());
    
  }

}

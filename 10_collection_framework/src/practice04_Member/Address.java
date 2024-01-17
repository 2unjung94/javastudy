package practice04_Member;

public class Address {

  // field

  private String postCode;
  private String roadAddress;
  private String jibunAddress;
  private String detailAddress;
  private String extraAddress;
  private boolean isBasicAddress; // 실무에선 boolean type 의 field 이름을 is+이름을 많이 씀
  
  // constructor 와 setter 는 비슷한 역할을 함(둘 다 private 의 필드값을 저장할 수 있으므로)
  // java 에서 데이터를 주고 받는 단위 : bean = VO = DTO
  
  
  // constructor
  // default 형식의 생성자 단축키 : crtl + space -> 디폴트 생성자 선책
  // field 값이 추가되었을 때 이전 constructor 는 지우고 다시 생성할 것
  public Address() {
  
  }
  
  public Address(String postCode, String roadAddress, String jibunAddress, String detailAddress, String extraAddress,
      boolean isBasicAddress) {
    super();
    this.postCode = postCode;
    this.roadAddress = roadAddress;
    this.jibunAddress = jibunAddress;
    this.detailAddress = detailAddress;
    this.extraAddress = extraAddress;
    this.isBasicAddress = isBasicAddress;
  }

  // method
  // field 가 새로 추가되었을 때 추가된 field getter, setter 추가됨.
  public String getPostCode() {
    return postCode;
  }

  public void setPostCode(String postCode) {
    this.postCode = postCode;
  }

  public String getRoadAddress() {
    return roadAddress;
  }

  public void setRoadAddress(String roadAddress) {
    this.roadAddress = roadAddress;
  }

  public String getJibunAddress() {
    return jibunAddress;
  }

  public void setJibunAddress(String jibunAddress) {
    this.jibunAddress = jibunAddress;
  }

  public String getDetailAddress() {
    return detailAddress;
  }

  public void setDetailAddress(String detailAddress) {
    this.detailAddress = detailAddress;
  }

  public String getExtraAddress() {
    return extraAddress;
  }

  public void setExtraAddress(String extraAddress) {
    this.extraAddress = extraAddress;
  }

  // boolean type 의 getter : is + 필드명(). 
  // 예외사항 : field 명이 is+필드명 이면, getter 의 이름이 isIs필드명() 이 아닌 is필드명()으로 바꿔줌
  public boolean isBasicAddress() {
    return isBasicAddress;
  }


  // field 이름이 is+필드명 일때 setter 도 알아서 setIs필드명 이 아닌 set필드명()으로 바꿔줌
  public void setBasicAddress(boolean isBasicAddress) {
    this.isBasicAddress = isBasicAddress;
  }
}

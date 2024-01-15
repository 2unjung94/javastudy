package pkg08_Object;

public class Student {

  // field
  private int stuNo;
  private String name;
  private Book[] books;
  private int bookCount;
  
  // constructor
  public Student() {
    books = new Book[100];

  }
  public Student(int stuNo, String name) {
    super();
    this.stuNo = stuNo;
    this.name = name;
    books = new Book[100];
  }
  
  // method
  public int getStuNo() {
    return stuNo;
  }
  public void setStuNo(int stuNo) {
    this.stuNo = stuNo;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Book[] getBooks() {
    return books;
  }
  public void setBooks(Book[] books) {
    this.books = books;
  }
  public int getBookCount() {
    return bookCount;
  }
  public void setBookCount(int bookCount) {
    this.bookCount = bookCount;
  }
  
  // 책 등록
  public void addBook(Book book) {
    if(bookCount >= books.length) {
      System.out.println("더 이상 책을 등록 할 수 없습니다.");
      return;
    }
    
    books[bookCount++] = book;
  }
  
  // 책 삭제 (몇번째 책)
  public void removeBook(int idx) {
    if(idx < 0 || idx >= bookCount) {
      System.out.println("잘못된 인덱스입니다.");
      return;
    }
    
    System.arraycopy(books, idx+1, books, idx, bookCount-idx-1); // books 배열에 idx + 1 에 있는 걸 idx 자리에 옮기고 bookCount-idx-1 개 만큼 옮긴다.
    bookCount--;
    books[bookCount] = null;
  }
  
  // 책 삭제 (같은 책)
  public void removeBook(Book book) {
    if(bookCount == 0) {
      System.out.println("저장된 책이 없습니다.");
      return;
    }
    for(int i = 0 ; i <= bookCount; i++) {        // books.length : 책이 저장된 최대 수 이므로 bookCount를 쓸 것
      if(book.equals(books[i])) {                 // book 클래스에 Object 클래스의 equals 메소드 오버라이드 해야 한다. (isbn 이 같으면 true 반환)
        System.arraycopy(books, i+1, books, i, bookCount-i-1); 
        bookCount--;
        books[bookCount] = null;
        break;
      }
    }
  }

  
  /*
   * Object 의 클래스에 equals() 메소드 오버라이드
   * stuNo 값이 일치하면 true 를 반환
   */
  
  @Override
  public boolean equals(Object obj) {
    if(obj == null) return false;
    if(obj == this) return true;
    return this.stuNo == ((Student) obj).stuNo;
    // 또는 return this.stuNo == ((Student) obj).getStuNo();
  }
  
  /*
   * Object 의 클래스에 toStirng() 메소드 오버라이드
   * stuNo : 10101, name: 고길동 형식의 문자열 반환
   */
 @Override
  public String toString() {
  
    return "stuNo: " + stuNo + ", name: " + name;
  } 

  
}

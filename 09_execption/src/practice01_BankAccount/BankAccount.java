package practice01_BankAccount;

//1. 메소드마다 try - catch 넣기

public class BankAccount {
  
  // field
  private String accNo;   // 계좌번호
  private long balance;   // 잔액
  
  // constructor
  public BankAccount() {

  }
  
  public BankAccount(String accNo, long balance) {
    super();
    this.accNo = accNo;
    this.balance = balance;
  }

  public String getAccNo() {
    return accNo;
  }

  public void setAccNo(String accNo) {
    this.accNo = accNo;
  }

  public long getBalance() {
    return balance;
  }

  public void setBalance(long balance) {
    this.balance = balance;
  }
  
  // method
  // try 안에서 작성한 throw 는 catch 가 받는다.

  public void deposit(long money) {
    
    try {
      if(money <= 0) {
        throw new RuntimeException(money + "원 입금 불가");
      }
      
      balance += money;
      
    } catch(RuntimeException e) {
      System.out.println(e.getMessage()); 
    }

  }

//1. 메소드마다 try - catch 넣기
  public long withdrawal(long money) {
    
    long retValue = 0L;             // 변환타입 return 이 필요해서
    
    try {
      if(money <= 0) {
        throw new RuntimeException(money + "원 출금 불가");

      }
      if(money > balance) {
        throw new RuntimeException("잔액 부족");
      }
      
      balance -= money;
      retValue = money;           // 변환타입 return 이 필요해서
      
    } catch(RuntimeException e) {
        System.out.println(e.getMessage());
    }
    return retValue;              // 변환타입 return 이 필요해서

  }

  public void transfer(BankAccount account, long money) {
    
    // 내 통장에서 출금 -> 출금된 금액이 반환 -> 출금된 금액을 네 통장에 입금
    
    // 내 통장에서 출금
    // long a = withdrawal(money);
    
    // 네 통장에 입금
    // account.deposit(a);
    
    account.deposit(withdrawal(money));     // deposit, withdrawal 에서 메소드 내에서 예외 처리 하므로 별도로 try - catch 할 필요 없다.

  }
}

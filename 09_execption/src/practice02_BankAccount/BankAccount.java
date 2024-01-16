package practice02_BankAccount;

// 2. 메소드 호출한 곳으로 예외 던지기

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
  public void deposit (long money) throws RuntimeException {
    
    if(money <= 0) {
      throw new RuntimeException(money + " 원 입금 불가");       // 메소드를 호출한 곳에 던짐
    }
      balance += money;

  }

  public long withdrawal(long money) throws RuntimeException {
    if(money <= 0) {
      throw new RuntimeException("출금에 실패하였습니다.");
    }
    if(money > balance) {
      throw new RuntimeException("잔액 부족");
    }
    balance -= money;
    return money;
  }

  public void transfer(BankAccount account, long money) throws RuntimeException { // transfer 도 입출금을 호출하기 때문에
                                                                                  // 예외처리를 받기 때문에 다시 메인에게 던져주려고 throws 추가
    
    // 내 통장에서 출금 -> 출금된 금액이 반환 -> 출금된 금액을 네 통장에 입금
    
    // 내 통장에서 출금
    // long a = withdrawal(money);
    
    // 네 통장에 입금
    // account.deposit(a);
    
      
      account.deposit(withdrawal(money));       
    

  }
}

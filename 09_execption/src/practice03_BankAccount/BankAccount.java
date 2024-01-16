package practice03_BankAccount;

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
  public void deposit(long money) throws RuntimeException {
    
    try {
      if(money <= 0) {
        // catch 블록으로 던진다.
        throw new DepositException(1001);
      }
      balance += money;
      
    } catch (DepositException e) {      // DepositException e : 예외 원인 객체(cause). api 쪽에서 쓰인다. 해석 잘 할것.
      
      // deposit 메소드 호출한 곳으로 던진다. 
      throw new RuntimeException(money + "원 입금 불가", e);
      
    }

  }

  public long withdrawal(long money) throws RuntimeException {
    
    try {
      if(money <= 0) {
        throw new WithdrawalException(2001);
      }
      if(money > balance) {
        throw new WithdrawalException(2002);
      }
      
      balance -= money;
      
      
    } catch (WithdrawalException e) {   // WithdrawalException e : 예외 원인 객체(cause) 
      
      String message = null;
      switch(e.getErrorCode()) {
      case 2001 :
        message = money + "원 출금 불가";
        break;
        
      case 2002 :
        message = "잔액 부족";
        break;
      }           // 자동으로 return 0해줌
      throw new RuntimeException(message, e);
    }
    return money;
  }

  public void transfer(BankAccount account, long money) throws RuntimeException{
    
    // 내 통장에서 출금 -> 출금된 금액이 반환 -> 출금된 금액을 네 통장에 입금
    
    // 내 통장에서 출금
    // long a = withdrawal(money);
    
    // 네 통장에 입금
    // account.deposit(a);
    
    account.deposit(withdrawal(money));

  }
}

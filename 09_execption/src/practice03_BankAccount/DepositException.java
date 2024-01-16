package practice03_BankAccount;

// field 가 없을 때 생성자는 [Source] -> {Generate constructor from Superclass] 로 생성

public class DepositException extends BankException {

  public DepositException(String message, int errorCode) {
    super(message, errorCode);
  }
  public DepositException(int errorCode) {
    super(errorCode);
  }
  


}

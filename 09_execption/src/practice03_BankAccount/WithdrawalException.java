package practice03_BankAccount;

//field 가 없을 때 생성자는 [Source] -> {Generate constructor from Superclass] 로 생성

public class WithdrawalException extends BankException{

  public WithdrawalException(String message, int errorCode) {
    super(message, errorCode);
  }
  public WithdrawalException(int errorCode) {
    super(errorCode);
  }
  

}

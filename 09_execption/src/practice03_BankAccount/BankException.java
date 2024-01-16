package practice03_BankAccount;

public class BankException extends Exception {
  // field
  private int errorCode;
  
  // constructor
  public BankException(int errorCode) {
    this.errorCode = errorCode;
    
  }
  public BankException(String message, int errorCode) {
    super(message);   
    this.errorCode = errorCode;
    
  }

  // method
  public int getErrorCode() {
    return errorCode;
  }
  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

}

package practice03_Employee;

public class Regular extends Employee {
  
  // field
  private int salary; // 기본급

  
  // constructor
  public Regular(int empNo, String name) {
    super(empNo, name);
  }
  public Regular(int empNo, String name, int salary) {
    super(empNo, name);
    this.salary = salary;
  }
  
  // method
  public int getSalary() {
    return salary;
  }
  public void setSalary(int salary) {
    this.salary = salary;
  }
  
  @Override
  public void info() {
    super.info();       // 사원번호, 사원이름 출력하는 부모 메소드 호출
    System.out.println("연봉 : " + salary);
  }
  
  
}

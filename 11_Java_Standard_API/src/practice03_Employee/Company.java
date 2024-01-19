package practice03_Employee;

import java.util.ArrayList;
import java.util.List;

public class Company {

  // field
  private String name;
  private List<Employee> employees; //new Regular, new PartTime 가능하게

  
  // constructor
  public Company(String name) {
    this.name = name;
    employees = new ArrayList<Employee>();
  }
  
  // method
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  // 고용
  public void hire(Employee employee) throws RuntimeException {
    
    // 예외 발생시 null 이 넘어온다.
    if(employee == null) {
      throw new RuntimeException("고용될 사원 정보가 올바르지 않습니다.");
    }
    employees.add(employee);
  }
  
  // 해고
  public void fire(int empNo) throws RuntimeException{
    
   
    for(Employee e: employees) {
      if(e.getEmpNo() != empNo) {
        throw new RuntimeException("사원이 존재하지 않습니다");
      }else employees.remove(e);
    }
    
  }
  
  // 조회
  public void search(int empNo) {
    
  }
  
  // 전체 조회
  public void searchAll() throws RuntimeException {
    
    if(employees.isEmpty()) {
      throw new RuntimeException("조회할 사원이 없습니다.");
    }
    System.out.println("전체 사원 명단");
    System.out.println("-------------------");
    for(Employee employee : employees) {
      employee.info();
      System.out.println("-------------------");
    }
    
  }
  
}

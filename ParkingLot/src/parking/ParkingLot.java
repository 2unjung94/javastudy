package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {

  /* field 영역 수정 금지 */
  private String name;
  private List<Car> cars;
  private Scanner sc;
  public final static int LIMIT = 5;
  
  public ParkingLot(String name) {
    this.name = name;
    cars = new ArrayList<Car>();
    sc = new Scanner(System.in);
  }
  
  public void addCar() throws RuntimeException {
    /* 구현부 */
    System.out.println("현재 등록된 차량 : "+cars.size() + "대");
    if(cars.size() == LIMIT) {
      throw new RuntimeException("만차입니다. 더이상 차량 등록이 불가능합니다.");      
    }
    System.out.println("차량번호 입력 >>>");
    String carNo = sc.next();
    System.out.println("모델 입력>>>");
    String model = sc.next();
    cars.add(new Car(carNo, model));
    System.out.println("차랑번호 " + carNo + " 차량이 등록되었습니다.");
  }
  
  public void deleteCar() throws RuntimeException {
    /* 구현부 */
    
    if(cars.isEmpty()) {
      throw new RuntimeException("현재 주차장에 등록된 차량이 없습니다.");
    }
    
    System.out.println("삭제할 차량번호 입력>>>");
    String carNo = sc.next();
    int size = cars.size();
    int count = 0;
    
    for(int i = 0; i<size ;i++) {
      if(carNo.equals(cars.get(i).getCarNo())) {
      cars.remove(i);
      System.out.println("차량번호 " + carNo + " 차량이 삭제되었습니다.");
      break;
      } 
      count++;
    }
    
    if(size == count) {
      throw new RuntimeException("차량번호 " + carNo + " 차량이 존재하지 않습니다.");
    }
    
  }
  
  public void searchCar() throws RuntimeException {
    /* 구현부 */
    if(cars.isEmpty()) {
      throw new RuntimeException("현재 주차장에 등록된 차량이 없습니다.");
    }
    System.out.println("조회할 차량번호 입력>>>");
    String carNo = sc.next();
    int size = cars.size();
    
    int count = 0;
    for(int i = 0; i<size ; i++) {
      if(carNo.equals(cars.get(i).getCarNo())) {
        System.out.println(cars.get(i).toString());
        break;
        }
      count++;
      }
    
    if(size == count) {
      throw new RuntimeException("차량번호 " + carNo + " 차량이 존재하지 않습니다.");
    }
    
  }
  
  public void printAllCars() throws RuntimeException {
    /* 구현부 */
    if(cars.isEmpty()) {
      throw new RuntimeException("현재 주차장에 등록된 차량이 없습니다.");
    }

    System.out.println(name + " 차량 목록");
    String[] info = new String[5];
    for(int i = 0, idx = 1; i < LIMIT  ; i++) {
      if(i >= cars.size()) {
        info[i] = idx + "번째 차량 : 없음";
      } else {
      info[i] = idx + "번째 차량 : " + cars.get(i).toString();
      }
      System.out.println(info[i]);
      idx++;
    }
     
  }
  
  public void manage() {
    /* 구현부 */
    while(true) {
      try {
        System.out.println("\n1.추가 2.삭제 3.조회 4.전체조회 0.종료 >>>");
        String choice = sc.next();
        switch(choice) {
        case "1": 
          addCar();
          break;
        case "2":
          deleteCar();
          break;
        case "3":
          searchCar();
          break;
        case "4":
          printAllCars();
          break;
        case "0":
          System.out.println("===== 종료 =====");
          return;
        default:
          throw new RuntimeException("잘못된 입력입니다.");
        }  
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
  }
}
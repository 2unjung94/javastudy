package pkg04_HashSet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * hash 의 개념 : 빠른 탐색을 위해 만들어진 자료구조
 * 
 * Set = 집합
 * 특징
 * 집합에 들어간 데이터들은 순서의 개념이 없다. (index 가 없다)
 * 중복이 불가능하다 ( 1, 1, 2, 2, 3, 3, 3, 불가 ) ( 1, 2, 3 가능 ) -> 저장 전 중복 검사한다.
 * HashSet과 ArrayList는 부모가 같기 때문에(Collection<E>) 메소드는 같다.
 * 
 * Collection<E> void a(); void b(); void c();
 * HashSet<E> void a() { }; void b() { }; void c() { };
 * ArrayList<E> void a() { }; void b() { }; void c() { }; 
 * 
 * hash 의 알고리즘 읽어보기
 *  
 */


public class MainClass {
  
  public static void method1() {
    
    // HashSet 타입 선언
    Set<String> hobbies;
    
    // HashSet 객체 생성
    hobbies = new HashSet<String>();
    
    // 요소 추가하기 (순서 없이 저장되고, 중복 저장이 불가능하다)
    hobbies.add("게임");
    hobbies.add("게임");
    hobbies.add("게임");
    hobbies.add("여행");
    hobbies.add("영화");
    hobbies.add("음악감상");
    hobbies.add("독서");
    hobbies.add("운동");

    // advanced for 문
    for(String hobby : hobbies) {
      System.out.println(hobby);
    }
  }

  public static void method2() {
    
    // 교집합
    Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5)); // 1,2,3,4,5를 리스트로 받아서 hashset 으로 만든다.
    Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(4,5,6,7,8)); 
    
    // set1 이 교집합 결과로 변환된다.
    set1.retainAll(set2);  // set1 -> 4, 5
    
    System.out.println(set1);
    
  }
  
  public static void method3() {
    
    // 합집합
    Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5)); // 1,2,3,4,5를 리스트로 받아서 hashset 으로 만든다.
    Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(4,5,6,7,8)); 
    
    // set1 이 합집합 결과로 변환된다.
    set1.addAll(set2);  // set1 -> 1,2,3,4,5,6,7,8
    
    System.out.println(set1);
    
  }
  
  public static void method4() {
    
    // 차집합
    Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1,2,3,4,5)); // 1,2,3,4,5를 리스트로 받아서 hashset 으로 만든다.
    Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(4,5,6,7,8)); 
    
    // set1 이 차집합 결과로 변환된다.
    set1.removeAll(set2);  // set1 -> 1,2,3
    
    System.out.println(set1);
    
  }
  
  public static void main(String[] args) {
    
    method4();

  }

}

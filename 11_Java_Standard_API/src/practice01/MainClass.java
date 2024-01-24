package practice01;

import java.security.SecureRandom;

// import 자동 입력 crtl + shift + o

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.UUID;

public class MainClass {

  public static void method1() {
    
    // 파일명 만들기
    // 형식 : 하이픈이 제거된 UUID + 밑줄 + 타임스탬프.확장자
    
    String fileName = "apple.jpg";
    
    // Format 저장
    String extName = fileName.substring(fileName.lastIndexOf("."));

    // 하이픈 제거한 UUID 생성
    StringBuilder builder = new StringBuilder();
    builder.append(UUID.randomUUID().toString().replace("-", ""));
    
    // 밑줄, timestamp, extName 추가
    builder.append("_");
    builder.append(System.currentTimeMillis());
    builder.append(extName);
    
    System.out.println(builder.toString());
  }
  
  public static Map<String, Object> method2(String id) {
    
    // 주민번호로 나이 구하기 + 성별 구하기
    // 나이(age) : 현재년도 - 태어난년도
    // 성별(gender) : 하이픈 뒤의 숫자가 1, 3 이면 남자 2, 4 이면 여자
    int nowYear = LocalDateTime.now().getYear();
    
    // 태어난 년도 + 성별
    int birthYear = 0;
    
    // 하이픈 뒤 숫자
    int afterHyphen = Integer.parseInt(id.substring(7, 8));
    
    switch(afterHyphen) {
      case 1 :
      case 2 : 
        birthYear = 1900 + Integer.parseInt(id.substring(0,2));
        break;
      case 3 :
      case 4 : 
        birthYear = 2000 + Integer.parseInt(id.substring(0,2));
        break;    
    }
    String[] genders = {"여자", "남자"}; // 인덱스를 나머지 값으로 보자
    
    return Map.of("age", nowYear - birthYear
                , "gender", genders[afterHyphen % 2]);
    
    
        
    /*Integer.parseInt(id.substring(0, 2));
    int birthYear2 = 0;
    if(birthYear >= 0 || birthYear < 25) {
      birthYear2 = 2000 + birthYear;
      
    }else birthYear2 = 1900 + birthYear;
    String age = Integer.toString(nowYear - birthYear2);
    
    
    
    // 성별계산
    int hipen = id.lastIndexOf("-");
    String genNo = id.substring(hipen + 1, hipen + 2);
    StringBuilder gen = new StringBuilder(genNo);
    String gender = null;
    
    if(gen.equals("1") || gen.equals("3")){
      gender = "남";
    } else gender = "여";
    
    person.put(age, gender);*/ 
  }
  
  public static void method3() {
    
    // 각 나라별 수도 맞히기
    
    // 프랑스 수도는? >>> 
    // 파리
    // 스위스 수도는? >>> 
    // 베른
    // 영국 수도는? >>> 
    // 런던
    // 독일 수도는? >>> 
    // 베를린
    // 이탈리아 수도는? >>> 
    // 로마
    // 5개 정답 성공
    
    Map<String, String> map = Map.of("프랑스", "파리"
                                   , "독일", "베를린"
                                   , "이탈리아", "로마"
                                   , "스위스", "베른"
                                   , "영국", "런던");
    
    Scanner sc = new Scanner(System.in);
    int count = 0;
    
    for(Entry<String, String> entry : map.entrySet()) {
      System.out.println(entry.getKey() + " 수도는? >>>");
      String capital = sc.next();
      if(capital.trim().equals(entry.getValue())) { 
        count++;
      }
    }
    System.out.println(count + "개 정답 성공");
    sc.close();
    
    
    /*String[] answer = new String[5];
    int count = 0;
    
    System.out.println("프랑스 수도는? >>>");
    answer[0] = sc.next();
    if(map.get("프랑스") == answer[0]); 
      count++;
    System.out.println(count + "개 정답 성공");
    
    System.out.println("독일 수도는? >>>");
    answer[1] = sc.next();
    if(map.get("독일") == answer[1])
      count++;
    
    System.out.println("이탈리아 수도는? >>>");
    answer[2] = sc.next();
    if(map.get("이탈리아") == answer[2])
      count++;
   
    System.out.println("스위스 수도는? >>>");
    answer[3] = sc.next();
    if(map.get("스위스") == answer[3])
      count++;
    
    System.out.println("영국 수도는? >>>");
    answer[4] = sc.next();
    if(map.get("영국") == answer[4])
      count++;*/
  
  }
  
  public static void method4() {

    // 5000원이 있는 통장(balance)에서 랜덤하게 출금하기
    // 실행예시)
    // 출금 전 5000원, 1회 출금액 2917원, 출금 후 2083원
    // 출금 전 2083원, 2회 출금액 1961원, 출금 후 122원
    // 출금 전 122원, 3회 출금액 102원, 출금 후 20원
    // 출금 전 20원, 4회 출금액 2원, 출금 후 18원
    // 출금 전 18원, 5회 출금액 17원, 출금 후 1원
    // 출금 전 1원, 6회 출금액 1원, 출금 후 0원
     
     int balance = 5000;
     int count = 0;
     while(balance > 0) {
       // 출금액 : 1 <= 난수 <= balance
       int money = (int)(Math.random() * balance + 1);
       count++;
       System.out.println("출금 전 " + balance + "원, " + count + "회 출금액 " + money + "원, 출금 후 " + (balance -= money) + "원");
     }
     
     
     /*SecureRandom secureRandom = new SecureRandom();
     
     int count = 1;
     
     while(true) {
       int draw = secureRandom.nextInt(balance + 1);
       int afterDraw = balance - draw;
       
       System.out.println("출금 전 " + balance + "원, " + count + "회 출금액 " + draw + "원, 출금 후 " + afterDraw + "원");
       balance -= draw;
       count++;
       if(balance == 0)
         break;
     }*/
  
  }
  
  public static void method5() {

    // 윷놀이
    // 실행예시1) "도", 1칸 이동한다.
    // 실행예시2) "개", 2칸 이동한다.
    // 실행예시3) "걸", 3칸 이동한다.
    // 실행예시4) "윷", "도", 5칸 이동한다.
    // 실행예시5) "모", "윷", "도", 10칸 이동한다.
    
    String[] yuts = {"", "도", "개", "걸", "윷", "모"};
    
    StringBuilder builder = new StringBuilder();
    int move = 0;
    int totalMove = 0;
    do {
      move = (int)(Math.random() *5 + 1);   // 윷 던지는 코드
      totalMove += move;
      builder.append("\"");
      builder.append(yuts[move]);
      builder.append("\", ");
      
    } while(move >= 4);
    builder.append(totalMove).append("칸 이동한다");   // chaining 가능
    System.out.println(builder.toString());
    
    /*List<String> result = new ArrayList<String>();
    SecureRandom secureRandom = new SecureRandom();
    
    for(int i = 0; i<yuts.length; i++) {
      int random = secureRandom.nextInt(yuts.length);
      int move = random;
      if(random >= 4) {
        while(true) {
          int loopRandom = secureRandom.nextInt(yuts.length);
          move += loopRandom;
          if(loopRandom < 4) break;
              
        }
      }
      System.out.println("\"" + yuts[random] + "\", " + move + "칸 이동한다.");
      break;
      
    }*/
    
  }

  static final String FINAL_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  static SecureRandom rnd = new SecureRandom();
  public static void method6() {
   
   // SecureRandom을 이용해 "대문자+소문자+숫자"로 구성된 임의의 인증번호 만들기
   // 실행예시1)
   //   몇 자리의 인증번호를 생성할까요? >>> 4
   //   생성된 4자리 인증번호는 7W5e입니다.
   // 실행예시2)
   //   몇 자리의 인증번호를 생성할까요? >>> 6
   //   생성된 6자리 인증번호는 Fa013b입니다.
    
    Scanner scanner = new Scanner(System.in);
    System.out.println("몇 자리의 인증번호를 생성할까요? >>>");
    int num = scanner.nextInt();
    scanner.close();
   
    StringBuilder sb = new StringBuilder(num);
    for(int i = 0; i < num; i++)
    sb.append(FINAL_STRING.charAt(rnd.nextInt(FINAL_STRING.length())));
    
    System.out.println("생성된 " + num + "자리 인증번호는 "+ sb.toString() + "입니다.");
    
  }

  public static void method7() {

 // UpDown 게임
    // 컴퓨터가 1 ~ 10000 사이의 난수를 발생시킨다.
    // 사용자는 해당 난수를 맞힌다.
    // 실행예시)
    // 입력 >>> 5000
    // Down!
    // 입력 >>> 2500
    // Up!
    // ...
    // 입력 >>> 4500
    // 정답입니다. 총 5번만에 성공했습니다.
     int random = (int)(Math.random() * 10000 + 1);
     int count = 1;
     int input = 0;
     
     Scanner sc = new Scanner(System.in);
     while(true) {
       System.out.println("입력 >>> ");
       input = sc.nextInt();
       if(input > random) {
         System.out.println("down!");
         count++;
       } else if( input < random) {
         System.out.println("Up!");
         count++;
       } else {
         sc.close();
         System.out.println("정답입니다. 총 " + count + "번만에 성공했습니다.");
         break;
       }
     }  
    
    
  }

  public static void method8() {
    // 0~9 사이 난수를 100개 발생시키고 발생한 난수들이 생성된 횟수(빈도수)를 그래프화 하여 출력하시오.
    // 실행예시)
    // 0 : #### 4
    // 1 : ############ 12
    // 2 : ############ 12
    // 3 : ##### 5
    // 4 : ######## 8
    // 5 : ########### 11
    // 6 : ############ 12
    // 7 : ################## 18
    // 8 : ####### 7
    // 9 : ########### 11

    List<Integer> random = new ArrayList<Integer>();
    List<String> sharp = new ArrayList<String>();
    int[] countNum = new int[10];
    String s = "";
      
    for(int i = 0 ; i < 100 ; i++) {
      random.add((int)(Math.random() * 10));
      for(int j = 0 ; j < countNum.length; j++) {
        if(random.get(i) == j) {
          countNum[j]++;
        } 
      }
    }
    
    // System.out.println(random.toString());
    for(int k = 0 ; k < countNum.length ; k++) {
      for(int l = 0 ; l < countNum[k]; l++) {
        s += "#";
      }
      sharp.add(k, s);
      System.out.println(k + " : " + sharp.get(k) +" "+countNum[k]); 
      s = "";  
    }
    
  }
  
  // 난수 생성
  
  // https://chichibaby.tistory.com/31 참고로 짜보기
  public static int randomValue() {
    int[] random = new int[5];
    
    for(int n = 0 ; n <random.length ; n++) {
      int temp = (int)(Math.random() * 5);
      random[n] = temp;
      
      for(int m = 0 ; m < n ; m++) {
        if(random[m] == temp) {
          n--;
          break;
        }
      }
    }
    int randomValue = random[0];
    return randomValue;
  }
  public static void method9() {
    
    // 5 x 5 숫자 빙고판 자동 생성
    //
    // 지시사항)
    //   1. 1 ~ 25 사이 정수를 2차원 배열 bingo 에 순차적으로 넣는다.
    //      1  2  3  4  5
    //      6  7  8  9 10
    //     11 12 13 14 15
    //     16 17 18 19 20
    //     21 22 23 24 25
    //   2. 25번 서로 섞는다.
    //      순차적으로        랜덤하게
    //      모든요소접근      접근
    //      ----------------------------
    //      bingo[0][0]  <->  bingo[1][4]
    //      bingo[0][1]  <->  bingo[0][2]
    //      bingo[0][2]  <->  bingo[2][1]
    //      ...
    //      bingo[4][4]  <->  bingo[3][1]
    //
    // 실행예시)
    //  10  9  4 25  2
    //  15  3 13 21  1
    //  14 20 11 19  6
    //   8 17  5 12  7
    //  16 22 18 24 23
    int[][] bingo1 = new int[5][5];
    int[][] bingo2 = new int[5][5];
    
    // 2차원 배열 생성
    int num = 1;
    for(int i = 0 ; i < 5; i++) {    
      for(int j = 0; j < 5; j++) {
        bingo1[i][j] = num;
        num++;
      }
    }
    
    System.out.println("배열 변환");
    for(int n = 0 ; n < 5; n++) {
      for(int m = 0 ; m < 5; m++) {
        int r1 = randomValue();
        int r2 = randomValue();
        if(n != r1 || m != r2) {
          bingo2[n][m] = bingo1[r1][r2];  
        }
        System.out.print(String.format("%3d", bingo2[n][m]));
      }
      System.out.println();
    }

   
    
    
  }
    
 
  public static void main(String[] args) {
//    method1();
//    
//    Map<String, Object> map = method2("140101-4123456");
//    for(Entry<String, Object> entry : map.entrySet()) {
//      System.out.println(entry.getKey() + ": " + entry.getValue());
//    }
//    
//    method3();
//    method4();
//    method5();
    method7();
 
  }

}

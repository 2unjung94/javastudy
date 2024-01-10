package practice02_Watch;

public class Watch {
  
  // field
  private int hour;
  private int minute;
  private int second;

  
  //constructor
  public Watch(int hour, int minute, int second) {
    super();
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }
  //method
  
  // 선생님풀이
  public void addHour(int hour) {
    if(hour <= 0) {
      return;
    }
    this.hour += hour;
    this.hour %= 24;      // 0 ~ 23 사이 값을 가지게 된다.
  }
  
  public void addMinute(int minute) {
    if(minute <= 0) {
      return;
    }
    this.minute += minute;
    addHour(this.minute / 60);
    this.minute %= 60;
    
  }
  
  public void addSecond(int second) {
    if(second <= 0) {
      return;
    }
    this.second += second;
    addMinute(this.second / 60);
    this.second %= 60;
    
  }
  
  // 내가 짠 것
  /*public void addHour(int h) {
    hour += h;
    if(hour >= 24) {
      hour -= 24;
    }
  }
  
  public void addMinute(int m) {
    if(m >= 60) {
      int n = m / 60;
      hour += n;
      
      int j = m % 60;
      minute += j;
    }
    else minute += m;
  }
  
  public void addSecond(int s) {
    if(s > 3600) {
      int a = s / 60;
      addMinute(a);
      second += s % 60;
    }else if( s >= 60 && s < 3600) {
      addMinute(s);
      second += s % 60;
    }else second += s;
    
  }*/
  
  public void see() {
    System.out.println(String.format("%02d:%02d:%02d", hour, minute, second ));     // 실무에 쓰일때가 종종 있음 알아 둘 것
  }
}

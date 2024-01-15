package practice03_Bus;

public class MainClass {

  public static void main(String[] args) {
  
    Bus bus = new Bus();
    
    bus.busOn(new Woman("제시카"));
    bus.busOn(new Woman("앨리스"));
    bus.busOn(new Woman("캐서린"));
    bus.busOn(new Woman("낸시"));
    bus.busOn(new Woman("엠마"));
    
    bus.info();
    
    bus.off(1);
    bus.off(2);
    bus.off(3);
    bus.off(4);
    
    bus.busOn(new Man("스티브"));
    bus.busOn(new Man("필립"));
    bus.busOn(new Man("톰"));
    bus.busOn(new Man("앤디"));
    bus.busOn(new Man("제임스"));
    
    bus.info();
    
  }

}

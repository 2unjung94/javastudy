package pkg05_marker_interface;

public class DurianHatePerson {

 /* public void eat(Food food) {
    
    // 두리안 안먹는 사람
    // 1. 실행은 하지만 호출을 막아버리는 경우(받기는 받지만 안먹는 경우)
    if(food instanceof Durian) {
      return;
    }
    food.eat();*/
  public void eat(Eatable eatable) {
    
    ((Food) eatable).eat();
    
  }
}

package pkg02_has_a;
/*
 * 상속을 만족할 때 아래 문장을 확인할 것
 * 
 * (is a 관계)   -> 이 관계일 때 상속을 사용하는 것을 추천
 * 자식   is    a   부모
 * sub    is    a   super
 * Ev     is    a   Car
 * 
 * (has a 관계)  -> 이 관계도 상속으로 풀 수 있지만 추천은 안한다.
 * 자식   has   a   부모
 * sub    has   a   super.
 * Ev     has   a   Car
 * sodier has   a   Gun
 * 
 */

public class Soldier extends Gun {
  

}

package practice04_Bus;

// Man 또는 Woman 1개 저장 가능
public class Seat {
  
  // field
  private Person person;
  
  // constructor
  public Seat() {
    // TODO Auto-generated constructor stub
  }

  public Seat(Person person) {
    super();
    this.person = person;
  }

  // method
  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}

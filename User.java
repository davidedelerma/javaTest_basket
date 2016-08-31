public class User{
  
  private String name, surname;
  private boolean membership;

  public User(String name, String surname, boolean membership){
    this.name = name;
    this.surname = surname;
    this.membership = membership;
  }

  public String getName(){
    return name;
  }

  public String getSurname(){
    return surname;
  }

  public boolean getMembership(){
    return membership;
  }

  public void setMembership(boolean state){
    this.membership = state;
  }
}
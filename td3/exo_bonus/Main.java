public class Main {
  public static void main(String[] args) {

    System.out.println("");
    Person c1 = new Client_banque();
    Person c2 = new Client_banque();
    Person c3 = new Client_banque();
    Person c4 = new Client_banque();

    System.out.println(c1.to_string());
    System.out.println(c2.to_string());
    System.out.println(c3.to_string());
    System.out.println(c4.to_string());

    System.out.println("");
    Person p1 = new Person();

    System.out.println(p1.to_string());
  }
}

public class Main
{
  public static void main(String[] args)
  {
    System.out.println("");
    String_crypted s = new String_crypted("Bonjour", 3);
    System.out.println(s.get_str());
    System.out.println(s.shift());

    s.set_new_str("zqsd");
    System.out.println(s.get_str());
    System.out.println(s.shift());
    System.out.println(s.get_str());

    System.out.println(s.unshift());

    String test="";
    String_crypted s2 = new String_crypted(test, 3);
    System.out.println(s2.get_str());
    s2.view_str();
  }
}

import java.util.Scanner;

public class Work_string
{
  private String str;

  public Work_string()
  {
    System.out.println("Give me a string:");
    Scanner sc = new Scanner(System.in);
    this.str=sc.next();
  }

  public static void main(String[] args)
  {
    Work_string my_str = new Work_string();
    System.out.println(my_str.str);
  }
}

import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    aff_msg("Give me your name:");
    Scanner sc = new Scanner(System.in);
    String name = sc.nextLine();

    aff_msg("Give me your family name:");
    Scanner sc2 = new Scanner(System.in);
    String familyName = sc2.nextLine();

    aff_msg("Give me your age:");
    Scanner sc3 = new Scanner(System.in);
    int age = sc3.nextInt();


    aff_msg("Give me your size:");
    Scanner sc4 = new Scanner(System.in);
    int size = sc4.nextInt();

    Personne p = new Personne(name, familyName, age, size, "brown", "brown");

    Personne.aff_perso();
  }

  private static void aff_msg(String msg)
  {
    System.out.println(msg);
  }
}

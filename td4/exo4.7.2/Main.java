public class Main {
  public static void main(String[] args) {

    /*
    System.out.println("");
    Fraction frac1 = new Fraction();
    System.out.print("Numerateur is: " + frac1.get_numerateur());
    System.out.println(" and denominateur is: " + frac1.get_denominateur() + ".");
    System.out.println("Fraction is: " + frac1.to_string() + " = " + frac1.get_fraction() + "\n");

    Fraction frac2 = new Fraction((short)12);
    System.out.print("Numerateur is: " + frac2.get_numerateur());
    System.out.println(" and denominateur is: " + frac2.get_denominateur() + ".");
    System.out.println("Fraction is: " + frac2.to_string() + " = " + frac2.get_fraction() + "\n");
    */

    Fraction frac3 = new Fraction((short)3, (short)4);
    System.out.print("Numerateur is: " + frac3.get_numerateur());
    System.out.println(" and denominateur is: " + frac3.get_denominateur() + ".");
    System.out.println("Fraction is: " + frac3.to_string() + " = " + frac3.get_fraction() + "\n");

    Fraction frac4 = new Fraction((short)1, (short)3);
    System.out.print("Numerateur is: " + frac4.get_numerateur());
    System.out.println(" and denominateur is: " + frac4.get_denominateur() + ".");
    System.out.println("Fraction is: " + frac4.to_string() + " = " + frac4.get_fraction() + "\n");

    Fraction frac_res = frac3.add_fraction(frac4);
    System.out.println("Fraction is: " + frac_res.to_string());
    System.out.println("is simplified ? " + frac_res.is_simplified());
  }
}

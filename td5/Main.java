import org.apache.commons.math3.complex.*;

/**
  * @author LE DENMAT Mickael td4 21804355
  * @version v1
  *
  */
public class Main {
  public static void main(String[] args) {
    System.out.println("\nCompile success\n");

    double d1 = 14, d2 = 24;
    Complex cpl1 = new Complex(d1, d2);

    System.out.println("cpl1: "+cpl1.toString());

    ComplexFormat cpl1_f = new ComplexFormat();
    System.out.println("cpl1 format (a + bi): "+cpl1_f.format(cpl1));

    System.out.println("\n|"+cpl1_f.format(cpl1)+"| = sqrt( "+
      cpl1.getReal()+"² + "+cpl1.getImaginary()+"² ) = "
      +cpl1.abs());
  }
}

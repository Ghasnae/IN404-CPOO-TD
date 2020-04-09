import java.util.Scanner;

/**
  * Class SaisieRPN
  *
  * Gestion de la saisie de chiffre et du calcul
  */
public class SaisieRPN {

  // Attributs
  private Scanner scan;
  private MoteurRPN motor;

  // Builder
  public SaisieRPN(){
    scan = new Scanner(System.in);
    motor = new MoteurRPN();
  }

  public void saisie() {

    // Quelques tests //

    // Test n°1
    motor.save( (double)4 );
    motor.save( (double)4 );
    System.out.println( motor.treatment( Operation.PLUS ) );
    // Output: 8,0

    //
    motor.save(( double)4 );
    System.out.println( motor.treatment( Operation.PLUS ) );
    // Output: 12.0

    //
    motor.save( (double)2 );
    System.out.println( motor.treatment( Operation.MULT ) );
    // Output: 24.0

    //
    motor.reset();

    //
    motor.save( (double)152 );
    System.out.println( motor.treatment( Operation.MOINS ) );
    // Output:
    //    "Not enought number in the stack"
    //    -1.0 -> valeur indiquant une erreur

    //
    motor.save( (double)152 );
    System.out.println( motor.treatment( Operation.MOINS ) );
    // Output:
    //    0.0
  }
}

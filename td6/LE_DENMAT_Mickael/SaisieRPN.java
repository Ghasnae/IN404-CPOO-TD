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

  public void saisie2() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to the new high calculator!\n"
      +"Give me a number or an operator an I calculate for you\n");

    while( true ) {

      if( sc.hasNextDouble() )
        motor.save( sc.nextDouble() );

      //
      else{
        String choice = sc.nextLine();

        //
        switch( choice ) {
          case "exit":
            System.out.println( "You have left the calculator" );
            System.exit(0);

          //
          case "+":
            System.out.println( "res = "+motor.treatment( Operation.PLUS ) );
            break;

          //
          case "-":
            System.out.println( "res = "+motor.treatment( Operation.MOINS ) );
            break;

          //
          case "*":
            System.out.println( "res = "+motor.treatment( Operation.MULT ) );
            break;

          //
          case "/":
            System.out.println( "res = "+motor.treatment( Operation.DIV ) );
            break;
        }
      }
    }
  }
}

/**
  * Class MoteurRPN
  *
  */

public class MoteurRPN {

  // Attribut
  private StackDouble stack_num;

  // Builder
  public MoteurRPN() {
    stack_num = new StackDouble();
  }

  /**
    * Empile les elements dans la pile
    *
    * @param elem     la valeur qu'on veut empiler
    */
  public void save(Double elem) { stack_num.pushDouble(elem); }

  /**
    * Fait les calculs
    *
    * @param op   l'opération a utilisé
    * @return     -1 en cas d'erreur
    *               , sinon la valeur empilé
    */
  public double treatment(Operation op) {

    // Test si il y a assez de valeur
    if( stack_num.getLength()  <  2 ) {
      System.out.println("Not enought number in the stack");
      return (double)-1;
    }
    else {
      Double numA = stack_num.popDouble();
      Double numB = stack_num.popDouble();
      stack_num.pushDouble( op.eval( numA, numB ) );

      //
      return stack_num.peekDouble();
    }
  }

  public void reset() {
    double bin;
    while( !stack_num.isEmpty() )
      bin = stack_num.popDouble();
  }
}

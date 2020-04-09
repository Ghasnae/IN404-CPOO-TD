import java.util.*;

/**
  * Class StackDouble
  *
  * Redéfinition de la class Stack
  */
public class StackDouble {

  // Attributs
  private Stack<Double> stack;
  private int length;

  // Builder
  public StackDouble() {
    this.stack = new Stack<Double>();
    this.length = 0;
  }

  /**
    * Getter: obtenir la taille
    * @return     la taille de la pile
    */
  public int getLength() { return this.length; }

  /**
    * Getter: obtenir la pile
    * @return     la pile
    */
  public Stack<Double> getStack() { return this.stack; }

  /**
    * Verifie si la pile est vide
    * @return     Oui ou non
    */
  public boolean isEmpty() { return this.stack.empty(); }

  /**
    * Empiler un elem dans la pile
    * @param elem   la valeur a empiler
    */
  public void pushDouble(Double elem) {
    this.stack.push(elem);
    this.length += 1;
  }

  /**
    * Permet de voir l'elem du dessus sans le depiler
    * @return   -1 si echec, la valeur vu sinon
    */
  public Double peekDouble() throws EmptyStackException
  {
    //
    try {
      return this.stack.peek();
    }

    // Pile vide
    catch( EmptyStackException except ) {
      System.out.println("Error with 'stack.peek()': Stack is empty");
      return (double)-1;
    }
  }

  /**
    * Depiler un elem
    * @return     -1 si echec, la valeur depiler sinon
    */
  public Double popDouble() throws EmptyStackException
  {
    try {
      this.length -= 1;
      return this.stack.pop();
    }

    // Pile vide
    catch( EmptyStackException except ) {
      System.out.println("Error with 'stack.pop()': Stack is empty");
      return (double)-1;
    }
  }

  /**
    * Renverser la pile
    * @return     la pile renverser
    */
  public StackDouble reverse() {
    StackDouble reverse = new StackDouble();

    while( !this.isEmpty() )
      reverse.pushDouble(this.popDouble());

    return reverse;
  }

  /**
    * Affiche la pile
    */
  public StackDouble viewStack() {
    StackDouble temp = new StackDouble();

    // On depile tout on affiche
    // et on empile dans une autre pile
    System.out.print("Stack\ntop: {");
    while( !this.isEmpty() ) {
      System.out.print(" "+this.peekDouble()+", ");
      temp.pushDouble(this.popDouble());
    }

    // On retourne la pile tmp
    System.out.println("} end");
    return temp.reverse();
  }
}

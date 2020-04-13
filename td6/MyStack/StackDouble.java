import java.util.*;

/**
  * Class Stack for Double
  * @author m27bay
  *
  */
public class StackDouble {

  // Attributs
  private int sizeMax;
  private Stack<Double> stack;
  private int length;

  // Builder
  public StackDouble() {
    this.sizeMax = 100;
    this.stack = new Stack<Double>();
    this.length = 0;
  }

  /**
    * Getter: get the size of the stack
    * @return the size
    */
  public int getLength() { return this.length; }

  /**
    * Getter: get the stack
    * @return the stack
    */
  public Stack<Double> getStack() { return this.stack; }

  /**
    * Test if the stack is empty
    * @return boolean
    */
  public boolean isEmpty() { return this.stack.empty(); }

  /**
    * Push an object in the stack
    * @param Elem to push
    * @return the length on succes, else -1
    */
  public int pushDouble(Double elem) {
    if( this.length < this.sizeMax ) {
      this.stack.push(elem);
      this.length += 1;
      return length;
    }
    else
      return -1;
  }

  /**
    * Peek an object in the stack
    * @return on success, the object at the top,
    *         else -1
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
    * Pop an object in the stack
    * @return the object pop on succes,
    *         else -1
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
    * Reverse the stack
    * @return the reverse stack
    */
  public StackDouble reverse() {
    StackDouble reverse = new StackDouble();

    while( !this.isEmpty() )
      reverse.pushDouble(this.popDouble());

    return reverse;
  }

  /**
    * Print elements in the stack
    * @return the stack
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

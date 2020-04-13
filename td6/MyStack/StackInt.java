import java.util.*;

/**
  * Universal Stack
  * @author m27bay
  */
public class StackInt {

  // Attributs
  private Stack<Integer> stack;
  private int length;

  // Builder
  public StackInt() {
    this.stack = new Stack<Integer>();
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
  public Stack<Integer> getStack() { return this.stack; }

  /**
    * Test if the stack is empty
    * @return boolean
    */
  public boolean isEmpty() { return this.stack.empty(); }


  /**
    * Push an object in the stack
    * @param Elem to push
    */
  public void pushInt(int elem) {
    this.stack.push(elem);
    this.length += 1;
  }

  /**
    * Peek an object in the stack
    * @return on success, the object at the top,
    *         else -1
    */
  public int peekInt() throws EmptyStackException
  {
    try {
      return this.stack.peek();
    }
    catch( EmptyStackException except ) {
      System.out.println("Error with 'stack.peek()': Stack is empty");
      return -1;
    }
  }

  /**
    * Pop an object in the stack
    * @return the object pop on succes,
    *         else -1
    */
  public int popInt() throws EmptyStackException
  {
    try {
      this.length -= 1;
      return this.stack.pop();
    }
    catch( EmptyStackException except ) {
      System.out.println("Error with 'stack.pop()': Stack is empty");
      return -1;
    }
  }

  /**
    * Reverse the stack
    * @return the reverse stack
    */
  public StackInt reverse() {
    StackInt reverse = new StackInt();

    while( !this.isEmpty() )
      reverse.pushInt(this.popInt());

    return reverse;
  }

  /**
    * Push an object in the stack
    * @param Elem to push
    * @return the length on succes, else -1
    */
  public StackInt viewStack() {
    StackInt temp = new StackInt();

    System.out.print("Stack\ntop: {");
    while( !this.isEmpty() ) {
      System.out.print(" "+this.peekInt()+", ");
      temp.pushInt(this.popInt());
    }
    System.out.println("} end");
    return temp.reverse();
  }
}

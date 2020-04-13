import java.util.*;

/**
  * Universal Stack
  * @author m27bay
  */
public class MyStack {

  // Attributs
  private Stack<Object> stack;
  private int length;

  // Builder
  public MyStack() {
    this.stack = new Stack<Object>();
    this.length = 0;
  }

  /**
    * Get the size of the stack
    * @return size of the stack
    */
  public int getLength() { return this.length; }

  /**
    * Get the stack
    * @return the stack
    */
  public Stack<Object> getStack() { return this.stack; }

  /**
    * Test if the stack is empty
    * @return boolean
    */
  public boolean isEmpty() { return this.stack.empty(); }

  /**
    * Push an object in the stack
    * @param Elem to push
    */
  public void pushObj(Object elem) {
    this.stack.push(elem);
    this.length += 1;
  }

  /**
    * Peek an object in the stack
    * @return on success, the object at the top,
    *         else -1
    */
  public Object peekObj() throws EmptyStackException
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
  public Object popObj() throws EmptyStackException
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
  public MyStack reverse() {
    MyStack reverse = new MyStack();

    while( !this.isEmpty() )
      reverse.pushObj(this.popObj());

    return reverse;
  }

  /**
    * Print elements in the stack
    * @return the stack
    */
  public MyStack viewStack() {
    MyStack temp = new MyStack();

    System.out.print("Stack\ntop: {");
    while( !this.isEmpty() ) {
      System.out.print(" "+this.peekObj()+", ");
      temp.pushObj(this.popObj());
    }
    System.out.println("} end");
    return temp.reverse();
  }
}

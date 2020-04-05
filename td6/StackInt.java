import java.util.*;

public class StackInt {
  private Stack<Integer> stack;
  private int length;

  public StackInt() {
    this.stack = new Stack<Integer>();
    this.length = 0;
  }

  public int getLength() { return this.length; }
  public Stack<Integer> getStack() { return this.stack; }
  public boolean isEmpty() { return this.stack.empty(); }

  public void pushInt(int elem) {
    this.stack.push(elem);
    this.length += 1;
  }

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

  public StackInt reverse() {
    StackInt reverse = new StackInt();

    while( !this.isEmpty() )
      reverse.pushInt(this.popInt());

    return reverse;
  }

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

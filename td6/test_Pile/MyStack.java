import java.util.*;

public class MyStack {
  private Stack<Object> stack;
  private int length;

  public MyStack() {
    this.stack = new Stack<Object>();
    this.length = 0;
  }

  public int getLength() { return this.length; }
  public Stack<Object> getStack() { return this.stack; }
  public boolean isEmpty() { return this.stack.empty(); }

  public void pushObj(Object elem) {
    this.stack.push(elem);
    this.length += 1;
  }

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

  public MyStack reverse() {
    MyStack reverse = new MyStack();

    while( !this.isEmpty() )
      reverse.pushObj(this.popObj());

    return reverse;
  }

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

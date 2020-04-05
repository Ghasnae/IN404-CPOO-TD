public class Main {
  public static void main(String[] args) {
    System.out.println("Compile success\n\n");

    System.out.println("##### StackInt #####");
    StackInt stack = new StackInt();

    System.out.println("Value push '1'");
    stack.pushInt(1);

    System.out.println("Value push '2'");
    stack.pushInt(2);

    System.out.println("Value push '3'");
    stack.pushInt(3);

    System.out.println("\nlength of the stack: "+stack.getLength());

    System.out.print("\nTop stack: '"+stack.peekInt()+"'\n");
    System.out.println("Value pop: '"+stack.popInt()+"'");
    System.out.print("Top stack: '"+ stack.peekInt()+"'\n");

    // System.out.println("Reverse the stack");
    // stack = stack.reverse();
    // stack.peekInt();

    System.out.println("\nValue push '4'");
    stack.pushInt(4);

    System.out.println("Value push '5'");
    stack.pushInt(5);

    System.out.println("Value push '6'");
    stack.pushInt(6);

    stack = stack.viewStack();
    System.out.println("##### End #####");


    System.out.println("\n##### MyStack #####");
    MyStack stack2 = new MyStack();

    System.out.println("Object push '1'");
    stack2.pushObj(42);

    System.out.println("Object push '3.14159265359'");
    stack2.pushObj(3.14159265359);

    System.out.println("Object push 'Hello'");
    stack2.pushObj("Hello");

    System.out.println("\nlength of the stack: "+stack2.getLength());

    System.out.print("\nTop stack: '"+stack2.peekObj()+"'\n");
    System.out.println("Object pop: '"+stack2.popObj()+"'");
    System.out.println("length of the stack: "+stack2.getLength());

    System.out.print("\nTop stack: '"+ stack2.peekObj()+"'\n");

    System.out.println("\nObject push 'Hello'");
    stack2.pushObj("Hello");

    System.out.println("Object push 'There'");
    stack2.pushObj("There");

    System.out.println("Object push 'General'");
    stack2.pushObj("General");

    System.out.println("Object push 'Kenobi'\n");
    stack2.pushObj("Kenobi");

    stack2 = stack2.viewStack();
    System.out.println("##### End #####");
  }
}

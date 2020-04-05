public class MoteurRPN {
  private MyStack stack;
  private Operation op;

  public MoteurRPN() { stack = new MyStack(); }

  public void save(Object obj) { stack.pushObj(obj); }

  public void treatment() {
    Object obj = stack.peekObj();
    for( Operation op: Operation.values() ) {
      if( obj.equals(op) ) {
        Object symbole = stack.popObj();
        Object val1 = stack.popObj();
        Object val2 = stack.popObj();
        op.eval(val1, val2)
      }
    }
  }
}

public enum Operation {
  PLUS  ("+") { public double eval(double val1, double val2) { return val1+val2 } },
  MOINS ("-") { public double eval(double val1, double val2) { return val1-val2 } },
  MULT  ("*") { public double eval(double val1, double val2) { return val1*val2 } },
  DIV   ("/") { public double eval(double val1, double val2) { return val1/val2 } };

  private String symbole;

  public Operation() {}

  public Operation(String symbole) {
    this.symbole = symbole;
  }

  public abstract double eval(double val1, double val2));
}

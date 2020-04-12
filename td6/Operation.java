/**
  * Enum Operation
  *
  * Utilisé pour associer le symbole
  * à l'opération
  *
  */
public enum Operation {
  PLUS  ('+') { public double eval(double val1, double val2) { return val1+val2; } },
  MOINS ('-') { public double eval(double val1, double val2) { return val2-val1; } },
  MULT  ('*') { public double eval(double val1, double val2) { return val1*val2; } },
  DIV   ('/') { public double eval(double val1, double val2) { return val2/val1; } };

  // Attribut
  private char symbole;

  // Builder
  Operation(char symbole) {
    this.symbole = symbole;
  }

  public abstract double eval(double val1, double val2);
}

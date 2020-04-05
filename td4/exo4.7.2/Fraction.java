public class Fraction implements Interface1 {
  // Attributs
  protected short num; // Pour le numerateur
  protected short den; // Pour le denominateur

  // Methods
  // Builders
  public Fraction() {
    this.num = 0;
    this.den = 1;
  }

  public Fraction(short numerateur /* ou short _numerateur*/) {
    // ou den = _denominateur;
    this.num = numerateur;
    this.den = 1;
  }

  public Fraction(short numerateur, short denominateur) {
    this.num = numerateur;
    this.den = denominateur;
  }

  public short get_numerateur() {
    return num;
  }

  public short get_denominateur() {
    return den;
  }

  public double get_fraction() {
    double convert = (double)num;
    return convert/den;
  }

  public void set_numerateur(short new_num) {
    this.num = new_num;
  }

  public void set_denominateur(short new_den) {
    this.den = new_den;
  }

  public String to_string() {
    return num + "/" + den;
  }

  public Fraction add_fraction(Fraction other) {
    Fraction res = new Fraction();
    short res_num, res_den;
    short other_num = other.get_numerateur();
    short other_den = other.get_denominateur();

    if(this.den != other_den)
      res_den = (short) (this.den*other_den);
    else
      res_den = this.den;

    res_num = (short) ((this.num*other_den) + (other_num*this.den));

    res.set_numerateur(res_num);
    res.set_denominateur(res_den);

    return res;
  }

  private int pgcd(int a, int b) {
    if (b>a) {
      int tmp = a;
      a = b;
      b = tmp;
    }
    int r;
    do {
      r = a % b;
      a = b;
      b = r;
    } while(r!=0);

    return a;
  }

  public boolean is_simplified() {
    int frac = pgcd(this.num, this.den);

    if(frac == 1)
      return true;
    return false;
  }
}

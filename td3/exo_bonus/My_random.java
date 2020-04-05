import java.util.Random;

public class My_random
{
  // attributs //
  private int rand_int;
  private String rand_str;
  private long rand_long;

  // Methods //

  // builder //
  public My_random()
  {
    // Creat random string and integer.
    this.rand_int=rand_integer();
    this.rand_str=rand_string();
    this.rand_long=rand_long();
  }

  // Reset string //
  public void reset_rand_str()
  {
    // System.out.println("Reset the random string.");
    rand_str="";
  }

  // Creation of the random char //
  public char rand_char()
  {
    // Creation of an random number
    Random rand = new Random();
    int num_alea = rand.nextInt((int)'z' - (int)'a' + 1) + (int)'a';

    // Conversion in char.
    return (char) num_alea;
  }

  // Creation of a random string //
  public String rand_string()
  {
    // Concatenation for any caracteres.
    reset_rand_str();

    for(int i=0; i<5; ++i)
    {
      rand_str+=rand_char();
    }
    return rand_str;
  }

  // Creation of a random integer //
  public int rand_integer()
  {
    Random rand = new Random();
    return rand.nextInt(5);
  }

  public long rand_long()
  {
    Random rand = new Random();
    return rand.nextLong();
  }

  // String getter //
  public String get_rand_string()
  {
    return rand_str;
  }

  // Integer getter //
  public int get_rand_int()
  {
    return rand_int;
  }

  public long get_rand_long()
  {
    return rand_long;
  }
}

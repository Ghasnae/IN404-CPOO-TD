public class Person extends My_random
{
  private final String name, f_name;
  private final int age;
  private final long num_CNI;

  public Person()
  {
    My_random rand = new My_random();

    this.name = rand.get_rand_string();
    this.f_name = rand.rand_string();

    this.age = 20 + rand.get_rand_int();

    long tmp = rand.get_rand_long();
    if(tmp<0)
      tmp=-tmp;
    this.num_CNI = tmp;
  }

  public String get_name()
  {
    return name;
  }

  public String get_f_name()
  {
    return f_name;
  }

  public int get_age()
  {
    return age;
  }

  public long get_num_CNI()
  {
    return num_CNI;
  }

  public String to_string()
  {
    return name + " " + f_name + ", " + age + " years old, CNI: " + num_CNI;
  }
}

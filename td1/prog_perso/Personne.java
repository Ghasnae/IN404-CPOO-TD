public class Personne
{
  String persoName;
  String persoFamilyName;
  int persoAge;
  int persoSize;
  String persoEyesColor;
  String persoHairColor;

  public Personne(String name, String familyName, int age, int size, String eyesColor, String hairColor)
  {
    this.persoName=name;
    this.persoFamilyName=familyName;

    this.persoAge=age;
    this.persoSize=size;

    this.persoEyesColor=eyesColor;
    this.persoHairColor=hairColor;
  }

  public void aff_perso()
  {
    System.out.println("\nHello, my name is " + this.persoName + " " + this.persoFamilyName + ".");
    System.out.println("I'm " + this.persoAge + " years old.");
    System.out.println("I'm " + this.persoSize + " cm told.");
    System.out.println("I've " + this.persoEyesColor + " eyes and " + this.persoHairColor + " hairs.");
  }

  public void test_size()
  {
    if(this.persoSize>200 || this.persoSize<10)
      System.out.println("You haven't " + this.persoSize + " years old!");

    else
      System.out.println("Nothing.");

  }

  public void test_age()
  {
    if(this.persoSize<200)
    {
      static int now = 2020;
      int date_of_bird = now - this.persoAge;

      System.out.println("You was bord in " + date_of_bird + ".");
    }
    else
      System.out.println("You haven't " + this.persoSize + " told.")
  }

}

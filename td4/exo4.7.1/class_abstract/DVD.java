public class DVD extends Document_abstract
{
  // Attributs
  private String title;
  private String producer;
  private int year_of_release;

  // Methodes
  // Builders
  public DVD()
  {
    this.title = "Unknown";
    this.producer="Unknown";
    this.year_of_release=0;
  }

  public DVD(String title, String producer, int year)
  {
    this.title = title;
    this.producer = producer;
    this.year_of_release = year;
  }


  public String to_String()
  {
    return "Title: '" + title + "', producer: " + producer + ", year of release: " + year_of_release + ".";
  }
}

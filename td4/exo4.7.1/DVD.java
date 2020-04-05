public class DVD extends Document
{
  // Attributs
  private String producer;
  private int year_of_release;

  // Methodes
  // Builders
  public DVD()
  {
    super();
    this.producer="Unknown";
    this.year_of_release=0;
  }

  public DVD(String _title, String producer, int year)
  {
    super(_title);
    this.producer = producer;
    this.year_of_release = year;
  }

  public String get_producer()
  {
    return producer;
  }

  public String to_String()
  {
    return "Title: '" + title + "', producer: " + producer + ", year of release: " + year_of_release + ".";
  }
}

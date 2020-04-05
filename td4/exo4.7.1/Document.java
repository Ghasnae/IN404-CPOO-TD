public class Document
{
  // Attributs
  protected final String title;
  // Methods
  // Builders
  public Document()
  {
    this.title = "Unknown";
  }

  public Document(String title)
  {
    this.title = title;
  }

  public String get_artist_name()
  {
    return "Unknown";
  }

  public String get_producer()
  {
    return "Unknown";
  }

  public String to_String()
  {
    return "Title: " + title;
  }
}

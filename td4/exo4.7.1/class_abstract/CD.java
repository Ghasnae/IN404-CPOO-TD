public class CD extends Document_abstract
{
  // Attributs
  private String title;
  private String artist_name;
  private int nbr_of_songs;

  // Methods
  // Builders
  public CD()
  {
    this.title = "Unknown";
    this.artist_name = "Unknown";
    this.nbr_of_songs = 0;
  }

  public CD(String title, String artist_name, int number_songs)
  {
    this.title = title;
    this.artist_name = artist_name;
    this.nbr_of_songs = number_songs;
  }

  public String to_String()
  {
    return "Title: '" + title + "', artist name: " + artist_name + ", number of songs: " + nbr_of_songs + ".";
  }
}

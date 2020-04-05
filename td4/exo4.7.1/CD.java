public class CD extends Document
{
  // Attributs
  private String artist_name;
  private int nbr_of_songs;

  // Methods
  // Builders
  public CD()
  {
    super();
    this.artist_name = "Unknown";
    this.nbr_of_songs = 0;
  }

  public CD(String _title, String artist_name, int number_songs)
  {
    super(_title);
    this.artist_name = artist_name;
    this.nbr_of_songs = number_songs;
  }

  public String get_artist_name()
  {
    return artist_name;
  }

  public String to_String()
  {
    return "Title: '" + title + "', artist name: " + artist_name + ", number of songs: " + nbr_of_songs + ".";
  }
}

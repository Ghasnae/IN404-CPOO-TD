import java.util.ArrayList;

public class Collection
{
  // Attributs
  private ArrayList <Document> list_of_doc;

  // Methods
  // Builders
  public Collection()
  {
    this.list_of_doc = new ArrayList <Document>();
  }

  public void add_doc(Document new_doc)
  {
    list_of_doc.add(new_doc);
  }

  public boolean found_doc(String key_word)
  {
    boolean found = false;
    int nbr_result = 0;

    for(Document tmp: list_of_doc)
    {
      if(tmp.title.compareTo(key_word) == 0)
      {
        found=true;
        nbr_result++;
        System.out.println("I've found: " + nbr_result + " match result of '" + key_word + "'.");
        System.out.println(tmp.to_String());
      }
      else if(tmp.get_artist_name().compareTo(key_word) == 0)
      {
        found=true;
        nbr_result++;
        System.out.println("I've found: " + nbr_result + " match result of '" + key_word + "'.");
        System.out.println(tmp.to_String());
      }
      else if(tmp.get_producer().compareTo(key_word) == 0)
      {
        found=true;
        nbr_result++;
        System.out.println("I've found: " + nbr_result + " match result of '" + key_word + "'.");
        System.out.println(tmp.to_String());
      }
    }
    if(!found)
      System.out.println("'" + key_word + "' not found in the collection.");
    return found;
  }

  public void view_collection()
  {
    System.out.println("List of document(s) in the collection:");
    for(Document tmp: list_of_doc)
      // Use to_string in CD if Doc is a CD or DVD if Doc is a DVD
      System.out.println(tmp.to_String());
  }
}

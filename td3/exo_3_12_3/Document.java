import java.util.ArrayList;

public class Document
{
  // Attributs //
  private String title;

  private String writer_name;
  private String writer_family_name;

  private int publication_year;

  private int nbr_of_ref;
  // Don't use an array, use a list, like in python.
  private ArrayList <String> list_of_reference;

  // Methods //

  // Builder //
  public Document(String d_title, String d_writer_name, String d_writer_family_name, int doc_year)
  {
    this.title=d_title;

    this.writer_name=d_writer_name;
    this.writer_family_name=d_writer_family_name;

    this.publication_year=doc_year;

    this.nbr_of_ref=0;
    this.list_of_reference = new ArrayList<String>();
  }

  public String get_title()
  {
    return title;
  }

  public ArrayList<String> get_ref()
  {
    return list_of_reference;
  }

  public void add_reference(String name_reference)
  {
    if(name_reference == null)
      System.out.println("Add failed: string null.");
    else
    {
      nbr_of_ref+=1;
      list_of_reference.add(name_reference);
    }
  }

  public void view_ref()
  {
    System.out.println(nbr_of_ref + " Référence(s) :");
    if(nbr_of_ref==0)
      System.out.println("List empty.");
    else
    {
      // That mean ref in list_of_reference, like in python
      for(String ref: list_of_reference)
        System.out.println(ref + ".");
    }
  }

  public boolean auteur_is_equal(String f_name, String name)
  {
    if((this.writer_family_name.compareTo(f_name)==0) && (this.writer_name.compareTo(name))==0)
      return true;
    return false;
  }

  public boolean doc_is_equal(Document other)
  {
    if(auteur_is_equal(other.writer_family_name, other.writer_name) && (this.title.compareTo(other.title)==0) && (this.publication_year==other.publication_year))
      return true;
    return false;
  }

  public boolean title_is_equal(String title)
  {
    if(this.title.compareTo(title)==0)
      return true;
    return false;
  }

  public String to_String()
  {
    return title + ", " + writer_name + " " + writer_family_name + ", " + publication_year + ".";
  }
}

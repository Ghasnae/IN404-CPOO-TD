import java.util.Scanner;
import java.util.ArrayList;

public class Library
{
  // Attribtus //
  private  ArrayList <Document> library;

  // Methods //

  // Builder //
  public Library()
  {
    this.library = new ArrayList<Document>();
  }

  public boolean add_document(Document new_doc)
  {
    if(library.add(new_doc))
      return true;
    return false;
  }

  public boolean found_title()
  {
    System.out.println("Here you can found a book.\nGive me the title of the book:");
    Scanner sc = new Scanner(System.in);
    String title=sc.next();

    return is_here(title);
  }

  private boolean is_here(String title)
  {
    for(Document tmp: library) {
      if(tmp.title_is_equal(title))
      {
        System.out.println("'" + title + "'" + " is in the library.");
        System.out.println("Is here: " + tmp.to_String());
        return true;
      }
    }
    System.out.println("'" + title + "'" + " isn't in the library.");
    return false;
  }

  public boolean found_reference()
  {
    System.out.println("Here you can found a reference in a book.\nGive me the reference:");
    Scanner sc = new Scanner(System.in);
    String reference=sc.next();

    return ref_is_here(reference);
  }

  private boolean ref_is_here(String reference)
  {
    for(Document tmp: library) {
      for(String ref_book: tmp.get_ref()) {
        if(ref_book.compareTo(reference)==0) {

          System.out.println("'" + reference + "'" + " is in the library.");
          System.out.println("Is here: " + tmp.to_String());
          tmp.view_ref();
          return true;
        }
      }
    }
    System.out.println("'" + reference + "'" + " isn't in any books.");
    return false;
  }

  public void view_library()
  {
    System.out.println("Document in the library:");
    for(Document doc: library)
      System.out.println(doc.to_String());
  }
}

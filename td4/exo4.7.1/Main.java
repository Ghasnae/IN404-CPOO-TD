public class Main{
  public static void main(String[] args) {

    // System.out.println("");
    Document doc1 = new CD("Greatest Hits", "Queen", 17);
    Document doc2 = new CD("Greatest Hits II", "Queen", 17);
    Document doc3 = new DVD("I Am Legend", "Francis Lawrence", 2007);
    Document doc4 = new DVD("Avatar", "James Cameron", 2009);
    Document doc5 = new DVD("Saving Private Ryan", "Steven Spielberg", 1998);

    System.out.println("");
    Collection collection1 = new Collection();
    collection1.add_doc(doc1);
    collection1.add_doc(doc2);
    collection1.add_doc(doc3);
    collection1.add_doc(doc4);
    collection1.add_doc(doc5);
    collection1.view_collection();

    System.out.println("");
    collection1.found_doc("James Cameron");
    System.out.println("");
    collection1.found_doc("Michel Druker");
    System.out.println("");
    collection1.found_doc("Queen");
    System.out.println("");
    collection1.found_doc("Avatar");
  }
}

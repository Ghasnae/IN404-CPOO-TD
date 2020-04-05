public class Main{
  public static void main(String[] args) {

    // System.out.println("");
    Document_abstract doc1 = new CD("Greatest Hits", "Queen", 17);
    Document_abstract doc2 = new CD("Greatest Hits II", "Queen", 17);
    Document_abstract doc3 = new DVD("I Am Legend", "Francis Lawrence", 2007);
    Document_abstract doc4 = new DVD("Avatar", "James Cameron", 2009);
    Document_abstract doc5 = new DVD("Saving Private Ryan", "Steven Spielbarg", 1998);

    System.out.println("");
    System.out.println(doc1.to_String());
    System.out.println(doc2.to_String());
    System.out.println(doc3.to_String());
    System.out.println(doc4.to_String());
    System.out.println(doc5.to_String());
  }
}

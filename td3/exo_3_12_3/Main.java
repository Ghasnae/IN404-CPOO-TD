public class Main
{
  public static void main(String[] args) {
    System.out.println("");
    // Init a new document //
    Document doc1 = new Document("Les_Misérables", "Victor", "Hugo", 1862);
    System.out.println(doc1.to_String());

    // Add few reference in the document //
    doc1.add_reference("reference_1");
    doc1.add_reference("reference_2");
    doc1.add_reference("reference_3");

    // System.out.println(doc1.to_String());
    // System.out.println("");
    // doc1.view_ref();

    Document doc2 = new Document("Notre-Dame_de_Paris", "Victor", "Hugo", 1831);
    doc2.add_reference("reference_11");
    doc2.add_reference("reference_12");
    doc2.add_reference("reference_13");

    Document doc3 = new Document("Les_Contemplations", "Victor", "Hugo", 1856);
    doc3.add_reference("reference_21");
    doc3.add_reference("reference_22");
    doc3.add_reference("reference_23");

    System.out.println("");
    Library lib = new Library();
    System.out.println("Document '" + doc1.get_title() + "' add ? " + lib.add_document(doc1));
    System.out.println("Document '" + doc2.get_title() + "' add ? " + lib.add_document(doc2));
    System.out.println("Document '" + doc3.get_title() + "' add ? " + lib.add_document(doc3));

    System.out.println("");
    lib.view_library();

    System.out.println("");
    lib.found_title();

    System.out.println("");
    lib.found_reference();
  }
}

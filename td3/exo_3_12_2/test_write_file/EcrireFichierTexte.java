import java.io.*;
import java.util.Scanner;

class EcrireFichierTexte{
  public static void main(String[] args) throws IOException{
    PrintWriter writer;
    int n=5;

    Scanner sc = new Scanner(System.in);
    System.out.println("Give me a file name (without extension): ");
    String file_name = sc.next();
    file_name+=".txt";

    writer = new PrintWriter (new BufferedWriter(new FileWriter(file_name)));

    writer.print("Here is an integer : ");
    writer.println(n);
    writer.println(new String("test"));
    writer.close();
  }
}

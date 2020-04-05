import java.io.*;

public class Client
{
  // Attributs //
  private String name;
  private int errors;

  // Methods //

  // Builder //
  public Client()
  {
    // Creat random name and errors.
    My_random rand = new My_random();

    this.name=rand.get_rand_string();
    this.errors=rand.get_rand_int();
  }
  // End builder //

  // User name getter //
  public String get_user_name()
  {
    return name;
  }

  // Errors getter //
  public int get_errors()
  {
    return errors;
  }

  // Name setter //
  public void set_user_name(String u_name)
  {
    System.out.println("User name is change.");
    name=u_name;
  }

  // Try connexion with the server //
  public boolean sign_in(Server s)
  {
    // System.out.println("Connexion with the server in process...");
    if(s.get_opening())
    {
      // System.out.println("Connexion with the server: Success");
      // System.out.println("Connexion with the client in process...");
      if(s.sign(this))
      {
        // System.out.println("Connexion with the client: Success");
        System.out.println(this.name + ": Connected.");

        // All is ok, add the new client in the list.
        s.add_client(this);

        return true;
      }
      else
      {
        // System.out.println("Connexion with the client: Fail");
        return false;
      }
    }
    // System.out.println("Connexion with the server: Fail");
    return false;
  }

  public boolean is_equal(Client other)
  {
    if((this.name.compareTo(other.get_user_name())==0) && (this.errors==other.errors))
      return true;
    return false;
  }

  // Send and receive message //
  public void send_msg(String msg, Server s)
  {
    System.out.println("\nClient '" + name + "' send a new message for everyone.");
    s.broadcast(msg, this);
  }

  public void receive_msg(String msg)
  {
    System.out.println("\nClient: '" + name + "' receive a new message :\n" + msg + ".");
  }

  // View all paramters //
  public String to_String()
  {
    return "\nName user is: " + name + ". Number(s) of error(s) is: " + errors + ".";
  }

  // public void write_input(String input) throws IOException
  // {
  //   try
  //   {
  //     PrintWriter writer = new FileWriter("input.txt");
  //     writer.println(input);
  //     writer.close();
  //   }
  //   catch(FileNotFoundException ex)
  //   {
  //     System.out.println("Errors: File not found.");
  //   }
  // }
}

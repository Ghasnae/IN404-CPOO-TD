import java.util.Random;

public class Client_banque extends Person
{
  // Attributs
  protected final long num_client;

  // Methods
  // Builders
  Client_banque()
  {
    super();

    long tmp = rand_long();
    if(tmp<0)
      tmp=-tmp;
    this.num_client = tmp;
  }

  public long rand_long()
  {
    Random rand = new Random();
    return rand.nextLong();
  }

  public String to_string()
  {
    return "Client n°: " + num_client;
  }
}

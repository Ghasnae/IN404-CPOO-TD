import java.io.IOException;
import java.util.Scanner;

public class DnsApp {
	//
	private DnsTUI support;
	
	/**
	 * Builder
	 */
	public DnsApp()
	{
		this.support = new DnsTUI();
	}
	
	public void run() throws IOException
	{
		Scanner scan = new Scanner( System.in );
		while( true )
		{
			System.out.print( "> " );
			String arg = scan.nextLine();
			support.setArg( arg );
			support.nextCommand();
		}
	}
}


// For read the file

import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.FileReader;

// Exception
import java.io.IOException;
import java.io.FileNotFoundException;
import java.lang.NumberFormatException;

//
import java.util.*;

/**
 *
 */
public class Main {
	
	public static void main( String[] args ) throws IOException
	{
		System.out.println( "Usage : after the '>' you can tape a ip address for know his machine name\n" +
				"or vise versa, or you can tape 'ls -a' follows with a domain for know all machine in this domain\n" +
				"or just 'ls' follows with a domain for know all ip address in this domain\n" +
				"or 'Exit' for exit.\n" );
		DnsApp app = new DnsApp();
		app.run();
	}
}

import java.io.IOException;

public class DnsTUI {
	
	//
	private String arg;
	private ExeCmd exe;
	
	/**
	 * Builder
	 */
	public DnsTUI()
	{
		this.exe = new ExeCmd();
	}
	
	/**
	 * Getter: get arg
	 *
	 * @return arg
	 */
	public String getArg()
	{
		return arg;
	}
	
	/**
	 * Setter: set cmd
	 *
	 * @param newArg
	 */
	public void setArg( String newArg )
	{
		this.arg = newArg;
	}
	
	/**
	 * @param res
	 */
	public void printRes( String res )
	{
		System.out.println( "Answer : "+res );
	}
	
	/**
	 *
	 */
	public void nextCommand() throws IOException
	{
		int countPoint = 0;
		
		for( int c = 0 ; c < this.arg.length() ; c++ )
		{
			if( this.arg.charAt( c ) == '.' )
				countPoint++;
		}
		
		// Maybe machine
		if( countPoint == 2 )
		{
			// Split cmd string
			String read[] = new String[ 3 ]; // Save three substring
			int pos = 0;
			
			// Found name machine
			pos = this.arg.indexOf( "." );
			read[ 0 ] = this.arg.substring( 0, pos );
			this.arg = this.arg.substring( pos + 1, this.arg.length() );
			
			// Found name domain
			pos = this.arg.indexOf( "." );
			read[ 1 ] = this.arg.substring( 0, pos );
			this.arg = this.arg.substring( pos + 1, this.arg.length() );
			
			// Found local
			read[ 2 ] = this.arg;
			
			// Check good format
			for( String str : read )
			{
				for( int c = 0 ; c < str.length() ; c++ )
				{
					if( !Character.isLetterOrDigit( str.charAt( c ) ) )
					{
						System.out.println( "Error: not good format for machine name, is not a letter or digit"
								+ " => '" + str.charAt( c ) + "'" );
					}
				}
			}
			
			//
			this.arg = read[ 0 ] + "." + read[ 1 ] + "." + read[ 2 ];
			this.exe.setCmdExe( "NomMachineToIp" );
			this.exe.setArg( this.arg );
			printRes( this.exe.execute() );
		}
		
		// Maybe ip address
		else if( countPoint == 3 )
		{
			String tmp = this.arg;
			// Split cmd string
			int read[] = new int[ 4 ]; // Save three substring
			
			// Init variables
			int pos = 0;
			String reseau, mask, mask2, id;
			
			// Found first number
			pos = tmp.indexOf( "." );
			reseau = tmp.substring( 0, pos );
			tmp = tmp.substring( pos + 1, tmp.length() );
			
			// Found second number
			pos = tmp.indexOf( "." );
			mask = tmp.substring( 0, pos );
			tmp = tmp.substring( pos + 1, tmp.length() );
			
			// Found third number
			pos = tmp.indexOf( "." );
			mask2 = tmp.substring( 0, pos );
			
			// Found last number
			id = tmp.substring( pos + 1, tmp.length() );
			
			try
			{
				read[ 0 ] = Integer.parseInt( reseau );
				read[ 1 ] = Integer.parseInt( mask );
				read[ 2 ] = Integer.parseInt( mask2 );
				read[ 3 ] = Integer.parseInt( id );
			}
			catch( NumberFormatException exception )
			{
				System.out.println( "Error: not good format for IP address, is not a number" );
				System.exit( 1 );
			}
			
			boolean isgood = true;
			for( int value : read )
			{
				if( !( 0 <= value && value <= 255 ) )
				{
					System.out.println( "Error: not good format for IP address, " +
							"number need to be smaller or equal than 255 and bigger or equal than zero"
							+ " => '" + value + "'" );
					isgood = false;
				}
			}
			
			//
			if( isgood )
			{
				this.exe.setCmdExe( "IpToNomMachine" );
				this.exe.setArg( this.arg );
				printRes( this.exe.execute() );
			}
		}
		
		// Maybe 'ls'
		else if( this.arg.contains( "ls" ) )
		{
			if( this.arg.contains( "-a" ) )
			{
				int pos = this.arg.indexOf( "a" );
				String tmp = this.arg.substring( pos + 2, this.arg.length() );
				
				this.exe.setCmdExe( "ls -a" );
				this.exe.setArg( tmp );
				printRes( this.exe.execute() );
			}
			
			else
			{
				int pos = this.arg.indexOf( "s" );
				String tmp = this.arg.substring( pos + 2, this.arg.length() );
				
				this.exe.setCmdExe( "ls" );
				this.exe.setArg( tmp );
				printRes( this.exe.execute() );
			}
		}
		
		// Maybe Exit
		else if( this.arg.equals( "Exit" ) )
		{
			System.exit( 1 );
		}
		else
		{
			printRes( "Command unknown" );
		}
	}
}

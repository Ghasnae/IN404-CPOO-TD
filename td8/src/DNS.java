
// For read the file

import java.io.BufferedReader;
import java.io.FileReader;

// Exception
import java.io.IOException;
import java.io.FileNotFoundException;

//
import java.util.*;

/**
 *
 */
public class DNS {
	
	/**
	 * Class AdresseIP
	 */
	public class AdresseIP {
		
		// format : reseau.mask.mask2.id
		private int reseau;
		private int mask;
		private int mask2;
		private int id;
		
		/**
		 * Builder: default
		 */
		public AdresseIP()
		{
			this.reseau = -1;
			this.mask = -1;
			this.mask2 = -1;
			this.id = -1;
		}
		
		/**
		 * Builder with reseau
		 */
		public AdresseIP( int reseau )
		{
			// test : 0 <= reseau <= 255 ?
			if( check( reseau ) )
				this.reseau = reseau;
			else
				this.reseau = -1;
			
			//
			this.mask = -1;
			this.mask2 = -1;
			this.id = -1;
		}
		
		/**
		 * Builder all param
		 */
		public AdresseIP( int reseau, int mask, int mask2, int id )
		{
			// test : 0 <= all param <= 255
			if( !check( reseau, mask, mask2, id ) )
			{
				// this() must be first statement in constructor body
				this.reseau = -1;
				this.mask = -1;
				this.mask2 = -1;
				this.id = -1;
			}
			
			//
			this.reseau = reseau;
			this.mask = mask;
			this.mask2 = mask2;
			this.id = id;
		}
		
		/**
		 * Check number
		 *
		 * @param reseau
		 *
		 * @return true/false
		 */
		private boolean check( int reseau )
		{
			return reseau <= 255 & reseau >= 0;
		}
		
		/**
		 * Check numbers
		 *
		 * @param reseau
		 * @param mask
		 * @param mask2
		 * @param id
		 *
		 * @return true/false
		 */
		private boolean check( int reseau, int mask, int mask2, int id )
		{
			return check( reseau )
					& mask >= 0 & mask <= 255
					& mask2 >= 0 & mask2 <= 255
					& id >= 0 & id <= 255;
		}
		
		/**
		 * Getter: get reseau
		 *
		 * @return reseau value
		 */
		public int getReseau()
		{
			return this.reseau;
		}
		
		/**
		 * Setter: set reseau
		 *
		 * @param newReseau
		 */
		public void setReseau( int newReseau )
		{
			this.reseau = newReseau;
		}
		
		/**
		 * Getter: get mask
		 *
		 * @return mask value
		 */
		public int getMask()
		{
			return this.mask;
		}
		
		/**
		 * Setter: set mask
		 *
		 * @param newMask
		 */
		public void setMask( int newMask )
		{
			this.mask = newMask;
		}
		
		/**
		 * Getter: get mask2
		 *
		 * @return mask value
		 */
		public int getMask2()
		{
			return this.mask2;
		}
		
		/**
		 * Setter: set mask2
		 *
		 * @param newMask2
		 */
		public void setMask2( int newMask2 )
		{
			this.mask2 = newMask2;
		}
		
		/**
		 * Getter: get id
		 *
		 * @return id value
		 */
		public int getId()
		{
			return this.id;
		}
		
		/**
		 * Setter: set id
		 *
		 * @param newId
		 */
		public void setId( int newId )
		{
			this.id = newId;
		}
		
		/**
		 * @return string
		 */
		public String toString()
		{
			return this.reseau + "." + this.mask + "." + this.mask2 + "." + this.id;
		}
		
		/**
		 * @param other
		 *
		 * @return true/false
		 */
		public boolean equals( AdresseIP other )
		{
			return this.reseau == other.getReseau()
					& this.mask == other.getMask()
					& this.mask2 == other.getMask2()
					& this.id == other.getId();
		}
		
	}
	
	/**
	 * Class NomMachine
	 */
	public class NomMachine {
		
		// format : machine.domaine.local
		private String machine;
		private String domain;
		private String local;
		
		/**
		 * Builder: default
		 */
		public NomMachine()
		{
			this.machine = "unknown";
			this.domain = "unknown";
			this.local = "unknown";
		}
		
		/**
		 * Builder
		 */
		public NomMachine( String machine, String domain, String local )
		{
			this.machine = machine;
			this.domain = domain;
			this.local = local;
		}
		
		/**
		 * Getter: get machine
		 *
		 * @return machine name
		 */
		public String getMachine()
		{
			return this.machine;
		}
		
		/**
		 * Setter: set new machine
		 *
		 * @param newMachine
		 */
		public void setMachine( String newMachine )
		{
			this.machine = newMachine;
		}
		
		/**
		 * Getter: get domain
		 *
		 * @return domain name
		 */
		public String getDomain()
		{
			return this.domain;
		}
		
		/**
		 * Setter: set domain
		 *
		 * @param newDomain
		 */
		public void setDomain( String newDomain )
		{
			this.domain = newDomain;
		}
		
		/**
		 * Getter: get local
		 *
		 * @return local name
		 */
		public String getLocal()
		{
			return this.local;
		}
		
		/**
		 * Setter: set local
		 *
		 * @param newLocal
		 */
		public void setLocal( String newLocal )
		{
			this.local = newLocal;
		}
		
		/**
		 * @return string
		 */
		public String toString()
		{
			return this.machine + "." + this.domain + "." + this.local;
		}
		
		/**
		 * @param other
		 *
		 * @return true/false
		 */
		public boolean equals( NomMachine other )
		{
			return this.machine.equals( other.getMachine() )
					& this.domain.equals( other.getDomain() )
					& this.local.equals( other.getLocal() );
		}
		
	}
	
	/**
	 * Class Dns
	 */
	public class Dns {
		
		//
		protected String dataFile;
		private HashMap < AdresseIP, NomMachine > IpToNomMachine;
		private HashMap < NomMachine, AdresseIP > NomMachineToIp;
		private int countDataMax;
		
		/**
		 * Builder: default
		 */
		public Dns()
		{
			this.countDataMax = 0;
			this.IpToNomMachine = null;
			this.NomMachineToIp = null;
			this.dataFile = "unknown";
		}
		
		/**
		 * Builder with param
		 *
		 * @param dataFile
		 */
		public Dns( String dataFile, int countDataMax )
		{
			this.countDataMax = countDataMax;
			this.IpToNomMachine = new HashMap < AdresseIP, NomMachine >( this.countDataMax );
			this.NomMachineToIp = new HashMap < NomMachine, AdresseIP >( this.countDataMax );
			this.dataFile = dataFile;
		}
		
		/**
		 * Getter: get dataFile
		 *
		 * @return dataFile
		 */
		public String getDataFile()
		{
			return this.dataFile;
		}
		
		/**
		 * Setter: set dataFile
		 *
		 * @param newDataFile
		 */
		public void setDataFile( String newDataFile )
		{
			this.dataFile = newDataFile;
		}
		
		/**
		 * Getter: get countDataMax
		 *
		 * @return countDataMax value
		 */
		public int getCountDataMax()
		{
			return this.countDataMax;
		}
		
		/**
		 * Setter: set countDataMax
		 *
		 * @param newCountDataMax
		 */
		public void setCountDataMax( int newCountDataMax )
		{
			this.countDataMax = newCountDataMax;
		}
		
		/**
		 * Getter: get IpToNomMachine
		 *
		 * @return IpToNomMachine HashMap
		 */
		public HashMap < AdresseIP, NomMachine > getIpToNomMachine()
		{
			return this.IpToNomMachine;
		}
		
		/**
		 * Setter: set IpToNomMachine
		 *
		 * @param newIpToNomMachine
		 */
		public void setIpToNomMachine( HashMap < AdresseIP, NomMachine > newIpToNomMachine )
		{
			this.IpToNomMachine = newIpToNomMachine;
		}
		
		/**
		 * Getter: get NomMachineToIp
		 *
		 * @return NomMachineToIp HashMap
		 */
		public HashMap < NomMachine, AdresseIP > getNomMachineToIp()
		{
			return this.NomMachineToIp;
		}
		
		/**
		 * Setter: set NomMachineToIp
		 *
		 * @param newNomMachineToIp
		 */
		public void setNomMachineToIp( HashMap < NomMachine, AdresseIP > newNomMachineToIp )
		{
			this.NomMachineToIp = newNomMachineToIp;
		}
		
		/**
		 * Read and init dataBase
		 *
		 * @throws IOException
		 */
		private void initDatabase() throws IOException
		{
			// Variables
			BufferedReader read = null;
			String line;
			
			// Init read
			try
			{
				read = new BufferedReader( new FileReader( dataFile ) );
			}
			
			// Exception
			catch( FileNotFoundException exception )
			{
				System.out.println( "Error in class 'DnsItem', method 'initDataBase':" +
						" file not found" );
				System.exit( 1 );
			}
			
			int countDataMax = 0;
			// Read
			while( ( line = read.readLine() ) != null && countDataMax < this.countDataMax )
			{
				AdresseIP IpRead = splitAddressIp( line );
				NomMachine MachineRead = splitDomainName( line );
				
				this.IpToNomMachine.put( IpRead, MachineRead );
				this.NomMachineToIp.put( MachineRead, IpRead );
				countDataMax++;
			}
			
			// Close and exit
			read.close();
		}
		
		/**
		 * @param line
		 *
		 * @return AdresseIP
		 */
		public AdresseIP strToAdresseIP( String line )
		{
			// Init variables
			int pos = 0;
			int reseau = 0, mask = 0, mask2 = 0, id = 0;
			
			// Found first number
			pos = line.indexOf( "." );
			reseau = Integer.parseInt( line.substring( 0, pos ) );
			line = line.substring( pos + 1, line.length() );
			
			// Found second number
			pos = line.indexOf( "." );
			mask = Integer.parseInt( line.substring( 0, pos ) );
			line = line.substring( pos + 1, line.length() );
			
			// Found third number
			pos = line.indexOf( "." );
			mask2 = Integer.parseInt( line.substring( 0, pos ) );
			
			// Found last number
			id = Integer.parseInt( line.substring( pos + 1, line.length() ) );
			
			// Return
			return new AdresseIP( reseau, mask, mask2, id );
		}
		
		/**
		 * Split String address ip
		 *
		 * @param line
		 *
		 * @return ip adress
		 */
		private AdresseIP splitAddressIp( String line )
		{
			// Research end ip address
			int endIP = 0;
			while( !Character.isWhitespace( ( line.charAt( endIP ) ) ) ) endIP++;
			
			return strToAdresseIP( line.substring( 0, endIP ) );
		}
		
		/**
		 * @param line
		 *
		 * @return NomMachine
		 */
		public NomMachine strToNomMachine( String line )
		{
			// Init variables
			int pos = 0;
			String machine, domain, local;
			// Found name machine
			pos = line.indexOf( "." );
			machine = line.substring( 0, pos );
			line = line.substring( pos + 1, line.length() );
			
			// Found name domain
			pos = line.indexOf( "." );
			domain = line.substring( 0, pos );
			line = line.substring( pos + 1, line.length() );
			
			// Found local
			local = line;
			
			// Return
			return new NomMachine( machine, domain, local );
		}
		
		/**
		 * Split String domain name
		 *
		 * @param line
		 *
		 * @return NomMachine
		 */
		private NomMachine splitDomainName( String line )
		{
			// Found start domain
			int endName = 0;
			while( !Character.isWhitespace( ( line.charAt( endName ) ) ) ) endName++;
			
			return strToNomMachine( line.substring( endName + 1, line.length() ) );
		}
		
		/**
		 * Getter: get item
		 *
		 * @param machine
		 *
		 * @return DnsItem
		 */
		public DnsItem getItem( NomMachine machine )
		{
			DnsItem found = new DnsItem();
			found.setMachine( machine );
			
			for( Map.Entry < NomMachine, AdresseIP > element : this.NomMachineToIp.entrySet() )
			{
				if( element.getKey().equals( machine ) )
					found.setIp( element.getValue() );
			}
			
			// Return
			return found;
		}
		
		/**
		 * getter: get item
		 *
		 * @param ip
		 *
		 * @return DnsItem
		 */
		public DnsItem getItem( AdresseIP ip )
		{
			DnsItem found = new DnsItem();
			found.setIp( ip );
			
			for( Map.Entry < AdresseIP, NomMachine > element : this.IpToNomMachine.entrySet() )
			{
				if( element.getKey().equals( ip ) )
					found.setMachine( element.getValue() );
			}
			
			// Return
			return found;
		}
		
		/**
		 * Getter: get items
		 *
		 * @param domainExpected
		 *
		 * @return ArrayList
		 */
		public Collection < DnsItem > getItems( String domainExpected )
		{
			ArrayList < DnsItem > found = new ArrayList < DnsItem >( this.countDataMax );
			
			Collection < NomMachine > convert = this.IpToNomMachine.values();
			
			// Course in dataBase
			for( NomMachine machine : convert )
			{
				String format = ".";
				format.concat( domainExpected );
				format.concat( "." );
				
				if( machine.getDomain().contains( format ) )
				{
					String domaine = machine.toString();
					AdresseIP iP = this.NomMachineToIp.get( machine );
					
					DnsItem item = new DnsItem();
					item.setMachine( machine );
					item.setIp( iP );
					
					found.add( item );
				}
			}
			
			// Return
			return found;
		}
		
		private void printHashMap()
		{
			// Get all key
			Set listKeys = this.IpToNomMachine.keySet();
			Iterator iterateur = listKeys.iterator();
			
			// Course on key list
			while( iterateur.hasNext() )
			{
				Object key = iterateur.next();
				System.out.println( key + " => " + this.IpToNomMachine.get( key ) );
			}
			
			// Second HashMap
			System.out.println();
			
			// Get all key
			listKeys = this.NomMachineToIp.keySet();
			iterateur = listKeys.iterator();
			
			// Course on key list
			while( iterateur.hasNext() )
			{
				Object key = iterateur.next();
				System.out.println( key + " => " + this.NomMachineToIp.get( key ) );
			}
		}
	}
	
	/**
	 * Class DnsItem
	 */
	public class DnsItem {
		
		//
		private NomMachine machine;
		private AdresseIP ip;
		
		/**
		 * Builder: default
		 */
		public DnsItem()
		{
			this.machine = new NomMachine();
			this.ip = new AdresseIP();
		}
		
		/**
		 * Builder
		 */
		public DnsItem( AdresseIP ip, NomMachine machine )
		{
			this.machine = machine;
			
			this.ip = ip;
		}
		
		/**
		 * Getter: get NomMachine machine
		 *
		 * @return machine
		 */
		public NomMachine getMachine()
		{
			return this.machine;
		}
		
		/**
		 * Setter: set NomMachine machine
		 *
		 * @param newMachine
		 */
		public void setMachine( NomMachine newMachine )
		{
			this.machine = newMachine;
		}
		
		/**
		 * Getter: get AdresseIP ip
		 *
		 * @return ip
		 */
		public AdresseIP getIp()
		{
			return ip;
		}
		
		/**
		 * Setter: set AdresseIP ip
		 *
		 * @param newip
		 */
		public void setIp( AdresseIP newip )
		{
			this.ip = newip;
		}
		
		/**
		 * @return String
		 */
		public String toString()
		{
			return this.ip.toString() + " => " + this.machine.toString();
		}
	}
	
	public interface Command {
		public String execute() throws IOException;
	}
	
	public class ExeCmd implements Command {
		
		//
		private String cmdExe;
		private String arg;
		
		/**
		 * Builder: default
		 */
		public ExeCmd()
		{
			this.cmdExe = "unknown";
			this.arg = "unknown";
		}
		
		/**
		 * Getter: get arg
		 *
		 * @return
		 */
		public String getArg()
		{
			return arg;
		}
		
		/**
		 * Setter: set arg
		 *
		 * @param arg
		 */
		public void setArg( String arg )
		{
			this.arg = arg;
		}
		
		/**
		 * Getter: get cmdExe
		 *
		 * @return cmdExe
		 */
		public String getCmdExe()
		{
			return cmdExe;
		}
		
		/**
		 * Setter: set cmdExe
		 *
		 * @param cmdExe
		 */
		public void setCmdExe( String cmdExe )
		{
			this.cmdExe = cmdExe;
		}
		
		/**
		 * @return String
		 */
		public String execute() throws IOException
		{
			Dns support = new Dns( "dataFile.cfg", 50 );
			support.initDatabase();
			
			if( this.cmdExe.equals( "NomMachineToIp" ) )
			{
				String res = support.getItem( support.strToNomMachine( this.arg ) ).getIp().toString();
				if( res.contains( "-1" ) ) res = "Not found in the data base";
				return res;
			}
			
			else if( this.cmdExe.equals( "IpToNomMachine" ) )
			{
				String res = support.getItem( support.strToAdresseIP( this.arg ) ).getMachine().toString();
				if( res.contains( "unknown" ) ) res = "Not found in the data base";
				return res;
			}
			
			else if( this.cmdExe.equals( "ls" ) )
				return support.getItems( this.arg ).toString();
			else
				return "unknown";
		}
	}
	
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
			System.out.println( res );
		}
		
		/**
		 *
		 */
		public void nextCommand() throws IOException
		{
			int countPoint = 0;
			String tmp = this.arg.substring( 0, 2 );
			
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
							System.out.println( "Error: not good format for machine name"
									+ " => '" + str.charAt( c ) + "'" );
							System.exit( 1 );
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
				// Split cmd string
				int read[] = new int[ 4 ]; // Save three substring
				int pos = 0, pos2 = 0; // Start end stop for cut the substring
				int count = 0; // Position in read[]
				
				// See any char in cmd
				for( int c = 0 ; c < this.arg.length() ; c++ )
				{
					if( this.arg.charAt( c ) == '.' )
					{
						read[ count ] = Integer.parseInt( this.arg.substring( pos, pos2 ) );
						pos = pos2 + 1;
					}
					pos2++;
				}
				
				//
				this.exe.setCmdExe( "IpToNomMachine" );
				this.exe.setArg( this.arg );
				printRes( this.exe.execute() );
			}
			
			// Maybe 'ls'
			else if( tmp.equals( "ls" ) )
			{
				String tmp2 = tmp.substring( 0, tmp.length() );
				
				this.exe.setCmdExe( "ls" );
				this.exe.setArg( this.arg );
				printRes( this.exe.execute() );
			}
			
			// Maybe Exit
			else if( this.arg.equals( "Exit" ) )
			{
				System.exit( 1 );
			}
			else
			{
				printRes( "Commande unknown" );
			}
		}
	}
	
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
	
	//
	private DnsApp app;
	
	public DNS()
	{
		this.app = new DnsApp();
	}
	
	public void run() throws IOException
	{
		this.app.run();
	}
	
	public static void main( String[] args ) throws IOException
	{
		System.out.println( "Usage : after the '>' you can tape a ip address for know his machine name\n" +
				"or vise versa, or you can tape 'ls -a' follows with a domain for know all machine in this domain\n" +
				"or just 'ls' follows with a domain for know all ip address in this domain\n" +
				"or 'Exit' for exit.\n" );
		DNS app = new DNS();
		app.run();
	}
}

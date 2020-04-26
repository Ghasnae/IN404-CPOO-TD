//

import java.io.BufferedReader;
import java.io.FileReader;

//
import java.io.IOException;
import java.io.FileNotFoundException;

//
import java.util.*;

public class Dns {
	
	//
	protected String dataFile;
	private HashMap < AddressIP, MachineName > ipToMachineName;
	private HashMap < MachineName, AddressIP > machineNameToIp;
	private int countDataMax;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Builder: default
	 */
	public Dns()
	{
		this.countDataMax = 0;
		this.ipToMachineName = null;
		this.machineNameToIp = null;
		this.dataFile = "unknown";
	}
	
	/**
	 * Builder with param
	 *
	 * @param dataFile     for read ip address and his machine name
	 * @param countDataMax number max of element in the
	 */
	public Dns( String dataFile, int countDataMax )
	{
		this.countDataMax = countDataMax;
		this.ipToMachineName = new HashMap < AddressIP, MachineName >( this.countDataMax );
		this.machineNameToIp = new HashMap < MachineName, AddressIP >( this.countDataMax );
		this.dataFile = dataFile;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	 * @param dataFile with ip address and machine name
	 */
	public void setDataFile( String dataFile )
	{
		this.dataFile = dataFile;
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
	 * @param countDataMax the
	 */
	public void setCountDataMax( int countDataMax )
	{
		this.countDataMax = countDataMax;
	}
	
	/**
	 * Getter: get IpToMachineName
	 *
	 * @return IpToMachineName HashMap
	 */
	public HashMap < AddressIP, MachineName > getIpToMachineName()
	{
		return this.ipToMachineName;
	}
	
	/**
	 * Setter: set IpToMachineName
	 *
	 * @param ipToMachineName new ipToMachineNma hashMap
	 */
	public void setIpToMachineName( HashMap < AddressIP, MachineName > ipToMachineName )
	{
		this.ipToMachineName = ipToMachineName;
	}
	
	/**
	 * Getter: get machineNameToIp
	 *
	 * @return machineNameToIp HashMap
	 */
	public HashMap < MachineName, AddressIP > getMachineNameToIp()
	{
		return this.machineNameToIp;
	}
	
	/**
	 * Setter: set machineNameToIp
	 *
	 * @param machineNameToIp new machineNameToIp HashMap
	 */
	public void setMachineNameToIp( HashMap < MachineName, AddressIP > machineNameToIp )
	{
		this.machineNameToIp = machineNameToIp;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Read and init dataBase
	 *
	 * @throws IOException
	 */
	public void initDatabase() throws IOException
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
			AddressIP IpRead = splitAddressIp( line );
			MachineName MachineRead = splitDomainName( line );
			
			if( IpRead.getNetwork() != -1 &&
					IpRead.getMask() != -1 &&
					IpRead.getMask2() != -1 &&
					IpRead.getId() != -1 )
			{
				this.ipToMachineName.put( IpRead, MachineRead );
				this.machineNameToIp.put( MachineRead, IpRead );
				countDataMax++;
			}
			else
			{
				System.out.println("\t\tError in the configuration file");
			}
		}
		
		// Close and exit
		read.close();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @param line to convert in IP address
	 *
	 * @return AddresseIP
	 */
	public AddressIP strToAdresseIP( String line )
	{
		// Init variables
		int pos = 0;
		String network2, mask3, mask4, id2;
		
		// Found first number
		pos = line.indexOf( "." );
		network2 = line.substring( 0, pos );
		line = line.substring( pos + 1, line.length() );
		
		// Found second number
		pos = line.indexOf( "." );
		mask3 = line.substring( 0, pos );
		line = line.substring( pos + 1, line.length() );
		
		// Found third number
		pos = line.indexOf( "." );
		mask4 = line.substring( 0, pos );
		
		// Found last number
		id2 = line.substring( pos + 1, line.length() );
		
		int network = 0, mask = 0, mask2 = 0, id = 0;
		try
		{
			network = Integer.parseInt( network2 );
			mask = Integer.parseInt( mask3 );
			mask2 = Integer.parseInt( mask4 );
			id = Integer.parseInt( id2 );
		}
		catch( NumberFormatException exception )
		{
			System.out.println( "\t\tError number format, one variable can't be converting to a integer" );
			return new AddressIP();
		}
		
		// Return
		AddressIP adrIp = new AddressIP( network, mask, mask2, id );
		if( adrIp.checkNetwork( network )
				&& adrIp.checkMask( mask )
				&& adrIp.checkMask2( mask2 )
				&& adrIp.checkId( id ) )
			return adrIp;
		else
		{
			System.out.println( "\t\tIp Address '"+ adrIp.toString() +"' ins't in the format, values are switch to '-1'" );
			return new AddressIP();
		}
	}
	
	/**
	 * Split String address ip
	 *
	 * @param line to split for convert in IP address
	 *
	 * @return ip adress
	 */
	private AddressIP splitAddressIp( String line )
	{
		// Research end ip address
		int endIP = 0;
		while( !Character.isWhitespace( ( line.charAt( endIP ) ) ) ) endIP++;
		
		return strToAdresseIP( line.substring( 0, endIP ) );
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @param line to convert un machine name
	 *
	 * @return machine name
	 */
	public MachineName strToNomMachine( String line )
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
		
		String name = machine.concat( "." ).concat( domain ).concat( "." ).concat( local );
		if( name.matches( "^((?!-)[A-Za-z0-9-]{1,63}(?<!-)\\.)+[A-Za-z]{2,6}$" ) )
			return new MachineName( machine, domain, local );
		else
		{
			System.out.println("\t\tName machine '"+ name +"' ins't in the format, values are switch to 'unknown'" );
			return new MachineName();
		}
	}
	
	/**
	 * Split String domain name
	 *
	 * @param line to spilt and convert to machine name
	 *
	 * @return machine name
	 */
	private MachineName splitDomainName( String line )
	{
		// Found start domain
		int endName = 0;
		while( !Character.isWhitespace( ( line.charAt( endName ) ) ) ) endName++;
		
		return strToNomMachine( line.substring( endName + 1, line.length() ) );
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter: get item
	 *
	 * @param machine to convert in IP address
	 *
	 * @return DnsItem
	 */
	public DnsItem getItem( MachineName machine )
	{
		DnsItem found = new DnsItem();
		found.setMachine( machine );
		
		for( Map.Entry < MachineName, AddressIP > element : this.machineNameToIp.entrySet() )
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
	 * @param ip for convert to his machineName
	 *
	 * @return DnsItem
	 */
	public DnsItem getItem( AddressIP ip )
	{
		DnsItem found = new DnsItem();
		found.setIp( ip );
		
		for( Map.Entry < AddressIP, MachineName > element : this.ipToMachineName.entrySet() )
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
	 * @param domainExpected for found all machine name with this domain
	 *
	 * @return ArrayList
	 */
	public Collection < DnsItem > getItems( String domainExpected )
	{
		// Result
		List < DnsItem > found = new ArrayList < DnsItem >( this.countDataMax );
		
		// Course in dataBase
		for( Map.Entry < MachineName, AddressIP > element : this.machineNameToIp.entrySet() )
		{
			if( element.getKey().getDomain().contains( domainExpected ) )
			{
				AddressIP iP = element.getValue();
				
				DnsItem item = new DnsItem();
				item.setMachine( element.getKey() );
				item.setIp( iP );
				
				found.add( item );
			}
		}
		
		// Return
		return found;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void printHashMap()
	{
		// Get all key
		Set listKeys = this.ipToMachineName.keySet();
		Iterator iterateur = listKeys.iterator();
		
		// Course on key list
		while( iterateur.hasNext() )
		{
			Object key = iterateur.next();
			System.out.println( key + " => " + this.ipToMachineName.get( key ) );
		}
		
		// Second HashMap
		System.out.println();
		
		// Get all key
		listKeys = this.machineNameToIp.keySet();
		iterateur = listKeys.iterator();
		
		// Course on key list
		while( iterateur.hasNext() )
		{
			Object key = iterateur.next();
			System.out.println( key + " => " + this.machineNameToIp.get( key ) );
		}
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class ExeCmd {
	
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
		{
			Collection < DnsItem > list = support.getItems( this.arg );
			String res = "";
			Iterator < DnsItem > it = list.iterator();
			
			while( it.hasNext() )
				res = res.concat( it.next().getMachine().toString().concat( "\n" ) );
			
			return res;
		}
		
		else if( this.cmdExe.equals( "ls -a" ) )
		{
			Collection< DnsItem > list = support.getItems( this.arg );
			String res = "";
			Iterator< DnsItem > it = list.iterator();
			
			while( it.hasNext() )
				res = res.concat( it.next().getIp().toString().concat( "\n" ) );
			
			return res;
		}
		
		else
			return "unknown";
	}
}

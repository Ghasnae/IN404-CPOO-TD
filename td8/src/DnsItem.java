public class DnsItem {
	//
	private MachineName machine;
	private AddressIP ip;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Builder: default
	 */
	public DnsItem()
	{
		this.machine = new MachineName();
		this.ip = new AddressIP();
	}
	
	/**
	 * Builder: with param
	 * @param ip the machine ip address
	 * @param machine the machine name
	 */
	public DnsItem( AddressIP ip, MachineName machine )
	{
		this.machine = machine;
		this.ip = ip;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter: get machine
	 *
	 * @return machine
	 */
	public MachineName getMachine()
	{
		return this.machine;
	}
	
	/**
	 * Setter: set NomMachine machine
	 *
	 * @param machine the new machine
	 */
	public void setMachine( MachineName machine )
	{
		this.machine = machine;
	}
	
	/**
	 * Getter: get AdresseIP ip
	 *
	 * @return ip
	 */
	public AddressIP getIp()
	{
		return ip;
	}
	
	/**
	 * Setter: set AdresseIP ip
	 *
	 * @param ip the new ip
	 */
	public void setIp( AddressIP ip )
	{
		this.ip = ip;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @return String
	 */
	public String toString()
	{
		return this.ip.toString() + " => " + this.machine.toString();
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

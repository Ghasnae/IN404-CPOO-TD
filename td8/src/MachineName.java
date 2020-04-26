public class MachineName {
	
	// format : machine.domain.local
	private String machine;
	private String domain;
	private String local;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Builder: default
	 */
	public MachineName()
	{
		this.machine = "unknown";
		this.domain = "unknown";
		this.local = "unknown";
	}
	
	/**
	 * Builder
	 */
	public MachineName( String machine, String domain, String local )
	{
		this.machine = machine;
		this.domain = domain;
		this.local = local;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
	 * @param machine new machine name
	 */
	public void setMachine( String machine )
	{
		this.machine = machine;
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
	 * @param domain the new domain
	 */
	public void setDomain( String domain )
	{
		this.domain = domain;
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
	 * @param local new local name
	 */
	public void setLocal( String local )
	{
		this.local = local;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @return string
	 */
	public String toString()
	{
		return this.machine + "." + this.domain + "." + this.local;
	}
	
	/**
	 * @param other an other machine to compare
	 *
	 * @return true/false
	 */
	public boolean equals( MachineName other )
	{
		return this.machine.equals( other.getMachine() )
				& this.domain.equals( other.getDomain() )
				& this.local.equals( other.getLocal() );
	}
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
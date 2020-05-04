
/**
 * Class AddressIP
 */
public class AddressIP {
	
	// format : network.mask.mask2.id
	private int network;
	private int mask;
	private int mask2;
	private int id;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Builder: default
	 */
	public AddressIP()
	{
		this.network = -1;
		this.mask = -1;
		this.mask2 = -1;
		this.id = -1;
	}
	
	/**
	 * Builder with reseau
	 */
	public AddressIP( int network )
	{
		this.network = network;
		this.mask = -1;
		this.mask2 = -1;
		this.id = -1;
	}
	
	/**
	 * Builder all param
	 */
	public AddressIP( int network, int mask, int mask2, int id )
	{
		this.network = network;
		this.mask = mask;
		this.mask2 = mask2;
		this.id = id;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Check number
	 *
	 * @param network to check if his correct
	 *
	 * @return true/false
	 */
	public boolean checkNetwork( int network )
	{
		return network <= 255 & network >= 0;
	}
	
	/**
	 * Check number
	 *
	 * @param mask to check if his correct
	 *
	 * @return true/false
	 */
	public boolean checkMask( int mask )
	{
		return mask <= 255 & mask >= 0;
	}
	
	/**
	 * Check number
	 *
	 * @param mask2 to check if his correct
	 *
	 * @return true/false
	 */
	public boolean checkMask2( int mask2 )
	{
		return mask2 <= 255 & mask2 >= 0;
	}
	
	/**
	 * Check number
	 *
	 * @param id to check if his correct
	 *
	 * @return true/false
	 */
	public boolean checkId( int id )
	{
		return id <= 255 & id >= 0;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter: get network
	 *
	 * @return network value
	 */
	public int getNetwork()
	{
		return this.network;
	}
	
	/**
	 * Setter: set network
	 *
	 * @param network new network
	 */
	public void SetNetwork( int network )
	{
		this.network = network;
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
	 * @param newMask new mask
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
	 * @param newMask2 new mask2
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
	 * @param id new is
	 */
	public void setId( int id )
	{
		this.id = id;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @return string
	 */
	public String toString()
	{
		return this.network + "." + this.mask + "." + this.mask2 + "." + this.id;
	}
	
	/**
	 * @param other ip address to compare
	 *
	 * @return true/false
	 */
	public boolean equals( AddressIP other )
	{
		return this.network == other.getNetwork()
				& this.mask == other.getMask()
				& this.mask2 == other.getMask2()
				& this.id == other.getId();
	}
	
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
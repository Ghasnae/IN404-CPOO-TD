public class Rectangle extends Figure
{
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private double x;
	private double y;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Builder
	 * @param x abscissa
	 * @param y ordinate
	 */
	public Rectangle( double x, double y)
	{
		this.x = x;
		this.y = y;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter : get x
	 * @return x
	 */
	public double getX()
	{
		return x;
	}
	
	/**
	 * Stter: set x
	 * @param x new abscissa
	 */
	public void setX( double x )
	{
		this.x = x;
	}
	
	/**
	 * Getter : get y
	 * @return y
	 */
	public double getY()
	{
		return y;
	}
	
	/**
	 * Stter : set y
	 * @param y new ordinate
	 */
	public void setY( double y )
	{
		this.y = y;
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Change abscissa and ordinate
	 * @param dx shift in abscissa
	 * @param dy shift in ordinate
	 */
	@Override
	public void move( double dx, double dy )
	{
	
	}
	
	/**
	 * Print the figure
	 */
	@Override
	public void print()
	{
	
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Create a string with rectangle information
	 * @return string
	 */
	@Override
	public String toString()
	{
		return "Rectangle{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}

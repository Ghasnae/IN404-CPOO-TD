public class Point2D extends Figure
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
	public Point2D( double x, double y)
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
	 *
	 * @param dx shift in abscissa
	 * @param dy shift in ordinate
	 */
	@Override
	public void move( double dx, double dy )
	{
		this.x += dx;
		this.y += dy;
	}
	
	/**
	 * Print the figure
	 */
	@Override
	public void print()
	{
		System.out.println( this.toString() );
	}
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Create a string with point information
	 * @return string
	 */
	@Override
	public String toString()
	{
		return "Point2D : {" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
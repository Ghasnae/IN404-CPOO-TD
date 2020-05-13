import java.io.Serializable;

public class Rectangle extends Figure implements Serializable {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Point2D topLeft;
	private final Point2D downRight;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @param topLeft top left point
	 * @param downRight down left point
	 */
	public Rectangle( Point2D topLeft, Point2D downRight )
	{
		this.topLeft = topLeft;
		this.downRight = downRight;
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
		this.topLeft.move( dx, dy );
		this.downRight.move( dx, dy );
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
	 * Create a string with rectangle information
	 *
	 * @return string
	 */
	@Override
	public String toString()
	{
		return "Rectangle : {"+this.topLeft.toString() + ",  " + this.downRight.toString() + "}";
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
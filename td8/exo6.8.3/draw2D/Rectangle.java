import java.io.Serializable;

public class Rectangle extends Figure implements Serializable {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private Point2D topLeft;
	private Point2D downRight;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @param topLeft
	 * @param downRight
	 */
	public Rectangle( Point2D topLeft, Point2D downRight )
	{
		this.topLeft = topLeft;
		this.downRight = downRight;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter : Get the point at the top left
	 *
	 * @return top left point
	 */
	public Point2D getTopLeft()
	{
		return topLeft;
	}
	
	/**
	 * Setter : Set the point at the top left
	 *
	 * @param topLeft the new top left point
	 */
	public void setTopLeft( Point2D topLeft )
	{
		this.topLeft = topLeft;
	}
	
	/**
	 * Getter : Get the point at the down right
	 *
	 * @return down right point
	 */
	public Point2D getDownRight()
	{
		return downRight;
	}
	
	/**
	 * Setter : Set the point at the down right
	 *
	 * @param downRight the new down right point
	 */
	public void setDownRight( Point2D downRight )
	{
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
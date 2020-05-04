import java.io.PipedOutputStream;
import java.io.Serializable;

public class Triangle extends Figure implements Serializable {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private Point2D top;
	private Point2D downRight;
	private Point2D downLeft;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public Triangle( Point2D topLeft, Point2D downRight, Point2D downLeft )
	{
		this.top = topLeft;
		this.downRight = downRight;
		this.downLeft = downLeft;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter : Get the point at the top left
	 *
	 * @return top left point
	 */
	public Point2D getTop()
	{
		return top;
	}
	
	/**
	 * Setter : Set the point at the top left
	 *
	 * @param top the new top left point
	 */
	public void setTop( Point2D top )
	{
		this.top = top;
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
	
	/**
	 * Getter : Get the point at the down left
	 *
	 * @return the down left
	 */
	public Point2D getDownLeft()
	{
		return downLeft;
	}
	
	/**
	 * Setter : Set the point at the down left
	 *
	 * @param downLeft the new down left
	 */
	public void setDownLeft( Point2D downLeft )
	{
		this.downLeft = downLeft;
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
		this.top.move( dx, dy );
		this.downLeft.move( dx, dy );
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
		return "Triangle : {top " + this.top.toString() + ", down right " + this.downRight.toString() + ", down left " + this.downLeft.toString() + "}";
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
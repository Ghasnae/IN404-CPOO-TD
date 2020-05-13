import java.io.PipedOutputStream;
import java.io.Serializable;

public class Triangle extends Figure implements Serializable {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Point2D top;
	private final Point2D downRight;
	private final Point2D downLeft;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * @param topLeft top left point
	 * @param downRight down right point
	 * @param downLeft down left point
	 */
	public Triangle( Point2D topLeft, Point2D downRight, Point2D downLeft )
	{
		this.top = topLeft;
		this.downRight = downRight;
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
		return "Triangle : {" + this.top.toString() + ", " + this.downRight.toString() + ", " + this.downLeft.toString() + "}";
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
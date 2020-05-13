import java.io.Serializable;

public class Circle extends Figure implements Serializable {
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	private Point2D center;
	private double radius;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Builder
	 *
	 * @param center the center
	 * @param radius the radius
	 */
	public Circle( Point2D center, double radius )
	{
		this.center = center;
		this.radius = radius;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter : get the center
	 *
	 * @return the center
	 */
	public Point2D getCenter()
	{
		return center;
	}
	
	/**
	 * Setter : set the center
	 *
	 * @param center the new center
	 */
	public void setCenter( Point2D center )
	{
		this.center = center;
	}
	
	/**
	 * Getter : get the radius
	 *
	 * @return the radius
	 */
	public double getRadius()
	{
		return radius;
	}
	
	/**
	 * Setter : set the radius
	 *
	 * @param radius the new radius
	 */
	public void setRadius( double radius )
	{
		this.radius = radius;
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
		this.center.move( dx, dy );
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
	 * Create a String with all information
	 *
	 * @return a String
	 */
	@Override
	public String toString()
	{
		return "Circle : {" +
				"center " + this.center.toString() +
				", radius=" + this.radius +
				'}';
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
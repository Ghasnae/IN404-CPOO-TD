import java.io.Serializable;

abstract class Figure implements Serializable {
	/**
	 * Change abscissa and ordinate
	 *
	 * @param dx shift in abscissa
	 * @param dy shift in ordinate
	 */
	public abstract void move( double dx, double dy );
	
	/**
	 * Print the figure
	 */
	public abstract void print();
}

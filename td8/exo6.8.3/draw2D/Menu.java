import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Menu {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private final String[] figureTbl;
	private final String[] commandTbl;

	private Figure[] fig;
	private int nextPlace;
	private int numFigMax;


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Builder
	 */
	public Menu()
	{
		this.figureTbl = new String[]{ "triangle", "rectangle", "circle" };
		this.commandTbl = new String[]{ "man", "quit", "create", "move", "view", "clear" };

		this.numFigMax = 10;
		this.nextPlace = 0;
		this.fig = new Figure[ this.numFigMax ];
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Rename print
	 *
	 * @param msg the msg to print
	 */
	private void printf( String msg )
	{
		System.out.print( msg );
	}

	/**
	 * Print
	 */
	private void back()
	{
		printf( "Back to the principal menu.\n\n" );
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Ask points to the user points.
	 *
	 * @return Point with coordinates in x et y.
	 */
	private Point2D askPoint()
	{
		Scanner sc = new Scanner( System.in );
		double x, y;

		// Ask coordinates in c
		printf( "coordinates in x : \n > " );
		try
		{
			x = sc.nextDouble();
		}
		catch( InputMismatchException e )
		{
			printf( "ERROR : the entry is not a double.\n" );
			Random r = new Random();
			x = 100 * r.nextDouble();
			printf( "Default value x = " + x + ".\n" );
		}

		// Reset
		sc = null;
		sc = new Scanner( System.in );

		// Ask coordinates in y
		printf( "coordinates in y : \n > " );
		try
		{
			y = sc.nextDouble();
		}
		catch( InputMismatchException e )
		{
			printf( "ERROR : the entry is not a double.\n" );
			Random r = new Random();
			y = 100 * r.nextDouble();
			printf( "Default value y = " + y + ".\n" );
		}

		// Create points
		return new Point2D( x, y );
	}

	/**
	 * ask move to the user
	 *
	 * @return coordinates for move
	 */
	private double[] askMove()
	{
		Scanner sc = new Scanner( System.in );
		double x, y;

		// Ask move in x
		printf( "move in x : \n > " );
		try
		{
			x = sc.nextDouble();
		}
		catch( InputMismatchException e )
		{
			printf( "ERROR : the entry is not a double.\n" );
			Random r = new Random();
			x = 100 * r.nextDouble();
			printf( "Default value x = " + x + ".\n" );
		}

		// Reset
		sc = null;
		sc = new Scanner( System.in );

		// Ask move in y
		printf( "move in y : \n > " );
		try
		{
			y = sc.nextDouble();
		}
		catch( InputMismatchException e )
		{
			printf( "ERROR : the entry is not a double.\n" );
			Random r = new Random();
			y = 100 * r.nextDouble();
			printf( "Default value y = " + y + ".\n" );
		}

		double[] move = new double[ 2 ];
		move[ 0 ] = x;
		move[ 1 ] = y;

		return move;
	}

	/**
	 * Init all points for the user
	 *
	 * @param numberPoints the number of points
	 *
	 * @return Points[] with points
	 */
	private Point2D[] initPointFigure( int numberPoints )
	{
		Point2D[] points = new Point2D[ numberPoints ];
		for( int i = 0 ; i < numberPoints ; i++ )
			points[ i ] = askPoint();

		return points;
	}

	/**
	 * Init figure
	 *
	 * @param nameFigure name figure
	 *
	 * @return Points[]
	 */
	private Point2D[] initPoint( String nameFigure )
	{
		if( nameFigure == null )
		{
			printf( "ERROR : String null.\n" );
			return null;
		}
		else
		{
			if( nameFigure.equals( this.figureTbl[ 0 ] ) )
				return initPointFigure( 3 );

			else if( nameFigure.equals( this.figureTbl[ 1 ] ) )
				return initPointFigure( 2 );

			else if( nameFigure.equals( this.figureTbl[ 2 ] ) )
				return initPointFigure( 1 );
		}

		return null;
	}

	/**
	 * Found the figure
	 *
	 * @return the figure
	 */
	private Figure whatFigure()
	{
		printf( "What figure do you want to create ?( triangle, rectangle, circle )\n > " );
		Scanner sc = new Scanner( System.in );
		if( sc.hasNextLine() )
		{
			// Triangle
			String fig = sc.nextLine();
			if( fig.equals( this.figureTbl[ 0 ] ) )
			{
				Point2D[] points = initPoint( this.figureTbl[ 0 ] );

				assert points != null;
				back();
				return new Triangle( points[ 0 ], points[ 1 ], points[ 2 ] );
			}

			// Rectangle
			else if( fig.equals( this.figureTbl[ 1 ] ) )
			{
				Point2D[] points = initPoint( this.figureTbl[ 1 ] );

				assert points != null;
				back();
				return new Rectangle( points[ 0 ], points[ 1 ] );
			}

			// Circle
			else if( fig.equals( this.figureTbl[ 2 ] ) )
			{
				double radius;
				Scanner sc2 = new Scanner( System.in );
				printf( "Give me the radius (in the format xxx,xxx and a virgule not a point) ?\n > " );

				try
				{
					radius = sc.nextDouble();
				}
				catch( InputMismatchException e )
				{
					printf( "ERROR : the entry is not a double.\n" );
					Random r = new Random();
					radius = 50 * r.nextDouble();
					printf( "Default value radius = " + radius + ".\n" );
				}

				Point2D[] points = initPoint( this.figureTbl[ 2 ] );

				assert points != null;
				back();
				return new Circle( points[ 0 ], radius );
			}

			else
			{
				printf( "Unknown figure.\n" );
				back();
				return null;
			}
		}
		else
		{
			printf( "ERROR : the entry is not a String.\n" );
			back();
			return null;
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Print man
	 */
	private void man()
	{
		printf( "man :\n" );
		printf( "'create' : for create a new figure.\n" );
		printf( "'move' : for move figure.\n" );
		printf( "'clear' : for remove all figure.\n" );
		printf( "'quit' or 'q' : for leave the program.\n" );
		printf( "'view' : for view all figure.\n\n" );
	}

	/**
	 * Create and add figure
	 */
	private void create()
	{
		if( this.nextPlace < this.numFigMax )
		{
			this.fig[ this.nextPlace ] = whatFigure();

			if( this.fig[ this.nextPlace ] != null )
				this.nextPlace += 1;
		}
		else
		{
			printf( "ERROR : maximum number figure is reached.\n" );
			back();
		}
	}

	/**
	 * Move Figure
	 */
	private void move()
	{
		if( this.nextPlace == 0 )
		{
			printf( "You can't move, there is no figure to move.\n" );
			back();
		}
		else
		{
			printf( "view : \n" );
			view( false );

			Scanner sc = new Scanner( System.in );
			int numberFigure;
			printf( "Which Figure do you want to move ? ( Give me her number ).\n > " );
			try
			{
				numberFigure = sc.nextInt();
			}
			catch( InputMismatchException e )
			{
				// e.getMessage();

				printf( "ERROR : the entry in not an int.\n" );
				back();
				return;
			}

			if( 0 <= numberFigure && numberFigure < this.nextPlace )
			{
				if( this.fig[ numberFigure ] != null )
				{
					double[] move = askMove();
					this.fig[ numberFigure ].move( move[ 0 ], move[ 1 ] );
					back();
				}
				else
				{
					printf( "ERROR : figure null.\n" );
					back();
				}
			}
			else
			{
				printf( "ERROR : wrong figure number.\n" );
				back();
			}

		}
	}

	/**
	 * Clear all
	 */
	private void clear()
	{
		if( this.nextPlace == 0 )
		{
			printf( "All is already clear.\n" );
			back();
		}
		else
		{
			for( int numFigure = 0 ; numFigure < this.nextPlace ; numFigure++ )
				this.fig[ numFigure ] = null;
			back();
		}
		this.nextPlace = 0;
	}

	/**
	 * print figure
	 *
	 * @param backMode for print 'back'
	 */
	private void view( boolean backMode )
	{
		if( this.nextPlace == 0 )
		{
			printf( "There is no figure draw yet.\n" );
			if( backMode )
				back();
			else
				printf( "\n" );
		}
		else
		{
			if( this.fig != null )
			{
				for( int numFigure = 0 ; numFigure < this.nextPlace ; numFigure++ )
				{
					printf( "number : " + numFigure + "  " );
					this.fig[ numFigure ].print();
				}
			}
			else
				printf( "figure table not define yet.\n" );

			printf( "Number of elements : " + this.nextPlace + " / " + this.numFigMax + ".\n\n" );
			if( backMode )
				back();
			else
				printf( "\n" );
		}
	}

	/**
	 * Quit program
	 */
	private void quit()
	{
		printf( "Exit in process...\n" );
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * the principal menu
	 *
	 * @return exit or not
	 */
	private boolean menu()
	{
		boolean leave = false;
		Scanner sc = new Scanner( System.in );
		String choice = null;

		printf( "You can write 'man' for see the manual.\nWhat is your choice ?\n > " );
		if( sc.hasNextLine() )
		{
			choice = sc.nextLine();
			if( choice.equals( this.commandTbl[ 0 ] ) )
				man();
			else if( choice.equals( this.commandTbl[ 2 ] ) )
				create();
			else if( choice.equals( this.commandTbl[ 3 ] ) )
				move();
			else if( choice.equals( this.commandTbl[ 4 ] ) )
				view( true );
			else if( choice.equals( this.commandTbl[ 5 ] ) )
				clear();
			else if( choice.equals( this.commandTbl[ 1 ] ) || choice.equals( "q" ) )
			{
				quit();
				leave = true;
			}
			else
				printf( "Command unknown.\n\n" );
		}
		else
			printf( "ERROR : the entry is not a String." );

		return leave;
	}

	/**
	 * Run
	 */
	public void run()
	{
		boolean quit = false;
		while( !quit )
		{
			quit = menu();
		}
	}
}


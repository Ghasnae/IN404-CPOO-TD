import java.util.Random;
import java.util.Scanner;

public class Menu {
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private Figure[] fig;
	private int nextPlace;
	private int numFigMax;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Builder
	 */
	public Menu()
	{
		this.numFigMax = 10;
		this.nextPlace = 0;
		this.fig = new Figure[ this.numFigMax ];
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Getter : get the figure table
	 *
	 * @return the figure table
	 */
	public Figure[] getFig()
	{
		return fig;
	}
	
	/**
	 * Setter : set the new figure table
	 *
	 * @param fig the new table figure
	 */
	public void setFig( Figure[] fig )
	{
		this.fig = fig;
	}
	
	/**
	 * Getter : get the maximum figure number
	 *
	 * @return numFigMax
	 */
	public int getNumFigMax()
	{
		return numFigMax;
	}
	
	/**
	 * Setter : set the maximum figure number
	 *
	 * @param numFigMax new maximum figure number
	 */
	public void setNumFigMax( int numFigMax )
	{
		this.numFigMax = numFigMax;
	}
	
	/**
	 * @return
	 */
	public int getNextPlace()
	{
		return nextPlace;
	}
	
	/**
	 * @param nextPlace
	 */
	public void setNextPlace( int nextPlace )
	{
		this.nextPlace = nextPlace;
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void printf( String msg )
	{
		System.out.print( msg );
	}
	
	private void exit( int status )
	{
		System.exit( status );
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private Point2D askPoint()
	{
		Scanner sc = new Scanner( System.in );
		double x, y;
		
		printf( "coordinates in x : \n > " );
		if( sc.hasNextDouble() )
			x = sc.nextDouble();
		else
		{
			printf( "ERROR : the entry is not a double.\n" );
			Random r = new Random();
			x = 100 * r.nextDouble();
			printf( "Default value x = " + x + ".\n" );
		}
		
		printf( "coordinates in y : \n > " );
		if( sc.hasNextDouble() )
			y = sc.nextDouble();
		else
		{
			printf( "ERROR : the entry is not a double.\n" );
			Random r = new Random();
			y = 100 * r.nextDouble();
			printf( "Default value y = " + y + ".\n" );
		}
		
		return new Point2D( x, y );
	}
	
	private Point2D[] initPointFigure( int numberPoints )
	{
		Point2D[] points = new Point2D[ numberPoints ];
		for( Point2D point : points )
		{
			point = askPoint();
		}
		
		return points;
	}
	
	private Point2D[] initPoint( String nameFigure )
	{
		if( nameFigure == null )
		{
			printf( "ERROR : String null.\n" );
			return null;
		}
		else
		{
			if( nameFigure.equals( "triangle" ) )
				return initPointFigure( 3 );
			
			else if( nameFigure.equals( "rectangle" ) )
				return initPointFigure( 2 );
			
			else if( nameFigure.equals( "circle" ) )
				return initPointFigure( 1 );
		}
		
		return null;
	}
	
	private Figure whatFigure()
	{
		printf( "What figure do you want to create ?\n > " );
		Scanner sc = new Scanner( System.in );
		if( sc.hasNextLine() )
		{
			String fig = sc.nextLine();
			if( fig.equals( "triangle" ) )
			{
				Point2D[] points = initPoint( "triangle" );
				if( points != null )
					return new Triangle( points[ 0 ], points[ 1 ], points[ 2 ] );
				else
					return null;
			}
			
			else if( fig.equals( "rectangle" ) )
			{
				Point2D[] points = initPoint( "Rectangle" );
				if( points != null )
					return new Rectangle( points[ 0 ], points[ 1 ] );
				else
					return null;
			}
			
			else if( fig.equals( "circle" ) )
			{
				double radius;
				Scanner sc2 = new Scanner( System.in );
				printf( "Give me the radius (in the format xxx,xxx and a virgule not a point) ?\n > " );
				if( sc2.hasNextDouble() )
					radius = sc.nextDouble();
				else
				{
					printf( "ERROR : the entry is not a double.\n" );
					Random r = new Random();
					radius = 50 * r.nextDouble();
					printf( "Default value radius = " + radius + ".\n" );
				}
				
				Point2D[] points = initPoint( "Circle" );
				printf( "est ce que points est null ? "+(points == null)+".\n" );
				if( points != null )
					return new Circle( points[ 0 ], radius );
				else
					return null;
			}
			
			else
			{
				printf( "Unknown figure.\nBack to the principal menu.\n" );
				return null;
			}
		}
		else
		{
			printf( "ERROR : the entry is not a String.\n" );
			return null;
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void man()
	{
		printf( "man :\n" );
		printf( "'create' : for create a new figure.\n" );
		printf( "'move' : for move figure.\n" );
		printf( "'quit' or 'q' : for leave the program.\n" );
		printf( "'view' : for view all figure.\n" );
		printf( "\n" );
	}
	
	private void create()
	{
		if( this.nextPlace < this.numFigMax )
		{
			this.fig[ this.nextPlace ] =  whatFigure();
			this.nextPlace += 1;
		}
		else
			printf( "ERROR : maximum number figure is reached.\n" );
		printf( "\n" );
	}
	
	private void move()
	{
		printf( "\n" );
	}
	
	private void view()
	{
		if( this.fig != null )
		{
			for( Figure figure : this.fig )
			{
				if( figure != null )
					figure.print();
				else
					printf( "figure not define yet.\n" );
			}
		}
		else
			printf( "figure table not define yet.\n" );
		
		printf( "Number of elements : " + this.nextPlace + " / " + this.numFigMax + ".\n\n" );
	}
	
	private void quit()
	{
		printf( "Exit in process..." );
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private boolean menu()
	{
		//
		boolean leave = false;
		Scanner sc = new Scanner( System.in );
		String choice = null;
		
		//
		printf( "You can write 'man' for see the manual.\nWhat is your choice ?\n > " );
		if( sc.hasNextLine() )
		{
			choice = sc.nextLine();
			if( choice.equals( "man" ) )
				man();
			else if( choice.equals( "create" ) )
				create();
			else if( choice.equals( "move" ) )
				move();
			else if( choice.equals( "view" ) )
				view();
			else if( choice.equals( "quit" ) || choice.equals( "q" ) )
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
	
	public void run()
	{
		boolean quit = false;
		while( !quit )
		{
			quit = menu();
		}
	}
}


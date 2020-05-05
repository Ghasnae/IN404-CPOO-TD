import java.time.LocalDate;

public class Main {
	public static void main( String[] args )
	{
		String file = "output_fig.ser";
		Figure[] tblFig = new Figure[ 5 ];
		
		tblFig[ 0 ] = new Rectangle( new Point2D( ( double ) 14.5, ( double ) 35.1 ), new Point2D( ( double ) 7, ( double ) 4.6 ) );
		tblFig[ 1 ] = new Rectangle( new Point2D( ( double ) -26.3, ( double ) 20 ), new Point2D( ( double ) 30, ( double ) 30 ) );
		tblFig[ 2 ] = new Circle( new Point2D( ( double ) 2, ( double ) 2 ), ( double ) 10 );
		tblFig[ 3 ] = new Circle( new Point2D( ( double ) 50, ( double ) -60 ), ( double ) 4.3 );
		tblFig[ 4 ] = new Triangle( new Point2D( ( double ) 1, ( double ) 2 ), new Point2D( ( double ) 3, ( double ) 4 ), new Point2D( ( double ) 5, ( double ) 6 ) );
		
		for( Figure fig : tblFig )
			fig.print();

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Figure[] tblFig2 = new Figure[ 1 ];
		tblFig2[ 0 ] = new Rectangle( new Point2D( ( double ) 14.5, ( double ) 35.1 ), new Point2D( ( double ) 7, ( double ) 4.6 ) );
		
		Figure[] tblFig3 = new Figure[ 1 ];
		tblFig3[ 0 ] = new Rectangle( new Point2D( ( double ) -1, ( double ) 2 ), new Point2D( ( double ) -3, ( double ) 4 ) );

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		Save backup = new Save();
		backup.save( tblFig, file );
		backup.save( tblFig2, file );

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		System.out.println( backup.load( tblFig, file ).toString() );
		System.out.println( backup.load( tblFig2, file ).toString() );
		System.out.println( backup.load( tblFig3, file ).toString() );
	}
}

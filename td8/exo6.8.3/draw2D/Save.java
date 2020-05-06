import java.io.*;
import java.time.LocalDate;
import java.util.Locale;

public class Save implements Serializable {
	
	public Save()
	{
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Write in the file
	 *
	 * @param fig      the figure table
	 * @param fileName the file for write
	 */
	private static void writeObjectsToFile( Figure[] fig, String fileName )
	{
		//
		if( fileName == null )
		{
			System.out.println( "Error : fileName null" );
			System.exit( 1 );
		}
		
		//
		ObjectOutputStream oos = null;
		try
		{
			// Initialise the stream with the file
			final FileOutputStream file = new FileOutputStream( fileName );
			
			// Write the serialisation
			oos = new ObjectOutputStream( file );
			
			//
			oos.writeObject( LocalDate.now() );
			oos.writeObject( fig );
			
			// Clean the buffer
			oos.flush();
		}
		catch( IOException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( oos != null )
				{
					try
					{
						// Clear the buffer
						oos.flush();
						oos.close();
					}
					catch( IOException exception )
					{
						exception.printStackTrace();
					}
				}
			}
			catch( Exception e )
			{
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * save all figure
	 *
	 * @param fig      the figure table
	 * @param fileName the name file
	 */
	public void save( Figure[] fig, String fileName )
	{
		writeObjectsToFile( fig, fileName );
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * read
	 *
	 * @param fileName data file
	 *
	 * @return Figure[]
	 */
	private static Figure[] readObjectsFromFile( String fileName )
	{
		ObjectInputStream ois = null;
		try
		{
			final FileInputStream file = new FileInputStream( fileName );
			ois = new ObjectInputStream( file );
			LocalDate date = ( LocalDate ) ois.readObject();
			return ( Figure[] ) ois.readObject();
		}
		catch( final IOException | ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if( ois != null )
				{
					ois.close();
				}
			}
			catch( IOException exception )
			{
				exception.printStackTrace();
			}
		}
		
		return null;
	}
	
	/**
	 * load figure
	 *
	 * @param fileName the name file
	 *
	 * @return Figure[]
	 */
	public Figure[] load( String fileName )
	{
		return readObjectsFromFile( fileName );
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
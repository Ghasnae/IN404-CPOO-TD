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
	 *
	 * @throws IOException for write
	 */
	private static void writeObjectsToFile( Figure[] fig, String fileName ) throws IOException
	{
		try( ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream( ( fileName ) ) ) )
		{
			oos.writeObject( LocalDate.now() );
			oos.writeObject( fig );
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
		try
		{
			writeObjectsToFile( fig, fileName );
		}
		catch( IOException exception )
		{
			exception.printStackTrace();
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Read in the file
	 *
	 * @param fig      the figure table
	 * @param fileName the name file
	 *
	 * @return LocalDate
	 *
	 * @throws IOException        for read
	 * @throws ClassCastException if class not found
	 */
	private static LocalDate readObjectsFromFile( Figure[] fig, String fileName ) throws IOException, ClassCastException
	{
		try( ObjectInputStream ois = new ObjectInputStream( new FileInputStream( fileName ) ) )
		{
			LocalDate date = ( LocalDate ) ois.readObject();
			fig = ( Figure[] ) ois.readObject();
			return date;
		}
		catch( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * load figure
	 *
	 * @param fig      the figure table
	 * @param fileName the name file
	 *
	 * @return LocalDate
	 */
	public LocalDate load( Figure[] fig, String fileName )
	{
		LocalDate date = null;
		try
		{
			date = readObjectsFromFile( fig, fileName );
		}
		catch( IOException exception )
		{
			exception.printStackTrace();
		}
		return date;
	}
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
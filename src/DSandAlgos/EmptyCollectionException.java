package DSandAlgos;

public class EmptyCollectionException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5007354089503071663L;
	
	public EmptyCollectionException()
	{
		super();
	}

	public EmptyCollectionException(String message)
	{
		super(message);
	}
}

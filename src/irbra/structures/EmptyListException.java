package irbra.structures;

/**
 *
 * @author Daniel Ferreira
 */
public class EmptyListException extends RuntimeException {
	
	public EmptyListException(){
		super();
	}
	
	public EmptyListException(String message){
		super(message);
	}

}

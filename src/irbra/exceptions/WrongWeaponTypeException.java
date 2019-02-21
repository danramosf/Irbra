package irbra.exceptions;

/**
 *
 * @author Daniel Ferreira
 */
public class WrongWeaponTypeException extends Exception{
    
    public WrongWeaponTypeException(){
        super();
    }
    
    public WrongWeaponTypeException(String message){
        super(message);
    }
    
}

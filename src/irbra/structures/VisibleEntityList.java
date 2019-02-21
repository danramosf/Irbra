package irbra.structures;

import irbra.VisibleEntity;

/**
 *
 * @author Daniel Ferreira
 */
public class VisibleEntityList {
	
	private VisibleEntityListElement first;
	private VisibleEntityListElement last;
	
	private int numberOfElements;
	
	public VisibleEntityList(){
		
	}
	
	public VisibleEntityList(VisibleEntity entity){
		addAtTheBeginning(entity);
	}
	
	/**
	 * Adds a new Visible Entity at the beginning of the list.
	 * @param entity The VisibleEntity element to be added
	 */
	public void addAtTheBeginning(VisibleEntity entity) {
		//If the list is empty
		if(this.numberOfElements == 0){
			VisibleEntityListElement newElement = new VisibleEntityListElement(entity);
		    this.first = newElement;
		    this.last = newElement;
		  } else {
			VisibleEntityListElement newElement = new VisibleEntityListElement(this.first, entity);
		    this.first.setPrevious(newElement);
		    this.first = newElement;
		  }
		  this.numberOfElements++;
	}
	
	/**
	 * Adds a new Visible Entity at the end of the list.
	 * @param entity The VisibleEntity element to be added.
	 */
	public void add(VisibleEntity entity) {
		if (this.numberOfElements == 0) {
		    this.addAtTheBeginning(entity);
		    System.out.println(entity + " was successful added at the beginning");
		  } else {
			  VisibleEntityListElement newElement = new VisibleEntityListElement(entity);
		    this.last.setNext(newElement);
		    newElement.setPrevious(this.last);
		    this.last = newElement;
		    this.numberOfElements++;
		  }
	  }
	
	/**
	 * Returns a String with all Visible Entities on the list.
	 */
	@Override
	public String toString() {

		  // Checking if the list is empty
		  if(this.numberOfElements == 0){
		    return "[]";
		  }
		  
		  StringBuilder builder = new StringBuilder("[");
		  VisibleEntityListElement curElement = first;

		  // Scrolling through the list up to the last but one element.
		  for (int i = 0; i < this.numberOfElements - 1; i++) {
		    builder.append(curElement.getEntity());
		    builder.append(", ");
		    curElement = curElement.getNext();
		  }

		  // Last element
		  builder.append(curElement.getEntity());
		  builder.append("]");
		  
		  return builder.toString();
	}
	
	/**
	 * Private method created to use in getVisibleEntityListElement method.
	 * @param position The position to be verified whether is occupied or not.
	 * @return True if the position is occupied. False otherwise.
	 */
	private boolean occupiedPosition(int position){
		  return position >= 0 && position < this.numberOfElements;
	}

	/**
	 * Returns a VisibleEntity with a given position on the list.
	 * @param position The position of the VisibleEntity to be returned
	 * @return The VisibleEntity which is in the given position on the list.
	 */
	private VisibleEntityListElement getVisibleEntityListElement(int position) {
		  if(!this.occupiedPosition(position)){
		    throw new IllegalArgumentException("Posição não existe");
		  }

		  VisibleEntityListElement curElement = first;
		  for (int i = 0; i < position; i++) {
		    curElement = curElement.getNext();
		  }
		  return curElement;
	}
	
	/**
	 * Adds a new VisibleEntity on the list in a specific position
	 * @param position The position to add the Visible Entity
	 * @param entity The VisibleEntity to be added
	 */
	public void add(int position, VisibleEntity entity) {
		if(position == 0){ // At the beginning
		    this.addAtTheBeginning(entity);
		  } else if(position == this.numberOfElements){ // At the end.
		    this.add(entity);
		  } else {
		    VisibleEntityListElement previous = this.getVisibleEntityListElement(position - 1);
		    VisibleEntityListElement next = previous.getNext();
		    VisibleEntityListElement newElement = new VisibleEntityListElement(previous.getNext(), entity);
		    newElement.setPrevious(previous);
		    previous.setNext(newElement);
		    next.setPrevious(newElement);
		    this.numberOfElements++;
		  }
		
	}
	
	/**
	 * Returns the VisibleEntity which is in a specific position in the list.
	 * @param position The position in the list where the VisibleEntity is.
	 * @return The VisibleEntity which is in the specified position
	 */
	public VisibleEntity get(int position) {
		  return this.getVisibleEntityListElement(position).getEntity();
	}
	
	/**
	 * Removes the VisibleEntity from the first position of the list.
	 * @throws EmptyListException if the list is empty
	 */
	public void removeFromBeginning() throws EmptyListException {
		  if (!this.occupiedPosition(0)) {
		    throw new EmptyListException("You are trying to remove an item from an empty list.");
		  }

		  this.first = this.first.getNext();
		  this.numberOfElements--;
		  
		  if (this.numberOfElements == 0) {
		    this.last = null;
		  }
	}
	
	/**
	 * Removes the VisibleEntity from the last position of the list.
	 */
	public void removeFromEnd() {
		  if (!this.occupiedPosition(this.numberOfElements - 1)) {
		    throw new IllegalArgumentException("The position does not exist.");
		  }
		  if (this.numberOfElements == 1) {
		    this.removeFromBeginning();
		  } else {
		    VisibleEntityListElement penultimate = this.last.getPrevious();
		    penultimate.setNext(null);
		    this.last = penultimate;
		    this.numberOfElements--;
		  }
	}
	
	/**
	 * Removes the VisileEntity on a specified position on the list.
	 * @param position The position where the VisibleEntity will be removed
	 */
	public void remove(int position) {
		  if (!this.occupiedPosition(position)) {
		    throw new IllegalArgumentException("The position does not exist.");
		  }

		  if (position == 0) {
		    this.removeFromBeginning();
		  } else if (position == this.numberOfElements - 1) {
		    this.removeFromEnd();
		  } else {
		    VisibleEntityListElement previous= this.getVisibleEntityListElement(position - 1);
		    VisibleEntityListElement curElement = previous.getNext();
		    VisibleEntityListElement next = curElement.getNext();
		    
		    previous.setNext(next);
		    next.setPrevious(previous);
		    
		    this.numberOfElements--;
		  }
	}
		
	/**
	 * Verify if a specific VisibleEntity is in the list.
	 * @param entity The VisibleEntity to be searched
	 * @return True if the VisibleEntity is in the list. False otherwise.
	 */
	public boolean contains(VisibleEntityListElement entity) {
		VisibleEntityListElement curElement = this.first;

	  while (curElement != null) {
	    if (curElement.getEntity().equals(entity)) {
	      return true;	      
	    }
	    curElement = curElement.getNext();
	  }
	  return false;
	}
	
	/**
	 * Returns the length of the list
	 * @return The number of elements on the list (the length of the list)
	 */
	public int length() {
	    return this.numberOfElements;
	}

}

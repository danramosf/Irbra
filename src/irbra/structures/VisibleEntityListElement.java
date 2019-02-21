package irbra.structures;

import irbra.VisibleEntity;

/**
 *
 * @author Daniel Ferreira
 */
public class VisibleEntityListElement {
	
	private VisibleEntityListElement next;
	private VisibleEntityListElement previous;
	private VisibleEntity entity;
	
	/**
	 * Creates a new VisibleEntity List item with a next item
	 * @param next The VisibleElemnt which is next to this one that is being created on the list.
	 * @param entity The VisibleElement to be created on the list.
	 */
	public VisibleEntityListElement(VisibleEntityListElement next, VisibleEntity entity) {
		super();
		this.next = next;
		this.entity = entity;
	}

	/** Creates a new VisibleEntity List item without a next item
	 * @param entity The VisibleEntity to be added to the list.
	 */
	public VisibleEntityListElement(VisibleEntity entity) {
		super();
		this.entity = entity;
	}

	
	
	/**
	 * Returns the previous VisibleEntity element in the list
	 * @return The previous VisibleEntity element in the list
	 */
	public VisibleEntityListElement getPrevious() {
		return previous;
	}

	/**
	 * Sets the VisibleEntity item that is before this current element in the list
	 * @param previous The VisibleEntity item that is going to be before this current element in the list
	 */
	public void setPrevious(VisibleEntityListElement previous) {
		this.previous = previous;
	}

	/**
	 * Returns the next VisibleEntity element in the list
	 * @return The next VisibleEntity element in the list
	 */
	public VisibleEntityListElement getNext() {
		return next;
	}

	/**
	 * Sets the VisibleEntity item that is next to this current element in the list
	 * @param next The VisibleEntity item that is going to be next to this current element in the list
	 */
	public void setNext(VisibleEntityListElement next) {
		this.next = next;
	}

	/**
	 * Returns the current VisibleEntity element in the list.
	 * @return The VisibleEntity object.
	 */
	public VisibleEntity getEntity() {
		return this.entity;
	}
	
}

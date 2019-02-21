package irbra;

import irbra.exceptions.NoDefaultAnimationException;
import javafx.animation.Animation;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * This is a generic class. All visible entities in the game must extend this class.<br>
 * Everything that has an image and players can look at.
 * @author Daniel Ferreira
 *
 */
public class VisibleEntity {
	
	private int entityId;
	private String entityName;
	private Image spriteSheet;
	private ImageView spriteSheetImageView;
       	private boolean carryable;
	private boolean pushable;
	private SpriteAnimation defaultAnimation;
	private Rectangle2D viewport;
        //Variables for visible entities with large sprites
        private int imgNumOfParts;
        private ImageView spriteSheetImageView2;
        private ImageView spriteSheetImageView3;
        private ImageView spriteSheetImageView4;
        private ImageView[] spriteSheetImageView30 = new ImageView[30];
	
	/**
	 * Creates a new VisibleEntity with a default animation.
	 * @param entityId This is the sprite's id, so all entities that uses the same sprite has the same ID.
	 * @param entityName The entity's name
	 * @param spriteSheet The spritesheet which will be used to generate all the animations for this entity.
	 * @param carryable True if this entity represents an item that can be carried by the player.
	 * @param pushable True if the entity may be pushed by players, npcs or monsters.
	 * @param count The number of frames on the default animation
	 * @param columns The number of frames on the first column on the spritesheet, to be used on the <br>
	 * default animation.
	 * @param offset_x The x axis offset in pixels on the spritesheet image file to get to the start <br>
	 * position of the first frame. (to generate the default animation)
	 * @param offset_y The y axis offset in pixels on the spritesheet image file to get to the start <br>
	 * position of the first frame. (to generate the default animation)
	 * @param width The width of the frame in pixels (to generate the default animation)
	 * @param height The height of the frame in pixels (to generate the default animation)
	 */
	public VisibleEntity(int entityId, String entityName, Image spriteSheet,
                             boolean carryable, boolean pushable, int count, int columns, int offset_x, 
                             int offset_y, int width, int height) {
            
            super();
            this.entityId = entityId;
            this.entityName = entityName;
            this.spriteSheet = spriteSheet;
            this.spriteSheetImageView =  new ImageView(spriteSheet);
            this.carryable = carryable;
            this.pushable = pushable;
            this.defaultAnimation = new SpriteAnimation(
                    this.spriteSheetImageView,
                    Duration.millis(500),
                    count, columns,
                    offset_x, offset_y,
                    width, height
            );
            this.imgNumOfParts = 1;
        }
        
        /**
	 * Creates a new VisibleEntity with no default animation.
	 * @param entityId This is the sprite's id, so all entities that uses the same sprite has the same ID.
	 * @param entityName The entity's name
	 * @param spriteSheet spriteSheet The spritesheet which will be used to generate all the animations for this entity.
	 * @param carryable True if this entity represents an item that can be carried by the player.
	 * @param pushable True if the entity may be pushed by players, npcs or monsters.
	 */
	public VisibleEntity(int entityId, String entityName, Image spriteSheet,
			boolean carryable, boolean pushable) {
		super();
		this.entityId = entityId;
		this.entityName = entityName;
		this.spriteSheet = spriteSheet;
		this.spriteSheetImageView =  new ImageView(spriteSheet);
		this.carryable = carryable;
		this.pushable = pushable;
                this.imgNumOfParts = 1;
	}
	
	/**
	 * Creates a new VisibleEntity with no default animation.
	 * @param entityId This is the sprite's id, so all entities that uses the same sprite has the same ID.
	 * @param entityName The entity's name
	 * @param spriteSheet spriteSheet The spritesheet which will be used to generate all the animations for this entity.
	 * @param carryable True if this entity represents an item that can be carried by the player.
	 * @param pushable True if the entity may be pushed by players, npcs or monsters.
	 */
	public VisibleEntity(int entityId, String entityName, Image spriteSheet,
			boolean carryable, boolean pushable, int imgNumOfParts) {
		super();
		this.entityId = entityId;
		this.entityName = entityName;
		this.spriteSheet = spriteSheet;
		this.spriteSheetImageView =  new ImageView(spriteSheet);
		this.carryable = carryable;
		this.pushable = pushable;
                if(imgNumOfParts == 4){
                    this.imgNumOfParts = imgNumOfParts;
                    this.spriteSheetImageView2 =  new ImageView(spriteSheet);
                    this.spriteSheetImageView3 =  new ImageView(spriteSheet);
                    this.spriteSheetImageView4 =  new ImageView(spriteSheet);
                    
                    double width = this.spriteSheet.getWidth()/2;
                    double height = this.spriteSheet.getHeight()/2;
                    this.spriteSheetImageView4.setViewport(new Rectangle2D(0, 0, width, height));
                    this.spriteSheetImageView3.setViewport(new Rectangle2D(width, 0, width, height));
                    this.spriteSheetImageView2.setViewport(new Rectangle2D(0, height, width, height));
                    this.spriteSheetImageView.setViewport(new Rectangle2D(width, height, width, height));
                }else if(imgNumOfParts == 30){
                    this.imgNumOfParts = imgNumOfParts;
                    
                    double width = this.spriteSheet.getWidth()/6;
                    double height = this.spriteSheet.getHeight()/5;
                    int count = 0;
                    for(int a=0;a<6;a++){
                        for(int b=0; b<5;b++){
                            this.spriteSheetImageView30[count] = new ImageView(spriteSheet);
                            this.spriteSheetImageView30[count].setViewport(new Rectangle2D((a*width), (b*height), width, height));
                            count++;
                        }
                    }
                  
                    
                }
	}
	
	
	/**
	 * 
	 * @param entityId This is the sprite's id, so all entities that uses the same sprite has the same ID.
	 * @param entityName The entity's name
	 * @param spriteSheetImageView The SpriteSheet ImageView, to be placed on the gameplay viewport
	 * @param carryable True if this entity represents an item that can be carried by the player.
	 * @param pushable True if the entity may be pushed by players, npcs or monsters.
	 * @param defaultAnimation The default animation, which will be played as soon as the VisibleEntity is placed on the gameplay viewport.
	 */
	public VisibleEntity(int entityId, String entityName, ImageView spriteSheetImageView, boolean carryable,
			boolean pushable, SpriteAnimation defaultAnimation) {
		super();
		this.entityId = entityId;
		this.entityName = entityName;
		this.spriteSheetImageView = spriteSheetImageView;
		this.carryable = carryable;
		this.pushable = pushable;
		this.defaultAnimation = defaultAnimation;
	}

	/**
	 * Returns the Visible Entity's Id.
	 * @return The entity's Id
	 */
	public int getEntityId() {
		return entityId;
	}

	/**
	 * Returns the Visible Entity's name
	 * @return The entity's name
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * Updates the Visible Entity's name
	 * @param entityName The new name
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * Returns the spritesheet image of the visible entity.
	 * @return The entity's spritesheet image
	 */
	public Image getSpriteSheet() {
		return spriteSheet;
	}
	
	/**
	 * Updates the spritesheet image of the visible entity.
	 * @param spriteSheet The new spritesheet image
	 */
	public void setSpriteSheet(Image spriteSheet) {
		this.spriteSheet = spriteSheet;
	}
	
	
	/**
	 * Returns the visible entity's sprite sheet ImageView object
	 * @return The visible entity's sprite sheet ImageView object
	 */
	public ImageView getSpriteSheetImageView() {
		return spriteSheetImageView;
	}
        
        public ImageView getSpriteSheetImageView2() {
		return spriteSheetImageView2;
	}
        
        public ImageView getSpriteSheetImageView3() {
		return spriteSheetImageView3;
	}
        
        public ImageView getSpriteSheetImageView4() {
		return spriteSheetImageView4;
	}

	/**
	 * Updates the value of the VisibleEntity's sprite sheet ImageView.
	 * @param spriteSheetImageView The new ImageView.
	 */
	public void setSpriteSheetImageView(ImageView spriteSheetImageView) {
		this.spriteSheetImageView = spriteSheetImageView;
	}

	/**
	 * Returns true if the visible entity can be carried by players
	 * @return True if the visible entity can be carried by players. False otherwise.
	 */
	public boolean isCarryable() {
		return carryable;
	}
	
	/**
	 * Updates the carryable value of the visible entity.
	 * @param carryable True if you want to make possible to players carry the visible entity, false otherwise.
	 */
	public void setCarryable(boolean carryable) {
		this.carryable = carryable;
	}

	/**
	 * Returns true if the visible entity can be pushed by players, npcs or monsters.
	 * @return True if the visible entity can be pushed by players, npcs or monsters. False otherwise.
	 */
	public boolean isPushable() {
		return pushable;
	}

	/**
	 * Updates the pushable value of the visible entity.
	 * @param pushable True if you want to make possible to players, npcs or monsters <br>
	 * push the visible entity, false otherwise.
	 */
	public void setPushable(boolean pushable) {
		this.pushable = pushable;
	}
	
	/**
	 * Returns the default animation of the visible entity
	 * @return The default animation of the visible entity
	 * @throws NoDefaultAnimationException if there is no default animation
	 */
	public SpriteAnimation getDefaultAnimation() throws NoDefaultAnimationException{
		if(this.defaultAnimation == null){
			throw new NoDefaultAnimationException();
		}
		return defaultAnimation;
	}

	/**
	 * Updates the default animation of the visible entity.
	 * @param defaultAnimation The new default animation to be updated
	 */
	public void setDefaultAnimation(SpriteAnimation defaultAnimation) {
		this.defaultAnimation = defaultAnimation;
	}
        
        /**
         * 
         * @return the number of tiles that the sprite occupy 
         */
        public int getImgNumOfParts(){
            return this.imgNumOfParts;
        }
        
        public void setImgNumOfParts(int imgNumOfParts){
            this.imgNumOfParts = imgNumOfParts;
        }
        
        /**
         * Used when the imgNumOfParts = 30 (for bosses)
         * @return The array of imageviews spriteSheetImageView30
         */
        public ImageView[] getSpriteSheetImageView30(){
            return this.spriteSheetImageView30;
        }

	/**
	 * This is executed when the player look to the item.
	 * When the player press shift and click on this entity, this message will be displayed.
	 * @return The information about the visible entity.
	 */
	public String getInfo(){
		return "You are looking at a " + entityName + ".";
	}	
	
	/**
	 * Plays the default animation of the entity.
	 * @throws NoDefaultAnimationException if there is no default animation
	 */
	public void playDefaultAnimation() throws NoDefaultAnimationException{
		if(this.defaultAnimation == null){
			throw new NoDefaultAnimationException();
		}
		this.defaultAnimation.setCycleCount(Animation.INDEFINITE);
		this.defaultAnimation.play();
	}
	
	/**
	 * Creates a rectangle2D to be used as a viewport for the visible entity
	 * @param posX The x position of the top left corner of the rectangle
	 * @param posY The y position of the top left corner of the rectangle
	 * @param width The width of the rectangle
	 * @param height The heigth of the rectangle
	 */
	public void createViewport(double posX, double posY, double width, double height){
		this.viewport = new Rectangle2D(posX, posY, width, height);
	}
	
	public Rectangle2D getViewport(){
		return this.viewport;
	}
	
	public void animate(){
		System.out.println("Animating " + getEntityName());
	}
        
        public void setSpriteSheetImageView2(ImageView iv){
            this.spriteSheetImageView2 = iv;
        }
        
        public void setSpriteSheetImageView3(ImageView iv){
            this.spriteSheetImageView3 = iv;
        }
        
        public void setSpriteSheetImageView4(ImageView iv){
            this.spriteSheetImageView4 = iv;
        }
	
}

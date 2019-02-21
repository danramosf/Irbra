package irbra;

import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

/**
 *
 * @author Daniel Ferreira
 */
public class Dragon extends Monster implements Walkable{
    
    private static final String NAME = "Dragon";
    private static final int ID = 5001;
    
    //Creating a spritesheet animation
    //private static final Image IMAGE = new Image("images/dragon_spritesheet.png");
    private static final Image IMAGE = new Image("images/Dragon.gif");
    private static final Image IMAGE_DEAD = new Image("images/3005.gif");
    private static final ImageView imageView = new ImageView(IMAGE);
		
    private static final int COLUMNS  =   3;
    private static final int COUNT    =  3;
    private static final int OFFSET_X =  0;
    private static final int OFFSET_Y =  0;
    private static final int WIDTH    = 79;
    private static final int HEIGHT   = 86;
    
    //Animations
    private static final SpriteAnimation defaultAnimation = new SpriteAnimation (
            imageView,
            Duration.millis(500),
            COUNT, COLUMNS,
            OFFSET_X, OFFSET_Y,
            WIDTH, HEIGHT
	);
	
	private static final Animation moveUpAnimation = new SpriteAnimation(
            imageView,
            Duration.millis(500),
            COUNT, COLUMNS,
            237, OFFSET_Y,
            WIDTH, HEIGHT
    );
	
	private static final Animation moveRightAnimation = new SpriteAnimation(
            imageView,
            Duration.millis(500),
            COUNT, COLUMNS,
            OFFSET_X, 86,
            WIDTH, HEIGHT
    );
	
	private static final Animation moveDownAnimation = new SpriteAnimation(
            imageView,
            Duration.millis(500),
            COUNT, COLUMNS,
            OFFSET_X, OFFSET_Y,
            WIDTH, HEIGHT
    );
	
	private static final Animation moveLeftAnimation = new SpriteAnimation(
            imageView,
            Duration.millis(500),
            COUNT, COLUMNS,
            237, 86,
            WIDTH, HEIGHT
    );
    
    private int[] droppableItemsIds;

    public Dragon(int spawnPosX, int spawnPosY) {
        super(ID, NAME, IMAGE, 300, spawnPosX, spawnPosY, false, 4);
    }
    
   

    @Override
    public void moveRight() {
        moveRightAnimation.setCycleCount(1);
        moveRightAnimation.play();

        imageView.setLayoutX(imageView.getLayoutX() + 40);
        setPosOnMapY(getPosOnMapY()+1); //y++
    }

    @Override
    public void moveLeft() {
        moveLeftAnimation.setCycleCount(1);
        moveLeftAnimation.play();

        imageView.setLayoutX(imageView.getLayoutX() - 40);
        setPosOnMapY(getPosOnMapY()-1); //y--
    }

    @Override
    public void moveUp() {
        moveUpAnimation.setCycleCount(1);
        moveUpAnimation.play();

        imageView.setLayoutY(imageView.getLayoutY() - 40);
        setPosOnMapX(getPosOnMapX()-1); //x--
    }

    @Override
    public void moveDown() {
        moveDownAnimation.setCycleCount(1);
        moveDownAnimation.play();

        imageView.setLayoutY(imageView.getLayoutY() + 40);
        setPosOnMapX(getPosOnMapX()+1); //x++
    }
    
    @Override
    public void load(Pane gameplayViewport){		
        super.createViewport(gameplayViewport.getLayoutX(), gameplayViewport.getLayoutY(), gameplayViewport.getWidth(), gameplayViewport.getHeight() );
                        
        imageView.setViewport(this.getViewport());	
        defaultAnimation.setCycleCount(1);
        defaultAnimation.play();
		
        imageView.setFitWidth(WIDTH);
        imageView.setFitHeight(HEIGHT);
	imageView.setLayoutX(gameplayViewport.getLayoutX());
	imageView.setLayoutY(gameplayViewport.getLayoutY());
	gameplayViewport.getChildren().addAll(imageView);
    }

    @Override
    public void die() {
        setExpPoints(50);
        super.setImgNumOfParts(4);
        getSpriteSheetImageView().setImage(IMAGE_DEAD);
        getSpriteSheetImageView2().setImage(IMAGE_DEAD);
        getSpriteSheetImageView3().setImage(IMAGE_DEAD);
        getSpriteSheetImageView4().setImage(IMAGE_DEAD);
        setDead(true);
    }

    @Override
    public void atkPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void goToPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

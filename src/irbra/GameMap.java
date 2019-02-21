package irbra;

import irbra.structures.VisibleEntitiesGenerator;
import irbra.structures.VisibleEntityList;
import java.io.*;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author aniel Ferreira and Ebrahim Zhalesani
 */
public class GameMap {
	
//	public static final int TILE_WIDTH = 55;
//	public static final int TILE_HEIGHT = 55;
//	public static final int SCREEN_WIDTH = 600;
//	public static final int SCREEN_HEIGHT = 360;
	
	private VisibleEntityList[][] visibleEntityMap = new VisibleEntityList[50][50];
        private Tile[][] tilesMatrix = new Tile[50][50];
        private StackPane[][] spMatrix = new StackPane[15][11];
        private ImageView[][] ivMatrix = new ImageView[15][11];

	public GameMap(GridPane gameplayGrid) {
            //this.map = map;
            //Reading the tiles map   
            try{
                File mapFile = new File("tilesMap.txt");
                    
                if(!mapFile.exists()){
                    throw new FileNotFoundException("File does not exist.");
                }
                    
                FileReader fr = new FileReader(mapFile.getAbsoluteFile());
                BufferedReader br = new BufferedReader(fr);
                    
                for(int i=0; i< this.tilesMatrix.length; i++){
                    for(int j=0; j<this.tilesMatrix[i].length; j++){
                        this.tilesMatrix[i][j] = Tile.createTile(br.readLine());
                    }
                }
                
                //Initializing tiles map
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j< 11; j++) {
                        spMatrix[i][j] = new StackPane();
                        ivMatrix[i][j] = new ImageView();
                        //Adding the stack pane matrix elements to the grid pane at its respective position.
                        gameplayGrid.add(spMatrix[i][j],i,j);
                    }
                }
                    
            }catch(IOException ie){
                System.out.println("Failed to read map file");
            }
            
            //Initializing VisibleEntityList map
            for(int i=0; i < visibleEntityMap.length;i++ ){
                for(int j=0; j< visibleEntityMap[i].length; j++){
                    visibleEntityMap[i][j] = new VisibleEntityList();
                }
            }            
            Dragon dragon = new Dragon(20,23);
            visibleEntityMap[18][18].add(dragon);
            Dragon dragon2 = new Dragon(34,33);
            visibleEntityMap[34][33].add(dragon2);
            Dragon dragon3 = new Dragon(20,23);
            visibleEntityMap[42][27].add(dragon3);
            OakBoss oakBoss = new OakBoss(11,28);
            visibleEntityMap[11][28].add(oakBoss);
            
            //Initialize some object in the map...
            VisibleEntitiesGenerator generator = new VisibleEntitiesGenerator();
            //Create some cactus:
            generator.generateRandomObjects(visibleEntityMap, new VisibleEntity(10294,"Cactus",new Image("images/10294.gif"), false, false,4),10);
            //Create some trees:
            generator.generateRandomObjects(visibleEntityMap, new VisibleEntity(10813,"Tree 1",new Image("images/10813.gif"), false, false,4),8);
            generator.generateRandomObjects(visibleEntityMap, new VisibleEntity(10812,"Tree 2",new Image("images/10812.gif"), false, false,4),4);
            
	}
        
	public void load(GridPane gameplayGrid, int xCenter, int yCenter){
            int tileX = xCenter - 7;
            int tileY = yCenter - 5;            
            
            //Loading the tiles map
            for (int i = 0; i < 15; i++) {
		for (int j = 0; j < 11; j++) {
                    //Creating the image view and getting the image from the tile, which has been created from map.txt
                    ivMatrix[i][j].setImage(tilesMatrix[tileX][tileY].getSpriteSheet());
                    //System.out.println("TileX: " + tileX + " TileY: " + tileY);
                    //Creating the stackpane on each element of the matrix and adding the respective imageview to it.
                    spMatrix[i][j].getChildren().clear();
                    //Resizing tile
                    ivMatrix[i][j].setFitHeight(spMatrix[i][j].getHeight());
                    ivMatrix[i][j].setFitWidth(spMatrix[i][j].getWidth());
                    //End resizing
                    spMatrix[i][j].getChildren().add(ivMatrix[i][j]);
                    ivMatrix[i][j].toBack();
                    
                    //Loading the VisibleEntityLists Map
                    for(int k=0; k < visibleEntityMap[tileX][tileY].length(); k++){                        
                        //If the visible entity's sprite fills 4 tiles.
                        if(visibleEntityMap[tileX][tileY].get(k).getImgNumOfParts() == 4){
                            if((i>0) && (j>0)){
                                visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView().setFitHeight(spMatrix[i][j].getHeight());
                                visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView().setFitWidth(spMatrix[i][j].getWidth());
                                spMatrix[i-1][j-1].getChildren().add(visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView());
                            }
                            if(((i-1) > 0) && ((j-1)>=0)){
                                visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView2().setFitHeight(spMatrix[i][j].getHeight());
                                visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView2().setFitWidth(spMatrix[i][j].getWidth());
                                spMatrix[i-2][j-1].getChildren().add(visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView2());
                            }
                            if(((j-1)>0) && ((i-1)>=0)){
                                visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView3().setFitHeight(spMatrix[i][j].getHeight());
                                visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView3().setFitWidth(spMatrix[i][j].getWidth());
                                spMatrix[i-1][j-2].getChildren().add(visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView3());
                            }
                            if(((i-1) > 0) && ((j-2) >= 0)){
                                visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView4().setFitHeight(spMatrix[i][j].getHeight());
                                visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView4().setFitWidth(spMatrix[i][j].getWidth());
                                spMatrix[i-2][j-2].getChildren().add(visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView4());
                            }                            
                        //If the visible entity's sprite fills 30 tiles (Boss)
                        }else if(visibleEntityMap[tileX][tileY].get(k).getImgNumOfParts() == 30){
                            int counter = 0;
                            for(int a=0; a<6;a++){
                                for(int b=0; b<5; b++){
                                    if((((i-5)+a)>=0) && (((j-4)+b) >=0)){
                                        //Resizing monster part
                                        visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView30()[counter].setFitHeight(spMatrix[i][j].getHeight());
                                        visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView30()[counter].setFitWidth(spMatrix[i][j].getWidth());
                                        //Adding monster part
                                        spMatrix[(i-5)+a][(j-4)+b].getChildren().add(visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView30()[counter]);
                                        //Moving to front
                                        visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView30()[counter].toFront();
                                    }
                                    counter++;
                                }
                            } 
                        //Otherwise, consider that the visible entity's sprite fills just one tile
                        }else{
                            //Resizing imageview
                            visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView().setFitHeight(spMatrix[i][j].getHeight());
                            visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView().setFitWidth(spMatrix[i][j].getWidth());
                            //Adding imageview to the grid
                            spMatrix[i-1][j-1].getChildren().add(visibleEntityMap[tileX][tileY].get(k).getSpriteSheetImageView());
                            System.out.println("imgNumOfParts != 4 executed");
                            System.out.println("imgNumOfParts = " + visibleEntityMap[i][j].get(k).getImgNumOfParts());
                        }
                    }
                    
                    tileX++;
                    
                }
                tileY++;
                tileX = xCenter - 7;                
            }        
	}
        
        public boolean hasMonsterOnScreen(int xCenter, int yCenter){
            for(int i = xCenter - 7; i < xCenter + 7; i++){
                for(int j = yCenter - 5; j < yCenter + 5; j++){
                    try{
                        for(int k = 0; k < visibleEntityMap[i][j].length(); k++){
                            if(visibleEntityMap[i][j].get(k) instanceof Monster){
                                Monster monster = (Monster)visibleEntityMap[i][j].get(k);
                                if(!monster.isDead()){
                                    return true;
                                }
                            }

                        }
                    }catch(ArrayIndexOutOfBoundsException ex){
                        
                    }
                }
            }
            
            return false;
        }
        
        public Monster getMonsterOnScreen(int xCenter, int yCenter){
            if(!hasMonsterOnScreen(xCenter,yCenter)){
                return null;
            }else{
                for(int i = xCenter - 7; i < xCenter + 7; i++){
                    for(int j = yCenter - 5; j < yCenter + 5; j++){
                        for(int k = 0; k < visibleEntityMap[i][j].length(); k++){
                            if(visibleEntityMap[i][j].get(k) instanceof Monster){
                                return (Monster)visibleEntityMap[i][j].get(k);
                            }
                        }
                    }
                }
            }
            return null;
        }
}

package irbra;

import javafx.scene.image.Image;

/**
 *
 * @author Daniel Ferreira
 */
public class Tile extends VisibleEntity{
    
    private boolean walkable;
    
    public Tile(int tileId, String tileName, Image tileImg, boolean walkable ){
        super(tileId, tileName, tileImg, false, false);
        this.walkable = walkable;
    }

    /**
     * @return true if its possible to walk on the tile, false otherwise.
     */
    public boolean isWalkable() {
        return walkable;
    }

    @Override
    public String toString() {
        return "" + getEntityId() + ";" + getEntityName() + ";" + getSpriteSheet().impl_getUrl() + ";" + this.walkable;
    }
    
    public static Tile createTile(String params){
        String[] parts = params.split(";");
        
        Image newTileImg = new Image(parts[2]);
        
        Tile newTile = new Tile(Integer.parseInt(parts[0]),parts[1], newTileImg, Boolean.parseBoolean(parts[3]));
        
        return newTile;
    }
    
}
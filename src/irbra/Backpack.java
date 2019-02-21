package irbra;

import irbra.structures.VisibleEntityList;
import javafx.scene.image.Image;

/**
 *
 * @author Daniel Ferreira
 */
public class Backpack extends VisibleEntity{
    
    private VisibleEntityList items = new VisibleEntityList();
    
    public Backpack(int backpackId, String backpackName, Image backpackImg, VisibleEntityList items) {
        super(backpackId, backpackName, backpackImg, true, true);
    }
    
    public Backpack(int backpackId, String backpackName, Image backpackImg) {
        super(backpackId, backpackName, backpackImg, true, true);
    }
    
    public void addItemToBackpack(VisibleEntity item){
        this.items.add(item);
    }
    
    public void removeItemFromBackpack(VisibleEntity item){
        for (int i = 0; i < this.items.length(); i++) {
            if(this.items.get(i).equals(item)){
                this.items.remove(i);
            }
        }
    }
    
}

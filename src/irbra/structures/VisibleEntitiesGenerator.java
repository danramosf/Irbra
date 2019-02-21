package irbra.structures;

import irbra.VisibleEntity;
import java.util.Random;

/**
 *
 * @author Daniel Ferreira
 */
public class VisibleEntitiesGenerator {
    
    /**
         * Generates a specific number of a specific Visible Entity in random positions on the map
         * @param obj the VisibleEntity to be created in the map
         * @param numOfObjcts the number of visible entities to me added to the map
         */
        public void generateRandomObjects(VisibleEntityList[][] visibleEntityMap, VisibleEntity obj, int numOfObjcts){
            if(numOfObjcts <= 0){
                return;
            }            
            Random rand = new Random();
            VisibleEntity[] objArr = new VisibleEntity[numOfObjcts];
            for(int i=0; i<objArr.length; i++){
                //((max - min) + 1) + min
                int iRnd = rand.nextInt((45 - 6) + 1) + 6;
                int jRnd = rand.nextInt((42 - 7) + 1) + 7;
                //add if tile is empty
                if(visibleEntityMap[iRnd][jRnd].length() == 0){
                    objArr[i] = new VisibleEntity(obj.getEntityId(),obj.getEntityName(),
                                                    obj.getSpriteSheet(),obj.isCarryable(),
                                                    obj.isPushable(),obj.getImgNumOfParts());
                    visibleEntityMap[iRnd][jRnd].add(objArr[i]);
                }
            }
        }
    
}

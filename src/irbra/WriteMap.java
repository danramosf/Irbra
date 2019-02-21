package irbra;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import javafx.scene.image.Image;

/**
 *
 * @author aniel Ferreira and Ebrahim Zhalesani
 */
public class WriteMap {
    
//    private Tile[][] tiles = new Tile[50][50];
//    private Image[] imgTiles = new Image[30];
    
    //Outer Borders
    private Image img4555 = new Image("images/squs/4555.gif");
    private Tile t4555 = new Tile(4555, "Water Corner 01", img4555, false);
    private Image img4554 = new Image("images/squs/4554.gif");
    private Tile t4554 = new Tile(4554, "Water Corner 02", img4554, false);
    private Image img4553 = new Image("images/squs/4553.gif");
    private Tile t4553 = new Tile(4553, "Water Corner 03", img4553, false); 
    private Image img4552 = new Image("images/squs/4552.gif");
    private Tile t4552 = new Tile(4552, "Water Corner 04", img4552, false);
    private Image img4546 = new Image("images/squs/4546.gif");
    private Tile t4546 = new Tile(4546, "Upper Edge 01", img4546, false); 
    private Image img4545 = new Image("images/squs/4545.gif");
    private Tile t4545 = new Tile(4545, "Left Edge 01", img4545, false);
    private Image img4544 = new Image("images/squs/4544.gif");
    private Tile t4544 = new Tile(4544, "Bottom Edge 01", img4544, false);
    private Image img4547 = new Image("images/squs/4547.gif");
    private Tile t4547 = new Tile(4547, "Right Edge 01", img4547, false);
    //Water tiles
    private Image img4520 = new Image("images/squs/4520.gif");
    private Tile t4520 = new Tile(4520, "Water 01", img4520, false);
    private Image img4521 = new Image("images/squs/4521.gif");
    private Tile t4521 = new Tile(4521, "Water 02", img4521, false);
    private Image img4522 = new Image("images/squs/4522.gif");
    private Tile t4522 = new Tile(4522, "Water 03", img4522, false);
    private Image img4523 = new Image("images/squs/4523.gif");
    private Tile t4523 = new Tile(4523, "Water 04", img4523, false);
    private Image img4524 = new Image("images/squs/4524.gif");
    private Tile t4524 = new Tile(4524, "Water 05", img4524, false);
    private Image img4525 = new Image("images/squs/4525.gif");
    private Tile t4525 = new Tile(4525, "Water 06", img4525, false);
    //Sand Borders
    private Image img4539 = new Image("images/squs/4539.gif");
    private Tile t4539 = new Tile(4539, "Sand Corner 1", img4539, true);
    private Image img4538 = new Image("images/squs/4538.gif");
    private Tile t4538 = new Tile(4538, "Sand Corner 2", img4538, true);
    private Image img4537 = new Image("images/squs/4537.gif");
    private Tile t4537 = new Tile(4537, "Sand Corner 3", img4537, true);
    private Image img4536 = new Image("images/squs/4536.gif");
    private Tile t4536 = new Tile(4536, "Sand Corner 4", img4536, true);
    private Image img4532 = new Image("images/squs/4532.gif");
    private Tile t4532 = new Tile(4532, "Sand Top Border", img4532, true);
    private Image img4533 = new Image("images/squs/4533.gif");
    private Tile t4533 = new Tile(4533, "Sand Left Border", img4533, true);
    private Image img4534 = new Image("images/squs/4534.gif");
    private Tile t4534 = new Tile(4534, "Sand Bottom Border", img4534, true);
    private Image img4535 = new Image("images/squs/4535.gif");
    private Tile t4535 = new Tile(4535, "Sand Right Border", img4535, true);
    //Sand
    private Image img4864 = new Image("images/squs/4864.gif");
    private Tile t4864 = new Tile(4864, "Sand 01", img4864, true);
    private Image img7926 = new Image("images/squs/7926.gif");
    private Tile t7926 = new Tile(7926, "Sand 02", img7926, true);
    private Image img7927 = new Image("images/squs/7927.gif");
    private Tile t7927 = new Tile(7927, "Sand 03", img7927, true);
    private Image img7928 = new Image("images/squs/7928.gif");
    private Tile t7928 = new Tile(7928, "Sand 04", img7928, true);
    private Image img7930 = new Image("images/squs/7930.gif");
    private Tile t7930 = new Tile(7930, "Sand 05", img7930, true);
    private Image img7931 = new Image("images/squs/7931.gif");
    private Tile t7931 = new Tile(7931, "Sand 06", img7931, true);
    private Image img8467 = new Image("images/squs/8467.gif");
    private Tile t8467 = new Tile(8467, "Sand 09", img8467, true);
    
    //Write the tilesMap.txt file with 50x50 tiles
    public void writeMap(){
        
        try{
            
            File mapFile = new File("tilesMap.txt");
            
            if(!mapFile.exists()){
                mapFile.createNewFile();
            }
            
            FileWriter fw = new FileWriter(mapFile.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i=0; i < 50; i++){
                for(int j=0; j < 50; j++){
                    //Corner 1
                    if((i==0) && (j==0)){
                        bw.write(t4555.toString());
                        bw.newLine();
                    //Corner 2
                    }else if((i==0) && (j==49)){
                        bw.write(t4554.toString());
                        bw.newLine();
                    //Corner 3
                    }else if((i==49) && (j==0)){
                        bw.write(t4553.toString());
                        bw.newLine();
                    //Corner 4
                    }else if((i==49) && (j==49)){
                        bw.write(t4552.toString());
                        bw.newLine();
                    //Upper edge
                    }else if((i==0) && (j!=0)){
                        bw.write(t4546.toString());
                        bw.newLine();
                    //Left edge
                    }else if((i!=0) && (j==0)){
                        bw.write(t4545.toString());
                        bw.newLine();
                    //Bottom edge
                    }else if((i == 49) && (j!=0)){
                        bw.write(t4544.toString());
                        bw.newLine();
                    //Right edge
                    }else if(j==49){
                        bw.write(t4547.toString());
                        bw.newLine();
                    //Water (random tiles)
                    }else if((i>=1 && i<=4) || (j>=1 && j<=6) || (i<=49 && i>=45) || (j<=49 && j>=43)){
                        Random rand = new Random();
                        int rnd = rand.nextInt(6) + 1;
                        
                        switch(rnd){
                            case(1):
                                bw.write(t4520.toString());
                                bw.newLine();
                                break;
                            case(2):
                                bw.write(t4521.toString());
                                bw.newLine();
                                break;
                            case(3):
                                bw.write(t4522.toString());
                                bw.newLine();
                                break;
                            case(4):
                                bw.write(t4523.toString());
                                bw.newLine();
                                break;
                            case(5):
                                bw.write(t4524.toString());
                                bw.newLine();
                                break;
                            case(6):
                                bw.write(t4525.toString());
                                bw.newLine();
                                break;
                            default:
                                System.out.println("Error generating random value.");
                        }
                    //Sand Corner 1
                    }else if((i==5) && (j==7)){
                        bw.write(t4539.toString());
                        bw.newLine();
                    //Sand Corner 2    
                    }else if((i==5) && (j==42)){
                        bw.write(t4538.toString());
                        bw.newLine();
                    //Sand Corner 3
                    }else if((i==44) && (j==7)){
                        bw.write(t4537.toString());
                        bw.newLine();
                    //Sand Corner 4
                    }else if((i==44) && (j==42)){
                        bw.write(t4536.toString());
                        bw.newLine();
                    //Sand Top Border
                    }else if(i==5){
                        bw.write(t4532.toString());
                        bw.newLine();
                    //Sand Left Border
                    }else if(j==7){
                        bw.write(t4533.toString());
                        bw.newLine();
                    //Sand Bottom Border
                    }else if(i==44){
                        bw.write(t4534.toString());
                        bw.newLine();
                    //Sand Right Border
                    }else if(j==42){
                        bw.write(t4535.toString());
                        bw.newLine();
                    //Fill up everything else with random sand
                    }else{
                        Random rand = new Random();
                        int rnd = rand.nextInt(150) + 1;
                        
                        switch(rnd){
                            case(1):
                                bw.write(t7926.toString());
                                bw.newLine();
                                break;
                            case(2):
                                bw.write(t7927.toString());
                                bw.newLine();
                                break;
                            case(3):
                                bw.write(t7928.toString());
                                bw.newLine();
                                break;
                            case(4):
                                bw.write(t7930.toString());
                                bw.newLine();
                                break;
                            case(5):
                                bw.write(t7931.toString());
                                bw.newLine();
                                break;
                            case(6):
                                bw.write(t8467.toString());
                                bw.newLine();
                                break;
                            default:
                                //Case 7, 8, 9, 10, ... fill with the most common type
                                bw.write(t4864.toString());
                                bw.newLine();
                        }
                    }
                    
                }
            }
            
            bw.close();
            System.out.println("Map file has been written.");
        }catch(IOException ie){
            System.out.println("Failed to write map file.");
        }
        
    }
}

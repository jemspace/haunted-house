//********************************************************************************
// PANTHERID:  6152714
// CLASS: COP 2210 – 2018
// ASSIGNMENT # 3
// DATE: 10/29/2018
//
// I hereby swear and affirm that this work is solely my own, and not the work 
// or the derivative of the work of someone else.
//********************************************************************************

package hauntedhousegame;

import java.util.ArrayList;
import javax.swing.*;

public class Item {
    
    private String itemName;
    private boolean isCollectible;
      
    public void setName(String n){ itemName = n; }
        
    public String getName(){ return itemName; }
    public boolean getCollectible(){ return isCollectible; }  
    
    public Item(String n, boolean col){
        itemName = n;
        isCollectible = col;
    }
    
    public boolean exploreItem(String userName, String room, ArrayList<Item> bag){ 
        boolean survived = true;
        String msg = "";
        String path = this.itemName + ".png";
        switch (this.itemName){
            case "chest":
                msg = "A ghost escapes \nfrom the chest!\nIt scares you to death!";
                String b = "";
                for(int i = 0; i < bag.size(); i++){
                    b = b + bag.get(i).itemName + " ";
                }
                if(!(b.contains("cabinet"))){ survived = false; }                
                break;
            case "mirror":
                msg = "A bloody face that\nyou don't recognize\nlooks back at you\n"
                        + "from the mirror.";
                break;
            case "shower":
                if(room.equals("master bathroom")){
                    msg = "You hear singing and \ntrickling of water, \nbut there's no one there.";
                    path = this.itemName + "1.png";
                }
                else{
                    msg = "The shower steams up... \nyou feel cold fingers \non the back of your neck.";
                }
                break;
            case "jar of eyeballs":
                msg = "As you notice a jar\nof eyeballs on the shelf...\n"
                        + "the eyeballs turn\nand stare at you.";
                break;
            case "broom":
                msg = "When you touch\nthe broom it floats\n in the air. \n"
                        + "What if it belongs \nto a witch?..";
                break;
            case "refrigerator":
                msg = "A human skul!!\n...wait, it's just a \n"
                        + "skull-shaped cake. \nWanna take a bite?";
                break;
            case "cabinet":
                msg = "You found a witch's \nspell book.\nThis might be useful.";
                break;
            case "candelabra":
                msg = "Candles light up, \na shadow of grim reaper \nappears on the wall.";
                break;
            case "old photo":
                msg = "...What is that dark\nfigure, standing behind\nthe children?...";
                break;
            case "pentagram":
                path = this.itemName + ".gif";
                msg = "*You summoned Satan himself*\n\t666\nyour soul is \neternally doomed\n\t666";
                break;
            case "dolls":
                msg = "The dolls come to \nlife and start \ndancing and giggling...";
                break;
            case "typewriter":
                msg = "The typewriter starts \ntyping on its own: \n\"Run, " + userName + ", run\".";
                break;
            case "telephone":
                msg = "You pick up the phone. \nA creepy voice on \nthe other end says:\n"
                        + "\n\"I'm watching you, " + userName + ".\"";
                break;
            case "dresser":
                msg = "The rake crawls \nout of the dresser!\n";
                if(bag.size() < 6){ 
                    survived = false; 
                    msg = msg + "You can't escape.";
                }                
                break;
        }
        this.callTheGhost(msg, path);
        
        return survived;
    }
    
    public void callTheGhost(String message, String path){
        ImageIcon itemImg = new ImageIcon(path);
        JOptionPane.showMessageDialog(null, message, this.itemName, 
                JOptionPane.INFORMATION_MESSAGE, itemImg);
    }
       
}

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

public class Room {
    private String roomName;
    private String[] pathOptions;
    private ArrayList<Item> roomItems = new ArrayList<>();
    
    public void setRoomName(String n){ roomName = n; }
    
    public String getRoomName(){ return roomName; }
    public String[] getPathOptions(){
        return pathOptions;
    }
    
    public ArrayList<Item> getItemsHere(){ return roomItems; }
    
    public Room(String rn){
        roomName = rn;
        Item i1;
        Item i2;
        switch(roomName){
            case "front lobby":
                pathOptions = new String[] {"living room", "dining room", "stairs"};
                break;
            case "living room":
                pathOptions = new String[] {"front lobby", "bathroom 1"};
                i1 = new Item("chest", false);
                roomItems.add(i1);
                break;
            case "bathroom 1":   
            case "bathroom 2":
                if(roomName.equals("bathroom 1")){ 
                    pathOptions = new String[] {"living room"}; }
                else{
                    pathOptions = new String[] {"bedroom 1", "bedroom 2"}; }    
                i1 = new Item("mirror", false);
                i2 = new Item("shower", false);         
                roomItems.add(i1);  
                roomItems.add(i2);
                break;
            case "pantry":
                pathOptions = new String[] {"kitchen"};
                i1 = new Item("jar of eyeballs", true);
                i2 = new Item("broom", true);
                roomItems.add(i1);
                roomItems.add(i2);
                break;
            case "kitchen":
                pathOptions = new String[] {"pantry", "dining room"};
                i1 = new Item("refrigerator", false);
                i2 = new Item("cabinet", true);
                roomItems.add(i1);
                roomItems.add(i2);
                break;
            case "dining room":
                pathOptions = new String[] {"kitchen", "front lobby"};
                i1 = new Item("candelabra", true);
                roomItems.add(i1);
                break;
                
            case "stairs":
                pathOptions = new String[] {"front lobby", "bedroom 1", "bedroom 2", "master bedroom"};
                break;
                
            case "bedroom 1":
                pathOptions = new String[] {"stairs", "bathroom 2"};
                i1 = new Item("dolls", true);                  
                i2 = new Item("dresser", false);
                roomItems.add(i1);
                roomItems.add(i2);
                break;           
            case "bedroom 2":
                pathOptions = new String[] {"stairs", "bathroom 2"};
                i1 = new Item("old photo", true);
                i2 = new Item("pentagram", false);
                roomItems.add(i1);
                roomItems.add(i2);
                break;
            case "master bedroom":
                pathOptions = new String[] {"stairs", "master bathroom"};
                i1 = new Item("telephone", true);
                i2 = new Item("typewriter", false);
                roomItems.add(i1);
                roomItems.add(i2);
                break;
            case "master bathroom":
                pathOptions = new String[] {"master bedroom"};
                i1 = new Item("shower", false);
                roomItems.add(i1);
                break;
        }       
    }
    
}

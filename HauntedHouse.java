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

/**
 */
public class HauntedHouse {
    private final String USERNAME;
    private boolean gameOver;
    private int clearedItems;  
    
    
    private ArrayList<Item> backpack = new ArrayList<Item>();   
    private Room[] allRooms = new Room[12];
    private Room currentRoom;
    private ImageIcon roomImg;
    
    public String getUser(){ return USERNAME; }
    public boolean getGameOver(){ return gameOver; }
    public ArrayList<Item> getBackPack(){ return backpack; }
    public Room[] getRooms(){ return allRooms; }
    public Room getCurrentRoom(){ return currentRoom; }
    
    
    public HauntedHouse(String name){    
        this.USERNAME = name;
        this.gameOver = false;
        this.clearedItems = 0;
        allRooms[0] = new Room("front lobby");
        allRooms[1] = new Room("living room");
        allRooms[2] = new Room("bathroom 1");
        allRooms[3] = new Room("pantry");
        allRooms[4] = new Room("kitchen");
        allRooms[5] = new Room("dining room");
        allRooms[6] = new Room("stairs");
        allRooms[7] = new Room("bedroom 1");
        allRooms[8] = new Room("bathroom 2");
        allRooms[9] = new Room("bedroom 2");
        allRooms[10] = new Room("master bedroom");
        allRooms[11] = new Room("master bathroom");
        this.currentRoom = allRooms[0];
        
    }
    
    public void exploreItems(){
        String title = "Explore a spooky item in " + currentRoom.getRoomName() + "...";
        if(currentRoom.getItemsHere().isEmpty()){
                JOptionPane.showMessageDialog(null, "Sorry, " + USERNAME + ",\nno new items found\nin"
                        + currentRoom.getRoomName(), 
                        title, JOptionPane.PLAIN_MESSAGE, this.roomImg);
        }
        else{     
            String[] itemOptions = new String[currentRoom.getItemsHere().size()];
            for(int i = 0; i < currentRoom.getItemsHere().size(); i++){
                itemOptions[i] = currentRoom.getItemsHere().get(i).getName();   }
                                    
            int c = JOptionPane.showOptionDialog(null, "", title,
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                    this.roomImg, itemOptions, itemOptions[0]); 
            Item i = currentRoom.getItemsHere().get(c);
            boolean survived = i.exploreItem(USERNAME, this.currentRoom.getRoomName(), this.backpack);

            if (survived){
                this.clearedItems++;
                if(i.getCollectible()){     backpack.add(i);    }
               
                this.currentRoom.getItemsHere().remove(this.currentRoom.getItemsHere().indexOf(i)); 
                if(this.clearedItems++ >= 12){                   
                    this.endGame("You won the game ;)");
                }
            }
            else{
                this.endGame("Sorry, you lost");
            }
       } 
    }
    
    public void displayOptions(){
        roomImg = new ImageIcon(this.currentRoom.getRoomName() + ".jpg");        
        String[] options = {"go to next room", "explore items"};        
        int c = JOptionPane.showOptionDialog(null, "", "You are in a spooky "+ this.currentRoom.getRoomName(),
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                this.roomImg, options, options[0]);        
        if(c == 0){
            this.goToRoom();
        }
        else if (c == 1){            
            this.exploreItems();            
        }   
    }
    
    public void goToRoom(){
        int c = JOptionPane.showOptionDialog(null, "", "Go to next room:", 
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                this.roomImg, this.currentRoom.getPathOptions(), this.currentRoom.getPathOptions()[0]);        
        String room = this.currentRoom.getPathOptions()[c];
        
        int i = 0;
        while(i < allRooms.length){
            if(allRooms[i].getRoomName().equals(room)){
                this.currentRoom = allRooms[i]; 
                i = allRooms.length;
            }i++;            
        }
    }
    
    public void endGame(String result){
        roomImg = new ImageIcon("house exterior.jpg");
        String myItems = "Collectible items found:\n";
        for(int i = 0; i < this.backpack.size(); i++){
            myItems = myItems + this.backpack.get(i).getName() + "\n";
        }       
        JOptionPane.showMessageDialog(null, myItems, result, JOptionPane.INFORMATION_MESSAGE, roomImg);
        this.gameOver = true;
    }
    
}

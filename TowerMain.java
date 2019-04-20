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
import javax.swing.*; //


public class TowerMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Hello and Welcome to the Haunted House.\nPlease enter your name:");
        HauntedHouse house = new HauntedHouse(input);
        
        while(!house.getGameOver()){
            house.displayOptions();
        }
        /*
            new Floor class - "displayFloor" method to display options of floor:
                -go to rooms... or
                -go to floor
        
       rename House class to Tower
        
        
        */
    }
    
}

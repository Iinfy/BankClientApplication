package gui;

import java.awt.Font;

public class utils {

    public static void Sleep(int time){
        try{
            Thread.sleep(time);
        } 
        catch (Exception e){

        }
        
    }


    public static Font setArialFontSize(int size){
        Font newFont = new Font("Arial", Font.BOLD, size);
        return newFont;

    }

}

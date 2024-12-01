package gui;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import DataBase.DataBase;


public class CloseListener implements WindowListener {

    @Override
    public void windowOpened(WindowEvent e) {
        
        
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("exiting...");
        DataBase.db.closeConnect();
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowIconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void windowActivated(WindowEvent e) {
        
       
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        // TODO Auto-generated method stub
        
    }

    
    
}

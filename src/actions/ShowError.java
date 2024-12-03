package actions;



import java.awt.Color;

import gui.ClientGui;
import gui.utils;

public class ShowError {

    public static void showAuthError(String errorText){
        ClientGui.authPanel.add(ClientGui.errorLabel);
        ClientGui.errorLabel.setVisible(true);
        ClientGui.errorLabel.setFont(utils.setArialFontSize(20));
        ClientGui.errorLabel.setBounds(250,50,1500,50);
        ClientGui.errorLabel.setForeground(Color.red);
        ClientGui.errorLabel.setText(errorText);
        
        
        
    }

    public static void showHomeError(String errorText){
        ClientGui.homePagePanel.add(ClientGui.errorLabel);
        ClientGui.errorLabel.setVisible(true);
        ClientGui.errorLabel.setFont(utils.setArialFontSize(20));
        ClientGui.errorLabel.setBounds(250,50,1500,50);
        ClientGui.errorLabel.setForeground(Color.red);
        ClientGui.errorLabel.setText(errorText);
        
        
        
    }

    public static void showConvertError(String errorText){
        ClientGui.converterPagePanel.add(ClientGui.errorLabel);
        ClientGui.errorLabel.setVisible(true);
        ClientGui.errorLabel.setFont(utils.setArialFontSize(20));
        ClientGui.errorLabel.setBounds(250,50,1500,50);
        ClientGui.errorLabel.setForeground(Color.red);
        ClientGui.errorLabel.setText(errorText);
        
        
        
    }

    public static void showTransferError(String errorText){
        ClientGui.moneyTranferPanel.add(ClientGui.errorLabel);
        ClientGui.errorLabel.setVisible(true);
        ClientGui.errorLabel.setFont(utils.setArialFontSize(20));
        ClientGui.errorLabel.setBounds(250,50,1500,50);
        ClientGui.errorLabel.setForeground(Color.red);
        ClientGui.errorLabel.setText(errorText);
    }

    public static void noError(){
        ClientGui.errorLabel.setVisible(false);
    }
}

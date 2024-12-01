package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import DataBase.Currencies;
import DataBase.DataBase;
import actions.MoneyTransfer;
import actions.authorization;

public class ButtonsListener extends JFrame implements ActionListener  {
    @Override
    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();
        System.out.println(command);
        if(command.equals("Select home page")){
            if(ClientGui.isAuthorized){
                ClientGui.homePageButton.setBackground(Color.green);
                ClientGui.converterPageButton.setBackground(Color.white);
                ClientGui.converterPagePanel.setVisible(false);
                ClientGui.homePagePanel.setVisible(true);
                ClientGui.moneyTranferPanel.setVisible(false);
                ClientGui.currentBalance.setText(DataBase.db.getBalance(authorization.userName));
                
            }
            
        }
        if(command.equals("Select converter page")){
            if(ClientGui.isAuthorized){
                ClientGui.homePageButton.setBackground(Color.white);
                ClientGui.converterPageButton.setBackground(Color.green);
                ClientGui.homePagePanel.setVisible(false);
                ClientGui.converterPagePanel.setVisible(true);
                ClientGui.moneyTranferPanel.setVisible(false);

            }
        }
        if(command.equals("Get auth")){
            authorization.auth();
            if(ClientGui.isAuthorized){
                ClientGui.authPanel.setVisible(false);
                ClientGui.getAuthButton.setBackground(Color.white);
            }
        }
        if(command.equals("MoneyTransfer")){
            ClientGui.homePagePanel.setVisible(false);
            ClientGui.moneyTranferPanel.setVisible(true);
            
            
            
        }
        if(command.equals("MTransferCon")){
            int money;
            try{
                money = Integer.parseInt(ClientGui.transferMoneyToTransfer.getText());
                MoneyTransfer.mTransfer(authorization.userName, ClientGui.transferUserToName.getText(), money);
            } catch(Exception e1){
                System.out.println("pars error");
                System.out.println(e1);
            }
        }
        if(command.equals("ChangeAuthButton")){
            if(ClientGui.authButtonAction.equals("Get auth")){
                ClientGui.authButtonAction = "Sign up";
                ClientGui.getAuthButton.setActionCommand(ClientGui.authButtonAction);
                ClientGui.getAuthButton.setText("Sign up");
                ClientGui.authorizationWordLabel.setText("Sign up");
            }else{
                ClientGui.authButtonAction = "Get auth";
                ClientGui.getAuthButton.setActionCommand(ClientGui.authButtonAction);
                ClientGui.getAuthButton.setText("Sign in");
                ClientGui.authorizationWordLabel.setText("Sign in");
            }
        }
        if(command.equals("Sign up")){
            Boolean isReg = DataBase.db.checkExistingUser(ClientGui.authUsername.getText());
            if(!isReg){
                DataBase.db.createNewUser(ClientGui.authUsername.getText(), ClientGui.authPassword.getText());
                authorization.auth();
                if(ClientGui.isAuthorized){
                    ClientGui.authPanel.setVisible(false);
                }
            } else{
                System.out.println("user already exist");
            }
        }
        if(command.equals("ExitAccount")){
            ClientGui.isAuthorized = false;
            ClientGui.homePagePanel.setVisible(false);
            ClientGui.authPanel.setVisible(true);
            ClientGui.homePageButton.setBackground(Color.white);
            
        }
        if(command.equals("ConvertCurrencies")){
            
            float rubles = Float.parseFloat(ClientGui.rublesConverterField.getText());
            float dollars = Float.parseFloat(ClientGui.dollarConverterField.getText());
            float euros = Float.parseFloat(ClientGui.euroConverterField.getText());

            ClientGui.dollarConverterField.setText("" + rubles * Currencies.USD);
            ClientGui.euroConverterField.setText("" + rubles * Currencies.EUR);

        }
        
    }

}

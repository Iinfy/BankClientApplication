package actions;




import java.awt.Color;




import DataBase.DataBase;
import gui.ClientGui;

public class authorization {
    public static String userName;
    public static String userPass;
    

    public static void auth(){
        userName = ClientGui.authUsername.getText();
        userPass = ClientGui.authPassword.getText();


        

        if(userName.length() > 16 || userPass.length() > 16){
            System.out.println("To long!");
        }else{
            ClientGui.isAuthorized = DataBase.db.getAuthorize(userName, userPass);
            if(ClientGui.isAuthorized){
                ClientGui.getAuthButton.setBackground(Color.green);
                ClientGui.homePagePanel.setVisible(true);
                ClientGui.authPanel.setVisible(false);
                ClientGui.currentBalance.setText(DataBase.db.getBalance(authorization.userName));
                ClientGui.homePageButton.setBackground(Color.green);
                

            }
            else{
                ClientGui.getAuthButton.setBackground(Color.red);
            }
        }
        
    }

}

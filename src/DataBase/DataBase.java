package DataBase;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class DataBase {
    
    public static String DBUrl = "Your DataBase URL";
    public static String DBUser = "root";
    public static String DBPass = "root";
    public static Connection con;
    public static Statement statement;
    public static ResultSet rs;


    




    //Column positions
    public static int id = 1;
    public static int name = 2;
    public static int pass = 3;
    public static int balance = 4;
    public static int maxID;


    public void connect(){
        try{
            con = DriverManager.getConnection(DBUrl, DBUser, DBPass);
            statement = con.createStatement();
            System.out.println("Connection succesful");
        
        }catch(Exception e){
            System.out.println(e);
        }

        
    }

    public void closeConnect(){
        try{
            statement.close();
            con.close();
            System.out.println("Connection closed");
            
        }catch(Exception e){
            System.out.println(e);
            
        }
    }

    public void sendRequest(String SQLRequest, int column){
        try{
        rs = statement.executeQuery(SQLRequest);
        while(rs.next()){
            System.out.println(rs.getString(column));
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public Boolean getAuthorize(String username, String password){
        String actionSQLRequest = "SELECT * FROM useraccounts WHERE Username='" + username + "'";
        System.out.println(actionSQLRequest);
        try{
            
            rs = statement.executeQuery(actionSQLRequest);
            rs.next();
            if(rs.getString(pass).equals(password)){
                System.out.println("Authorized");
                
                return true;
                
            }
            else{
                System.out.println("Authorization declined");
                
                return false;
            }
        }catch (Exception e){
            System.out.println(e);
            
            return false;
        }
        
    }

    public String getBalance(String username){
        try{
            rs = statement.executeQuery("SELECT * FROM useraccounts WHERE Username='" + username + "'");
            rs.next();
            String returnBalance = rs.getString(balance);
            
            return returnBalance;
            
        } catch(Exception e){
            System.out.println(e);
            
            return "Error";
        }

        
    }

    public void editBalance(String username, float sum){
        try{
            rs = statement.executeQuery("SELECT * FROM useraccounts WHERE Username='" + username + "'");
            rs.next();
            float currentBalance = rs.getFloat(balance) + sum;
            String actionSQLRequest = "UPDATE useraccounts SET Balance =" + currentBalance + " WHERE Username='" + username + "'";
            statement.execute(actionSQLRequest);
            
            
        } catch(Exception e){

        }
    }

    public void getMaxID(){
        
        try{
            
            rs = statement.executeQuery("SELECT * FROM useraccounts");
            while(rs.next()){
                maxID = rs.getInt(id);
                
            }
           
        }catch(Exception e){
            System.out.println(e);
            
        }

    }

    public int getUserID(String username){
        try{
            String actionSQLRequest = "SELECT * FROM useraccounts WHERE Username='" + username + "'";
            rs = statement.executeQuery(actionSQLRequest);
            rs.next();
            System.out.println(rs.getInt(id));
            return rs.getInt(id);
        }catch (Exception e){
            System.out.println(e);
            return -1;
        }
    }

    public void createNewUser(String username, String password){
        try{
            String SQLAction = "INSERT INTO useraccounts (Username, Password, Balance) VALUES ('" + username + "','" + password + "',0.0)";
            System.out.println(SQLAction);
            statement.execute(SQLAction);
            
        } catch(Exception e){
            System.out.println(e);
            
        }
    }

    public void getActualExRate(){
        try{
            rs = statement.executeQuery("SELECT ExRate FROM currencies");
            rs.next();
            Currencies.USD = rs.getFloat(1);
            rs.next();
            Currencies.EUR = rs.getFloat(1);
            System.out.println("Excange rates available");
        }catch(Exception e){
            System.out.println("Error while getting Exchange Rates");

        }

    }

    public Boolean checkExistingUser(String username){
        try{
        rs = statement.executeQuery("SELECT * FROM useraccounts");
        while (rs.next()) {
            if(rs.getString(name).equals(username)){
                System.out.println("username allready existt");
                return true;
            }
            
        }
        return false;
        }catch(Exception e){
            System.out.println(e);
            return true;
        }

    }

    //DataBase connection
    public static DataBase db = new DataBase();
    

}

package actions;



import DataBase.DataBase;

public class MoneyTransfer {
    public static Float currentUserBalance;

    public static void mTransfer(String userFrom, String userTo, float sum){
        currentUserBalance = Float.parseFloat(DataBase.db.getBalance(userFrom));
        if(currentUserBalance >= sum){
            DataBase.db.getMaxID();
            if(DataBase.maxID >= DataBase.db.getUserID(userTo)){
                DataBase.db.editBalance(userFrom, -sum);
                DataBase.db.editBalance(userTo, sum);
            } else{
                System.out.println("Unexpected user!");
            }
        } else{
            System.out.println("Not enough money");
        }
        
    }
}

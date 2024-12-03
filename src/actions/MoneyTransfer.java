package actions;



import DataBase.DataBase;

public class MoneyTransfer {
    public static Float currentUserBalance;

    public static void mTransfer(String userFrom, String userTo, float sum){
        currentUserBalance = Float.parseFloat(DataBase.db.getBalance(userFrom));
        if(!userFrom.equals(userTo)){
            if(DataBase.db.checkExistingUser(userTo)){
                if(currentUserBalance >= sum){
                    DataBase.db.getMaxID();
                    if(DataBase.maxID >= DataBase.db.getUserID(userTo)){
                        DataBase.db.editBalance(userFrom, -sum);
                        DataBase.db.editBalance(userTo, sum);
                        ShowError.noError();
                    } else{
                        System.out.println("Unexpected user!");
                    }
                } else{
                    System.out.println("Not enough money");
                }
            }else{
                System.out.println("User doesnt exist!");
            }
        } else{
            System.out.println("You cant transfer to itself");
            ShowError.showTransferError("You cant transfer money to itself");
        }
    }
}

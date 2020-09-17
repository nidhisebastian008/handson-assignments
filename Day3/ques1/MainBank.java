public class MainBank {
    public static void main(String[] args) {
        //pass the accountNo and amount to deposit from CLA
        long inputAccNo=Long.parseLong(args[0]);
        double inputAmount=Double.parseDouble(args[1]);

        //get the Account using the accountNo by calling getAccount(...)

        Account retAcc=getAccount(inputAccNo);

        // if accountNo is wrong show the error message and must not perform any below
        // operation
        if(retAcc==null)
        {
            System.out.println("Wrong acc no");
        }
        
        // show the account information before deposit
        else
        {
            if(retAcc instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount)retAcc; 
                savingsAccount.accountInformation();

                //deposit the amount to that particular Account
                savingsAccount.setBalance(savingsAccount.getBalance()+inputAmount);


                savingsAccount.accountInformation();
            }
            else{
                RDAccount rdAccount = (RDAccount)retAcc; 
                rdAccount.accountInformation();

                //deposit the amount to that particular Account

                rdAccount.setBalance(rdAccount.getBalance()+inputAmount);

                rdAccount.accountInformation();
            }
        }
        //deposit the amount to that particular Account
        


        //show the account information after deposit
        
    }

    // pass the accountNO and get the Account from Accounts[] 
    public static Account getAccount(long accountNo) {
        Account[] accounts = AccountsDB.getAccounts();

        Account account = null;
        // get the account from accounts using the accountNo

        //mycode
        for(Account a:accounts)
        {
            if(a.getAccountNumber()==accountNo)
            {
                account=a;
                break;
            }
        }
        //mycode

        return account;
    }
}
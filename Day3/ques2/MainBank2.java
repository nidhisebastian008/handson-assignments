public class MainBank2 {
    public static void main(String[] args) {
        //pass the accountNo and amount to deposit from CLA
        long srcAccNo=Long.parseLong(args[0]);
        double inputAmount=Double.parseDouble(args[1]);
        long desAccNo=Long.parseLong(args[2]);


        Account srcAcc=getAccount(srcAccNo);
        Account desAcc=getAccount(desAccNo);

        if(srcAcc==null||desAcc==null)
        {
            System.out.println("Wrong acc no");
        }
        else
        {
            if(srcAcc instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount)srcAcc; 
                savingsAccount.accountInformation();

                //deposit the amount to that particular Account
                savingsAccount.withdraw(inputAmount);
                savingsAccount.accountInformation();
            }
             if(srcAcc instanceof RDAccount) {
                RDAccount rdAccount = (RDAccount)srcAcc; 
                rdAccount.accountInformation();

                //deposit the amount to that particular Account

                rdAccount.withdraw(inputAmount);

                rdAccount.accountInformation();
            }
             if(desAcc instanceof RDAccount) {
                RDAccount rdAccount = (RDAccount)desAcc; 
                // rdAccount.accountInformation();

                //deposit the amount to that particular Account
                
                rdAccount.deposit(inputAmount);

                // rdAccount.accountInformation();
            }
            if(desAcc instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount)desAcc; 
                // savingsAccount.accountInformation();

                //deposit the amount to that particular Account
                savingsAccount.deposit(inputAmount);
                // savingsAccount.accountInformation();
            }
        }
    }

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
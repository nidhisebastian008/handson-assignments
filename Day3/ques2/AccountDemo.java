class AccountDemo { 
    public static void main(String[] args){
        Account account = new Account(5555L, 500);
        account.accountInformation();
       /* 
        account.withdraw(100);
        account.deposit(200);
        account.accountInformation(); */
        System.out.println("---------- Creating Savings Account ----------------");
        SavingsAccount savings = new SavingsAccount(6666L, 1500, "HSBC001");
        savings.accountInformation();
      /*  savings.withdrawLimit();
        savings.minimumBalance();
        savings.withdraw(100);
        savings.deposit(200);
        savings.accountInformation(); */
        System.out.println("------- Creating RD Account -------------------");
        RDAccount rdAccount = new RDAccount(7777L, 2500);
        rdAccount.accountInformation();
       // rdAccount.schedulesList();
       // rdAccount.accountInformation();
    
    }
}
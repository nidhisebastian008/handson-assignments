class PolymorphismDemo {
    public static void main(String[] args) {
        SavingsAccount savings = new SavingsAccount(9999L, 50000, "HSBC001");
        accountDetails(savings);
        RDAccount rdAccount = new RDAccount(8888L, 3000);
        accountDetails(rdAccount);
        test(savings);
        test(rdAccount);
    }

    public static void accountDetails(Account account) { 
        account.accountInformation(); // multiple result, runtime-polymorphism
    }

    public static void test(Account account) {
        System.out.println("---- test() method ----");
        if(account instanceof SavingsAccount) {
            SavingsAccount savingsAccount = (SavingsAccount)account; 
            savingsAccount.deposit(8888L, 3200);
        }
        
    }
}
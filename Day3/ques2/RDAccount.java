class RDAccount extends Account { 
    String[] schedules = {"Monthly", "Quarterly", "Yearly"};

    RDAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
        // this.accountNumber = accountNumber;
        // this.balance = balance;
        //System.out.println("RDAccount(long, double)");
    }
    void prematureWithdrawl(double amount) {
        System.out.println("prematureWithdrawl() in RD");
    }
    void interestRate() {
        System.out.println("7.5% interest in a year");
    }

    // public void deposit(double amount) { 
    //     // deposit to your account
    //     // this.balance=this.balance+amount;


    // } 
    // public void withdraw(double amount) {
    //     // this.balance=this.balance-amount;
    // }

    void schedulesList() {
        System.out.print("Schedule: ");
        for(String s : schedules) {
            System.out.print(s+" ");
        }
        System.out.println();
    }
    @Override
    public void accountInformation() { // accountInformation();
        super.accountInformation();
        schedulesList();
    }
}
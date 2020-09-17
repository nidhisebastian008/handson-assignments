public class AccountsDB {
    public static Account[] getAccounts() {
        Account[] accounts = {
            new SavingsAccount(1111L, 50000, "HSBC001"),
            new SavingsAccount(2111L, 53000, "HSBC002"),
            new SavingsAccount(3111L, 56000, "HSBC003"),
            new SavingsAccount(4111L, 59000, "HSBC004"),
            new SavingsAccount(5111L, 61000, "HSBC005"),
            new RDAccount(8888L, 4000),
            new RDAccount(9999L, 4500),
            new RDAccount(7777L, 3500),
            new RDAccount(6666L, 6600),
            new RDAccount(5555L, 8700)
            
        };

        return accounts;
    }
}
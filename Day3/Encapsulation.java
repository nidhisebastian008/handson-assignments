public class Encapsulation {
    public static void main(String[] args) {
        Account account = new Account(5555L, 10000);
        account.accountInformation();
        account.setBalance(account.getBalance() + (account.getBalance()*0.1));
        account.accountInformation();
    }
}
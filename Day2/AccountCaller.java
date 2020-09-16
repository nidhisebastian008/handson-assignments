class AccountCaller{
    public static void main(String[] args) {
        Account ac1= new Account(123456789L,"nidhi","delhi","delhi",110056);
        Account ac2= new Account(987654321L,"neha","bihar","patna",220056,1000);
        // ac1.display();
        // System.out.println("--------------------");
        // ac1.deposit(1000);
        // System.out.println("--------------------");
        // ac1.display();

        ac2.display();
        System.out.println("--------------------");
        ac2.withdraw(1000);
        System.out.println("--------------------");
        ac2.display();



    }
}
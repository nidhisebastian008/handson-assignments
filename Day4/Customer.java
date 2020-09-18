class Customer extends Person
{
    Account acc;

    Customer(String name,String gender,long phone,Account acc)
    {
        super(name,gender,phone);
        this.acc=acc;
    }


    void updateBalance(int amt)
    {
        //deposit
        this.acc.setBalance(this.acc.getBalance()+amt);
    }
    void display()
    {
        System.out.println("name"+name);
        System.out.println("account balance"+acc.getBalance());
    }

}
class Account
{

    long accNo;
    String name;
    double bal;
    String ifsc;
    String state ;
    String city;
    int pin;

    Account(long iaccNo,String iname,String istate ,String icity,int ipin)
    {
        accNo=iaccNo;
        name=iname;
        state=istate;
        city=icity;
        pin=ipin;
        ifsc="HSBC001";
        bal=0.0;
    }
    Account(long iaccNo,String iname,String istate ,String icity,int ipin,int ibal)
    {
        accNo=iaccNo;
        name=iname;
        state=istate;
        city=icity;
        pin=ipin;
        ifsc="HSBC001";
        bal=ibal;
    }



    void deposit(double amt)
    {
        bal=bal+amt;
    }
    void withdraw(double amt)
    {
        bal=bal-amt;
    }
    void display()
    {
        System.out.println("ACC NO:"+accNo);
        System.out.println("NAME:"+name);
        System.out.println("BAL:"+bal);
        System.out.println("IFSC CODE:"+ifsc);
        System.out.println("STATE:"+state);
        System.out.println("CITY:"+city);
        System.out.println("PIN:"+pin);
    }
}
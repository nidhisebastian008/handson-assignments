class Account 
{
    private long accountNumber;
    private double bal;
    Account(long accountNumber,int bal)
    {
        this.bal=bal;
        this.accountNumber=accountNumber;
    }
    double getBalance()
    {
        return this.bal;
    }
    void setBalance(double bal)
    {
        this.bal=bal;
    }
}
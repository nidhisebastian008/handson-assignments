 abstract class Employee extends Person
{
    int empid;
    private double sal;

    Employee(String name,String gender,long phone,int empid,double sal)
    {
        super(name,gender,phone);
        this.empid=empid;
        this.sal=sal;
    }

    abstract void incrementSalary();
    double getSal()
    {
        return this.sal;
    }
    void setSal(double sal)
    {
         this.sal=sal;
    }
}
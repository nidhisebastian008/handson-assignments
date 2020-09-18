class Programmer extends Employee
{

    Programmer(String name,String gender,long phone,int empid,double sal)
    {
        super(name,gender,phone,empid,sal);
        
    }
    void incrementSalary()
    {
        this.setSal(this.getSal()+(this.getSal()/10));
    }
    void display()
    {
        System.out.println("programer id"+this.empid);
        System.out.println("salary"+this.getSal()); 
    }
}
class Manager extends Employee
{
    int empCount;

    Manager(String name,String gender,long phone,int empid,double sal,int empCount)
    {
        super(name,gender,phone,empid,sal);
        
        this.empCount=empCount;
    }
    void incrementSalary()
    {
        this.setSal(this.getSal()+(this.getSal()/10));
    }
    void display()
    {
        System.out.println("mnager id"+this.empid);
        System.out.println("salary"+this.getSal());
        System.out.println("emp count"+this.empCount);
    }
    
}
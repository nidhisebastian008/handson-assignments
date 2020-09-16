class Employee
{
    int id;
    String name;
    int sal;
    Address address;

    Employee(int id ,String name,int sal)
    {
        this.id=id;
        this.name=name;
        this.sal=sal;
        
    }
    Employee(int id ,String name,int sal,Address address)
    {
        this(id,name,sal);
        this.address=address;
    }

    void display()
    {
       System.out.println(id);
       System.out.println(name);
       System.out.println(sal);
       if(address!=null)
       {
        System.out.println(address.state+" "+address.city+" "+address.pin);
       }
       
    }
}
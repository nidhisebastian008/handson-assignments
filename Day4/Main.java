class Main
{
    public static void main(String[] args) {

        // Address ads= new Address("delhi","sentral",110);
        Programmer pr= new Programmer("nidhi","female",89213809,123,50000);
        Manager mng= new Manager("sagar","male",89213809,124,100000,10);
        Account acc= new Account(1234,10000);
        Customer cst= new Customer("neha","female",89213809,acc);
        Student std= new Student("student-neha","female",89213809,3);
        Admin adm = new Admin("sonia","female",89213809,124,50000);

       test(adm);
    }
    public static void test(Person person)
    {
        if( person instanceof Admin)
        {
            Admin admin = (Admin)person;
            admin.display();
            admin.setSal(admin.getSal()+admin.getSal()/10);
            admin.display();
            
        }
        // if( p instanceOf Manager)
        // {
            
        // }
        // if(p instanceOf Student)
        // {

        // }

    }
}
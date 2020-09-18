abstract class Person
{
    String name;
    String gender;
    long phone;
    Address ads;


    Person(String name,String gender,long phone)
    {
        this.name=name;
        this.gender=gender;
        this.phone=phone;
    }
    Person(String name,String gender,long phone,Address ads)
    {
        this(name,gender,phone);
        this.ads=ads;
    }

    abstract void display();
     
}
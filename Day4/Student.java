class Student extends Person
{
    int grade;

    Student(String name,String gender,long phone,int grade)
    {
        super(name,gender,phone);
        this.grade=grade;
    }
    void updateGrade(int grd)
    {
        this.grade=grd;
    }
    void display()
    {
        System.out.println("name"+this.name);
        System.out.println("grade"+this.grade);
    }
}
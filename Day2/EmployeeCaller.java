class EmployeeCaller
{
    public static void main(String[] args) {
        
        Address ad1= new Address("delhi","delhi",10023);
        // Address ad2= new Address("mp","bhopal",10024);
        Employee [] empArr= new Employee[3];
        empArr[0]= new Employee(123,"nidhi",20000);
        empArr[1]= new Employee(456,"sonia",20000);
        empArr[2]= new Employee(789,"shubam",70000,ad1);

        for(Employee emp:empArr)
        {
            if(emp.sal > 50000)
                emp.display();
        }



    }
}
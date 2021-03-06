package Bank_AP_Project.src.src;

import java.util.ArrayList;

public class Admin extends Employee {
    private static ArrayList<Admin> all_admins = new ArrayList<>();

    public Admin(String name, String national_id, String password) {
        super(name, national_id, password);
        all_admins.add(this);
    }

    public static void show_all_admins() {
        for (Admin admin : all_admins) {
            System.out.println(admin);
        }
    }

    public static ArrayList<Admin> getAll_admins() {
        return all_admins;
    }

    public static ArrayList<Employee> getAll_employee() {
        return Employee.getAll_employees();
    }

    public void change_salary(String national_id, int new_salary) {
        ArrayList<Employee> all_Employees = Employee.getAll_employees();
         boolean flag=false;
        for (Employee emp : all_Employees)
        {
            if (emp.getNational_id().equals(national_id))
            {
                    emp.set_salary(new_salary);
                    flag=true;
            }
        }
        if(!flag)
        {
            System.out.println("employee didn't found");
        }


    }

    public void remove_employee(String national_id)
    {
        if(Employee.get_employee_by_national_id(national_id)==null)
        {
            System.out.println("employee didn't found");
        }
        else
        {
            Employee.getAll_employees().remove(Employee.get_employee_by_national_id(national_id));
            System.out.println("Removed!");
        }
    }

    public void change_employee_password(String national_id, String new_password)
    {
        if(Employee.get_employee_by_national_id(national_id)==null)
        {
            System.out.println("Employe didn't Found");
        }
        else
        {
            Employee.get_employee_by_national_id(national_id).set_new_password(new_password);
            System.out.println("set !");
        }
    }
    public void add_employee(String name,String national_id, String password,int salary)
    {
        new Employee(name,national_id,password,salary);
    }

    public Employee search_employee_by_national_id(String national_id)
    {
        if(Employee.get_employee_by_national_id(national_id)==null)
        {
            System.out.println("Employee didn't Found !");
        }
        else
        {
            return Employee.get_employee_by_national_id(national_id);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Admin{" + "name='" + this.getName() + '\'' + ", national_id='" + this.getNational_id() + '\'' + ", password='" + this.getPassword() + '\'' + '}';
    }
}


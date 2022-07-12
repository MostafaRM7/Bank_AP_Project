package Bank_AP_Project.src.src;

import java.util.ArrayList;

public class Auth
{
    // login
    public static Customer customer_login(String id, String password) throws NullPointerException
    {
        ArrayList<Customer> customers = Customer.getAll_customers();
        for (Customer cus:customers)
        {
            if(cus.getNational_id().equals(id) && cus.getPassword().equals(password))
            {
                return cus;
            }
        }
        return null;
    }
    public static Employee employee_login(String id, String password)
    {
        ArrayList<Employee> employees = Employee.getAll_employees();
        for (Employee emp: employees)
        {
            if(emp.getNational_id().equals(id) && emp.getPassword().equals(password))
            {
                return emp;
            }
        }
        return null;
    }
    // sign up
    public static void customer_sign_up(String name,String id, String password , String gender, Double initial_money)
    {
            Customer cus = new Customer(name,id,password,gender,initial_money);
            System.out.println("Sign up successful!\nNow you can login with your N.I.D. and password\n" + cus);
    }
    public static Admin admin_login(String id, String password)
    {
        ArrayList<Admin> admins = Admin.getAll_admins();
        for (Admin add:admins)
        {
            if(add.getNational_id().equals(id) && add.getPassword().equals(password))
            {
                return add;
            }
        }
        return null;
    }
}

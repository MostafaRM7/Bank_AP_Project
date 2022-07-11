package Bank_AP_Project.src.src;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Employee
{
    private String name;
    private String national_id;
    private String password;
    private int salary;

    private static ArrayList<Employee> all_employees = new ArrayList<>();

    // Constructors
    public Employee(String name, String national_id, String password, int salary)
    {
        this.name = name;
        this.national_id = national_id;
        this.password = password;
        this.salary=salary;
        all_employees.add(this);
    }
    public Employee(String name, String national_id, String password) {
        this.name = name;
        this.national_id = national_id;
        this.password = password;
    }
    // getters
    public String getName() {
        return name;
    }
    public String getNational_id() {
        return national_id;
    }
    public String getPassword() {
        return password;
    }
    public int getSalary() {
        return salary;
    }
    public static ArrayList<Employee> getAll_employees()
    {
        return all_employees;
    }
    // setters
    public void set_salary(int salary) {
        this.salary = salary;
    }
    public void set_new_password(String password) throws NullPointerException
    {
        this.password = password;
    }

    // main methods
    public void add_customer(String name, String national_id, String password, String gender, double initial_money)
    {
        Auth.customer_sign_up(name, national_id, password, gender ,initial_money);
    }
    public void show_all_accounts() {
        Account.show_all_accounts();
    }
    public void show_customer_accounts(String national_id)
    {
        if(Customer.get_customer_by_national_id(national_id)==null)
        {
            System.out.println("Customer didn't Found !");
        }
        else
        {
        Customer.get_customer_by_national_id(national_id).show_all_accounts();
        }
    }
    public void creat_new_account(Customer c)
    {
        c.creat_new_account();
    }
    public void remove_account(String national_id ,String account_id)
    {
        Customer.get_customer_by_national_id(national_id).remove_account(account_id);
    }
    public static void show_all_employees()
    {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (Employee emp: all_employees)
        {
            System.out.println(emp);
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
    }
    public static Employee get_employee_by_national_id(String national_id)
    {
        for (Employee emp: all_employees)
        {
            if(emp.national_id.equals(national_id))
            {
                return emp;
            }
        }
        return null;
    }
    public static ArrayList<Customer> getAll_customers() {
        return Customer.getAll_customers();
    }
    public static ArrayList<Account> getAll_customer_account(Customer c) {
        return c.getAll_accounts();
    }
    public static ArrayList<Account> getAll_account() {return Account.getAll_accounts();}
    public Customer search_customer_by_national_id(String national_id)
    {   if(Customer.get_customer_by_national_id(national_id)==null)
        {
            System.out.println("Customer didn't Found !");
        }
        else
        {
            return Customer.get_customer_by_national_id(national_id);
        }
        return null;
    }
    public void remove_customer(String national_id)
    {
       if (Customer.get_customer_by_national_id(national_id)==null)
       {
           System.out.println("Customer didn't Found!");
       }
       else
       {
           Customer.getAll_customers().remove(Customer.get_customer_by_national_id(national_id));
           System.out.println("Removed !");
       }
    }
    public void change_customer_password(String national_id, String new_password)
    {
        if(Customer.get_customer_by_national_id(national_id)==null)
        {
            System.out.println("Customer didn't Found");
        }
        else
        {
        Customer.get_customer_by_national_id(national_id).set_new_password(new_password);
            System.out.println("Set !");
        }
    }
    public void Show_customers() {
        Customer.show_all_customers();
    }
    public void Show_accounts()
    {
        Account.show_all_accounts();
    }
    public void Show_employees()
    {
        Employee.show_all_employees();
    }
    public Account search_account_by_account_id(String national_id,String account_id)
    {return Customer.get_customer_by_national_id(national_id).get_account_by_id(account_id);}
    public void show_customers_account()
    {
        for(Customer c:Customer.getAll_customers())
        {
            c.show_all_accounts();
        }
    }
    public void customer_balance(Customer c)
    {
        System.out.println(c.toString());
        c.show_all_accounts();
    }
    public void account_balance(String account_id)
    {
        System.out.println(Account.get_account_by_id(account_id).toString());
    }




    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", national_id='" + national_id + '\'' +
                ", password='" + password + '\'' +
                ", salary=" + salary +
                '}';

    }
}
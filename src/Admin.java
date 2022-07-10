package Bank_AP_Project.src.src;

import java.util.ArrayList;

public class Admin {
    private String name;
    private String national_id;
    private String password;
    private static ArrayList<Admin> all_admins = new ArrayList<>();

    public Admin(String name, String national_id, String password) {
        this.name = name;
        this.national_id = national_id;
        this.password = password;
        all_admins.add(this);
    }

    public static void show_all_admins() {
        for (Admin admin : all_admins) {
            System.out.println(admin);
        }
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getNational_id() {
        return national_id;
    }

    public String getPassword() {
        return password;
    }

    public static ArrayList<Admin> getAll_admins() {
        return all_admins;
    }

    public static ArrayList<Customer> getAll_customers() {
        return Customer.getAll_customers();
    }
    public static ArrayList<Account> getAll_customer_account(Customer c) {
        return c.getAll_accounts();
    }
    public static ArrayList<Account> getAll_account() {return Account.getAll_accounts();}
    public static ArrayList<Employee> getAll_employee() {
        return Employee.getAll_employees();
    }

    public void change_salary(String national_id, int new_salary) {
        ArrayList<Employee> all_Employees = Employee.getAll_employees();

        for (Employee emp : all_Employees) {
            if (emp.getNational_id().equals(national_id)) {
                {
                    emp.set_salary(new_salary);
                }
            }
            else
            {
                System.out.println("There's no employee with this name/national ID");
            }

        }
    }
    public void remove_employee(String national_id) {
        Employee e = Employee.get_employee_by_national_id(national_id);
        Employee.getAll_employees().remove(e);}
    public void add_employee(String name, String id, String password, int salary) {
        new Employee(name, id, password, salary);}
    public void add_customer(String name, String national_id, String password, String gender, int initial_money) {
        new Customer(name, national_id, password, gender ,initial_money);}
    public void remove_customer(String national_id) {
        Customer c = Customer.get_customer_by_national_id(national_id);
        Customer.getAll_customers().remove(c);}
    public void change_customer_password(String national_id, String new_password) {
        Customer c = Customer.get_customer_by_national_id(national_id);
        c.set_new_password(new_password);}
    public void change_employee_password(String national_id, String new_password) {
        Employee e = Employee.get_employee_by_national_id(national_id);
        e.set_new_password(new_password);}
    public Employee search_employee_by_national_id(String national_id) {return Employee.get_employee_by_national_id(national_id);}
    public Customer search_customer_by_national_id(String national_id) {return Customer.get_customer_by_national_id(national_id);}
    public Account search_account_by_account_id(String national_id,String account_id)
    {return Customer.get_customer_by_national_id(national_id).get_account_by_id(account_id);}
    public void Show_customers() {
        Customer.show_all_customers();
    }
    public void Show_employee() {
        Employee.show_all_employees();
    }
    public void Show_accounts() {
        Account.show_all_accounts();
    }
    public void creat_new_account(Customer c) {c.creat_new_account();}
    public void remove_account( String national_id ,String account_id) {Customer.get_customer_by_national_id(national_id).remove_account(account_id);}

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", national_id='" + national_id + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}


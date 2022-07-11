package Bank_AP_Project.src.src;

import java.util.ArrayList;

public class Customer
{
    private String name;
    private String national_id;
    private String password;
    private double initial_money;
    private String gender;
    private int unique_key = 0;
    private ArrayList<Account> all_accounts = new ArrayList<>();
    private static ArrayList<Customer> all_customers = new ArrayList<>();

    public Customer(String name, String national_id, String password, String gender, double initial_money) {
        this.name = name;
        this.national_id = national_id;
        this.password = password;
        this.gender=gender;
        this.initial_money = initial_money;
        all_customers.add(this);
    }

    public Customer() {
    }

    public void setInitial_money(Double initial_money) {
        this.initial_money = initial_money;
    }

    public static Customer get_customer_by_national_id(String national_id)
    {
        for (Customer cus: all_customers)
        {
            if(cus.getNational_id().equals(national_id))
            {
                return cus;
            }
        }
        return null;
    }

    public Account get_account_by_id(String id)
    {
        for (Account acc: all_accounts)
        {
            if(acc.getAccount_id().equals(id))
            {
                return acc;
            }
        }
        return null;
    }

    public String getNational_id() {
        return national_id;
    }
    public static Customer get_customer_by_name(String name)
    {
        for (Customer cus:all_customers)
        {
            if(cus.name.equals(name))
            {
                return cus;
            }
        }
        return null;
    }

    public ArrayList<Account> getAll_accounts()
    {
        return all_accounts;
    }

    public static ArrayList<Customer> getAll_customers() {
        return all_customers;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", national_id='" + national_id + '\'' +
                ", password='" + password + '\'' +
                ", initial_money=" + initial_money +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static void show_all_customers()
    {
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (Customer cus: all_customers)
        {
            System.out.println(cus);
            System.out.println("--------------------------------------------------------------------------------------------------------------");
        }
    }
    public void show_all_accounts()
    {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Account acc: all_accounts)
        {
            System.out.println(acc);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public double getInitial_money() {
        return initial_money;
    }

    public void set_new_password(String password) {
        this.password = password;
    }
    public Account creat_new_account()
    {
        Account acc = new Account(this);
        all_accounts.add(acc);
        return acc;
    }
    public void remove_account(String account_id)
    {
        all_accounts.remove(Account.get_account_by_id(account_id));
        Account.getAll_accounts().remove(Account.get_account_by_id(account_id));
    }

    public String getGender() {return gender;}

    public int getUnique_key() {
        return unique_key;
    }
    public Deposit create_deposit_account(double money, int duration)
    {
        if (money > initial_money)
        {
            System.out.println("You dont have enough money");
            return null;
        }
        else
        {
            System.out.println("Deposit account created successfully");
            return new Deposit(this,money,duration);
        }
    }
    public void unique_key_plus() {
        this.unique_key ++;
    }
}



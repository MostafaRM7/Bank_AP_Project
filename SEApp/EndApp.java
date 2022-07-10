package Bank_AP_Project.src.SEApp;

import Bank_AP_Project.src.src.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EndApp implements SE
{
    private static FileWriter admin_writer;
    private static FileWriter employee_writer;
    private static FileWriter customer_writer;
    private static FileWriter account_writer;
    private static FileWriter transaction_writer;
    private static FileWriter deposit_writer;
    private static final String space = "          ";

    static {
        try {
            admin_writer = new FileWriter(new File(ADMIN), true);
            employee_writer = new FileWriter(new File(EMPLOYEE), true);
            customer_writer = new FileWriter(new File(CUSTOMER), true);
            account_writer = new FileWriter(new File(ACCOUNT), true);
            transaction_writer = new FileWriter(new File(TRANSACTION), true);
            deposit_writer = new FileWriter(new File(DEPOSIT), true);
        } catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
    public static void save_admin_data(ArrayList<Admin> data) throws IOException
    {
        PrintWriter file_clear = new PrintWriter(ADMIN);
        file_clear.close();
        for (Admin admin: data)
        {
            admin_writer.append(admin.getName() + space + admin.getNational_id() + space + admin.getPassword() + "\n");
        }
        admin_writer.close();
    }
    public static void save_employee_data(ArrayList<Employee> data) throws IOException
    {
        PrintWriter file_clear = new PrintWriter(EMPLOYEE);
        file_clear.close();
        for (Employee emp: data)
        {
            employee_writer.append(emp.getName() + space + emp.getNational_id() + space + emp.getPassword() + space + emp.getSalary() + "\n");
        }
        employee_writer.close();
    }
    public static  void save_customer_data(ArrayList<Customer> data) throws IOException
    {
        PrintWriter file_clear = new PrintWriter(CUSTOMER);
        file_clear.close();
        for (Customer cus: data)
        {
            customer_writer.append(cus.getName() + space + cus.getNational_id() + space + cus.getPassword() + space + cus.getGender() + space + cus.getInitial_money() + "\n");
        }
        customer_writer.close();
    }
    public static void save_account_data(ArrayList<Account> data) throws IOException
    {
        PrintWriter file_clear = new PrintWriter(ACCOUNT);
        file_clear.close();
        for (Account acc: data)
        {
            account_writer.append(acc.getOwner().getName() + space + acc.getMoney() + space + acc.getOwner_id() + "\n");
        }
        account_writer.close();
    }
    public static void save_transaction_data(ArrayList<Transaction> data) throws IOException
    {
        PrintWriter file_clear = new PrintWriter(TRANSACTION);
        file_clear.close();
        for (Transaction tr: data)
        {
            transaction_writer.append(tr.getAmount() + space + tr.getFrom().getOwner().getName() + space + tr.getTo().getOwner().getName() + space + tr.getDate());
        }
        transaction_writer.close();
    }
    public static void save_deposit_data(ArrayList<Deposit> data) throws IOException
    {
        PrintWriter file_clear = new PrintWriter(DEPOSIT);
        file_clear.close();
        for (Deposit dep: data)
        {
            deposit_writer.append(dep.getOwner().getName()+ space + dep.getMoney() + space + dep.getDuration());
        }
        deposit_writer.close();
    }
}
package Bank_AP_Project.src.SEApp;

import Bank_AP_Project.src.src.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StartApp implements SE
{
    private static final Scanner admin_reader;
    private static final Scanner employee_reader;
    private static final Scanner customer_reader;
    private static final Scanner account_reader;
    private static final Scanner account_reader1;
    private static final Scanner transaction_reader;
    private static final Scanner deposit_reader;
    static
    {
        try
        {
            admin_reader = new Scanner(new File(ADMIN));
            employee_reader = new Scanner(new File(EMPLOYEE));
            customer_reader = new Scanner(new File(CUSTOMER));
            account_reader = new Scanner(new File(ACCOUNT));
            account_reader1 = new Scanner(new File(ACCOUNT));
            transaction_reader = new Scanner(new File(TRANSACTION));
            deposit_reader = new Scanner(new File(DEPOSIT));
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void read_admin_data()
    {
        while (admin_reader.hasNext())
        {                      // name         national_id      password
            new Admin(admin_reader.next(), admin_reader.next(), admin_reader.next());
        }
        admin_reader.close();
    }

    public static void read_employee_data()
    {
        while (employee_reader.hasNext())
        {                      // name           national id                password                        salary
            new Employee(employee_reader.next(), employee_reader.next(), employee_reader.next(), Integer.parseInt(employee_reader.next()));
        }
        employee_reader.close();
    }

    public static void read_customer_data()
    {
        while (customer_reader.hasNext())
        {
            new Customer(customer_reader.next(), customer_reader.next(), customer_reader.next(),customer_reader.next(), Integer.parseInt(customer_reader.next()));
        }
        customer_reader.close();

    }

    public static void read_account_data() {
        Customer cus = new Customer();
        Account acc = new Account();
        while (account_reader.hasNext())
        {
            cus = Customer.get_customer_by_name(account_reader.next());
            acc = new Account(cus, Double.parseDouble(account_reader.next()));
            account_reader.next();
            while (account_reader1.hasNext())
            {
                account_reader1.next();
                account_reader1.next();
                String owner_id = account_reader1.next();
                if(owner_id.equals(cus.getNational_id()))
                {
                    cus.getAll_accounts().add(acc);
                    break;
                }
            }
        }

    }
    public static void read_transaction_data(){
        while (transaction_reader.hasNext())
        {
            new Transaction
                    (//    amount
                            Integer.parseInt(transaction_reader.next()),
                            // from
                            Account.get_account_by_owner(Customer.get_customer_by_name(transaction_reader.next())),
                            //to
                            Account.get_account_by_owner(Customer.get_customer_by_name(transaction_reader.next()))
                            // date
                            ,Transaction.str_to_date(transaction_reader.next()));
        }
        transaction_reader.close();
    }
    public static void read_deposit_data()
    {
        while (deposit_reader.hasNext())
        {
            new Deposit(Customer.get_customer_by_name(deposit_reader.next()), Integer.parseInt(deposit_reader.next()), Integer.parseInt(deposit_reader.next()));
        }
    }
}
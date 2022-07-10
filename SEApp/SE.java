package Bank_AP_Project.src.SEApp;

import Bank_AP_Project.src.src.*;

import java.io.IOException;
import java.util.ArrayList;

public interface SE
{
    static final String ADMIN = "Data\\Admin.txt";
    static final String CUSTOMER = "Data\\Customer.txt";
    static final String ACCOUNT = "Data\\Account.txt";
    static final String EMPLOYEE = "Data\\Employee.txt";
    static final String TRANSACTION = "Data\\Transaction.txt";
    static final String DEPOSIT = "Data\\Deposit.txt";
    public static void START()
    {
        StartApp.read_admin_data();
        StartApp.read_employee_data();
        StartApp.read_customer_data();
        StartApp.read_account_data();
        StartApp.read_transaction_data();
        StartApp.read_deposit_data();
    }
    public static void END() throws IOException
    {
        EndApp.save_admin_data(Admin.getAll_admins());
        EndApp.save_employee_data(Employee.getAll_employees());
        EndApp.save_customer_data(Customer.getAll_customers());
        EndApp.save_account_data(Account.getAll_accounts());
        EndApp.save_transaction_data(Transaction.getAll_transactions());
        EndApp.save_deposit_data(Deposit.getAll_deposits());
    }

}

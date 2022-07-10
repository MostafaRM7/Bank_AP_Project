package Bank_AP_Project.src.CLI;

import Bank_AP_Project.src.src.Account;
import Bank_AP_Project.src.src.Customer;
import Bank_AP_Project.src.src.Deposit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EmployeeClient
{
    public static void main(String[] args)
    {
        Deposit d = new Deposit(new Customer("mostafa", "1234", "1234", "male", 2000),1000 ,24);
        d.add_profit();
    }
}

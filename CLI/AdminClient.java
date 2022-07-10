package Bank_AP_Project.src.CLI;

import Bank_AP_Project.src.SEApp.SE;
import Bank_AP_Project.src.src.Account;

import java.util.Scanner;

public class AdminClient
{
    public static void main(String[] args) {
     System.out.println("----------------------- WELCOME BACK BOSS -----------------------");
        SE.START();
        Scanner input = new Scanner(System.in);
        main_menu: while (true)
        {
            main_menu();
        }

}
    private static void main_menu()
    {
        String menu = """
                [2] Sign in
                [0] Exit
                """;
        System.out.println(menu);
    }
    private static void Admin_menu()
    {
        String menu = """
                [1] Add Employee
                [2] Add Customer
                [3] Add Account
                [4] Change Employee Salary
                [7] remove Employee
                [8] remove Customer
                [9] Change Employee Password
                [10] Change Customer Password
                [11] Show   Customers
                [12] Show Employees 
                [13] Show All Accounts 
                [14] Show Customer's Accounts 
                [15] Search Customer
                [16] Search Employee
                [17] Show All Customers
                [18] Show All Employee
                
                [0] Exit to main menu
                """;
        System.out.println(menu);
    }
}

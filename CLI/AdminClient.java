package Bank_AP_Project.src.CLI;

import Bank_AP_Project.src.SEApp.SE;
import Bank_AP_Project.src.src.Account;
import Bank_AP_Project.src.src.Auth;
import Bank_AP_Project.src.src.Customer;
import Bank_AP_Project.src.src.Employee;

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
            String choose = input.nextLine();
            if (choose.equals("1")) // sign in
            {
                System.out.println("N.I.D. :");
                String nid = input.nextLine();
                System.out.println("Password:");
                String pass = input.nextLine();
                Employee e = Auth.employee_login(nid, pass);
                System.out.println("Name: " + e.getName() + "\n" + "National ID: " + e.getNational_id() + "\n" + "Salary: " + e.getSalary());

            }
            else if (choose.equals("0"))
            {
                break main_menu;
            }
            customer_menu: while (true)
            {
                Admin_menu();
                String next_choose = input.nextLine();
                if (next_choose.equals("1")) //Add Employee
                {
                    System.out.println("Name :");
                    String name = input.nextLine();
                    System.out.println("N.I.D. :");
                    String nid = input.nextLine();
                    System.out.println("Password :");
                    String passward = input.nextLine();
                    System.out.println("Salary");
                    int salary = input.nextInt();
                   Employee e=new Employee(name,nid,passward,salary);
                   Employee.getAll_employees().add(e);
                   System.out.println(e.toString());

                }
            }

        }

}
    private static void main_menu()
    {
        String menu = """
                [1] Sign in
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
                [11] Show All Customers
                [12] Show All Employees
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

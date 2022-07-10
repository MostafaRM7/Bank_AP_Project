package Bank_AP_Project.src.CLI;

import Bank_AP_Project.src.SEApp.SE;
import Bank_AP_Project.src.src.*;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EmployeeClient
{
    public static void main(String[] args)
    {
        SE.START();
        System.out.println("----------------------- WELCOME -----------------------");
        Scanner input = new Scanner(System.in);
        main_menu:while (true)
        {
            main_menu();
            String choose = input.nextLine();
            if(choose.equals("1"))
            {
                System.out.println("Enter your N.I.D. :");
                String nid = input.nextLine();
                System.out.println("Enter your password :");
                String pass = input.nextLine();
                Employee emp = Auth.employee_login(nid, pass);
                employee_menu: while (true)
                {
                    employee_menu();
                    String next_choose = input.nextLine();
                    if(next_choose.equals(1))
                    {

                    }
                    else if(next_choose.equals(2))
                    {

                    }
                    else if(next_choose.equals(3))
                    {

                    }
                    else if(next_choose.equals(4))
                    {

                    }
                    else if(next_choose.equals(5))
                    {

                    }
                    else if(next_choose.equals(6))
                    {

                    }
                    else if(next_choose.equals(7))
                    {

                    }
                    else if(next_choose.equals(8))
                    {

                    }
                    else if(next_choose.equals(0))
                    {
                        break employee_menu;
                    }
                }
            }
            else if (choose.equals("0"))
            {
                break main_menu;
            }

        }
    }
    public static void main_menu()
    {
        String menu = """
                [1] Sign in
                [0] Exit
                """;
        System.out.println(menu);
    }
    public static void employee_menu()
    {
        String menu = """
                [1] Add customer
                [2] Add account
                [3] Remove customer
                [4] Change customer password
                [5] Show all customers
                [6] Show all accounts
                [7] Show customer's accounts
                [8] Search customer
                
                [0] Exit to main menu
                """;
    }
}

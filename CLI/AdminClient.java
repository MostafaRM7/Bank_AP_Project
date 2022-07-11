package Bank_AP_Project.src.CLI;

import Bank_AP_Project.src.SEApp.SE;
import Bank_AP_Project.src.src.*;

import java.util.Scanner;

public class AdminClient
{
    public static void main(String[] args) {
        SE.START();
        System.out.println("----------------------- WELCOME BACK BOSS -----------------------");
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
                admin_menu: while (true)
                {
                    Admin_menu();
                    String next_choose = input.nextLine();
                    if (next_choose.equals("1")) //Add Employee
                    {
                        System.out.println("Name :");
                        String name = input.nextLine();
                        System.out.println("N.I.D. :");
                        String NID = input.nextLine();
                        System.out.println("Password :");
                        String passward = input.nextLine();
                        System.out.println("Salary :");
                        int salary = input.nextInt();
                        Employee emp = new Employee(name,nid,passward,salary);
                        Employee.getAll_employees().add(emp);
                        System.out.println(emp.toString());

                    }
                    else if(next_choose.equals("2"))
                    {

                    }
                    else if(next_choose.equals("3"))
                    {

                    }
                    else if(next_choose.equals("4"))
                    {

                    }
                    else if(next_choose.equals("5"))
                    {

                    }
                    else if(next_choose.equals("6"))
                    {

                    }
                    else if(next_choose.equals("7"))
                    {

                    }
                    else if(next_choose.equals("8"))
                    {

                    }
                    else if(next_choose.equals("9"))
                    {

                    }
                    else if(next_choose.equals("10"))
                    {

                    }
                    else if(next_choose.equals("11"))
                    {

                    }
                    else if(next_choose.equals("12"))
                    {

                    }
                    else if(next_choose.equals("13"))
                    {

                    }
                    else if(next_choose.equals("14"))
                    {

                    }
                    else if(next_choose.equals("15"))
                    {

                    }
                    else if(next_choose.equals("16"))
                    {

                    }
                    else if(next_choose.equals("17"))
                    {

                    }
                    else if(next_choose.equals("18"))
                    {

                    }
                    else if(next_choose.equals("0"))
                    {
                        break admin_menu;
                    }
                }
            }

            else if (choose.equals("0"))
            {
                break main_menu;
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
                [1] Add employee
                [2] Add customer
                [3] Add account
                [4] Change employee salary
                [7] Remove employee
                [8] Remove customer
                [9] Change employee password
                [10] Change customer password
                [11] Show all customers
                [12] Show all employees
                [13] Show all accounts
                [14] Show customer's accounts
                [15] Search customer
                [16] Search employee
                [17] Show all customers
                [18] Show all employee
                
                [0] Exit to main menu
                """;
        System.out.println(menu);
    }
}

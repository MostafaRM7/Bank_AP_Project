package Bank_AP_Project.src.CLI;

import Bank_AP_Project.src.SEApp.SE;
import Bank_AP_Project.src.src.*;

import java.time.LocalDateTime;
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
               Admin admin = Auth.admin_login(nid,pass);
                if(admin == null)
                {
                    System.out.println("National ID or password is incorrect");
                }
                else {

                  Admin_menu:  while (true) {
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
                            admin.add_employee(name,NID,passward,salary);
                            System.out.println("made!");


                        } else if (next_choose.equals("2")) //add customer
                        {
                            System.out.println("Name :");
                            String name = input.nextLine();
                            System.out.println("N.I.D. :");
                            String NID = input.nextLine();
                            System.out.println("Password :");
                            String passward = input.nextLine();
                            System.out.println("male/female :");
                            String gender = input.nextLine();
                            System.out.println("initial_money :");
                            Double initial_money = input.nextDouble();
                            admin.add_customer(name,NID,passward,gender,initial_money);
                            System.out.println(" made!");

                        } else if (next_choose.equals("3"))//Add account
                        {
                            System.out.println("Enter customer national ID:");
                            String NID = input.nextLine();
                            System.out.println();
                            Customer cus = admin.search_customer_by_national_id(NID);
                            if (cus == null) {
                                System.out.println("National ID is incorrect");
                            } else {
                                cus.creat_new_account();
                                System.out.println("Account created successfully");
                            }

                        }
                        else if (next_choose.equals("4"))//Change employee salary
                        {
                            System.out.println("N.I.D :");
                            String NID = input.nextLine();
                            System.out.println("New Salary :");
                            int salary = input.nextInt();
                            admin.change_salary(NID,salary);

                        }
                        else if (next_choose.equals("5")) //Remove employee
                        {
                            System.out.println("N.I.D :");
                            String NID = input.nextLine();
                             admin.remove_employee(NID);
                        }
                        else if (next_choose.equals("6"))//Remove customer
                        {
                            System.out.println("N.I.D :");
                            String NID = input.nextLine();
                            admin.remove_customer(NID);
                        }
                        else if (next_choose.equals("7"))//Change employee password
                        {
                            System.out.println("N.I.D :");
                            String NID = input.nextLine();
                            System.out.println("New password :");
                            String password = input.nextLine();
                            admin.change_employee_password(NID,password);
                        }
                        else if (next_choose.equals("8")) //Change customer password
                        {
                            System.out.println("N.I.D :");
                            String NID = input.nextLine();
                            System.out.println("New password :");
                            String password = input.nextLine();
                            admin.change_customer_password(NID,password);
                        }
                        else if (next_choose.equals("9"))//Show all customers
                        {
                            admin.Show_customers();
                        }
                        else if (next_choose.equals("10"))//Show all employees
                        {
                            admin.Show_employees();
                        }
                        else if (next_choose.equals("11")) //Show all accounts
                        {
                            admin.Show_accounts();
                        }
                        else if (next_choose.equals("12"))//Show customer's accounts
                        {
                            System.out.println("N.I.D :");
                            String NID = input.nextLine();
                           admin.show_customer_accounts(NID);
                        }
                        else if (next_choose.equals("13")) //Search customer
                        {
                              System.out.println("N.I.D :");
                              String NID = input.nextLine();
                            if(admin.search_customer_by_national_id(NID)==null)
                            {

                            }
                            else
                            {
                                System.out.println(admin.search_customer_by_national_id(NID));
                            }
                        }
                        else if (next_choose.equals("14")) //Search employee
                        {
                            System.out.println("N.I.D :");
                            String NID = input.nextLine();
                            if(admin.search_employee_by_national_id(NID)==null)
                            {

                            }
                            else
                            {
                                System.out.println(admin.search_employee_by_national_id(NID));
                            }
                        }
                        else if (next_choose.equals("15")) //Show bank transactions
                        {
                            for (Transaction tr : Transaction.getAll_transactions())
                            {
                                System.out.println(tr);
                            }
                        }
                        else if (next_choose.equals("16")) //Show customer's transactions
                        {
                            System.out.println("Enter customer national ID:");
                            String NID = input.nextLine();
                            Customer cus = admin.search_customer_by_national_id(NID);
                            if (cus == null)
                            {
                                System.out.println("National ID is incorrect");
                            }
                            else
                            {
                                for (Account acc : cus.getAll_accounts())
                                {
                                    for (Transaction tr : Transaction.get_account_transaction(acc))
                                    {
                                        System.out.println(tr);
                                    }
                                }
                            }
                        }
                        else if (next_choose.equals("17")) //Show account's transactions
                        {
                            System.out.println("Enter account ID:");
                            String acc_id = input.nextLine();
                            for (Transaction tr : Transaction.get_account_transaction(Account.get_account_by_id(acc_id)))
                            {
                                System.out.println(tr);
                            }
                        }
                        else if (next_choose.equals("18"))//transaction between accounts
                        {
                            System.out.println("[1] Simple origin account");
                            System.out.println("[2] Deposit origin account");
                            String origin_type = input.nextLine();
                            // origin simple
                            if(origin_type.equals("1"))
                            {
                                System.out.println("Enter origin account ID:");
                                String or_id = input.nextLine();
                                Account from = Account.get_account_by_id(or_id);
                                if(from != null)
                                {
                                    System.out.println("[1] Simple destination account");
                                    System.out.println("[2] Deposit destination account");
                                    String des_type = input.nextLine();
                                    //destination simple
                                    if(des_type.equals("1"))
                                    {
                                        System.out.println("Enter destination account ID:");
                                        String des_id = input.nextLine();
                                        Account to = Account.get_account_by_id(des_id);
                                        if (to != null)
                                        {
                                            System.out.println("How much money do you want to withdraw:");
                                            double amount = input.nextDouble();
                                            new Transaction(amount, from, to, LocalDateTime.now()).withdraw();
                                        }
                                        else
                                        {
                                            System.out.println("Destination ID is incorrect");
                                        }
                                    }
                                    // destination deposit
                                    else if (des_type.equals("2"))
                                    {
                                        System.out.println("Enter deposit account ID:");
                                        String des_id = input.nextLine();
                                        Deposit dep = Deposit.get_deposit_by_id(des_id);
                                        if (dep != null)
                                        {
                                            System.out.println("How much money do you want to withdraw:");
                                            double amount = input.nextDouble();
                                            new Transaction(amount, from, dep, LocalDateTime.now()).withdraw();
                                        }
                                        else
                                        {
                                            System.out.println("Destination ID is incorrect");
                                        }
                                    }
                                }
                                else
                                {
                                    System.out.println("Origin ID is incorrect");
                                }
                            }
                            // origin deposit
                            else if (origin_type.equals("2"))
                            {
                                System.out.println("Enter deposit account ID:");
                                String or_id = input.nextLine();
                                Deposit dep = Deposit.get_deposit_by_id(or_id);
                                if(dep != null)
                                {
                                    System.out.println("[1] Simple destination account");
                                    System.out.println("[2] Deposit destination account");
                                    String des_type = input.nextLine();
                                    // destination simple
                                    if (des_type.equals("1"))
                                    {
                                        System.out.println("Enter origin simple account ID:");
                                        String des_id = input.nextLine();
                                        Account to = Account.get_account_by_id(des_id);
                                        if (to != null)
                                        {
                                            System.out.println("How much money do you want to withdraw");
                                            double amount = input.nextDouble();
                                            new Transaction(amount, dep, to,LocalDateTime.now()).withdraw();
                                        }
                                        else
                                        {
                                            System.out.println("Destination ID is incorrect");
                                        }
                                    }
                                    // destination deposit
                                    else if (des_type.equals("2"))
                                    {
                                        System.out.println("Enter deposit account ID:");
                                        String des_id = input.nextLine();
                                        Deposit deposit = Deposit.get_deposit_by_id(des_id);
                                        if (deposit != null)
                                        {
                                            System.out.println("How much money do you want to withdraw:");
                                            double amount = input.nextDouble();
                                            new Transaction(amount, dep, deposit, LocalDateTime.now()).withdraw();
                                        }
                                        else
                                        {
                                            System.out.println("Destination ID is incorrect");
                                        }
                                    }
                                }
                                else
                                {
                                    System.out.println("Deposit not found");
                                }
                            }
                        }
                         else if (next_choose.equals("0"))
                         {
                            break Admin_menu;
                        }
                    }
                }

            }

            else if (choose.equals("0"))
            {
                break main_menu;
            }

        }

        try
        {
            SE.END();
        }
        catch (Exception ee)
        {
            ee.printStackTrace();
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
                [5] Remove employee
                [6] Remove customer
                [7] Change employee password
                [8] Change customer password
                [9] Show all customers
                [10] Show all employees
                [11] Show all accounts
                [12] Show customer's accounts
                [13] Search customer
                [14] Search employee
                [15] Show bank transactions
                [16] Show customer's transactions
                [17] Show account's transactions
                [18] Do transaction between 2 accounts
                [0] Exit to main menu
                """;
        System.out.println(menu);
    }
}

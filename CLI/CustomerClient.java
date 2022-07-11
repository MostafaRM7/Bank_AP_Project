package Bank_AP_Project.src.CLI;


import Bank_AP_Project.src.SEApp.SE;
import Bank_AP_Project.src.src.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.SortedMap;

public class CustomerClient
{
    public static void main(String[] args)
    {
        SE.START();
        System.out.println("----------------------- WELCOME -----------------------");
        Account.show_all_accounts();
        Scanner input = new Scanner(System.in);
        main_menu: while (true)
        {
            main_menu();
            String choose = input.nextLine();
            if (choose.equals("1")) // sign up
            {
                System.out.println("Name:");
                String name = input.nextLine();
                System.out.println("N.I.D. :");
                String nid = input.nextLine();
                System.out.println("Password:");
                String pass = input.nextLine();
                System.out.println("Male\\female:");
                String gender = input.nextLine();
                System.out.println("How much money do you have?");
                double initial_money = input.nextDouble();
                Auth.customer_sign_up(name, nid, pass, gender,initial_money);
            }
            else if (choose.equals("2")) // sign in
            {
                System.out.println("N.I.D. :");
                String nid = input.nextLine();
                System.out.println("Password:");
                String pass = input.nextLine();
                Customer cus = Auth.customer_login(nid, pass);
                System.out.println("Name: " + cus.getName() + "\n" + "National ID: " + cus.getNational_id() + "\n" + "Money: " + cus.getInitial_money());
                customer_menu: while (true)
                {
                    customer_menu();
                    String next_choose = input.nextLine();
                    if (next_choose.equals("1")) // show all accounts
                    {
                        System.out.println(cus.getAll_accounts());
                    }
                    else if (next_choose.equals("2")) // show balance
                    {
                        System.out.println("Account ID:");
                        System.out.println("Balance: " + cus.get_account_by_id(input.nextLine()).getMoney());
                    }
                    else if (next_choose.equals("3")) // charge account
                    {
                        System.out.println("Account ID:");
                        String acc_id = input.nextLine();
                        System.out.println("Amount:");
                        int amount = input.nextInt();
                        if(cus.get_account_by_id(acc_id) != null)
                        {
                            cus.get_account_by_id(acc_id).charge_account(amount);
                        }
                        else
                        {
                            System.out.println("Account not found !");
                        }
                    }
                    else if(next_choose.equals("4"))
                    {
                        System.out.println("Enter origin account ID:");
                        String or_id = input.nextLine();
                        System.out.println("Enter destination account ID:");
                        String des_id = input.nextLine();
                        Account from = cus.get_account_by_id(or_id);
                        Account to = Account.get_account_by_id(des_id);
                        if (from != null && to != null)
                        {
                            System.out.println("How much money do you want to withdraw:");
                            int amount = input.nextInt();
                            new Transaction(amount, from, to, LocalDateTime.now()).withdraw();
                        }
                        else
                        {
                            System.out.println("Destination or origin account ID incorrect");
                        }
                    }
                    else if(next_choose.equals("6"))
                    {
                        System.out.println("Account created successfully:");
                        System.out.println(cus.creat_new_account());
                    }
                    else if (next_choose.equals("7"))
                    {
                        System.out.println("Account ID: ");
                        String acc_id = input.nextLine();
                        System.out.println(Transaction.get_account_transaction(Account.get_account_by_id(acc_id)));
                    }
                    else if(next_choose.equals("8"))
                    {
                        System.out.println("Account ID:");
                        String ac_id = input.nextLine();
                        System.out.println("Enter your password again");
                        String password = input.nextLine();
                        if(cus.getPassword().equals(password))
                        {
                            cus.remove_account(ac_id);
                            System.out.println("Account removed successfully");
                        }
                        else
                        {
                            System.out.println("Password is incorrect");
                        }
                    }
                    else if (next_choose.equals("0")) // exit
                    {
                        break customer_menu;
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
                [1] Sign up
                [2] Sign in
                
                [0] Exit
                """;
        System.out.println(menu);
    }
    private static void customer_menu()
    {
        String menu = """
                [1] Show all accounts
                [2] Show balance
                [3] Charge account
                [4] Withdraw
                [5] Show loan balance
                [6] Creat new account
                [7] Show account transactions
                [8] Remove account
                
                [0] Exit to main menu
                """;
        System.out.println(menu);
    }

}

package Bank_AP_Project.src.CLI;


import Bank_AP_Project.src.SEApp.SE;
import Bank_AP_Project.src.src.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class CustomerClient
{
    public static void main(String[] args)
    {
        SE.START();
        System.out.println("----------------------- WELCOME -----------------------");
        Account.show_all_accounts();
        Deposit.show_all_deposits();
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
                if(cus == null)
                {
                    System.out.println("N.I.D. or password is incorrect");
                }
                else
                {
                    System.out.println("Name: " + cus.getName() + "\n" + "National ID: " + cus.getNational_id() + "\n" + "Money: " + cus.getInitial_money());
                    customer_menu:
                    while (true) {
                        customer_menu();
                        String next_choose = input.nextLine();
                        if (next_choose.equals("1")) // show all accounts //Done
                        {
                            System.out.println("Current accounts:");
                            if (cus.getAll_accounts().size()==0)
                            {
                                System.out.println("you don't have any account yet !");
                            }
                            else
                            {
                                System.out.println(cus.getAll_accounts());
                            }

                        }
                        else if (next_choose.equals("2")) // show balance // Done
                        {
                            System.out.println("Account ID:");
                            String id=input.nextLine();
                            if(Account.get_account_by_id(id )== null)
                            {
                                System.out.println("ID is incorrect");
                            }
                            else
                            {
                                Account acc=Account.get_account_by_id(id);
                                System.out.println("Balance: " + acc.getMoney());
                            }

                        }
                        else if (next_choose.equals("3")) // charge account //Done
                        {
                            System.out.println("Account ID:");
                            String acc_id = input.nextLine();
                            System.out.println("Amount:");
                            double amount = input.nextDouble();
                            if (cus.get_account_by_id(acc_id) != null) {
                                cus.get_account_by_id(acc_id).charge_account(amount);
                            } else {
                                System.out.println("Account not found !");
                            }

                        }
                        else if (next_choose.equals("4")) // withdrawal
                        {
                            System.out.println("[1] Simple origin account");
                            System.out.println("[2] Deposit origin account");
                            String origin_type = input.nextLine();
                            // origin simple
                            if(origin_type.equals("1"))
                            {
                                System.out.println("Enter origin account ID:");
                                String or_id = input.nextLine();
                                Account from = cus.get_account_by_id(or_id);
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
                                Deposit dep = cus.get_deposit_by_id(or_id);
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

                        } else if (next_choose.equals("6")) {
                            System.out.println("Account created successfully:");
                            System.out.println(cus.creat_new_account());
                        } else if (next_choose.equals("7"))
                        {
                            System.out.println("Account ID: ");
                            String acc_id = input.nextLine();
                            if(Transaction.get_account_transaction(Account.get_account_by_id(acc_id)).size()==0)
                            {
                                System.out.println("no transaction yet !");
                            }
                            else
                            {
                                System.out.println(Transaction.get_account_transaction(Account.get_account_by_id(acc_id)));
                            }
                        }
                            else if (next_choose.equals("8")) {
                            System.out.println("Account ID:");
                            String ac_id = input.nextLine();
                            System.out.println("Enter your password again");
                            String password = input.nextLine();
                            if (cus.getPassword().equals(password)) {
                                cus.remove_account(ac_id);
                                System.out.println("Account removed successfully");
                            } else {
                                System.out.println("Password is incorrect");
                            }
                        } else if (next_choose.equals("9")) {
                            System.out.println("How much money do you want to deposit:");
                            double money = input.nextDouble();
                            System.out.println("24/12 month?");
                            int dur = input.nextInt();
                            System.out.println(cus.create_deposit_account(money, dur));
                        }
                        else if(next_choose.equals("10"))
                        {
                            System.out.println(cus.getAll_deposits());
                        }
                        else if(next_choose.equals("11"))
                        {
                            System.out.println("Account ID:");
                            String ac_id = input.nextLine();
                            System.out.println("N.I.D:");
                            String national_id = input.nextLine();
                            if(Customer.get_customer_by_national_id(national_id) == null || Account.get_account_by_id(ac_id) == null)
                            {
                                System.out.println("National ID / Account ID is incorrect");
                            }
                            else
                            {
                                Account acc=Account.get_account_by_id(ac_id);
                                System.out.println("Amount:");
                                double amount = input.nextDouble();
                                acc.request_loan(amount,national_id);

                            }

                        }
                        else if (next_choose.equals("0")) // exit
                        {
                            break customer_menu;
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
                [9] Creat deposit account
                [10] Show all deposit accounts
                [11] Request loan
                
                [0] Exit to main menu
                """;
        System.out.println(menu);
    }

}

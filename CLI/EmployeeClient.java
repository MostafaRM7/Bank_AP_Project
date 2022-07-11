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
                if(emp == null)
                {
                    System.out.println("National ID or password is incorrect");
                }
                else {
                    employee_menu();
                    employee_menu:
                    while (true) {
                        String next_choose = input.nextLine();
                        if (next_choose.equals("1")) {
                            System.out.println("Name:");
                            String name = input.nextLine();
                            System.out.println("National ID:");
                            String NID = input.nextLine();
                            System.out.println("Gender:");
                            String Gender = input.nextLine();
                            System.out.println("Password:");
                            String password = input.nextLine();
                            System.out.println("How much money do you have:");
                            int money = input.nextInt();
                            emp.add_customer(name, NID, Gender, password, money);
                        } else if (next_choose.equals("2")) {
                            System.out.println("Enter customer national ID:");
                            String NID = input.nextLine();
                            System.out.println();
                            Customer cus = emp.search_customer_by_national_id(NID);
                            if (cus == null) {
                                System.out.println("National ID is incorrect");
                            } else {
                                cus.creat_new_account();
                                System.out.println("Account created successfully");
                            }
                        } else if (next_choose.equals("3")) {
                            System.out.println("Enter customer national ID:");
                            String NID = input.nextLine();
                            Customer cus = emp.search_customer_by_national_id(NID);
                            if (cus == null) {
                                System.out.println("National ID is incorrect");
                            } else {
                                emp.remove_customer(NID);
                                System.out.println("Customer removed successfully");
                            }
                        } else if (next_choose.equals("4")) {
                            System.out.println("Enter customer national ID:");
                            String NID = input.nextLine();
                            Customer cus = emp.search_customer_by_national_id(NID);
                            if (cus == null) {
                                System.out.println("National ID is incorrect");
                            } else {
                                System.out.println("Enter new password:");
                                String new_pass = input.nextLine();
                                emp.change_customer_password(NID, new_pass);
                            }
                        } else if (next_choose.equals("5")) {
                            emp.Show_customers();
                        } else if (next_choose.equals("6")) {
                            emp.Show_accounts();
                        } else if (next_choose.equals("7")) {
                            System.out.println("Enter customer national ID:");
                            String NID = input.nextLine();
                            Customer cus = emp.search_customer_by_national_id(NID);
                            if (cus == null) {
                                System.out.println("National ID is incorrect");
                            } else {
                                Customer c = emp.search_customer_by_national_id(NID);
                                c.show_all_accounts();
                            }
                        } else if (next_choose.equals("8")) {
                            for (Transaction tr : Transaction.getAll_transactions()) {
                                System.out.println(tr);
                            }
                        } else if (next_choose.equals("9")) {
                            System.out.println("Enter customer national ID:");
                            String NID = input.nextLine();
                            Customer cus = emp.search_customer_by_national_id(NID);
                            if (cus == null) {
                                System.out.println("National ID is incorrect");
                            } else {
                                for (Account acc : cus.getAll_accounts()) {
                                    for (Transaction tr : Transaction.get_account_transaction(acc)) {
                                        System.out.println(tr);
                                    }
                                }
                            }
                        } else if (next_choose.equals("10")) {
                            System.out.println("Enter account ID:");
                            String acc_id = input.nextLine();
                            for (Transaction tr : Transaction.get_account_transaction(Account.get_account_by_id(acc_id))) {
                                System.out.println(tr);
                            }

                        } else if (next_choose.equals("11")) {
                            System.out.println("Enter customer national ID:");
                            String NID = input.nextLine();
                            Customer cus = emp.search_customer_by_national_id(NID);
                            if (cus == null) {
                                System.out.println("National ID is incorrect");
                            } else {
                                System.out.println(cus);
                            }
                        } else if (next_choose.equals("0")) {
                            break employee_menu;
                        }
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
                [8] Show bank transactions
                [9] Show customer's transactions
                [10] Show account's transactions
                [11] Search customer
                
                [0] Exit to main menu
                """;
        System.out.println(menu);
    }
}

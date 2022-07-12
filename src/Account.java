package Bank_AP_Project.src.src;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Account {
    private Customer owner;
    private String owner_id;
    private String account_id;
    private double money = 0;
    private double loan = 0;
    private int time = 12;
    private static ArrayList<Account> all_accounts = new ArrayList<>();

    public Account(Customer owner) // we use this for creating new account
    {
        this.owner = owner;
        this.account_id = id_creator();
        this.owner_id = owner.getNational_id();
        all_accounts.add(this);
    }

    public Account(Customer owner, double money) // we use this for reading data from files
    {
        this.owner = owner;
        this.account_id = id_creator();
        this.owner_id = owner.getNational_id();
        this.money = money;
        if (!(this instanceof Deposit))
            all_accounts.add(this);
    }

    public Account() {

    }

    public void charge_account(double money) {
        if (owner.getInitial_money() < money) {
            System.out.println("Not enough money");
        } else {
            owner.setInitial_money(owner.getInitial_money() - money);
            this.money += money;
            System.out.println("Account with account ID : " + account_id + " Charged successfully");
        }
    }

    private String id_creator() {
        owner.unique_key_plus();
        return owner.getNational_id() + "-" + owner.getUnique_key();
    }

    public static Account get_account_by_id(String account_id) {
        for (Account acc : all_accounts) {
            if (acc.getAccount_id().equals(account_id)) {
                return acc;
            }
        }
        return null;
    }

    public static ArrayList<Account> getAll_accounts() {
        return all_accounts;
    }


    public double getMoney() {
        return money;
    }

    public double getLoan() {
        return loan;
    }

    public static void show_all_accounts() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Account acc : all_accounts) {
            System.out.println(acc);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }

    public Customer getOwner() {
        return owner;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public static Account get_account_by_owner(Customer cus) {
        for (Account acc : all_accounts) {
            if (acc.owner.equals(cus)) {
                return acc;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Account{" +
                "owner=" + owner +
                ", owner_id='" + owner_id + '\'' +
                ", account_id='" + account_id + '\'' +
                ", money=" + money +
                ", loan=" + loan +
                '}';
    }

    public void request_loan(double amount, String national_id) {
        if (loan > 0) {
            System.out.println("you already requested");
        } else {
            loan = amount;
            money += loan;
            Runnable add = () -> {
                if (time > 1) {
                    if (money < ((loan + (loan * 0.2))) / 12) {
                        System.out.println("You'r broke man!");
                        Customer cus = Customer.get_customer_by_national_id(national_id);
                        double wealth = cus.getInitial_money();
                        if (wealth < loan) {
                            System.out.println("I don't know what to do with you!!!!!!!!!!!");
                            time = 0;
                        } else {
                            System.out.println("It will be taken from your initial money !");
                            wealth -= loan;
                            cus.setInitial_money(wealth);
                            time = 0;
                        }

                    } else {
                        money -= (loan + (loan * 0.2)) / 12;
                        time--;
                        System.out.println("Done !");
                    }


                }
            };
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(20);
            executor.scheduleAtFixedRate(add, 30, 30, TimeUnit.DAYS);
        }
    }
}

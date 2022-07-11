package Bank_AP_Project.src.src;

import java.util.ArrayList;

public class Account
{
    private Customer owner;
    private String owner_id;
    private String account_id;
    private double money = 0;
    private double loan  = 0;
    private static int unique_key = 0;
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
        all_accounts.add(this);
    }
    public Account() {

    }

    public void charge_account(Double money)
    {
        if(owner.getInitial_money() < money)
        {
            System.out.println("Not enough money");
        }
        else
        {
            owner.setInitial_money(owner.getInitial_money() - money);
            this.money += money;
            System.out.println("Account with account ID : " + account_id + " Charged successfully");
        }
    }
    private String id_creator()
    {
        unique_key++;
        return owner.getNational_id() + "-" + unique_key;
    }
    public static Account get_account_by_id(String account_id)
    {
        for (Account acc: all_accounts)
        {
            if(acc.getAccount_id().equals(account_id))
            {
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

    public static void show_all_accounts()
    {                   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Account acc: all_accounts)
        {
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
    public static Account get_account_by_owner(Customer cus)
    {
        for (Account acc: all_accounts)
        {
            if (acc.owner.equals(cus))
            {
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
}

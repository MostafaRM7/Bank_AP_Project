package Bank_AP_Project.src.src;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Deposit extends Account
{
    private static final double interest = 1.2;
    private int duration;

    private static ArrayList<Deposit> all_deposits = new ArrayList<>();

    public Deposit(Customer owner, double money, int duration) // we use this for creating new account
    {
        super(owner, money);
        if(owner.getInitial_money() >= money)
        {
            owner.setInitial_money(owner.getInitial_money() - money);
            this.duration = duration;
            all_deposits.add(this);
            this.add_profit();
        }
        else
        {
            System.out.println("Not enough money");
        }
    }
    public Deposit(Customer owner, double money, int duration, String owner_id) // we use this for reading data from files
    {
        super(owner, money);
        this.duration= duration;
        this.add_profit();
        all_deposits.add(this);
    }
    public void add_profit()
    {
        Runnable add = () -> {
            if(duration > 1)
            {
                Deposit.super.setMoney(Deposit.super.getMoney() * Deposit.interest);
                duration--;
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(add, 30, 30, TimeUnit.DAYS);
    }

    public int getDuration() {
        return duration;
    }
    public static void show_all_deposits()
    {   System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Deposit dep: all_deposits)
        {
            System.out.println(dep);
            System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    public static ArrayList<Deposit> getAll_deposits() {
        return all_deposits;
    }
    public static Deposit get_deposit_by_id(String id)
    {
        for (Deposit dep: all_deposits)
        {
            if(dep.getAccount_id().equals(id))
            {
                return dep;
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return "Deposit{" +
                super.toString() +"," +
                "duration=" + duration +
                '}';
    }
    public static Deposit get_deposit_by_owner_id(String id)
    {
        for (Deposit dep: all_deposits)
        {
            if(dep.getOwner_id().equals(id))
            {
                return dep;
            }
        }
        return null;
    }
}


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

    public Deposit(Customer owner, double money, int duration)
    {
        super(owner, money);
        if(owner.getInitial_money() >= money)
        {
            owner.setInitial_money(owner.getInitial_money() - money);
            this.duration = duration;
            all_deposits.add(this);
        }
        else
        {
            System.out.println("Not enough money");
        }

    }
    public void add_profit()
    {
        Runnable add = new Runnable() {
            public void run() {
                if(duration > 0)
                {
                    Deposit.super.setMoney(Deposit.super.getMoney() * Deposit.interest);
                    duration--;
                }
            }
        };
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(add, 0, 30, TimeUnit.DAYS);
    }

    public int getDuration() {
        return duration;
    }

    public static ArrayList<Deposit> getAll_deposits() {
        return all_deposits;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                super.toString() +"," +
                "duration=" + duration +
                '}';
    }
}


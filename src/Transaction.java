package Bank_AP_Project.src.src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class Transaction
{
    private double amount;
    private LocalDateTime date;
    private Account from;
    private Account to;
    private static ArrayList<Transaction> all_transactions = new ArrayList<>();

    public Transaction(double amount, Account from, Account to, LocalDateTime date) // LocalDateTime.now()
    {
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.date = date;
        all_transactions.add(this);
    }
    public void withdraw()
    {
        if(amount > from.getMoney())
        {
            System.out.println("Your account balance is not enough");
        }
        else if (this.from instanceof Deposit || this.to instanceof Deposit)
        {
            Deposit d1 = Deposit.get_deposit_by_owner_id(from.getOwner_id());
            Deposit d2 = Deposit.get_deposit_by_owner_id(to.getOwner_id());
            if(d1.getDuration() == 0 || d2.getDuration() == 0)
            {
                from.setMoney(from.getMoney() - this.amount);
                to.setMoney(to.getMoney() + this.amount);
                System.out.println("Withdraw on deposit account successful");
            }
            else if(d1.getDuration() > 0)
            {
                System.out.println("There is still remaining " + d1.getDuration() + " months from your deposit account");
            }
            else if (d2.getDuration() > 0)
            {
                System.out.println("You destination account cannot do withdrawals");
            }
        }
        else
        {
            from.setMoney(from.getMoney() - amount);
            to.setMoney(to.getMoney() + amount);
            System.out.println("Withdraw on simple account successful");
        }
    }
    public static LocalDateTime str_to_date(String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");
        LocalDateTime date_time = LocalDateTime.parse(date, formatter);
        return date_time;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Account getFrom() {
        return from;
    }

    public Account getTo() {
        return to;
    }

    public static ArrayList<Transaction> get_account_transaction(Account account)
    {
        ArrayList<Transaction> result = new ArrayList<>();
        for (Transaction tr: all_transactions)
        {
            if(tr.getFrom().equals(account) || tr.getTo().equals(account))
            {
                result.add(tr);
            }
        }
        return result;
    }


    public static ArrayList<Transaction> getAll_transactions() {
        return all_transactions;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date=" + date +
                ", from=" + from +
                ", to=" + to +
                '}';
    }

}

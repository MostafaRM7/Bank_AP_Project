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
        if(this.amount > from.getMoney())
        {
            System.out.println("Your account balance is not enough");
        }
        else if (this.from instanceof Deposit)
        {
            Deposit d = (Deposit) from;
            if(d.getDuration() == 0)
            {
                from.setMoney(from.getMoney() - this.amount);
                to.setMoney(to.getMoney() + this.amount);
                System.out.println("Withdraw on deposit account successful");
            }
            else
            {
                System.out.println("There is still remaining"+ d.getDuration() + " months from your deposit");
            }
        }
        else
        {
            from.setMoney(from.getMoney() - this.amount);
            to.setMoney(to.getMoney() + this.amount);
            System.out.println("Withdraw successful");
        }
    }
    public static LocalDateTime str_to_date(String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSSSSS");
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

public class CreditAccount extends Account {
    private long creditLimit;

    public CreditAccount(long creditLimit) {
        this.creditLimit = creditLimit;
    }

    @Override
    boolean add(long amount) {
        if (this.amount + amount > 0) {
            return false;
        }
        this.amount += amount;
        return true;
    }

    @Override
    boolean pay(long amount) {
        if (this.amount - amount < creditLimit) {
            return false;
        }
        this.amount -= amount;
        return true;
    }

    @Override
    boolean transfer(Account account, long amount) {
        if (this.amount - amount > creditLimit && account.add(amount)) {
            return pay(amount);
        }
        return false;
    }
}

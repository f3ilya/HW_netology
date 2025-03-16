public class SimpleAccount extends Account {

    @Override
    boolean add(long amount) {
        if (amount <= 0) {
            return false;
        }
        this.amount += amount;
        return true;
    }

    @Override
    boolean pay(long amount) {
        if (amount > this.amount) {
            return false;
        }
        this.amount -= amount;
        return true;
    }

    @Override
    boolean transfer(Account account, long amount) {
        if (amount < this.amount && account.add(amount)) {
            return pay(amount);
        }
        return false;
    }
}

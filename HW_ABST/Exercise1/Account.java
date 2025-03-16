public abstract class Account {

    protected long amount;

    abstract boolean add(long amount);

    abstract boolean pay(long amount);

    abstract boolean transfer(Account account, long amount);

    long getBalance() {
        return amount;
    }
}

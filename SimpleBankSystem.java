class Bank {
    long[] balance = null;
    int n = -1;
    public Bank(long[] balance) {
        this.balance = balance;
        n = balance.length;
    }
    
    public boolean transfer(int acc1, int acc2, long money) {
        if(acc1 - 1 >= n || acc2 - 1 >= n || balance[acc1 - 1] < money) return false;
        balance[acc1 - 1] -= money;
        balance[acc2 - 1] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(account - 1 >= n) return false;
        balance[account - 1] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(account - 1 >= n || balance[account - 1] < money) return false;
        balance[account - 1] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */

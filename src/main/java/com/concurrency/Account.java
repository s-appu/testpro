package com.concurrency;

public class Account {

    public int total;

    public boolean debit( final int amount ) {
        if ( this.total < amount ) {
            return false;
        }
        this.total = this.total - amount;
        return true;
    }

    public void credit( final int amount ) {
        this.total = this.total + amount;
    }

}

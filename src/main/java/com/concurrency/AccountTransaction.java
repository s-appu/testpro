package com.concurrency;

public class AccountTransaction {

    Object aLock = new Object();
    Object bLock = new Object();

    public void transact( final Account incoming, final Account outgoing, final int amount ) {
        synchronized ( this.aLock ) {
            if ( incoming.debit( amount ) ) {
                incoming.credit( amount );
            }
        }
    }

    public void debitAccount( final Account incoming, final int amount ) {
        synchronized ( this.bLock ) {
            if ( incoming.debit( amount ) ) {
                System.out.println( "" );
            } else {

            }
        }
    }

}

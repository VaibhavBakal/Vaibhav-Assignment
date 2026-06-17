//Task 1
package Task1;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoanAccount {

    private Date dueDate;
    private double outstandingBalance;
    private String accountId;

    public LoanAccount(Date dueDate, double outstandingBalance, String accountId) {
        this.dueDate = dueDate;
        this.outstandingBalance = outstandingBalance;
        this.accountId = accountId;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public String getAccountId() {
        return accountId;
    }

    public static List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {

        // FIX: Initialize result list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Handle null input list
        if (accounts == null) {
            return result;
        }

        Date today = new Date();

        for (LoanAccount account : accounts) {

            // FIX: Skip null account objects
            if (account == null) {
                continue;
            }

            // FIX: dueDate may be null for restructured accounts
            if (account.getDueDate() != null
                    && account.getDueDate().before(today)) {

                // FIX: Only overdue accounts with positive balance
                if (account.getOutstandingBalance() > 0) {
                    result.add(account);
                }
            }
        }

        return result;
    }
}
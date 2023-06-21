package AccountComparisonPackage;

public class AccountComparison implements OnlineAccount, Comparable<AccountComparison> {
    private String ownerName;
    private int noOfRegularMovies;
    private int noOfExclusiveMovies;

    public AccountComparison(String ownerName, int noOfRegularMovies, int noOfExclusiveMovies) {
        this.ownerName = ownerName;
        this.noOfRegularMovies = noOfRegularMovies;
        this.noOfExclusiveMovies = noOfExclusiveMovies;
    }

    @Override
    public int monthlyCost() {
        return getBasePrice() + (noOfRegularMovies * getRegularMoviePrice()) +
                (noOfExclusiveMovies * getExclusiveMoviePrice());
    }

    @Override
    public int compareTo(AccountComparison otherAccount) {
        return this.monthlyCost() - otherAccount.monthlyCost();
    }

    @Override
    public String toString() {
        return "Owner is " + ownerName + " and monthly cost is " + monthlyCost() + " USD.";
    }

    // Implement the methods from the OnlineAccount interface
    @Override
    public int getBasePrice() {
        return 10;
    }

    @Override
    public int getRegularMoviePrice() {
        return 2;
    }

    @Override
    public int getExclusiveMoviePrice() {
        return 4;
    }
}

package fileio;

public final class User {
    private String name;
    private String password;
    private String accountType;
    private String country;
    private String balance;

    public User(final User a) {
        this.setName(a.getName());
        this.setPassword(a.getPassword());
        this.setCountry(a.getCountry());
        this.setBalance(a.getBalance());
        this.setAccountType(a.getAccountType());
    }

    public User() {
        this.setName(null);
        this.setPassword(null);
        this.setCountry(null);
        this.setBalance(null);
        this.setAccountType(null);
    }

//   "name": "Eduard",
    //        "password": "secret",
    //        "accountType": "standard",
    //        "country": "Romania",
    //        "balance": "50"

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(final String accountType) {
        this.accountType = accountType;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(final String balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "user{"
                +
                "name='"
                + name
                + '\''
                +
                ", password='"
                + password
                + '\''
                +
                ", accountType='"
                + accountType
                + '\''
                +
                ", country='"
                + country
                + '\''
                +
                ", balance='"
                + balance
                + '\''
                +
                '}';
    }
}

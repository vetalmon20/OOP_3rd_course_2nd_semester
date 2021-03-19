package app.model.user;

public class User {
    private Long id;
    private Long money;
    private String name;
    private String email;
    private String pass;
    private Boolean isAdmin;

    public User(Long id, Long money, String name, String email, String pass, Boolean isAdmin) {
        this.id = id;
        this.money = money;
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.isAdmin = isAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}

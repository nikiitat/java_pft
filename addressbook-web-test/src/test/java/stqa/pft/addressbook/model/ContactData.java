package stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String company;
    private final String homePhone;
    private final String email;
    private String group;

    public ContactData(String firstName, String lastName, String company, String homePhone, String email, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.company = company;
        this.homePhone = homePhone;
        this.email = email;
        this.group = group;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompany() {
        return company;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public String getEmail() {
        return email;
    }

    public String getGroup() {
        return group;
    }
}

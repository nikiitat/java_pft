package stqa.pft.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private int id;
    private final String company;
    private final String homePhone;
    private final String email;
    private String group;

    public ContactData(String firstName, String lastName, int id, String company, String homePhone, String email, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.company = company;
        this.homePhone = homePhone;
        this.email = email;
        this.group = group;
    }

    public ContactData(String firstName, String lastName, String company, String homePhone, String email, String group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = 0;
        this.company = company;
        this.homePhone = homePhone;
        this.email = email;
        this.group = group;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactData that = (ContactData) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + id;
        return result;
    }
}

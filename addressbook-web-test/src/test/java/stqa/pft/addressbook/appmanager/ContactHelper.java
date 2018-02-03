package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;

import java.util.List;

/**
 * Created by nikitatertytskyi on 02.01.18.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }

    public void submitNewContact() {
        click(By.xpath("//div[@id='content']/form/input[21]"));
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void fillNewContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        type(By.name("company"), contactData.getCompany());
        type(By.name("home"), contactData.getHomePhone());
        type(By.name("email"), contactData.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
//            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void addNewContact() {
        click(By.linkText("add new"));
    }

    public void create(ContactData contactData, boolean condition) {
        addNewContact();
        fillNewContactForm(contactData, condition);
        submitNewContact();
        returnToHomePage();
    }

    public void modify(ContactData contact, boolean condition) {
        fillNewContactForm(contact, condition);
        updateContact();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("#maintable tr"));
        for (int i = 1; i < elements.size(); i++) {
            String lastName = elements.get(i).findElement(By.cssSelector("td:nth-child(2)")).getText();
            String name = elements.get(i).findElement(By.cssSelector("td:nth-child(3)")).getText();
            String[] phones = elements.get(i).findElement(By.cssSelector("td:nth-child(6)")).getText().split("\n");
            int id = Integer.parseInt(elements.get(i).findElement(By.tagName("input")).getAttribute("value"));
            ContactData contact = new ContactData().withFirstName(name).withLastName(lastName)
                    .withId(id).withCompany(null).withGroup(null).withEmail(null)
                    .withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2]);
            contacts.add(contact);
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        wd.navigate().back();
        return new ContactData().withFirstName(firstName).withLastName(lastName)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);
    }
}

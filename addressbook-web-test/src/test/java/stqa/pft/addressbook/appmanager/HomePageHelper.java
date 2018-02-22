package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import stqa.pft.addressbook.model.ContactData;

/**
 * Created by nikitatertytskyi on 03.01.18.
 */
public class HomePageHelper extends HelperBase {
    public HomePageHelper(WebDriver wd) {
        super(wd);
    }


    public void delete(ContactData deleteContact) {
        selectContactById(deleteContact.getId());
        deleteSelectedContact();
        confirmDeletion();
        returnToHomePage();
    }

    public void addContactToGroupById(int contactId, int groupId) {
        selectContactById(contactId);
        selectGroupTo(groupId);
        addToGroup();
    }

    public void removeContactFromGroupById(int contactId, int groupId) {
        selectGroup(groupId);
        selectContactById(contactId);
        removeFromGroup();
        returnToHomePage();
    }

    private void removeFromGroup() {
        click(By.name("remove"));
    }

    private void selectGroup(int groupId) {
        new Select(wd.findElement(By.name("group")))
                .selectByValue(String.valueOf(groupId));
    }

    public void selectContactById(int id) {
        click(By.cssSelector("input[id='" + id + "']"));
    }

    public void deleteSelectedContact() {
        click(By.cssSelector("[value=\"Delete\"]"));
    }

    public void confirmDeletion() {
        confirm();
    }

    public void editContactById(int id) {
        click(By.cssSelector("a[href*='edit.php?id=" + id + "']"));
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void selectGroupTo(int groupId) {
        new Select(wd.findElement(By.name("to_group")))
                .selectByValue(String.valueOf(groupId));
    }

    public void addToGroup() {
        click(By.name("add"));
    }
}

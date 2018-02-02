package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
    }

    public void deleteSelectedContact() {
        click(By.cssSelector("[value=\"Delete\"]"));
    }

    public void confirmDeletion() {
        confirm();
    }

    public void editContactById(int id) {
        wd.findElement(By.cssSelector("a[href*='edit.php?id=" + id + "']")).click();
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }
}

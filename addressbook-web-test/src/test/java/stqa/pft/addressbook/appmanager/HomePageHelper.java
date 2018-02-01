package stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by nikitatertytskyi on 03.01.18.
 */
public class HomePageHelper extends HelperBase {
    public HomePageHelper(WebDriver wd) {
        super(wd);
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void deleteSelectedContact() {
        click(By.cssSelector("[value=\"Delete\"]"));
    }

    public void confirmDeletion() {
        confirm();
    }

    public void editContact(int index) {
        wd.findElements(By.cssSelector("table [title=\"Edit\"]")).get(index).click();
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }
}

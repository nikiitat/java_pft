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

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteSelectedContact() {
        click(By.cssSelector("[value=\"Delete\"]"));
    }

    public void confirmDeletion() {
        confirm();
    }

    public void editContact() {
        click(By.cssSelector("table [title=\"Edit\"]"));
    }

    public void updateContact() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
    }
}

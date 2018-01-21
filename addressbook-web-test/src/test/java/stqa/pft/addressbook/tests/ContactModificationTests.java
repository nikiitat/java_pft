package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

/**
 * Created by nikitatertytskyi on 04.01.18.
 */
public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getNavigationHelper().gotoHomePage();
        app.getHomePageHelper().editContact();
        app.getContactHelper().fillNewContactForm(new ContactData("Jimmy", "James", "James",
                "-", "james@james.com", null), false);
        app.getHomePageHelper().updateContact();
        app.getHomePageHelper().returnToHomePage();
    }
}
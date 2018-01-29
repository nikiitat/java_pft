package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

/**
 * Created by nikitatertytskyi on 03.01.18.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test123", "Tester", "book",
                    "+123456789", "test@test.com", "tratata"), true);
        }
        app.getHomePageHelper().selectContact();
        app.getHomePageHelper().deleteSelectedContact();
        app.getHomePageHelper().confirmDeletion();
        app.getNavigationHelper().gotoHomePage();
    }
}

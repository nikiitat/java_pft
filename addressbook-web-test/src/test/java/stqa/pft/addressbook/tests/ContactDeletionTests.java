package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import java.util.List;

/**
 * Created by nikitatertytskyi on 03.01.18.
 */
public class ContactDeletionTests extends TestBase {

    @Test(enabled = false)
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test123", "Tester", "book",
                    "+123456789", "test@test.com", "tratata"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getHomePageHelper().selectContact(0);
        app.getHomePageHelper().deleteSelectedContact();
        app.getHomePageHelper().confirmDeletion();
        app.getNavigationHelper().gotoHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(0);
        Assert.assertEquals(before, after);
    }
}

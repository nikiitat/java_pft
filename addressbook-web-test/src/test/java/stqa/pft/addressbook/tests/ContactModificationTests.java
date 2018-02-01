package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

/**
 * Created by nikitatertytskyi on 04.01.18.
 */
public class ContactModificationTests extends TestBase {

    @Test(enabled = false)
    public void testContactModification() {
        app.goTo().gotoHomePage();
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Test123", "Tester", "book",
                    "+123456789", "test@test.com", "tratata"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        app.getHomePageHelper().editContact(0);
        ContactData contact = new ContactData("Jimmy", "James", before.get(0).getId(), "James",
                "-", "james@james.com", null);
        app.getContactHelper().fillNewContactForm(contact, false);
        app.getHomePageHelper().updateContact();
        app.getHomePageHelper().returnToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size());

        before.remove(0);
        before.add(contact);
        Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);

        Assert.assertEquals(after, before);
    }
}

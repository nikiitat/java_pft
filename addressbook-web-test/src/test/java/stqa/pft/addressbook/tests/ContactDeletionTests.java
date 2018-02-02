package stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by nikitatertytskyi on 03.01.18.
 */
public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Test123").withLastName("Tester").withCompany("book")
                    .withHomePhone("+123456789").withEmail("test@test.com").withGroup(null), true);
        }
    }

    @Test(enabled = true)
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deleteContact = before.iterator().next();
        app.home().delete(deleteContact);
        Contacts after = app.contact().all();

        assertEquals(after.size(), before.size() - 1);
        assertThat(after, equalTo(before.without(deleteContact)));
    }
}

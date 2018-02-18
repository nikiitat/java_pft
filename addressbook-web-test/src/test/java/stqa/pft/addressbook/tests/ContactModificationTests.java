package stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

/**
 * Created by nikitatertytskyi on 04.01.18.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.db().contatcs().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Test123").withLastName("Tester").withCompany("book")
                    .withHomePhone("+123456789").withEmail("test@test.com").withGroup(null), true);
        }
    }

    @Test(enabled = true)
    public void testContactModification() {
        Contacts before = app.db().contatcs();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withFirstName("Jimmy").withLastName("James").withId(modifiedContact.getId())
                .withCompany("James").withHomePhone("-").withEmail("james@james.com").withGroup(null);

        app.home().editContactById(modifiedContact.getId());
        app.contact().modify(contact, false);

        assertEquals(app.contact().getContactCount(), before.size());
        Contacts after = app.db().contatcs();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}

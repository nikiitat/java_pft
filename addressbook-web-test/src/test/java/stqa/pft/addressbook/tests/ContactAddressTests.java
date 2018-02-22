package stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nikitatertytskyi on 03.02.2018.
 */
public class ContactAddressTests extends TestBase {
    @BeforeMethod
    public void ensureContactExist() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Phone").withLastName("Guy")
                    .withAddress("asdas"), false);
        }
    }

    @Test
    public void testContactAddresses() {
        ContactData contact = app.contact().all().iterator().next();
        app.home().editContactById(contact.getId());
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(contactInfoFromEditForm.getAddress()));
    }
}

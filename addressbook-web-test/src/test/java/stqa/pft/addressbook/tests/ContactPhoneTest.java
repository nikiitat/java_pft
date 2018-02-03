package stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nikitatertytskyi on 02.02.2018.
 */
public class ContactPhoneTest extends TestBase {

    @BeforeMethod
    public void ensureContactExist() {
        app.goTo().homePage();
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstName("Phone").withLastName("Guy")
                    .withHomePhone("098").withMobilePhone("777").withWorkPhone("444"), false);
        }
    }

    @Test
    public void testContactPhones() {
        app.goTo().homePage();
        ContactData contact = app.contact().all().iterator().next();
        app.home().editContactById(contact.getId());
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getHomePhone(), equalTo(cleaned(contactInfoFromEditForm.getHomePhone())));
        assertThat(contact.getMobilePhone(), equalTo(cleaned(contactInfoFromEditForm.getMobilePhone())));
        assertThat(contact.getWorkPhone(), equalTo(cleaned(contactInfoFromEditForm.getWorkPhone())));
    }

    public String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}

package stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.GroupData;

/**
 * Created by nikitatertytskyi on 18.02.2018.
 */
public class AddContactToGroupTests extends TestBase {
    @BeforeMethod
    public void checkIfContactAndGroupExist() {
        app.goTo().homePage();
        if (app.db().contatcs().size() == 0) {
            app.contact().create(new ContactData().withFirstName("TestNew").withLastName("TestNew").withCompany("book")
                    .withHomePhone("+123456789").withEmail("test@test.com").inGroup(null), false);
        }
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName("testGroup"));
        }
    }

    @Test
    public void testAddContactToGroup() {
        app.goTo().homePage();
        ContactData contact = app.db().contatcs().iterator().next();
        GroupData group = app.db().groups().iterator().next();
        app.home().addContactToGroup(contact, group);
    }
}

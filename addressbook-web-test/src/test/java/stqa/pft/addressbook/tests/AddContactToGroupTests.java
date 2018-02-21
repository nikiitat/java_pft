package stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;
import stqa.pft.addressbook.model.GroupData;

/**
 * Created by nikitatertytskyi on 18.02.2018.
 */
public class AddContactToGroupTests extends TestBase {
    @BeforeMethod
    public void checkIfContactAndGroupExist() {
        app.goTo().homePage();
        if (app.db().contacts().size() == 0) {
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
        Contacts contact = app.db().contacts();
        GroupData group = app.db().groups().iterator().next();
//        app.home().addContactToGroup(contact, group);

//        ContactData f = app.db().contacts().stream().filter((c) -> Objects.equals(c, contact)).findFirst().get();
//        f.getGroups().iterator().next().getName();
//        assertThat(group.getName(), equalTo(app.db().contacts()
//                .stream().filter((c) -> Objects.equals(c, contact))
//                .findFirst()
//                .get()
//                .getGroups().iterator().next().getName()));


    }
}

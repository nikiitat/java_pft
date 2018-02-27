package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;
import stqa.pft.addressbook.model.GroupData;
import stqa.pft.addressbook.model.Groups;

import java.util.NoSuchElementException;

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
        int[] Ids = getUnusedGroupIdAlongWithContact();
        Assert.assertFalse(app.db().contacts().stream().filter((c) -> c.getId() == Ids[1]).findFirst().get()
                        .getGroups().stream().anyMatch((s) -> s.getId() == Ids[0]),
                String.format("Contact with Id: %s has group with Id: %s", Ids[1], Ids[0]));
        app.home().addContactToGroupById(Ids[1], Ids[0]);

        Assert.assertTrue(app.db().contacts().stream().filter((c) -> c.getId() == Ids[1]).findFirst().get()
                        .getGroups().stream().anyMatch((s) -> s.getId() == Ids[0]),
                String.format("Contact with Id: %s does not have group with Id: %s", Ids[1], Ids[0]));
    }

    private static int[] getUnusedGroupIdAlongWithContact() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();

        for (ContactData c : contacts) {
            for (GroupData d : groups) {
                try {
                    if (c.getGroups().stream().noneMatch((s) -> s.getId() == d.getId())) {
                        return new int[]{d.getId(), c.getId()};
                    }
                } catch (NoSuchElementException ex) {
                }
            }
        }
        app.goTo().groupPage();
        app.group().create(new GroupData().withName("testGroup"));
        app.goTo().homePage();
        return new int[]{app.db().groups().stream().mapToInt((g) -> g.getId()).max().getAsInt(), contacts.iterator().next().getId()};
    }
}

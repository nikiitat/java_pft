package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;
import stqa.pft.addressbook.model.GroupData;
import stqa.pft.addressbook.model.Groups;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by nikitatertytskyi on 22.02.2018.
 */
public class DeleteContactFromGroupTest extends TestBase {
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
    public void testDeleteContactFromGroup() {
        app.goTo().homePage();
        int[] Ids = getContactWithGroup();
        Groups before = app.db().contacts().stream().filter((c) -> c.getId() == Ids[0]).findFirst().get()
                .getGroups();

        Assert.assertTrue(app.db().contacts().stream().filter((c) -> c.getId() == Ids[0]).findFirst().get()
                        .getGroups().stream().anyMatch((s) -> s.getId() == Ids[1]),
                String.format("Contact with Id: %s does not have a group with Id: %s", Ids[0], Ids[1]));
        app.home().removeContactFromGroupById(Ids[0], Ids[1]);

        Assert.assertFalse(app.db().contacts().stream().filter((c) -> c.getId() == Ids[0]).findFirst().get()
                        .getGroups().stream().anyMatch((s) -> s.getId() == Ids[1]),
                String.format("Contact with Id: %s has group with Id: %s", Ids[0], Ids[1]));

        Groups after = app.db().contacts().stream().filter((c) -> c.getId() == Ids[0]).findFirst().get().getGroups();
        assertThat(after, equalTo(
                before.without(app.db().groups().stream().filter((g) -> g.getId() == Ids[1]).findFirst().get())));
    }

    private int[] getContactWithGroup() {
        Contacts contacts = app.db().contacts();
        Groups groups = app.db().groups();

        for (ContactData c : contacts) {
            for (GroupData g : groups) {
                try {
                    if (c.getGroups().stream().anyMatch((s) -> s.getId() == g.getId())) {
                        return new int[]{c.getId(), g.getId()};
                    }
                } catch (NoSuchElementException ex) {
                }
            }
        }
        app.contact().create(new ContactData().withFirstName("TestNew").withLastName("TestNew").withCompany("book")
                .withHomePhone("+123456789").withEmail("test@test.com").inGroup(groups.iterator().next()), true);
        return new int[]{app.db().contacts().stream().mapToInt((g) -> g.getId()).max().getAsInt(), groups.iterator().next().getId()};
    }
}

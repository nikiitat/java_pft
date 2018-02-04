package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;
import stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test(enabled = true)
    public void testContactCreation() {
        Contacts before = app.contact().all();
        File photo = new File("src/test/resources/dog.png");
        ContactData contact = new ContactData()
                .withFirstName("Test123").withLastName("Tester").withCompany("Test store").withHomePhone("+123456789")
                .withEmail("test@test.com").withPhoto(photo);
        app.contact().create(contact, false);
        Contacts after = app.contact().all();

        assertThat(after.size(), equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

    @Test
    public void testCurrentDir() {
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/dog.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.isDirectory() + "=" + photo.isFile());

    }
}

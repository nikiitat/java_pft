package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNewContact();
        app.getContactHelper().fillNewContactForm(new ContactData("Test123", "Tester", "book",
                "+123456789", "test@test.com", "test1"), true);
        app.getContactHelper().submitNewContact();
        app.getContactHelper().returnToHomePage();
    }
}

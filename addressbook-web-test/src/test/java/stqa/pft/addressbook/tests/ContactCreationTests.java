package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{
    
    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoAddNewContact();
        app.getContactHelper().fillNewContactForm(new ContactData("Test", "Tester", "book", "+123456789", "test@test.com"));
        app.getContactHelper().submitNewContact();
        app.getContactHelper().returnToHomePage();
    }
}

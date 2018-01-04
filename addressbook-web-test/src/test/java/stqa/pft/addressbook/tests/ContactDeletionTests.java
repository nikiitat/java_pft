package stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by nikitatertytskyi on 03.01.18.
 */
public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        app.getHomePageHelper().selectContact();
        app.getHomePageHelper().deleteSelectedContact();
        app.getHomePageHelper().confirmDeletion();
        app.getNavigationHelper().gotoHomePage();
    }
}

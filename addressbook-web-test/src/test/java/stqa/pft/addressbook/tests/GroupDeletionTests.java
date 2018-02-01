package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupDeletion() {
        Set<GroupData> before = app.group().all();
        GroupData groupDeleted = before.iterator().next();
        app.group().delete(groupDeleted);
        Set<GroupData> after = app.group().all();

        Assert.assertEquals(after.size(), before.size() - 1);
        before.remove(groupDeleted);
        Assert.assertEquals(before, after);
    }
}

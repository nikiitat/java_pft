package stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import stqa.pft.addressbook.model.GroupData;

import java.util.Set;

/**
 * Created by nikitatertytskyi on 03.01.18.
 */
public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification() {
        Set<GroupData> before = app.group().all();
        GroupData groupModified = before.iterator().next();
        GroupData group = new GroupData()
                .withId(groupModified.getId()).withName("test1").withHeader("tratata").withFooter("tratata");
        app.group().modify(group);
        Set<GroupData> after = app.group().all();

        Assert.assertEquals(after.size(), before.size());

        before.remove(groupModified);
        before.add(group);
        Assert.assertEquals(before, after);
    }
}

package stqa.pft.mantis.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import stqa.pft.mantis.model.Issue;
import stqa.pft.mantis.model.Project;

import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Set;

/**
 * Created by nikitatertytskyi on 03.03.2018.
 */
public class SoapTests extends TestBase {

    @Test
    public void testGetProjects() throws MalformedURLException, ServiceException, RemoteException {
        Set<Project> projects = app.soapHelper().getProject();
        System.out.println(projects.size());
        for (Project data : projects) {
            System.out.println(data.getName());
        }
    }

    @Test
    public void testCreateIssue() throws RemoteException, ServiceException, MalformedURLException {
        Set<Project> projects = app.soapHelper().getProject();
        Issue issue = new Issue()
                .withSummary("Test Issue").withDescription("Some Text").withProject(projects.iterator().next());
        Issue created = app.soapHelper().addIssue(issue);
        Assert.assertEquals(issue.getSummary(), created.getSummary());
    }

    @Test
    public void testIssue() throws Exception {
        skipIfNotFixed(2);
        System.out.println(app.soapHelper().getIssueStatusById(1));
    }
}

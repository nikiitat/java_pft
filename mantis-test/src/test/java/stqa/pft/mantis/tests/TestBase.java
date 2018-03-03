package stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import stqa.pft.mantis.appmanager.ApplicationManager;

import javax.xml.rpc.ServiceException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;

/**
 * Created by nikitatertytskyi on 28.12.17.
 */
public class TestBase {

    protected static final ApplicationManager app =
            new ApplicationManager(System.getProperty("browser", BrowserType.FIREFOX));

    @BeforeSuite
    public void setUp() throws Exception {
        app.init();
        app.ftpHelper().upload(new File("src/test/resources/config_inc.php"), "mantisbt-1.2.19/config_inc.php", "mantisbt-1.2.19/config_inc.php.bak");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() throws IOException {
        app.ftpHelper().restore("mantisbt-1.2.19/config_inc.php.bak", "mantisbt-1.2.19/config_inc.php");
        app.stop();
    }

    boolean isIssueOpen(int issueId) throws MalformedURLException, ServiceException, RemoteException {
        String statusById = app.soapHelper().getIssueStatusById(issueId);
        if (statusById.equals("closed")) {
            return true;
        }
        System.out.println("not fixed");
        return false;
    }

    public void skipIfNotFixed(int issueId) throws Exception {
        if (!isIssueOpen(issueId)) {
            throw new Exception("Test skipped because of issue " + issueId);
        }
    }

}

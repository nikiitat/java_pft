package stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import stqa.pft.mantis.appmanager.ApplicationManager;

import java.io.File;
import java.io.IOException;

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

}

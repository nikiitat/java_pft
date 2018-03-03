package stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * Created by nikitatertytskyi on 28.12.17.
 */
public class ApplicationManager {
    private final Properties properties;
    private WebDriver wd;

    private String browser;
    private RegistrationHelper registrationHelper;
    private FtpHelper ftpHelper;
    private MailHelper mailHelper;
    private JamesHelper jamesHelper;
    private LoginHelper loginHelper;
    private DbMantisHelper dbMantisHelper;
    private SoapHelper soapHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("targer", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    }

    public void stop() {
        if (wd != null) {
            wd.quit();
        }
    }

    public HttpSession newSession() {
        return new HttpSession(this);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public RegistrationHelper registration() {
        if (registrationHelper == null) {
            registrationHelper = new RegistrationHelper(this);
        }
        return registrationHelper;
    }

    public LoginHelper loginHelper() {
        if (loginHelper == null) {
            loginHelper = new LoginHelper(this);
        }
        return loginHelper;
    }

    public FtpHelper ftpHelper() {
        if (ftpHelper == null) {
            ftpHelper = new FtpHelper(this);
        }
        return ftpHelper;
    }

    public MailHelper mailHelper() {
        if (mailHelper == null) {
            mailHelper = new MailHelper(this);
        }
        return mailHelper;
    }

    public JamesHelper jamesHelper() {
        if (jamesHelper == null) {
            jamesHelper = new JamesHelper(this);
        }
        return jamesHelper;
    }

    public DbMantisHelper dbMantisHelper() {
        if (dbMantisHelper == null) {
            dbMantisHelper = new DbMantisHelper(this);
        }
        return dbMantisHelper;
    }

    public SoapHelper soapHelper() {
        if (soapHelper == null) {
            soapHelper = new SoapHelper(this);
        }
        return soapHelper;
    }

    public WebDriver getDriver() {
        if (wd == null) {
            if (browser.equals(BrowserType.FIREFOX)) {
                System.setProperty(properties.getProperty("driver.firefox"), properties.getProperty("firefox2"));
                wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
            } else if (browser.equals(BrowserType.CHROME)) {
                wd = new ChromeDriver();
            } else if (browser.equals(BrowserType.SAFARI)) {
                wd = new SafariDriver();
            }

            wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            wd.get(properties.getProperty("web.baseUrl"));
        }
        return wd;
    }
}

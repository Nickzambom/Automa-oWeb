package runners;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.page.PageMobileDialer;
import org.driverManager.DriverManager;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CN002_MobileTest {

    private AndroidDriver driver;
    DriverManager driverManager = new DriverManager();
    private static final String appPackage = "com.google.android.dialer";
    private static final String appActivity = ".extensions.GoogleDialtactsActivity";

    @BeforeAll
    public void setUp() throws IOException {
        AndroidDriver driver = driverManager.initializeDriver("myDevice", driverManager.getUdid(), appPackage, appActivity);
        if (driver == null) {
            throw new RuntimeException("Falha na inicialização do driver.");
        }
        this.driver = driver;  // Garantindo que o driver foi corretamente inicializado
    }


    @AfterAll
    public void tearDown() {
        driverManager.quitDriver();
    }

    @Test
    @DisplayName("Cadastrar dados no forms mobile")
    public void CT01() {
        new PageMobileDialer(driver).ClickInDialPad();
    }

}

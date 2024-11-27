package runners;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.pageMobile.PageMobileDialer;
import org.driverManager.DriverManager;

import java.io.IOException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CN003_MobileTestChrome {

    private AndroidDriver driver;
    DriverManager driverManager = new DriverManager();
    private static final String appActivity = "com.google.android.apps.chrome.Main";
    private static final String appPackage = "com.android.chrome";

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
    @DisplayName("Abrir chrome")
    public void CT01() {
    //
    }

}

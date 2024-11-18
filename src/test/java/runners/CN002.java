package runners;

import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.page.PageMobileDialer;

import java.net.URL;
import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CN002 {

    private AndroidDriver driver;
    private static final String appPackage = "com.google.android.dialer";
    private static final String appActivity = ".extensions.GoogleDialtactsActivity";

    @BeforeAll
    public void setUp() {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "MeuDispositivo"); // Altere para o nome do dispositivo
            capabilities.setCapability("udid", "0047115091"); // Altere para o UDID do dispositivo
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("automationName", "UiAutomator2");

            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // Timeout para encontrar elementos

            System.out.println("Driver iniciado com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao inicializar o AndroidDriver: " + e.getMessage());
        }
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Driver encerrado com sucesso!");
        }
    }

    @Test
    @DisplayName("Cadastrar dados no forms mobile")
    public void CT01() {
        new PageMobileDialer(driver).ClickInDialPad();
    }

}

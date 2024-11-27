package runners;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pageWeb.PageCadastrar;
import org.pageWeb.PageRead;

import java.time.Duration;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CN001_BrowserDesktopTest {

    private WebDriver driver;
    private static final String url = "http://localhost:8080/Faculdade/index.html";

    @BeforeAll
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C://chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(20000)); // Ajuste o timeout, se necessário
    }

    @AfterAll
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Cadastrar dados no forms")
    public void CT01() {
        driver.get(url);
        new PageCadastrar(driver).inserirDados();
    }
    @Test
    @DisplayName("Validar cadastro")
    public void CT02(){
        driver.get(url);
        new PageRead(driver).validarCadastro();
    }
}

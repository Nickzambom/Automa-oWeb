package org.driverManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private AndroidDriver mobileDriver;


    public AndroidDriver initializeDriver(String deviceName, String udid, String appPackage, String appActivity) {
        try {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", deviceName);
            capabilities.setCapability("udid", udid);
            capabilities.setCapability("appPackage", appPackage);
            capabilities.setCapability("appActivity", appActivity);
            capabilities.setCapability("automationName", "UiAutomator2");

            System.out.println("Iniciando o AndroidDriver...");
            mobileDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            System.out.println("Driver iniciado com sucesso!");
            return mobileDriver;

        } catch (Exception e) {
            System.err.println("Erro ao inicializar o AndroidDriver: " + e.getMessage());
            e.printStackTrace(); // Imprime a stack trace completa para mais detalhes
            return null;
        }
    }


    public String getUdid() throws IOException {
        Process process = Runtime.getRuntime().exec("adb devices");
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String udid = "";

        String line;
        boolean foundDevice = false;

        while ((line = reader.readLine()) != null) {
            // Ignora as linhas de cabeçalho
            if (line.contains("List of devices attached")) {
                continue;
            }

            // Processa a linha contendo o UDID
            if (line.trim().length() > 0 && !line.contains("unauthorized") && !line.contains("offline")) {
                udid = line.split("\\s+")[0]; // Pega o primeiro elemento da linha (UDID)
                System.out.println("UDID do dispositivo conectado: " + udid);
                foundDevice = true;
                break; // Para após encontrar o primeiro dispositivo
            }
        }
        if (!foundDevice) {
            System.out.println("Nenhum dispositivo conectado encontrado.");
        }
        reader.close();
        return udid;
    }

    public void quitDriver() {
        if (mobileDriver != null) {
            mobileDriver.quit();
            System.out.println("Driver encerrado com sucesso!");
        }
    }

    public AndroidDriver getMobileDriver() {
        if (mobileDriver == null) {
            throw new RuntimeException("O AndroidDriver não foi inicializado.");
        }
        return mobileDriver;
    }

    public AndroidDriver setMobileDriver(AndroidDriver mobileDriver) {
        return this.mobileDriver = mobileDriver;
    }
}

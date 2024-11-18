package org.statements;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

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

            mobileDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            System.out.println("Driver iniciado com sucesso!");
            return mobileDriver;

        } catch (Exception e) {
            System.err.println("Erro ao inicializar o AndroidDriver: " + e.getMessage());
            return null;
        }
    }

    public void quitDriver() {
        if (mobileDriver != null) {
            mobileDriver.quit();
            System.out.println("Driver encerrado com sucesso!");
        }
    }

    public AndroidDriver getMobileDriver() {
        return mobileDriver;
    }

    public AndroidDriver setMobileDriver(AndroidDriver mobileDriver) {
        return this.mobileDriver = mobileDriver;
    }
}

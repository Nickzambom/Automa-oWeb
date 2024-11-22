package org.statements;

import io.appium.java_client.android.AndroidDriver;

public class StatementsMobile {
    private AndroidDriver mobileDriver;

    public StatementsMobile(AndroidDriver driver) {
        this.mobileDriver = driver;
    }

    public void openUrl(String url) {
        try {
            System.out.println("Abrindo URL: " + url);
            mobileDriver.get(url);
        } catch (Exception e) {
            System.err.println("Erro ao abrir a URL: " + e.getMessage());
        }
    }
}

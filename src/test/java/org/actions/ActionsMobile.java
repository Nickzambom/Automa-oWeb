package org.actions;

import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.driverManager.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;

public interface ActionsMobile {

    default AndroidDriver getDriver() {
        return new DriverManager().getMobileDriver();
    }

    // Método para validar se o elemento está visível e habilitado com espera explícita
    default boolean validateObject(WebElement element) {

        try {
            snapShot();
            if (element.isEnabled()) {
                return element.isEnabled();
            } else {
                throw new IllegalStateException("Erro ao validar o objeto");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao validar o objeto: " + e.getMessage(), e);
        }
    }

    // Método para inserir texto em um campo
    default void setText(WebElement element, String text) {
        try {
            snapShot();
            if (element.isEnabled()) {
                element.clear(); // Limpa o campo antes de inserir texto
                element.sendKeys(text); // Insere o texto
            } else {
                throw new IllegalStateException("O elemento não está habilitado para receber texto.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao definir o texto: " + e.getMessage(), e);
        }
    }

    // Método para clicar em um elemento
    default void click(WebElement element) {
        try {
            snapShot();
            if (element.isEnabled() && element.isDisplayed()) {
                element.click(); // Clique no elemento
            } else {
                throw new IllegalStateException("O elemento não está habilitado ou visível para ser clicado.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao clicar no elemento: " + e.getMessage(), e);
        }
    }

    // Método para comparar textos
    default boolean validateEquals(String text1, String text2) {
        try {
            snapShot();
            return text1.equals(text2);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao comparar os textos: " + e.getMessage(), e);
        }
    }

    default void wait(int seconds) throws InterruptedException {
        try{
            getDriver().manage().wait(seconds);
        }catch (Exception e){
            throw new RuntimeException("Erro ao esperar"+ e.getMessage());
        }
    }

    default boolean snapShot() {
        try {
            AndroidDriver driver = getDriver();
            // Diretório para salvar as capturas
            String currentDirectory = System.getProperty("user.dir");
            String resultDirectory = currentDirectory + "/Results/Screenshots";

            // Cria o diretório, caso não exista
            File directory = new File(resultDirectory);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Nome do arquivo baseado no timestamp
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(resultDirectory + "/screenshot_" + timestamp + ".png");

            // Salva a captura
            FileUtils.copyFile(screenshot, destination);
            return true;
        } catch (IOException e) {
            System.out.println("Erro ao tirar o screenshot: " + e.getMessage());
            return false;
        }
    }
}

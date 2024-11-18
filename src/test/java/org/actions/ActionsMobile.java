package org.actions;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.App;
import org.statements.DriverManager;

import java.time.Duration;

public interface ActionsMobile {

    // Método para validar se o elemento está visível e habilitado com espera explícita
    default boolean validateObject(WebElement element) {
        try {
            if(element.isEnabled()){
                return element.isEnabled();
            }else {
                throw new IllegalStateException("Erro ao validar o objeto");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao validar o objeto: " + e.getMessage(), e);
        }
    }

    // Método para inserir texto em um campo
    default void setText(WebElement element, String text) {
        try {
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
            return text1.equals(text2);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao comparar os textos: " + e.getMessage(), e);
        }
    }
}

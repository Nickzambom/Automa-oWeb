package org.attributesMobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttributesMobileDialer {

    public AppiumDriver driver;

    public AttributesMobileDialer(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Exemplo de elemento mapeado
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Teclado\"]")
    public WebElement dialPadButton;


}

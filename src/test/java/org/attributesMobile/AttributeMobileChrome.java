package org.attributesMobile;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.w3c.dom.Element;

public class AttributeMobileChrome {

    public AppiumDriver driver;

    public AttributeMobileChrome(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Exemplo de elemento mapeado
   protected WebElement inputUrl(){
        String xpath = "//android.widget.EditText[@resource-id=\"com.android.chrome:id/search_box_text\"]";
        return driver.findElement(By.xpath(xpath));
   }


}

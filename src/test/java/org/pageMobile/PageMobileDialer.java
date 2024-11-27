package org.pageMobile;

import io.appium.java_client.AppiumDriver;
import org.actions.ActionsMobile;
import org.attributesMobile.AttributesMobileDialer;
import org.openqa.selenium.support.PageFactory;

public class PageMobileDialer extends AttributesMobileDialer implements ActionsMobile {

    public AppiumDriver driver;

    public PageMobileDialer(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void ClickInDialPad(){
        validateObject(dialPadButton);
        click(dialPadButton);
    }

    public void typeNumber(String number) {
        for (char digit : number.toCharArray()) { // Itera pelos caracteres na String
            // Localiza o botão correspondente ao número.
            // Substitua `clickButtonById` pelo método que seu framework de automação usa para clicar no botão.
            switch (digit){
                case '0':
//                  /
            }
        }
    }
}

package org.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.actions.Actions;
import org.actions.ActionsMobile;
import org.attributes.AttributesMobileDialer;
import org.openqa.selenium.support.PageFactory;
import org.statements.DriverManager;

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

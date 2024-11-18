package org.page;

import io.appium.java_client.AppiumDriver;
import org.actions.Actions;
import org.actions.ActionsMobile;
import org.attributes.AttributesMobileDialer;
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
}

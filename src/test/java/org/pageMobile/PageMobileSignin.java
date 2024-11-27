package org.pageMobile;

import io.appium.java_client.AppiumDriver;
import org.actions.ActionsMobile;
import org.attributesMobile.AttributeMobileChrome;
import org.openqa.selenium.support.PageFactory;

public class PageMobileSignin extends AttributeMobileChrome implements ActionsMobile {

    public AppiumDriver driver;

    public PageMobileSignin(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchUrl(String url) throws InterruptedException {
        setText(inputUrl(),url);
        wait(10);
    }


}

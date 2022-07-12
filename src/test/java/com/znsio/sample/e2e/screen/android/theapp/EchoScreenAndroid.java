package com.znsio.sample.e2e.screen.android.theapp;

import com.znsio.sample.e2e.screen.theapp.EchoScreen;
import com.znsio.e2e.tools.Driver;
import com.znsio.e2e.tools.Visual;
import org.openqa.selenium.By;

public class EchoScreenAndroid
        extends EchoScreen {
    private final Driver driver;
    private final Visual visually;
    private final String SCREEN_NAME = EchoScreenAndroid.class.getSimpleName();
    private final String byMessageInputAccessibilityId = "messageInput";
    private final By bySaveMessageButtonXpath = By.xpath("//android.widget.Button[@content-desc=\"messageSaveBtn\"]/android.widget.TextView");
    private final By byGoBackToHomeScreenButtonXpath = By.xpath("//android.widget.ImageButton[@content-desc=\"Navigate Up\"]");

    public EchoScreenAndroid(Driver driver, Visual visually) {
        this.driver = driver;
        this.visually = visually;
    }

    @Override
    public EchoScreen echoMessage(String message) {
        driver.waitForClickabilityOf(bySaveMessageButtonXpath);
        driver.findElementByAccessibilityId(byMessageInputAccessibilityId)
              .click();
        driver.findElementByAccessibilityId(byMessageInputAccessibilityId)
              .sendKeys(message);
        driver.waitForClickabilityOf(bySaveMessageButtonXpath)
              .click();
        driver.waitForClickabilityOf(byGoBackToHomeScreenButtonXpath)
              .click();
        return this;
    }
}

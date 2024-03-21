package org.example.carina.demo.gui.pages.ebay;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.decorator.PageOpeningStrategy;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BasePage extends AbstractPage {
    protected Logger logger;

    public BasePage(WebDriver driver) {
        super(driver);
        this.logger = LoggerFactory.getLogger(getClass());
    }

    protected void click(ExtendedWebElement element) {
        logger.info("Clicking on element: {}", element);
        element.clickIfPresent();
    }
    protected void sendKeys(ExtendedWebElement element, String text) {
        logger.info("Sending keys '{}' to element: {}", text);
        element.type(text);
    }
    protected void selectDropdownElementByIndex(ExtendedWebElement dropdown, int index){
        Select drop = new Select(dropdown.getElement());
        drop.selectByIndex(index);
    }
}

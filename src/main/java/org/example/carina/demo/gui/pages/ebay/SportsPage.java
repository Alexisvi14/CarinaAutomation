package org.example.carina.demo.gui.pages.ebay;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SportsPage extends AbstractPage {

    @FindBy(xpath = "//li[@class='b-links-accordion']")
    List<ExtendedWebElement> categoriesLinks;

    public SportsPage(WebDriver driver) {
        super(driver);
    }


    public void iterateCategorySection(String linkToSelect){
        for (ExtendedWebElement link : categoriesLinks) {
            String dropdownText = link.getText();
            if (dropdownText.equalsIgnoreCase(linkToSelect)){
                link.click();
                break;
            }
        }
    }
}

package org.example.carina.demo.gui.pages.ebay;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(xpath = "//a[@_sp='m570.l1524']")
    ExtendedWebElement loginButton;
    @FindBy(className = "gh-tb")
    ExtendedWebElement searchBox;
    @FindBy(id = "gh-btn")
    ExtendedWebElement searchButton;
    @FindBy(css = "div#srp-river-results li")
    List<ExtendedWebElement> searchedElements;
    @FindBy(id = "gh-cat")
    ExtendedWebElement dropdownCategories;
    @FindBy(linkText = "Deportes")
    ExtendedWebElement sportsCategory;
    @FindBy(xpath = "(//a[contains(text(), 'Moda')])[2]")
    ExtendedWebElement fashionCategory;
    @FindBy(linkText = "Calzado")
    ExtendedWebElement footwear;

    @FindBy(css = "nav.vl-flyout-nav__sub-cat-col")
    List<ExtendedWebElement> fashionHoverList;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return new LoginPage(driver);
    }

    public void clickSearchBox(String elementToSearch){
        sendKeys(searchBox, elementToSearch);
    }

    public void clickSearchButton(){
        click(searchButton);
    }

    public int getNumberOfSearchedElements(){
        logger.info(String.valueOf(searchedElements.size()));
        return searchedElements.size();
    }

    public void hoverSportsLink(){
        sportsCategory.hover();
    }
    public SportsPage clickSportsLink(){
        click(sportsCategory);
        return new SportsPage(driver);
    }

    public void hoverFashionLinkAndSelectLink(String link){
        fashionCategory.hover();
        fashionHoverList.forEach(e -> {
            if (e.getText().equalsIgnoreCase(link)){
                e.clickIfPresent();
            }
        });
    }

    public void clickCategoriesDropdown(int index) throws InterruptedException {
        selectDropdownElementByIndex(dropdownCategories, index);
        Thread.sleep(3000);
    }
}

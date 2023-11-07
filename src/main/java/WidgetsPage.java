import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class WidgetsPage extends BasePage {
    private WebDriverWait wait;

    public WidgetsPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 30);
    }

    @FindBy(xpath = "//div[contains(text(),'Widgets')]")
    private WebElement widgets;

    @FindBy(xpath = "//span[contains(text(),'Select Menu')]")
    public WebElement selectMenu;

    @FindBy(id = "oldSelectMenu")
    private WebElement oldStyleSelectMenuDropDown;

    @FindBy(xpath = "//div[contains(text(),'Select Value')]")
    public WebElement selectValue;


    public void openWidgets() {
        widgets.click();
    }

    public void openSelectMenu() {
        selectMenu.click();
    }

    public void openOldStyleSelectMenu() {
        oldStyleSelectMenuDropDown.click();
    }

    public void selectOldStyleSelectMenu(String color) {
        Select oldSelectMenu = new Select(oldStyleSelectMenuDropDown);
        oldSelectMenu.selectByVisibleText(color);
    }

    public void clickWhenReady(WebElement locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void goToWidgetsPage() {
        openWidgets();
        assertEquals("Select Value", selectValue.getText());
        openOldStyleSelectMenu();
        selectOldStyleSelectMenu("Red");
    }

    public void assertText(WebElement locator, String expectedText) {
        wait.until(ExpectedConditions.visibilityOf(locator));
        wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));
        assertEquals(expectedText, locator.getText());
    }

    //completeaza toat camputile in afara de unul, trimit ca parametru
    public void fillMandatoryFiledsExcept(WebElement filedToSkip){
//        completeAllMandatoryFieldMethod();
        goToWidgetsPage();//this is not used correct
        filedToSkip.clear();

    }

    public void assertTextWhenReady(WebElement locator, String expectedText) {

        wait.until(ExpectedConditions.visibilityOf(locator));

        try {

            wait.until(ExpectedConditions.textToBePresentInElement(locator, expectedText));

        } catch (Exception e){

            System.out.println("Text not present");

        }

        assertEquals(expectedText, locator.getText());

    }



}

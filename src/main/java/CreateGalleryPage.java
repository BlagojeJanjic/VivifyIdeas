import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateGalleryPage extends BasePage{
    private By createGalleryField = By.xpath("//*[@id=\"navbarTogglerDemo01\"]/ul[1]/li[3]/a");
    private By titleField = By.id("title");
    private By descriptionFiled = By.id("description");
    private By imageUrl = By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/div[3]/div/div/input");
    private By submitButton = By.xpath("//*[@id=\"app\"]/div[2]/div/div/form/button[1]");
    private By filterField = By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/div/div/button");

    public CreateGalleryPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnCreateGallery() {
        getDriver().findElement(createGalleryField).click();
    }

    public boolean isTitleFieldEnabled() {
        return getDriver().findElement(titleField).isEnabled();
    }

    public void inputTitle(String title) {
        getDriver().findElement(titleField).sendKeys(title);
    }

    public void inputDescription(String description) {
        getDriver().findElement(descriptionFiled).sendKeys(description);
    }

    public void clickSubmitButton() {
        getDriver().findElement(submitButton).click();
    }

    public void inputImageUrl(String imageUrl) {
        getDriver().findElement(this.imageUrl).sendKeys(imageUrl);
    }

    public boolean isFilterFieldDisplayed() {
        return getDriver().findElement(filterField).isDisplayed();
    }
}

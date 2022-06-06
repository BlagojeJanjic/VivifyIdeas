import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditGallery extends BasePage{
    private By galleryTitle = By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/div[1]/div/div[1]/h2/a");
    private By editButton = By.xpath("//*[@id=\"app\"]/div[2]/div/div[2]/a");
    private By galleryName = By.xpath("//*[@id=\"app\"]/div[2]/div/h1");

    public EditGallery(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickOnGalleryTitle() {
        getDriver().findElement(galleryTitle).click();
    }

    public boolean isGalleryNameDisplayed() {
        return getDriver().findElement(galleryName).isDisplayed();
    }

    public void clickOnEditButton() {
        getDriver().findElement(editButton).click();
    }


}

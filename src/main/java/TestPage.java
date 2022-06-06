import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestPage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private LoginPage loginPage;
    private CreateGalleryPage createGalleryPage;
    private EditGallery editGallery;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(10));

        loginPage = new LoginPage(driver, driverWait);
        createGalleryPage = new CreateGalleryPage(driver, driverWait);
        editGallery = new EditGallery(driver, driverWait);

        driver.navigate().to("https://gallery-app.vivifyideas.com/");
    }

    @Test (priority = 1)
    public void login() {
        try {
            loginPage.clickLoginButton();
            Assert.assertTrue(loginPage.isEmailFieldEnabled());
            loginPage.inputEmail("blagoje@gmail.com");
            loginPage.inputPassword("123456789!");
            loginPage.clickSubmit();
            Thread.sleep(2000);

            Assert.assertTrue(loginPage.isLogoutButtonDisplayed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 2)
    public void createGallery() {
        try {
            createGalleryPage.clickOnCreateGallery();
            Assert.assertTrue(createGalleryPage.isTitleFieldEnabled());
            createGalleryPage.inputTitle("New pictures");
            createGalleryPage.inputDescription("Nature");
            createGalleryPage.inputImageUrl("https://th.bing.com/th/id/OIP.TM1GkIhtCbZb8FTHgAIh4QHaFs?pid=ImgDet&rs=1.jpg");
            createGalleryPage.clickSubmitButton();
            Thread.sleep(2000);
            Assert.assertTrue(createGalleryPage.isFilterFieldDisplayed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 3)
    public void editGallery() {
        try {
            editGallery.clickOnGalleryTitle();
            Assert.assertTrue(editGallery.isGalleryNameDisplayed());
            Thread.sleep(2000);
            editGallery.clickOnEditButton();
            Thread.sleep(2000);
            Assert.assertTrue(createGalleryPage.isTitleFieldEnabled());
            createGalleryPage.inputTitle("3123124124123123123asasfdsfbabasbasnas12323sdffdgdfg23252332534532523523423421421412412424234234");
            createGalleryPage.inputDescription("3123124124123123123asasfdsfbabasbasnas12323sdffdgdfg232523325345325235234234214214124124asdasddddddddddddddddddddddddddddddddddddddddffffffffffffffdsdssssssssssssssssssssssssssssssssssssssssssssssssssss24234234");
            createGalleryPage.clickSubmitButton();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 4)
    public void logout() {
        loginPage.clickLogoutButton();
        Assert.assertTrue(loginPage.isEmailFieldEnabled());
    }

    @AfterClass
    public void close() {
        driver.close();
    }
}

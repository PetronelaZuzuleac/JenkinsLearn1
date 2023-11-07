import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    protected WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\petronela.zuzuleac\\IdeaProjects\\Project\\MedisonIslandAutomationTests\\src\\main\\resources\\chromedriver.exe");
        this.driver = new ChromeDriver();
        driver.get("https://demoqa.com/select-menu");
    }

//    @After
//    public void tearDown() {
//        driver.quit();
//    }


}

package cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class BrowserTest {

    private WebDriver driver;
    private String url;

    @Parameters({"driverPath", "url"})
    @BeforeTest
    public void beforeTest(String driverPath, String url) {
        System.setProperty("webdriver.chrome.driver", driverPath);

    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
    }

    @Parameters({"driverPath", "url"})
    @Test
    public void broswer(String driverPath, String url) throws Exception {
        driver.get(url);
        driver.findElement(By.id("kw")).sendKeys("第一个测试方法");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        System.out.println("success");
    }


    @Parameters({"driverPath", "url"})
    @Test
    public void broswer2(String driverPath, String url) throws Exception {
        driver.get(url);
        driver.findElement(By.id("kw")).sendKeys("第二个测试方法");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        System.out.println("success2");
    }

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

}

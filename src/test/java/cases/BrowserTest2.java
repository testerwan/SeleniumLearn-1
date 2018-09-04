package cases;

import POI.RangeDatabyPOI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class BrowserTest2 {

    private WebDriver driver;
    private String url;

    @Parameters({"driverPath", "url"})
    @BeforeTest
    public void beforeTest(String driverPath, String url) {
        System.setProperty("webdriver.chrome.driver", driverPath);
        this.url = url;
        driver = new ChromeDriver();

    }

//    @BeforeMethod
//    public void beforeMethod() {
//        driver = new ChromeDriver();
//    }


    @DataProvider(name = "muke")
    public Object[][] getData() {
        String path = "/Users/wan/Desktop/test.xlsx";
        Object[][] array = RangeDatabyPOI.poiRangeData(path);
        return array;
    }

    @Test(dataProvider = "muke")
    public void broswer(String s1, String s2) throws Exception {
        driver.get(url);
        driver.findElement(By.id("kw")).clear();
        Thread.sleep(2000);

        driver.findElement(By.id("kw")).sendKeys(s1);
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);

        driver.findElement(By.id("kw")).clear();
        Thread.sleep(2000);

        driver.findElement(By.id("kw")).sendKeys(s2);
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        System.out.println("success");
    }


    @AfterTest
    public void afterMethod() {
        driver.close();
    }

}

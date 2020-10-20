import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTest {
    private WebDriver driver;

    @BeforeTest
    public void setup(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @Test
    public void firstTest(){
        driver.get("C:\\Users\\itser\\IdeaProjects\\selenium-web-sample\\src\\main\\java\\example.html");
        driver.findElement(By.id("one"));
    }

    @Test
    public void secondTest(){
        driver.findElement(By.id("one")).click();
        String textAfterClick = driver.findElement(By.id("one")).getAttribute("value");
        Assert.assertEquals(textAfterClick, "Two");
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;

public class MyFirstTest {
    private WebDriver driver;
    private File file;
    private static final String BUTTON_ID_1 = "one";
    private static final String BUTTON_LABEL_1 = "One";
    private static final String BUTTON_LABEL_2 = "Two";

    @BeforeTest
    public void setup(){
        driver = DriverFactory.getDriver(DriverType.CHROME);
        file = new File("src/test/resources/example.html");
    }

    @Test
    public void firstTest(){
        driver.get(file.getAbsolutePath());

        assertEquals(driver.findElements(By.id(BUTTON_ID_1)).size(), 1);
        assertEquals(driver.findElement(By.id("one")).getAttribute("value"), BUTTON_LABEL_1);
    }

    @Test
    public void secondTest(){
        driver.findElement(By.id(BUTTON_ID_1)).click();

        assertEquals(driver.findElement(By.id(BUTTON_ID_1)).getAttribute("value"), BUTTON_LABEL_2);
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }
}

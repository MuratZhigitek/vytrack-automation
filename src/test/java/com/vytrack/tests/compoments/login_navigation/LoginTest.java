package com.vytrack.tests.compoments.login_navigation;

import com.vytrack.utilities.LoginUtil;
import com.vytrack.utilities.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    String getName = "//*[@id=\"user-menu\"]/a/text()";




    @BeforeClass
    public void BeforeClass() {

        WebDriverManager.chromedriver().setup();


    }

    @BeforeMethod
    public void setUp() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("http://qa2.vytrack.com/user/login");


    }

    @Test (priority = 1)
    public void PositiveLogin() {

        //Store manager Login
        LoginUtil.login(driver, "storemanager209", "UserUser123");
        //Wait.sleep(2);

        String actualPageTitle = driver.findElement(By.className("oro-subtitle")).getText();
        String expectedPageTitle = "Dashboard";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        driver.findElement(By.cssSelector("[class='dropdown user-menu-dropdown'] a")).click();
       // Wait.sleep(2);
        String storeManagerName = driver.findElement(By.id("user-menu")).getText();

        Assert.assertTrue(driver.findElement(By.id("user-menu")).isDisplayed());
        //Wait.sleep(2);
        driver.findElement(By.linkText("Logout")).click();
       // Wait.sleep(1);

        //Salesman Login
        LoginUtil.login(driver, "salesmanager270", "UserUser123");
        //Wait.sleep(2);
        actualPageTitle = driver.findElement(By.className("oro-subtitle")).getText();
        expectedPageTitle = "Dashboard";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        driver.findElement(By.cssSelector("[class='dropdown user-menu-dropdown'] a")).click();
       // Wait.sleep(2);
        String salesManagerName = driver.findElement(By.id("user-menu")).getText();

        Assert.assertNotEquals(storeManagerName, salesManagerName);
      //  Wait.sleep(2);
        driver.findElement(By.linkText("Logout")).click();
       // Wait.sleep(1);


        // Driver Login
        LoginUtil.login(driver, "user170", "UserUser123");
        //Wait.sleep(2);

        actualPageTitle = driver.findElement(By.className("oro-subtitle")).getText();
        expectedPageTitle = "Quick Launchpad";

        Assert.assertEquals(actualPageTitle, expectedPageTitle);

        driver.findElement(By.cssSelector("[class='dropdown user-menu-dropdown'] a")).click();
        String driverName = driver.findElement(By.id("user-menu")).getText();


        Assert.assertNotEquals(driverName,storeManagerName);

        driver.findElement(By.linkText("Logout")).click();
       // Wait.sleep(1);


    }

    @Test
    public void NegativeLogIn() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.get("http://qa2.vytrack.com/user/login");

        LoginUtil.login(driver, "User290", "123");

        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Invalid user name or password.')]")).isDisplayed());
    }


        @AfterMethod
    public void tearDown(){

        driver.close();
    }

}
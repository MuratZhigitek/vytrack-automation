package com.vytrack.tests.compoments.login_navigation;

//import com.vytrack.utilities.LoginUtil;
//import com.vytrack.utilities.NavigateToTab;
//import com.vytrack.utilities.Wait;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import java.util.concurrent.TimeUnit;
//
//public class PageAccessTest {
//
//    WebDriver driver;
//
//    @BeforeClass
//    public void beforeClass() {
//
//        WebDriverManager.chromedriver().setup();
//
//    }
//
//    @BeforeMethod
//    public void beforeMethod() {
//
//        driver = new ChromeDriver();
//
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.get("http://qa2.vytrack.com/user/login");
//
//    }
//
//    @Test
//    public void storemanagerContractPage() {
//
//        LoginUtil.login(driver, "storemanager209", "UserUser123");
//
//        NavigateToTab.navigateToModule(driver, "Fleet", "Vehicle Contracts");
////        String actualPage = driver.getTitle();
////        String expectedPage = "All - Vehicle Contract - Entities - System - Car - Entities - System";
//
//
//        String actualPage = driver.findElement(By.cssSelector("h1[class='oro-subtitle']")).getText();
//
//        String expectedPage = "All Vehicle Contract";
//        Assert.assertEquals(actualPage, expectedPage);
//
//    }
//
//    @Test
//    public void salesmanagerContractPage() {
//
//        LoginUtil.login(driver, "salesmanager270", "UserUser123");
//       // Wait.sleep(2);
//        NavigateToTab.navigateToModule(driver, "Fleet", "Vehicle Contracts");
//
//        String actualPage = driver.findElement(By.cssSelector("h1[class='oro-subtitle']")).getText();
//
//        String expectedPage = "All Vehicle Contract";
//        Assert.assertEquals(actualPage, expectedPage);
//
//
//    }
//
//    @Test
//    public void driverContractPage() {
//
//        LoginUtil.login(driver, "user170", "UserUser123");
//       // Wait.sleep(2);
//        NavigateToTab.navigateToModule(driver, "Fleet", "Vehicle Contracts");
//
//        Assert.assertTrue(driver.findElement(By.className("message")).isDisplayed());
//
//    }
//
//    @AfterMethod
//    public void tearDown(){
//        driver.close();
//    }
//}
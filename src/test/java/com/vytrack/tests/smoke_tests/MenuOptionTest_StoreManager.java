package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class MenuOptionTest_StoreManager {

    WebDriver driver;

    String userNameDriver = "salesmanager270";
    String password = "UserUser123";

    @BeforeClass
    public void BeforeClass(){
        WebDriverManager.chromedriver().setup();

    }

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.name("_username")).sendKeys(userNameDriver);
        driver.findElement(By.name("_password")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();


    }

    @Test
    public void DashboardVefirication(){
        Wait.sleep(2);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[1]")).click();
        Wait.sleep(2);
        driver.findElement(By.xpath("//span[.='Dashboard']")).click();
        Wait.sleep(2);
        String expectedTitle = "Dashboard - Dashboards";
        String actualTitle = driver.getTitle();
        Wait.sleep(2);
        Assert.assertEquals(actualTitle, expectedTitle);
        String expectedPageName = "Dashboard";
        String actualPageName =  driver.findElement(By.xpath("//li[text()='Dashboard']")).getText();
        Assert.assertEquals(actualPageName,expectedPageName);

    }

    @Test
    public void FleetVerification(){

        Wait.sleep(2);
        driver.findElement(By.xpath("//*[@id='main-menu']/ul/li[2]")).click();
        Wait.sleep(2);
        driver.findElement(By.xpath("//span[.='Vehicles']")).click();
        Wait.sleep(1);
        String expectedTitle = "All - Car - Entities - System - Car - Entities - System";
        String actualTitle = driver.getTitle();

        String expectedPageName = "All Cars";
        String actualPageName = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        Assert.assertEquals(actualPageName, expectedPageName);

    }
    @Test
    public void Customer1() {
        Wait.sleep(2);
        WebElement mainCustomer = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]"));

        Wait.sleep(2);
        mainCustomer.click();
        driver.findElement(By.xpath("//a[.='Accounts']")).click();
        String expectedTitle = "All - Accounts - Customers";
        Wait.sleep(2);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        String  actualPageName = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        String expectedPageName = "All Accounts";
        Assert.assertEquals(actualPageName, expectedPageName);

    }

    @Test
    public void Customer2() {
        Wait.sleep(2);
        WebElement mainCustomer = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]"));

        Wait.sleep(2);
        mainCustomer.click();
        driver.findElement(By.xpath("//a[.='Contacts']")).click();
        String expectedTitle = "All - Contacts - Customers";
        Wait.sleep(2);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        String actualPageName = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        String expectedPageName = "All Contacts";
        Assert.assertEquals(actualPageName, expectedPageName);
    }

    @Test
    public void Sales() {
        Wait.sleep(2);
        WebElement mainSales = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[4]"));
        mainSales.click();

        driver.findElement(By.linkText("Opportunities")).click();
        Wait.sleep(2);
        String expectedTitle = "Open Opportunities - Opportunities - Sales";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        String actualPageName = driver.findElement(By.xpath("//*[@id=\"container\"]/div[2]/div/div/div[1]/div/div/div/div[1]/div/h1")).getText();
        String expectedPageName = "Open Opportunities";
        Assert.assertEquals(actualPageName, expectedPageName);

    }

    @Test
    public void ActivitiesCalls() {
        Wait.sleep(2);
        WebElement mainActivities = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]"));
        mainActivities.click();

        driver.findElement(By.linkText("Calls")).click();
        Wait.sleep(2);
        String expectedTitle = "All - Calls - Activities";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        String actualPageName = driver.findElement(By.cssSelector("h1[class='oro-subtitle']")).getText();
        String expectedPageName = "All Calls";
        Assert.assertEquals(actualPageName, expectedPageName);

    }

    @Test
    public void ActivitiesCalendarEvent() {
        Wait.sleep(2);
        WebElement mainActivities = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[5]"));
        mainActivities.click();

        driver.findElement(By.linkText("Calendar Events")).click();
        Wait.sleep(2);
        String expectedTitle = "All - Calendar Events - Activities";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        String actualPageName = driver.findElement(By.cssSelector("h1[class='oro-subtitle']")).getText();
        String expectedPageName = "All Calendar Events";
        Assert.assertEquals(actualPageName, expectedPageName);
    }

        @AfterMethod
    public void tearDown(){

        driver.close();
    }
}

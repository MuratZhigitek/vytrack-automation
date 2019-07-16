package com.vytrack.tests.smoke_tests;

import com.vytrack.utilities.Wait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class MenuOptionsTest_Driver {

    String userNameDriver = "user174";
    String password = "UserUser123";

    WebDriver driver;

    @BeforeClass
    public void beforeClass(){
    WebDriverManager.chromedriver().setup();
}
    @BeforeMethod
    public void setUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.name("_username")).sendKeys(userNameDriver);
        driver.findElement(By.name("_password")).sendKeys(password);
        driver.findElement(By.id("_submit")).click();
    }
    @Test (priority = 1)
    public void Fleet(){


        WebElement mainFleet = driver.findElement(By.cssSelector("[class='dropdown dropdown-level-1']:nth-of-type(1) "));
        Wait.sleep(2);
        mainFleet.click();
        driver.findElement(By.linkText("Vehicles")).click();
        String expectedTitle = "Car - Entities - System - Car - Entities - System";
        Wait.sleep(2);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

        String actualPageTitle =   driver.findElement(By.xpath("//*[.='Cars']")).getText();
        String expectedPageTitle = "All Cars";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);



    }

    @Test (priority = 2)
    public void CustomerAccounts(){
       Wait.sleep(2);
        WebElement mainCustomer = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]"));

        Wait.sleep(2);
        mainCustomer.click();
        driver.findElement(By.xpath("//a[.='Accounts']")).click();
        String expectedTitle = "Accounts - Customers";
        Wait.sleep(2);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        String actualPageTitle =   driver.findElement(By.xpath("//li[text()='Accounts']")).getText();
        String expectedPageTitle = "Accounts";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);
    }

    @Test (priority = 3)
    public void CustomerContacts(){
        Wait.sleep(2);
        WebElement mainCustomer = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[2]"));

        Wait.sleep(2);
        mainCustomer.click();
        driver.findElement(By.xpath("//a[.='Contacts']")).click();
        String expectedTitle = "Contacts - Customers";
        Wait.sleep(2);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        String actualPageTitle =  driver.findElement(By.xpath("//li[text()='Contacts']")).getText();
        String expectedPageTitle = "Contacts";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);

    }

    @Test
    public void Activities(){
        WebElement calendarPage = driver.findElement(By.xpath("//*[@id=\"main-menu\"]/ul/li[3]"));
        calendarPage.click();

        driver.findElement(By.xpath("//span[.='Calendar Events']")).click();
        String expectedTitle = "Calendar Events - Activities";
        String actualTitle = driver.getTitle();
        Wait.sleep(2);
        Assert.assertEquals(actualTitle, expectedTitle);

        String actualPageTitle = driver.findElement(By.xpath("//li[text()='Calendar Events']")).getText();
        Wait.sleep(2);
        String expectedPageTitle = "Calendar Events";
        Assert.assertEquals(actualPageTitle, expectedPageTitle);




    }


    @AfterMethod
    public void tearDown(){

        driver.close();
    }
}
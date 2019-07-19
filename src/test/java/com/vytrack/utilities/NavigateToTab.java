package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigateToTab {

    public static void navigateToModule(WebDriver driver, String tab, String module) {

        String tabLocator = "//span[contains(text(),'" + tab + "') and contains(@class, 'title title-level-1')]";
        String moduleLocator = "//span[contains(text(),'" + module + "') and contains(@class, 'title title-level-2')]";
        driver.findElement(By.xpath(tabLocator)).click();
        Wait.sleep(2);
        driver.findElement(By.xpath(moduleLocator)).click();
        Wait.sleep(2);
    }
    public static void verifyEquals(String expectedResult, String actualResult){
        if(expectedResult.equals(actualResult)){
            System.out.println("Passed");
        }else{
            System.out.println("Failed");
            System.out.println("Expected result: "+expectedResult);
            System.out.println("Actual result: "+actualResult);
        }

    }
}

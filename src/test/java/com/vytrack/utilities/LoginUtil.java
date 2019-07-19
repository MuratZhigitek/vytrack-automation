package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginUtil {

        //we dont want to access these var outside of class
        private static  String usernameLocator = "prependedInput";
        private static String passwordLocator = "prependedInput2";

        public static void login(WebDriver driver, String username, String password){
            driver.findElement(By.id(usernameLocator)).sendKeys(username);
            driver.findElement(By.id(passwordLocator)).sendKeys(password, Keys.ENTER);
            Wait.sleep(3);


        }
}

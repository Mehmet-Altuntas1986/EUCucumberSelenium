package com.vytrack.utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private Driver() {
        //inheritableThreadLocal-->this is like a container,bag,pool
        //in this poolwe can have seperate objects for each thread
        //for each thread, in inheritableThreadLocal we can have seperate object for that thread
        //driver class will provide seperate webdriver object per thread
        public static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();
        public static WebDriver get () {  //public ve static te hat gorunuyordu, sag ustten file--> invalidate cashes tikla sorun kalkiyor

            if (driverPool.get() == null){
                //if we pass the driver from terminal then use that one
                //if we do not pass the driver from terminal then use te one properties file

                String browser=System.getProperty( "browser" )!=null?browser=System.getProperty("browser");
                switch (browser) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver()  );
                        break;
                    case "chrome-headless":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver(new ChromeOptions().setHeadless(true)));
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        break;
                    case "firefox-headless":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver(new FirefoxOptions().setHeadless(true)));
                        break;
                    case "ie":
                        if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                            throw new WebDriverException("Your OS doesn't support Internet Explorer");
                        WebDriverManager.iedriver().setup();
                        driverPool.set(new InternetExplorerDriver());
                        break;

                    case "edge":
                        if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                            throw new WebDriverException("Your OS doesn't support Edge");
                        WebDriverManager.edgedriver().setup();
                        driverPool.set(new EdgeDriver());
                        break;

                    case "safari":
                        if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                            throw new WebDriverException("Your OS doesn't support Safari");
                        WebDriverManager.getInstance(SafariDriver.class).setup();
                        driverPool.set(new SafariDriver());
                        break;
                }


            }

        }
    }
}


//Driver class i olmayinca browserutils class i hata verir
//day32_ we are learning parallel testing, simdi bu sinifta degisiklikler yapacagiz


//bu sinifin eski hali asagidak i gibiydi

/*

import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private Driver() {

    }

    private static WebDriver driver;

    public static WebDriver get() {
        // Test
        if (driver == null) {
            // this line will tell which browser should open based on the value from properties file
            String browser = ConfigurationReader.get("browser");
            switch (browser) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "firefox-headless":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(new FirefoxOptions().setHeadless(true));
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS doesn't support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS doesn't support Safari");
                    WebDriverManager.getInstance(SafariDriver.class).setup();
                    driver = new SafariDriver();
                    break;
            }

        }

        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

 */
package Drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    public WebDriver driver;

    public static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    /**
     * this method is to initilalize a web driver using thread local
     *
     * @param browser
     * @return
     */
    public WebDriver init_driver(String browser){

        System.out.println("browser value is: "+browser);

        if (browser.equals("chrome")){
            WebDriverManager.chromedriver().setup();
            ChromeOptions option = new ChromeOptions();

        /*    //below code is  to run headless
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            option.addArguments("--remote-allow-origins=*");*/

            //below code is to run in incognito mode
            option.addArguments("incognito");
            option.addArguments("--remote-allow-origins=*");
            driverThreadLocal.set(new ChromeDriver(option));
        }
        else if (browser.equals("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driverThreadLocal.set(new FirefoxDriver());
        }
        else {
            System.out.println("Please pass the correct browser value: "+browser);
        }
        getDriver().manage().deleteAllCookies();
        getDriver().manage().window().maximize();
        return getDriver();


    }

    /**
     * this method is used to get driver using thread local
     * @return
     */

    public static synchronized WebDriver getDriver(){
        return driverThreadLocal.get();
    }




}

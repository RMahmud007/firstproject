package com.selenium.base;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static java.time.temporal.ChronoUnit.SECONDS;


public class TestBase {
    public static WebDriver driver;
    public static Properties properties;
    private static ExtentReports extent;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // store the creds in the properties file and read from there
    private final String BROWSERSTACK_USERNAME = properties.getProperty("browserstack-username");
    private final String BROWSERSTACK_ACCESS_KEY =properties.getProperty("browserstack-accessKey");
    private final String URL_OF_BS = "https://" + BROWSERSTACK_USERNAME + ":" + BROWSERSTACK_ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browserName", "url", "cloud","cloudName"})
    public void setupBrowser(String browserName, String url, boolean cloud, String cloudName) throws MalformedURLException {
        System.out.println("Setup browser running");

        //if (cloud==true)
        if (cloud) {
            driver = getRemoteWebDriver(cloudName, browserName);
        } else {
            driver = getLocalWebDriver(browserName);
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.of(20, SECONDS));
        driver.manage().timeouts().implicitlyWait(Duration.of(20, SECONDS));
        driver.get(url);
    }

    private WebDriver getLocalWebDriver(String browserName) {
        WebDriver localDriver;
        if (browserName.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-fullscreen");
            localDriver = new ChromeDriver(options);
        } else {

            localDriver = new FirefoxDriver();
        }
        return localDriver;
    }

    private WebDriver getRemoteWebDriver(String cloudName, String browserName) throws MalformedURLException {
        if (cloudName.equalsIgnoreCase("saucelabs")){
            ChromeOptions browserOptions= new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");
            Map<String, Object>sauceOptions=new HashMap<>();
            sauceOptions.put("Username", properties.getProperty("saucelabs-username"));
            sauceOptions.put("accessKey", properties.getProperty("saucelabs-accessKey"));
            sauceOptions.put("build","selenium-build-TW74R");
            sauceOptions.put("name","<your test name>");
            browserOptions.setCapability("sauce:options",sauceOptions);
            URL url =new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            RemoteWebDriver cloudDriver =new RemoteWebDriver(url, browserOptions);
            return driver;

        }else {
            MutableCapabilities capabilities = new MutableCapabilities();
            HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
            capabilities.setCapability("browserName",browserName);
            bstackOptions.put("os", "OS X");
            bstackOptions.put("osVersion", "Catalina");
            bstackOptions.put("browserVersion", "121.0");
            capabilities.setCapability("bstack:options", bstackOptions);
            //System.out.println(URL_OF_BS);
            URL url = new URL(URL_OF_BS);
            WebDriver cloudDriver = new RemoteWebDriver(url, capabilities);
            return cloudDriver;
        }


    }
    @AfterMethod(alwaysRun = true)
    public void quitBrowser() {
        waitFor(2);
        driver.quit();
    }

    public void scrollDownToSpecificElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Extent Report Setup
    @BeforeSuite(alwaysRun = true)
    public void extentSetup(ITestContext context) {
        ExtentTestManager.setOutputDirectory(context);
        extent = ExtentTestManager.getInstance();
    }

    //Extent Report Setup for each methods
    @BeforeMethod(alwaysRun = true)
    public void startExtent(Method method) {
        String className = method.getDeclaringClass().getSimpleName();
        ExtentTestManager.startTest(method.getName());
        ExtentTestManager.getTest().assignCategory(className);
    }

    //Extent Report cleanup for each methods
    @AfterMethod(alwaysRun = true)
    public void afterEachTestMethod(ITestResult result) {
        ExtentTestManager.getTest().getTest().setStartedTime(ExtentTestManager.getTime(result.getStartMillis()));
        ExtentTestManager.getTest().getTest().setEndedTime(ExtentTestManager.getTime(result.getEndMillis()));
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        if (result.getStatus() == 1) {
            ExtentTestManager.getTest().log(LogStatus.PASS, "TEST CASE PASSED : " + result.getName());
        } else if (result.getStatus() == 2) {
            ExtentTestManager.getTest().log(LogStatus.FAIL, "TEST CASE FAILED : " + result.getName() + " :: " + ExtentTestManager.getStackTrace(result.getThrowable()));
        } else if (result.getStatus() == 3) {
            ExtentTestManager.getTest().log(LogStatus.SKIP, "TEST CASE SKIPPED : " + result.getName());
        }
        ExtentTestManager.endTest();
        extent.flush();
        if (result.getStatus() == ITestResult.FAILURE) {
            ExtentTestManager.captureScreenshot(driver, result.getName());
        }
    }

    @AfterSuite(alwaysRun = true)
    public void generateReport() {
        extent.close();
    }

    //Extent Report closed
    public static void waitFor(int second){
        try {
            Thread.sleep(second*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickUsingXpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }
    public void clickUsingXpathSendKey(String locator){
        driver.findElement(By.xpath(locator)).sendKeys("");
    }
    public void clickUsingID(String locator){
        driver.findElement(By.id(locator)).click();
    }
    public void clicklinkTest(String locator){
        driver.findElement(By.linkText(locator)).click();
        waitFor(5);
    }

}

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Test {

    public static void main(String[] args) throws InterruptedException {


      ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.makemytrip.com/");
        System.out.println(driver.getTitle());


//        System.out.println(driver.getPageSource());
//        System.out.println(driver.getCurrentUrl());
//        System.out.println(driver.getSessionId());
        driver.manage().window().maximize();
        Thread.sleep(5000);
//        System.out.println(driver.manage().logs());
//        driver.navigate();
//        driver.findElement(By.id("user-name")).sendKeys("1234");
//        driver.findElement((By.name("password"))).sendKeys("1234");
//        driver.findElement((By.xpath("//input[@id=\"login-button\"]"))).click();
//        String error=driver.findElement(By.xpath("//div[@class='error-message-container error']")).getText();
//        System.out.println(error);
//        if("Epic sadface: Username and password do not match any user in this service".equals(error))
//        {
//            System.out.println("equal");
//        }
//        Assert.assertTrue(driver.findElement(By.id("user-name")).isDisplayed());
//        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service",error);
       // WebDriverWait(driver, 10).until(EC.element_to_be_clickable((By.className(), 'close-button')))
        try {
            WebElement element = driver.findElement(By.id("webklipper-publisher-widget-container-notification-frame"));
            driver.switchTo().frame(element);
//        driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
            WebElement element1 = driver.findElement(By.className("close"));
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();", element1);
            driver.switchTo().defaultContent();
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        driver.findElement(By.xpath("//li[@class='menu_Cabs']/span/a/span[text()='Cabs']")).click();
        Thread.sleep(1000);
        //driver.findElement(By.xpath("//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/div/input[@title=\"From\"]")).click();
        driver.findElement(By.xpath("//div[@class=\"csw_inputBox searchCity increaseHeight\"]/label/input[@id=\"fromCity\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='autoSuggestPlugin hsw_autocomplePopup']/div/input[@title='From']")).sendKeys("Coimbatore");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class=\"autoSuggestPlugin hsw_autocomplePopup\"]/div/div/div/ul/li[@id=\"react-autowhatever-1-section-0-item-0\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@title=\"To\"]")).sendKeys("ooty");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@id=\"react-autowhatever-1-section-0-item-0\"]")).click();
        Thread.sleep(1000);

        while(!driver.findElement(By.xpath("//div[@role=\"heading\"]/div")).getText().equals("February 2024")){
            Thread.sleep(1000);
            driver.findElement(By.xpath("//span[@aria-label=\"Next Month\"]")).click();
        }
        Thread.sleep(1000);

        List<WebElement> date= driver.findElements(By.xpath("\n" +"//div[@class='DayPicker-Body']/div[@class='DayPicker-Week']/div[@class='DayPicker-Day']"));
        for(WebElement element:date){
            String text=element.getText();
            Thread.sleep(1000);
            if(text.equals("3")){
                element.click();
                break;
            }
        }
        Thread.sleep(1000);
        List<WebElement> hour=driver.findElements(By.xpath("//div[@data-cy=\"OutstationOneWayWidget_62\"]//div[@class=\"newTimeSlotParent\"] //div[@class=\"makeFlex row\"]/ul[@class=\"newTimeSlotHrUl\"]//li[@class=\"hrSlotItemParent\"]//span[@class=\"hrSlotItemChild\"]"));
        for(WebElement element:hour)
        {
            String text=element.getText();
            Thread.sleep(1000);
            if(text.equals("03 Hr")){
                element.click();
                break;
            }
        }
        List<WebElement> min=driver.findElements(By.xpath("//div[@data-cy=\"OutstationOneWayWidget_62\"]//div[@class=\"newTimeSlotParent\"] //div[@class=\"makeFlex row\"]/ul[@class=\"newTimeSlotMinUl\"]/li[@data-cy=\"MinSlots_83\"]"));
        for(WebElement element:min)
        {
            String text=element.getText();
            Thread.sleep(1000);
            if(text.equals("30 min")){
                element.click();
                break;
            }
        }
        List<WebElement> mer=driver.findElements(By.xpath("//div[@data-cy=\"OutstationOneWayWidget_62\"]//div[@class=\"newTimeSlotParent\"] //div[@class=\"makeFlex row\"]/ul[@class=\"newTimeSlotMerUl\"]/li[@data-cy=\"MeridianSlots_82\"]"));
        for(WebElement element:mer)
        {
            String text=element.getText();
            Thread.sleep(1000);
            if(text.equals("PM")){
                element.click();
                break;
            }
        }

        driver.findElement(By.xpath("//span[@class=\"applyBtnText\"]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@data-cy='OutstationOneWayWidget_64']")).click();
        Thread.sleep(1000);
        WebDriverWait webdriver=new WebDriverWait(driver, Duration.ofSeconds(20));

//        driver.findElement(By.xpath("//div[@aria-label='Sun Mar 03 2024']")).click();
//        Thread.sleep(1000);



//        System.out.println("das");
       // driver.findElement((By.className("wewidgeticon we_close"))).click();
    }
}

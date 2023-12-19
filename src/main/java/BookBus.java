import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookBus {
    public static void main(String[] args) throws InterruptedException {
        ChromeDriver driver = new ChromeDriver();
        driver.get(" https://www.easemytrip.com/bus/");
        System.out.println(driver.getTitle());
        //Assert.assertEquals(pageTitle, "Online Bus Ticket Booking with lowest fares & best offers - Cleartrip");
        driver.manage().window().maximize();
        driver.findElement(By.id("txtSrcCity")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("txtSrcCity")).sendKeys("coimbatore");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//ul[@id='srcNav']/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("txtDesCity")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("txtDesCity")).sendKeys("Bangalore");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//ul[@id='desNav']/li[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("datepicker")).click();
        Thread.sleep(1000);
        WebElement month;
        WebElement year;
        do {
            Thread.sleep(1000);
            month = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/div/span[1]"));
            year = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/div/span[2]"));

            if (month.getText().equals("January") && year.getText().equals("2024")) {
                break;
            }

            driver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/a[2]/span")).click();
        } while (true);
        List<WebElement> date = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
        for (WebElement element : date) {
            String text = element.getText();
            System.out.println(text);
            Thread.sleep(1000);
            if (text.equals("3")) {
                element.click();
                break;
            }
        }
        driver.findElement(By.id("srcbtn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("nig")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("disAc")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("disSleeper")).click();
        Thread.sleep(2000);
//        WebElement element = driver.findElement(By.xpath("//div[@id='topratedBus']/img[@alt='Top Rated Buses']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        element.click();
        String operatorName = driver.findElement(By.xpath("//div[@class='main_center']/div[3]/div[2]/div/div/span")).getText();
        Thread.sleep(2000);
        String seatPrice = driver.findElement(By.xpath("//div[@class=\"main_center\"]/div[3]/div[2]/div[5]/p[2]")).getText();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class=\"main_center\"]/div[3]/div[2]/div[6]")).click();
        Thread.sleep(2000);
        String Date= driver.findElement(By.xpath("//div[@class='bot_info']/p[3]")).getText();
        List<String> resultList = new ArrayList<>();
        Thread.sleep(2000);
        List<WebElement> seats=driver.findElements(By.xpath("//*[@id=\"myModal\"]/div/div[1]/div[3]/div[2]/div[2]/div[2]/div[@class=\"upper-seat-fl ng-scope\"]/ul/li[@class=\"ng-scope\"]/div[@class=\"sleeper_normal\"]"));
        Thread.sleep(2000);
        for(WebElement seat:seats){
            if (seat.getText().contains("DU") && seat.getAttribute("class").equals("sleeper_normal")){
                resultList.add(seat.getText());
            }
        }
        System.out.println("operator: "+operatorName);
        System.out.println("Price: "+seatPrice);
        System.out.println("Date: "+Date);
        System.out.println("Available seats:");
        for (int i = 1; i < 10; i+=2) {
            String current = "DU" + i;
            String next = "DU" + (i + 1);
            if (resultList.contains(current) && resultList.contains(next)) {
                System.out.println( current + " or " + next );
            }
        }








    }

}

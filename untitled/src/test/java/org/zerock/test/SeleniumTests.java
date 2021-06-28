package org.zerock.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SeleniumTests {
    //셀레니움 동작(ajax 데이터 출력 및 로그인)
    @Test
    public void testOpen() throws InterruptedException {
        WebDriver driver= new ChromeDriver();
        driver.get("http://gs25.gsretail.com/gscvs/ko/products/event-goods");
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement ele= driver.findElement((By.cssSelector("#TWO_TO_ONE")));
        ele.click();
        Thread.sleep(2000);

        List<WebElement> list = driver.findElements(By.cssSelector(".prod_list li"));
        list.forEach(webElement -> {
            //System.out.println(webElement);
            WebElement imgEle = webElement.findElement(By.cssSelector("img"));
            System.out.println(imgEle.getAttribute("src"));
            System.out.println(imgEle.getAttribute("src"));
        });

    }

    @Test
    public void testOne() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://gs25.gsretail.com/gscvs/ko/sign-up/login");

        WebElement ele = driver.findElement(By.cssSelector("#webId"));
        ele.sendKeys("stxz00");
        Thread.sleep(1000);
        WebElement ele1 = driver.findElement(By.cssSelector("#pwd"));
        ele1.sendKeys("3w44r24");
        Thread.sleep(1000);
        WebElement ele2 = driver.findElement(By.cssSelector(".btn_login"));
        ele2.click();
    }
}

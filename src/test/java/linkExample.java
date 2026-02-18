import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class linkExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/link.xhtml");
    }

    @Test //take  me dashboard
    public void linkTest(){
       WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
       homeLink.click();
       driver.navigate().back();

        //find my destination
        WebElement wheretoGo = driver.findElement(By.partialLinkText("Find the URL"));
        String path = wheretoGo.getAttribute("href");
        System.out.println(" This is the link going to - " + path);

        //broken link
        WebElement brokenLink = driver.findElement(By.linkText("Broken?"));
        brokenLink.click();

        String title = driver.getTitle();
        if (title.contains("404")){
            System.out.println("Link Broken");
        }
        else {
            System.out.println("not broken");
        }
        driver.navigate().back();


        //duplicate link
        WebElement homeLink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homeLink1.click();
        driver.navigate().back();


        //count page links
        List<WebElement> countfullpagelinks = driver.findElements(By.tagName("a"));
        int pagelinkcount = countfullpagelinks.size();
        System.out.println("System all page links "+ pagelinkcount);

        //count layout links
        WebElement layoutEliment =  driver.findElement(By.className("layout-main-content"));
        List<WebElement> countoflayouteliment =  layoutEliment.findElements(By.tagName("a"));
        System.out.println("count of layout links - "+  countoflayouteliment.size());

    }

}


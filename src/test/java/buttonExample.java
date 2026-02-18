import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class buttonExample {

    WebDriver driver;
@BeforeMethod
    public void openSite(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){
        driver.findElement(By.xpath("//button[@id='j_idt88:j_idt90']")).click();
        String expectTitle = "Dashboard";
        //String actualTitle = driver.getTitle();

        if (expectTitle.equals(driver.getTitle())){
            System.out.println("Title True");
        }
        else {
            System.out.println("Title False");
        }

        driver.navigate().back();


        WebElement position = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt94']"));
        Point getposition = position.getLocation();
        int x = getposition.getX();
        int y = getposition.getY();
        System.out.println("x - "+x );
        System.out.println("y - "+y );

        WebElement btnColor = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt96']"));
        String btColor = btnColor.getCssValue("background-color");
        System.out.println("Button color = "+btColor );
        System.out.println("Button color = "+ btnColor.getCssValue("background-color") );

        WebElement hwbtn = driver.findElement(By.xpath("//button[@id='j_idt88:j_idt98']"));
        int height = hwbtn.getSize().getHeight();
        int width = hwbtn.getSize().getWidth();
        System.out.println("Heigth - "+height + "Weight - "+ width);

    }

}

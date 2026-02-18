import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class textboxexample {
    WebDriver driver;

    @BeforeMethod
    public void openLinkPage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0xdkw6hdqha67g8y774d46vcm11706492.node0");
    }

    @Test
    public void textBox(){
        WebElement name = driver.findElement(By.id("j_idt88:name"));
        name.sendKeys("sadaruu");

        WebElement country = driver.findElement(By.id("j_idt88:j_idt91"));
        country.sendKeys("India");

        boolean ans = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Tect box is enable - "+ ans);

        WebElement  cleartext  =  driver.findElement(By.xpath("//*[@id=\"j_idt88:j_idt95\"]"));
        cleartext.clear();

        WebElement textRet = driver.findElement(By.id("j_idt88:j_idt97"));
        String text = textRet.getAttribute("value");
        System.out.println("text box text - "+text);

        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("gest@gmail.com" + Keys.TAB + "Confirm control moved to next element." );



    }
}

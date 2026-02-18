import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class dropdownTest {

    WebDriver driver;
    @BeforeMethod
    public void openwebsiet(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }
@Test
    public void test() throws InterruptedException {
    driver.get("https://www.leafground.com/select.xhtml");
        WebElement dropdown = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
    Select select = new Select(dropdown);
    select.selectByIndex(1);
    Thread.sleep(3000);
    select.selectByVisibleText("Playwright");
    Thread.sleep(3000);

    List<WebElement> listofOpt = select.getOptions();
    int size = listofOpt.size();
    System.out.println("Number of list - "+size);

    for(WebElement element : listofOpt) {
        System.out.println(element.getText());
    }

    dropdown.sendKeys("Puppeteer");
    Thread.sleep(3000);

    WebElement dropdown2 = driver.findElement(By.xpath("//label[@id='j_idt87:country_label']"));
   dropdown2.click();

   List<WebElement> countrylist = driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));

   for (WebElement element : countrylist){
       String dropValue = element.getText();

       if(dropValue.equals("USA")){
           element.click();
           break;
       }
   }
 }

 @Test
 public void googletest() throws InterruptedException {
        driver.get("https://www.google.com");

       driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("palitha");
       Thread.sleep(3000);


 }

}

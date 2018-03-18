//https://www.youtube.com/watch?v=QgW8W9yZlmY
//İlkay Günel'e Teşekkürler

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestCase {

    @Test

    public void doTestCase(){


        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        WebDriver webDriver=new FirefoxDriver();

        webDriver.get("http://www.iett.istanbul/");


        //Arama kutusu
        WebElement searchBox = webDriver.findElement(By.id("select2-searchShortcutsLine-container"));
        searchBox.click();

        //Arama kutusuna değer girme
        WebElement fillSearchBox = webDriver.findElement(By.className("select2-search__field"));
        fillSearchBox.sendKeys("522");

        //Değer girdikten sonra max. 3 saniye listeleme için bekleme
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,3);
        //örnek yazı gidene kadar listenin gelmesi için bekle ilk class örnek yazı ikinci class listenin class adı dikkat ederseniz ikiside aynı sınıfta
        //bir elementin gitmesini bekliyoruz
        webDriverWait.until(ExpectedConditions.invisibilityOfElementWithText(By.className("select2-results__option"),webDriver.findElement(By.className("select2-results__option")).getText()));

        //Aranan değerde listede ilk çıkan sonuca tıklama
        List<WebElement> searchResult = webDriver.findElements(By.className("select2-results__option"));
        searchResult.get(0).click();

        //visibilityOfElement.. bir elementin gelmesini bekliyoruz
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("button--success")));
        //butonu bulduruyoruz
        WebElement allInfas= webDriver.findElement(By.className("button--success"));
        allInfas.click();


        //Geçtiği duraklar
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement stations = webDriver.findElement(By.cssSelector("a[href*='#LineStation']"));
        stations.click();

        //arka plandaki açık kalan driverları kaparır
        webDriver.quit();

    }
}

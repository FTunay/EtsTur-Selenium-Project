import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class EtsTurWeb {

    @Test

    public void EtsBrowser() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\furka\\Desktop\\Selenium\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.etstur.com");
        Thread.sleep(1000);

        // Çerez ve Reklam Kapat
        driver.findElement(By.xpath("//*[@id=\"appCookie\"]/button/i")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/button")).click();

        // Tarih Seçimi
        driver.findElement(By.id("checkIn")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sf-hotelSearchForm\"]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[6]/td[4]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sf-hotelSearchForm\"]/div[1]/div/div[2]/div[1]/div[2]/div[2]/div/div[1]/div/table/tbody/tr[6]/td[7]")).click();
        Thread.sleep(1000);

        // Bölge Seçimi
        driver.findElement(By.id("tb-autocomplete")).sendKeys("Eskişehir");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"sf-hotelSearchForm\"]/div[1]/div/div[1]/div/div[2]/div/ul/li[1]/span")).click();
        Thread.sleep(1000);

        // Search
        driver.findElement(By.xpath("//*[@id=\"sf-hotelSearchForm\"]/div[2]/div/div[2]/button")).click();
        Thread.sleep(2000);

        // En yüksek puanli otel seçimi
        driver.findElement(By.xpath("//*[@id=\"hotel-card-list\"]/div/div[2]/div[3]/div/div[2]/select")).click();
        driver.findElement(By.xpath("//*[@id=\"hotel-card-list\"]/div/div[2]/div[3]/div/div[2]/select/option[4]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"hotelList\"]/div[1]/a/div/div/div[2]/div/div[2]/div[3]/ul/li[2]/i")).click();
        Thread.sleep(5000);

        // Yeni Pencereye Geçiş
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        // Oda Seç
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"hotelRoomList\"]/div[4]/div[3]/ul/li[1]/div[2]/div/div[2]/a/i")).click();
        Thread.sleep(3000);

        // Rezervasyon Bilgileri Doldurulmadan İlerleme Kontrolü
        driver.findElement(By.id("btn-preBook")).click();
        Thread.sleep(2000);

        // Rezervasyon Bilgilerinin doldurulup ilerlenmesi
        boolean metin = driver.findElement(By.xpath("//*[@id=\"guestInformation-0-0\"]/div/div/div/div/div[3]/div[1]/div[1]/div")).isDisplayed();

            if (metin) {
                driver.findElement(By.xpath("//*[@id=\"guestInformation-0-0\"]/div/div/div/div/div[3]/div[1]/div[2]/label")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"guestInformation-0-0\"]/div/div/div/div/div[3]/div[1]/div[2]/label")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("tb-name_0_0")).sendKeys("Furkan");
                Thread.sleep(1000);
                driver.findElement(By.id("tb-surname_0_0")).sendKeys("Tunay");
                Thread.sleep(1000);
                driver.findElement(By.id("tb-email_0_0")).sendKeys("furkan_tunay26@hotmail.com");
                Thread.sleep(1000);
                driver.findElement(By.name("contactFormPhoneNumber")).sendKeys("5332429630");
                Thread.sleep(1000);
                driver.findElement(By.id("btn-preBook")).click();
                Thread.sleep(2000);
            }


        // Kart Bilgilerinin girilmesi
        driver.findElement(By.id("creditCardOwnerName")).sendKeys("Furkan TUNAY");
        Thread.sleep(1000);
        driver.findElement(By.id("tb-creditCardNumber")).sendKeys("1234123412341234");
        Thread.sleep(1000);
        driver.findElement(By.name("creditCardValidMonth")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"collapse-CREDITCARD\"]/div/div/div/div[1]/div[2]/div[1]/div/select/option[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("creditCardValidYear")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"collapse-CREDITCARD\"]/div/div/div/div[1]/div[2]/div[2]/div/select/option[5]")).click();
        driver.findElement(By.name("creditCardCVC")).sendKeys("123");
        Thread.sleep(3000);

        // Checkboxes
        driver.findElement(By.xpath("//*[@id=\"checkboxesContent\"]/div[1]/label/span")).click();
        Thread.sleep(2000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String el = "document.getElementById('kvkApproval').click()";
        js.executeScript(el);

        jse.executeScript("window.scrollBy(0,500)");
    }
}
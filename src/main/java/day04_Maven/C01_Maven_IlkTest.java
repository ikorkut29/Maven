package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Maven_IlkTest {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();//System.set property yazmıyoruz
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //Arama kutusunu locate ediniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));

        //"Samsung headphones" ile arama yapınız
        aramaKutusu.sendKeys("Samsung headphones");//Burada virgün koyup Keys.Enter olarak ta yazabiliriz
        aramaKutusu.submit();//Arama kutusunun içerisine yazar

        //Bulunan sonuc sayisini yazdirin
        WebElement aramaSonucuYazisi = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(aramaSonucuYazisi.getText());//getText webelementin üstündeki yaziyi alir.
        String[] sonucSayisi = aramaSonucuYazisi.getText().split(" ");//split ile bölerek sadece 2. sonucu yazdirdik
        System.out.println("sonucSayisi = " + sonucSayisi[2]);

        //İlk ürüne tıklayın
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //Sayfadaki tüm basliklari yazdiralim
        //Baslik tagi h1.... olarak baslar
        List<WebElement> sayfaBasliklariListesi = driver.findElements(By.xpath("//h1"));
        for (WebElement w : sayfaBasliklariListesi) {
            System.out.println("Sayfa Basliklari:" + w.getText());//Sırasi ile sayfa basliklari listesindekileri w ye atayip bitene kadar getText ile yazdiracaktir
            //Lambda ile sayfa basliklarini yazdiriniz
            //sayfaBasliklariListesi.forEach(t -> System.out.println("Lambda ile yazilmis hali:" + t.getText()));

            //sayfayi kapatiniz
            driver.close();

        }
    }


}


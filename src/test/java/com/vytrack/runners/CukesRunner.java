package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

                     //note: bazen test case is passing but there might be some problems (farkina varmadigimiz)
@RunWith(Cucumber.class)
@CucumberOptions( //my report is taking information from json that is a plugin in pom.xml
        plugin = {"json:target/cucumber.json",        //json i target klasorunde cucumber a ekledik (cukesrunner i run edince o klasorun icinde belirdi)
                "html:target/default-html-reports",   //solda target in icinde default-html-reports olustu (bunda we dont need to run with maven
                                                      // , package right click--> index.html right click--> open in browser ,  yani maven +verify demiyoruz)-bunda diagram gibi seyler yok ,
                                                      // bize hitap ediyor ,manager lara degil cucumber in simple report u , json is much better in reporting
        "rerun:target/rerun.txt"  } ,  // bu kisim ile solda target in icinde rerun.txt olustu bize hata veren class line numaralarini verir, hangi senaryolar hata verir gosterir
                                       //we formed a FailedTestRunner class in runner package to run only failed test cases



        features = "src/test/resources/features",   // virgul ile yeni bir ozellik ekliyorum , features ile baglanti sagladi
        glue = "com/vytrack/step_definitions",      //glue bana benim step definitions larimin yerini buluyor ve baglanti sagliyor
        dryRun = false,
        tags = "@smoke"

)

 public class CukesRunner { //bu class ile test leri run ediyoruz
}

/*plugin deki json normalde stores date ,  in plugin in line 10 , json is keeping execution
info related to out last execution , so my report is taking information from json */

// **** junit ve io.cucumber dependencies ayni version a sahib olmali pom.xml de

// Somehow we need to tell , hey cucumber , hey cukesrunner ,you should not be looking at the runners package ,
// my features files are under resources and in features folder

//Peki buna nasil ulasiriz?   --->    features="src/test/resources/features"  note lara bak

//you can copy paste the path too
//for resources you can go outside of the java folder (for path) but for glue you can start inside the java --> from com file
//"com/vytrack/step_definitions"

//resources daki login.feature is not java file

// login.feature da yazarken gherkin language kullandik

//dryRun=true dersek   step defintionlar ki given, when , ve then in icindeki codelar run olmaz , sadece login.feature da herhangi birsey login step definition
// a aktarilmismi onu kontrol ederiz , mili saniye icerisinde sonuc cikar , missing steps varsa consolda copy paste ile login step definitionslara kopyalariz
//dryRun=false dersek ayni islem ama code larda calisiyor , ama eksik olan step definition lari bulmak daha uzun zaman aliyor

//login.feature in icinde sari renkte olanlar undefined step definitions

//login.feature file inin icinde eger biz sadece bir test scenario  sunun calismasini isitiyorsak ,  scenario: yazisinin
// hemen ustune @ koyup yanina anlamamzi saglayan bir baslik yada yazi yazariz

//ornegin -->  @ Store_Manager    boyle yazinca sadece bu test run olabilir birde bu islemi yaparken tags= "store_manager "
// diye cukes runner class inin icinde eklemeliyiz

//birkactane annotation ayni anda ekleyebiliriz ama tags = "bu aralikta ne yaziyorsa o test run olur "

//ilginc ornegin @login    den birkactane test scenario larinin uzerinde ayni olacak sekilde yazdim ve bunu tags a da
// ekledim bu durumda eklediklerimin hepsi calisir

//smoke test yapmak istedim , tek yapmam gereken sectigim scenarios larin uzerine@smoke yazarim ve tags=smoke derim , bu kadar

//eger butun scenario larin run olmasini istiyorsam login.feature file inin icinde Feature nin ust kisminda @login derim
// , butun scenario lara gozle gorulmeyen
//bir @login eklenmis olur ve tags "login" olacak sekilde ayarlarim  (note : login ismi degistirilebilir , onemli olan mantikli bisey yazmak )
/*

tags= "@login and @wip"   bunlarin ikisi varsa run olur         (wip--working prosesS)
tags= "@login and not @wip"     login ve wip taglari beraber varsa test run olmaz    ---> Feature nin usutune @login koydugunu dusun
tags= "@login and not @wip and not @salesmanager"
tags= "not @wip"      wip tagi olmayanlar calisir   (version 5 ten once (not) kismi  kullanilmiyordu
//feature file inin icindeki yazilar gherken language ile yazilyor
 */

// virguller i koymayi unutma yeni bir ozellik koyarken

//plugin={"json:target/cucumber.json"}, bunu ekledik ve json a baglanti kurduk
//json is another type of storing  information , we use to store information in a key and value structure , in api deslerinde detayli ogrenecegiz ileride

//bu adimdan sonra pom xml e plugin copy paste etti (word file a bak masaustu day 28)   ==> pom xml de bulunan version lar onemli ,aklinda tut

//<!-- once pom xml i ac ==>sonra intellij de en sagda mavena tikla , daha sonra lifecycle klasorune tikla, ve sonra
//        verify a tikla ==> bunun sonucunda sol taraftaki intellij consolundaki target
//        klasorunun icerisinde cucumber html reports klasoru olusur ==> sonra bu klasore tikla ==> any of the overview u sec==>
//        right click==>open in==> choose a browser==> and report
//  consolu silmek  ve report lari silmek icin ==> en sag maven a tikla===> lifecycle===> click clean (boylece target file silinir,
//  verify a tiklayinca tekrar geri doner)
//  EUCucumberSelenium (projenin isminin) uzerinde-->saga tikla---> file--> configuration.propertirties olustur
//  day 28 de pages, utilities ve configuration properties ekledik

//login.feature file ini ac , herhangi bir step def.. -in uzerine gel --> command e basarak mous ok unu uzerlerinde hareket ettir-->
// ve sectigin birinin uzerine tikla --> bu sekilde onun codunun yazilacagi yere kisa yoldan ulasirsin
//ders esnasinda hangi senaryo uzerinde calisiyorsa genellikle .feature da uzerine @wip  ekledi  @wip (working peosess}

//day 32 de paralel execution icin -- Driver class ve pom.xml updated.sonra features bazi file lara @smoke ekledim paralel execution icin

//sonra intellijy sag taraftan--> maven--> lifecycle-->verify tikla yada intellij terminalinde mnv verify  yaz tikla yada
//intellij in terminalinde mvn verify    yaz ve tikla --> bunu yapinca birden fazla chrome browser eszamanli isi boluserek test executiona basladi

//3 ten fazla feature da @smoke koyarsak bilgisayar zorlanabilir --bilgisayarin gucu onemli
//test execution baslayinca--web sayfasi chrome ile acilir--> acilan pencereyi mouse ile tut ve hareket ettir--> hemen altinda baska bir chrome web
// sayfasinin acilmis oldugunu goreceksin

//paralel test execution icin acilan chrome web sayfasi sayisi= kac tane farkli feature file inin icinde @smoke var

//*****day 32_ de intellijy terminal---> mvn verify -Dbrowser=firefox  diye yazdi ve browser i degistirdi paralel execution icin

//cuke runner-->tags=wip yaziyorr ben ama @smoke kullanmak istiyorum wip e dokunmadan tags nasil degisitirilir?
//****cevap cukes runner da tags ="wip" -->intellj terminal--> then  mvn verify -Dcucumber.options="--tags @smoke"  diye yaz

//****maven-->verify tiklayinca  hem cukesrunner hemde failedtestrunner      calisir
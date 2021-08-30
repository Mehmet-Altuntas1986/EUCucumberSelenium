package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
                                        //option+comment+l ile sayfaya duzen verili
                                        // bu class i olusturduktan sonra pom.xml e git ve bunu  <include>**/*FailedTestRunner.java</include> ekle
                                        //sonra sag panelden click maven--> click verify --> it will execute cukesrunnner first, sonra failed testrunner baslar
                                     //bu islemden sonra target klasorunun icnde failed html report---> index--< open with any browser --> sadece failed test caseleri goruruz
                //dk 50 -53 day 31 video isin ozetini veriyor
                 //en az iki kez testleri run et ve hatali olanlari manuel olarak ta bak, emin olunca rapor edip bildir
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"@html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "com/vytrack/step_definitions"


)
public class FailedTestRunner {
}

package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
                                        //option+comment+l ile sayfaya duzen verili
                                        // bu class i olusturduktan sonra pom.xml e git ve bunu  <include>**/*FailedTestRunner.java</include> ekl//sonra sag panelden click maven--> click verify --> it will execute cukesrunnner first, sonra failed testrunner basla//bu islemden sonra target klasorunun icinde failed html report---> index-->open with any browser --> sadece failed test caseleri goruruz
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

//To rerun failed tests only, we created FailedTestRunner under runner package.
// Then we use maven verify phase to execute both CukesRunner and FailedTestRunner

/*
Maven
Maven is build management tool in java.There are other build tools in java
 such as gradle and ant.
 */
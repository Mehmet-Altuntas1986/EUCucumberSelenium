package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before            //bunu yazarken cucumber a ait olmasina dikkat et , iki tane var biri selenium digeri cucumber--> burdaki
                                           // before ve after butun test senariolarinda run olur annotation olmadigindan --> cukesrunner ile run et-->
      public void setUp() {
        System.out.println( "\tthis is coming from BEFORE" );
    }

        @After // CHOOSE CUCUMBER , SELENIUM DADA AFTER METHODU VAR
        public void tearDown (Scenario scenario) {
        if(scenario.isFailed()){
            final byte[] screenshot=((TakesScreenshot) Driver.get() ).getScreenshotAs( OutputType.BYTES );
            scenario.attach( screenshot,"image/png","screenshot" );
        }
            Driver.closeDriver();
        }

    @Before ("@db")           // cucumber is smart  --> navigationMenu.feature icinde bu annotation i bir senaryoya uyguladim,
                                                                // boylece before ve after methodu sadece ona uygulanir ,
                                                        // bunu database or api connection lazim olunca kullanacagiz ileride

    public void setUpdb() {
        System.out.println( "\tconnecting to database..." );
    }

    @After("@db") //
    public void closedb () {
        System.out.println("\tconnecting to database...");
    }


}


//there is no connection between feature files and hooks. Hooks will run always so we need to be careful about what we use inside
//but we have also custom hooks that is running if we have same tag on top of scenarios

//("@db")   boyle bir seyi database or api conncetion oldugu zaman kullanacagiz , ornegin 100 tane test senaryosu var
// ve sadece 20 tanesi databese ile iliskili , butun test leri bununla run etmek  -extends execution time   -- it is gonno put burden to database

//@db senaryo larin oldugu future file inda bunu koydugum yerlerde ---> bu senaryo needs databese connection  --db yi farkli bir isimlede yazabiliriz

//feature file in icindeki senaryolar  , step_definitions paket inin icindekiler tarafindan kullanilabilir, bu yuzden bu paketin icine Hooks u koyduk
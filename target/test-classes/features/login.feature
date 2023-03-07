@login @smoke
Feature: Users should be able to login
 """    --> note icin kullanabilirim yada
  Background
  Given the user is on the login page   --> bu line asagidaki scenerio da ayni oldugu icin burda Bacground ile kullanilabilir
 """
  @driver @VYT-123
  Scenario: Login as a driver
    Given the user is on the login page
    When the user enters the driver information
    Then the user should be able to login

  @sales_manager @VYT-123
  Scenario:  Login as a sales manager
    Given the user is on the login page
    When the user enters the sales manager information
    Then the user should be able to login

  @store_manager @smoke
  Scenario: Login as a store manager
    Given the user is on the login page
    When the user enters the store manager information
    Then the user should be able to login



    #Given the user is on the login page -->  bu senaryo yukaridaki senaryolarin hepsinde var,
    # biz bunlari senaryolardan silip en ustte  Feature in hemen altinda Background: ve altina bu senaryoyu
    # yapistirabiliriz .bunu kullanabiliriz eger alttaki butun senaryolar icin ortaksa ornegin

    # @login
    #Feature: Users should be able to login
    #Background:

    Given the user is on the login page
    #buradan asagida senaryolar var ama backgroundaki senaryo iclerinden silinmis halde
    #cucumber keys ve diger ozellikler i ogrenmek icin cucumber in sitesinde guzel bilgiler mevcut

    """
  cucumber.io/docs/gherkin/reference/   --> buradan background i inceleyebilirsin
    """



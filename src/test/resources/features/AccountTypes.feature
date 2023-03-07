Feature: Account types
  @wip @smoke
  @AC-206
  Scenario: Test1
    Given the user logged in as "driver"
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar Events - Activities"
  @wip
  Scenario: Sales manager user
    Given the user logged in as "sales manager"
    When the user navigates to "Customers" "Accounts"
    Then the title contains "Accounts - Customers"

  @wip @smoke
  Scenario: Store manager user
    Given the user logged in as "store manager"
    When the user navigates to "Customers" "Contacts"
    Then the title contains "Contacts - Customers"
#DAY31 DE-  hata vermesi icin bir harfi degistirdi -CustomerS- ,VE BU SAYFADAKI SENARYOLARIN BASINA @wip EKLEDI

 Scenario Outline: Login with different accounts <userType>

    Given the user logged in as "<userType>"
    When the user navigates to "<tab>" "<module>"
    Then the title contains "<title>"

    Examples:
      | userType      | tab        | module          | title                                                              |
      | driver        | Fleet      | Vehicles Model  | Vehicles Model - Entities - System - Car - Entities - System       |
      | driver        | Customers  | Accounts        | Accounts - Customers                                               |
      | driver        | Customers  | Contacts        | Contacts - Customers                                               |
      | driver        | Activities | Calendar Events | Calendar Events - Activities                                       |
      | driver        | System     | Jobs            | Jobs - System                                                      |
      | sales manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | sales manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | sales manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | sales manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | sales manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | sales manager | System     | Jobs            | All - Jobs - System                                                |
      | store manager | Fleet      | Vehicles        | All - Car - Entities - System - Car - Entities - System            |
      | store manager | Fleet      | Vehicles Model  | All - Vehicles Model - Entities - System - Car - Entities - System |
      | store manager | Customers  | Accounts        | All - Accounts - Customers                                         |
      | store manager | Customers  | Contacts        | All - Contacts - Customers                                         |
      | store manager | Activities | Calendar Events | All - Calendar Events - Activities                                 |
      | store manager | System     | Jobs            | All - Jobs - System                                                |
      | store manager | System     | Menus           | All - Menus - System                                               |


  Scenario Outline: Different user types
    Given the user logged in as "<userType>"

    Examples:
      | userType      |
      | driver        |
      | admin         |
      | store manager |
      | sales manager |



#account types.feature  --day 30 daki ders
    #we are gonno pass multiple values , we dont wanna change the step definitions . ornegin " elma"  "armut" 2 tae var
   # yanina 1 tane daha ekleseydim step definition i yeniden duzenlemek zorunda kalacaktim, bunu |  |  boyle yapinca
   # yenilerini eklemek step definitions larin degismesine sebebiyet vermez

  #bu sayfada dikkat edersen test case ler ayni ama test datalari, verileri farkli, (same test case with different test data =DDT)
  # HOW WE ARE DOING dDT=DATA DRIVEN TESTING (SAME TEST CASE WITH DIFFERENT TEST DATAS
  #senaryo outline varsa examples koymak zorundayiz
  # "<userType>"  this is a special way to name columns
  #if we are testing with 500 data ,cucumber is not the best option dedi, hangisi best option? test ng , testng api test icinde daha iyi
  #row lar sirayla test oluyorlar
  #line 22-46 arasinda ornegin  2d array to my test execution
  #we can use testng with cucumber too
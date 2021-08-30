Feature: Contacts page

  Scenario:Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Customers" "Contacts"
    Then default page number should be 1

  @wip
  Scenario: Verify Create Calender Event
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendars"
   #added "s" at the end of calendar to fail

  Scenario: Menu Options Driver
    Given the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |

#buradakiler expected list , actual list is in the website

  Scenario: Menu Options Sales Manager
    Given the user logged in as "sales manager"
    Then the user should see following options
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |

#alltaki senaryo da map kullaniliyor , list of maps kullanilmiyor , cunku multiple username, password vs yok
  @wip
  Scenario Outline: login as a given <user>
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | <user>      |
      | password  | UserUser123 |
      | firstname | <firstName> |
      | lastname  | <lastName>  |
    Then the user should be able to login
    Examples:
      | user           | firstName | lastName  |
      | user10         | Brenden   | Schneider |
      | storemanager85 | <Stephan> | Haley     |


# option +7 ile  | bu isareti olusturuyoruz
  #fn  + sag sol ok
  #option+command+L  ile yukaridaki pipeline lar belirli bir duzen aliyor, guzel gorunum kazaniyor

  #line 39 a gelip @wip koydu, bunu calistigi senaryoya getiriyor, surekli yerini degistiriyor,
  #daha sonra cukesrunner a gidip dryrun i true yapti ve run etti class i ve boylece hizli bir sekilde missing step
  # definitions consolda belirdi , onlari alip contacts definitions a kopyaladi ve codu yazdi , sonra birdaha false yazdi ve run etti

# numara 10 daki scenario yu bilerek hata verdirdi rapor almak icin, peki rapor almadan once ne yapariz?
  #once sagdan maven--> verify a tikla --> solda targetin icinde html guncellenir kodlarimizin son haline gore-->
  # cucumber-html reports u sec-->right click--> open in any browser
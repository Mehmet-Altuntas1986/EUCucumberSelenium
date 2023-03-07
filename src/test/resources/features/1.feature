Feature: Default

	
	@AC-206
	Scenario: Test1
		Given the user logged in as "driver"
		When the user navigates to "Activities" "Calendar Events"
		Then the title contains "Calendar Events - Activities"
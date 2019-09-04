Feature: Booking.com search

  Scenario: Searching Hilton on Booking.com
    Given Input keyword for searching "Hilton"
    When User does search on Booking
    Then Booking shows "Hilton Sharm Waterfalls Resort"
    And  rating should be "7,0"
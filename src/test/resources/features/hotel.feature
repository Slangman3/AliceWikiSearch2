Feature: Booking.com search
  Scenario: Searching Hilton on Booking.com
    Given Input keyword for searching "Hilton"
    When User does search Hilton on Booking
    Then Booking opened page shows Hilton Sharm Waterfalls Resort with 7.0 "rating"
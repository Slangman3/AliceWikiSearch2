Feature: Booking.com search
  Scenario: Searching Hilton on Booking.com
    Given Input keyword for searching "Hilton"
    When User does search Hilton on Booking
    Then Booking opened page shows DoubleTree by Hilton with 9.4 "rating"
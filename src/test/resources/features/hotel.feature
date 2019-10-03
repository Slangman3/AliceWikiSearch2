Feature: Booking.com search

  Scenario: Searching Hilton on Booking.com
    Given Input keyword for searching "Юбилейный"
    When User does search on Booking
    Then Booking shows "Отель Юбилейный"
    And  rating should be "8,3"
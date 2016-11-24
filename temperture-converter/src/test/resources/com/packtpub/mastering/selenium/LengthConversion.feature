Feature: Convert between different unit of length

  Formula:


  Scenario: Convert to Feet from  Meter

    Given I want to convert 10 Meter to Feet
    When I input the value of Meter 10 in text field
    Then It should be converted to Feet as 32.8084
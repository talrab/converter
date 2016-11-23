Feature: Convert between different unit of temperatures

  Formula: C/5 = (F - 32)/9
  C = 5(F - 32)/9 = 5(158 - 32 =)/9  = 70

  Scenario: Convert  to Celsius from  Fahrenheit

    Given I need to  convert 158 degree Fahrenheit to Celsius
    When I then input the value of Fahrenheit as 158 in text field
    Then It then should be converted to Celsius as 70 degree
Feature: Convert between different unit of temperatures

  Formula: C/5 = (F - 32)/9
  C = 5(F - 32)/9 = 5(98.6 - 32 =)/9  = 37

  Scenario Outline: Convert  to Celsius from  Fahrenheit

    Given I want to  convert <Fahrenheit> degree Fahrenheit to Celsius
    When I input the value of Fahrenheit as <Fahrenheit> in text field
    Then It should be converted to Celsius as <Celsius> degree
    Examples:
      |Fahrenheit   |Celsius|
      |98.6         |37     |


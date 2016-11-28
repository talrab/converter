Feature: Test the Converter drop down options

  Formula:


  Scenario Outline: Verifying different converters first option.
    Given I open the converter web page
    When In the drop down I choose <type>
    Then the first selected messurement should be <status>

    Examples:
      | type      | status         |
      | Speed     | Miles per hour |
      | Frequency | Hertz          |
      | Time      | Second         |
      | Energy    | Joule          |



Feature: Login page feature


  Scenario Outline: Login with different set of data
#    Given User is on the login page
    When user enters username and password from given sheetname "<SheetName>" and rownumber <RowNumber>
    And User clicks the log in button
    Then User should see the Home Page title from given sheetname "<SheetName>" and rownumber <RowNumber>
    And User should see invalid credentials message from given sheetname "<SheetName>" and rownumber <RowNumber>
    And User should see no user message from given sheetname "<SheetName>" and rownumber <RowNumber>
    Examples:
      | SheetName | RowNumber |
      |Login      |0          |
      |Login|1|
      |Login|2|
      |Login|3|
      |Login|4|









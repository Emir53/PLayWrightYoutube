Feature: Testing The Cart Page
  Background: Logged İn
    Given I Opened The Browser
    And CLicked On Login
    When I Log in correct e-mail "emir@mail.com" and password "emir"
    Then I checked İf I logged in


  Scenario Outline: Search a pruduct
    Given I clicked on Products button
    And I searched for product "<product>"
    When I click on Search Button
    Then I check İf Expected visible "<product>"
    Examples:
      | product |
      | Blue Top         |



Feature: Testing The Cart Page
  Background: Logged İn
    Given I Opened The Browser
    And CLicked On Login
    When I Log in correct e-mail "emir@mail.com" and password "emir"
    Then I checked İf I logged in

  Scenario Outline:  add product and place an order
    Given I Clicked View product
    And I added product on my cart
    And I proceed to Checkout
    When I Enter The Cart İnformations "<nameOnCart>" "<cartnumber>"  "<expdate>"  "<mm>" "<yy>"
    Then I complete Order Then check if order created
    Examples:
      | nameOnCart | cartnumber | expdate | mm | yy |
      | deneme | deneme | 123 | 123 | 123 |


  Scenario: Add product Then remove
    Given I Clicked View product
    And I added product on my cart
    When I remove order from cart
    Then I should see if product removed





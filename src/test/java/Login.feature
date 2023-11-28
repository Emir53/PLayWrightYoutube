Feature: login
  Background: Opens the Website And Navigates To Login Page
    Given I Opened The Browser
    And CLicked On Login

    Scenario Outline: login with correct cred.
      When I Log in correct e-mail "<usrname>" and password "<pwd>"
      Then I checked İf I logged in
      Examples:
        | usrname | pwd |
        | emir@mail.com | emir |


    Scenario Outline: login with correct cred.
    When I Log in with invalid e mail "<usrname>" and password "<pwd>"
    Then I checked İf I get an error message
      Examples:
        | usrname | pwd |
        | emir@mail.com | incorrectpassword |


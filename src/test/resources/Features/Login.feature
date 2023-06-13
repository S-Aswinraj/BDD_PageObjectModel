Feature: Login functionality in book cart

  Background:
    Given User is in book cart homepage
    When user clicks on login button
@smoke
  Scenario: login with valid credentials
    And user inputting valid credentials username "abcxy" password "Abc1234!"
    Then login should be successful
    And user quit browser

    Scenario: Login with invalid credentials
      And user inputting valid credentials username "abcxyz" password "Abc1234"
      But Login should fail
      And user quit browser
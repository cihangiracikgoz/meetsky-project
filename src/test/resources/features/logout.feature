Feature: Meetsky log out functionalty
  User Story: As a user, I should be able to log out.

  @METSK-381
  Scenario: User can log out and ends up in Login page
    Given user log in with valid credentials in login page
    When user is on files page
    And user click the profile icon on the upper right of the page
    And user click the log out button
    Then user should come back to the login page

    @wip
  Scenario: User can not go to home page again by clicking step back button
    Given user log in with valid credentials in login page
    When user is on files page
    And user click the profile icon on the upper right of the page
    And user click the log out button
    And user should come back to the login page
    And user click go back button
    Then user can not go to home page and stay in login page





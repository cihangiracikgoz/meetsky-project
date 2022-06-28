Feature: Meetsky login functionality
  User Story: As a user, I should be able to login.

  @METSK-345
  Scenario: User can login with valid credentials
    Given user is on Meetsky login page
    When user type his valid username
    And user type his valid password
    And user click Log in button
    Then user should see Files-Meetsky-QA header

  Scenario: User can not login with invalid username and password
    Given user is on Meetsky login page
    When user type invalid username
    And user type invalid password
    And user click Log in button
    Then user should see "Wrong username or password" error

  Scenario: User can not login with invalid username even if password is correct
    Given user is on Meetsky login page
    When user type invalid username
    And user type his valid password
    And user click Log in button
    Then user should see "Wrong username or password" error

  @wip
  Scenario: User can not login with invalid password even if username is correct
    Given user is on Meetsky login page
    When user type his valid username
    And user type invalid password
    And user click Log in button
    Then user should see "Wrong username or password" error






@METSK-302 @wip
Feature: Meetsky login functionality
  User Story: As a user, I should be able to login.

    @METSK-345
    Scenario: User can login with valid credentials
      Given user is on Meetsky login page
      When user type his valid username
      And user type his valid password
      And user click Log in button
      Then user should see Files-Meetsky-QA header

    @METSK-347
    Scenario: User can not login with invalid username and password
      Given user is on Meetsky login page
      When user type invalid username
      And user type invalid password
      And user click Log in button
      Then user should see Wrong username or password error

    @METSK-348
    Scenario: User can not login with invalid username even if password is correct
      Given user is on Meetsky login page
      When user type invalid username
      And user type his valid password
      And user click Log in button
      Then user should see Wrong username or password error

    @METSK-349
    Scenario: User can not login with invalid password even if username is correct
      Given user is on Meetsky login page
      When user type his valid username
      And user type invalid password
      And user click Log in button
      Then user should see Wrong username or password error

     @METSK-350
    Scenario: User can not login without using password
      Given user is on Meetsky login page
      When user type his valid username
      And user click Log in button
      Then user should see the Please fill out this field message on password input box

    @METSK-351
    Scenario: User can not login without using username
      Given user is on Meetsky login page
      When  user type his valid password
      And   user click Log in button
      Then  user should see the Please fill out this field message on username input box

    @METSK-364
    Scenario: User can not login without using both
      Given user is on Meetsky login page
      When  user click Log in button
      Then  user should see the Please fill out this field message on username input box

    @METSK-365
    Scenario: User should see the password in form of dots
      Given user is on Meetsky login page
      When  user type his valid password
      Then  user should see the password as form of dots

    @METSK-367
    Scenario: User can see the password explicitly
      Given user is on Meetsky login page
      When user type his valid password
      And user click the eye image to see the password
      Then user should see the password explicitly





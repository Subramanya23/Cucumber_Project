@activity1_1
Feature: Create a new user

Scenario: Visit the site’s backend and create a new user
    Given Open a browser
    When Navigate to Alchemy Jobs and log in
    Then Locate the left hand menu and click the menu item that has Users
    And Locate the Add New button and click it
    Then Fill in the necessary details
    And Click the Add New User button
    Then Verify that the user was created
    And Close the browser
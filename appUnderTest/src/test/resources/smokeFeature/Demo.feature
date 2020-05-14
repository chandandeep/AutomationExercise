@Feature
Feature: Complete Order of T-Shirt


Background:
  Background: User is Logged In
    Given User click on Sign in on index page
    When Login to the application with valid credentials
    Then User should be logged in

  @smoke
  Scenario: Login to application and update the first name
    Given Navigate to Personal Information on My account page
    When Save the form after updating the first name
    Then Success message "Your personal information has been successfully updated." should be displayed

  @Test1
  Scenario: Buy a T-Shirt and validate on order history page
    Given User navigates to "T-Shirts" section and start purchasing the first item
    When User completes the purchase
    And User navigate back to orders after confirming the order on Payment page
    Then Verify that Order is displayed in order history page
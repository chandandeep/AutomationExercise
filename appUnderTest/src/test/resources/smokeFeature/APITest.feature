Feature: End to End Test for Books API

  Background: User generates token for Authorisation

    Given I am an authorized user

  @API
  Scenario: the Authorized user can Add and Remove a book.
    Given A list of books are available
    When I Search the ISBN "9781449325862" in the list
    Then Status Code is "200"
    And Title of book is "Git Pocket Guide"

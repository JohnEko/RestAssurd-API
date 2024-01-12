Feature: Verify different GET request on ReatAPI

  Scenario Outline: Verify a GET call
    Given I performed a GET call on the "<url>"
    Then Response "<statusCode>" is called

    Examples:
    | url    | statusCode |
    | /posts | 200   |


  Scenario: Verify an author is in post request
    Given I made a GET  request for "/post"
    And I perform Get for the id number "1"
    Then I should see the author name as "James"

  Scenario: Verify the collections on the author request
    Given I perform a GET request for "/posts"
    Then I should see the author name as


  Scenario: Verify the PathParameter of the author request
    Given I perform a GET request for "/posts"
    Then I should the path parameter exist

  Scenario: Verify the QueryParameter of the author request
    Given I perform a GET request for "/posts"
    Then I should the Query parameter exist

  Scenario: Verify the POST operation fr the new author
    Given I perform a POST request for "/posts"

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

  Scenario: Verify the POST operation for the new author
    Given I perform a POST request for "/posts"

  Scenario : Verify the Post request from a user
    Given I perform a POST request for "/posts/{userNum}/profile" with body
        |name | profile |
        |Bada | 2       |
    Then I should the see the request arrive as "Bada"


Scenario: Verify DELETE operation after post
  Given I ensure to Perform POST operation for "/posts" with body
      | id |  title        | author        |
      | 6  |  API Testing  | QA Automation |

  And I perform a DELETE operation for "/posts/{postid}"
      | postid |
      | 6      |
  And I perform a GET request with path parameter for "/posts/{postid}
      | postid |
      | 6      |
  Then I should not see the body with title as "API Testing"

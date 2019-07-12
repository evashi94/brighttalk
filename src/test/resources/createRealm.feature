Feature: create a realm with name and description

  Scenario: client successfully creates a realm
    When the client posts to /service/user/realm with name and description
    Then the client receives status code of 201
    And the client receives realm details
      | id | name | description | key |

  Scenario: client dose not provide realm name when creates a realm
    When the client posts to /service/user/realm without a name
    Then the client receives status code of 400
    And the client receives message InvalidRealmName

  Scenario: client tried to create a realm with a name already exits in database
    When the client posts /service/user/realm with name exists in database
    Then the client receives status code of 400
    And the client receives message DuplicateRealmName
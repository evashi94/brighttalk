Feature: get details of an individual realm

  Scenario: client successfully gets realm data
    When the client calls /service/user/realm/1
    Then the client receives status code of 201
    And the client receives realm details
      | id | name | description | key |

  Scenario Outline: client tried to get realm data with an invalid realm id
    When the client calls /service/user/realm/<invalidRealmId>
    Then the client receives status code of 400
    And the client receives message InvalidArgument

  Examples:
    | invalidRealmId |
    | !@#$%^&*       |
    | 1!2@3#4$)      |
    | 99.3456        |
    | -1563423       |

  Scenario: client tried to get realm data using an realm id which not exit in database
    When the client calls /service/user/realm/999999
    Then the client receives status code of 404
    And the client receives message RealmNotFound
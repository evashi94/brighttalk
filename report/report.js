$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("createRealm.feature");
formatter.feature({
  "line": 1,
  "name": "create a realm with name and description",
  "description": "",
  "id": "create-a-realm-with-name-and-description",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "client successfully creates a realm",
  "description": "",
  "id": "create-a-realm-with-name-and-description;client-successfully-creates-a-realm",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the client posts to /service/user/realm with name and description",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "the client receives status code of 201",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "the client receives realm details",
  "rows": [
    {
      "cells": [
        "id",
        "name",
        "description",
        "key"
      ],
      "line": 7
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.theClientPostsToServiceUserRealmWithNameAndDescription()"
});
formatter.result({
  "duration": 3075010151,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 35
    }
  ],
  "location": "StepDefinition.theClientReceivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 54973742,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.theClientReceivesRealmDetails(String\u003e)"
});
formatter.result({
  "duration": 319944431,
  "status": "passed"
});
formatter.scenario({
  "line": 9,
  "name": "client dose not provide realm name when creates a realm",
  "description": "",
  "id": "create-a-realm-with-name-and-description;client-dose-not-provide-realm-name-when-creates-a-realm",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 10,
  "name": "the client posts to /service/user/realm without a name",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the client receives status code of 400",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "the client receives message InvalidRealmName",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.theClientPostsToServiceUserRealmWithoutAName()"
});
formatter.result({
  "duration": 580840568,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 35
    }
  ],
  "location": "StepDefinition.theClientReceivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 735200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "InvalidRealmName",
      "offset": 28
    }
  ],
  "location": "StepDefinition.theClientReceivesMessage(String)"
});
formatter.result({
  "duration": 6174807,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "client tried to create a realm with a name already exits in database",
  "description": "",
  "id": "create-a-realm-with-name-and-description;client-tried-to-create-a-realm-with-a-name-already-exits-in-database",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "the client posts /service/user/realm with name exists in database",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "the client receives status code of 400",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "the client receives message DuplicateRealmName",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinition.theClientPostsServiceUserRealmWithNameExistsInDatabase()"
});
formatter.result({
  "duration": 41284834,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 35
    }
  ],
  "location": "StepDefinition.theClientReceivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 1662660,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DuplicateRealmName",
      "offset": 28
    }
  ],
  "location": "StepDefinition.theClientReceivesMessage(String)"
});
formatter.result({
  "duration": 5725880,
  "status": "passed"
});
formatter.uri("getRealm.feature");
formatter.feature({
  "line": 1,
  "name": "get details of an individual realm",
  "description": "",
  "id": "get-details-of-an-individual-realm",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "client successfully gets realm data",
  "description": "",
  "id": "get-details-of-an-individual-realm;client-successfully-gets-realm-data",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the client calls /service/user/realm/1",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "the client receives status code of 201",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "the client receives realm details",
  "rows": [
    {
      "cells": [
        "id",
        "name",
        "description",
        "key"
      ],
      "line": 7
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "1",
      "offset": 37
    }
  ],
  "location": "StepDefinition.theClientCallsServiceUserRealmIdWithRealmId(String)"
});
formatter.result({
  "duration": 72334303,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 35
    }
  ],
  "location": "StepDefinition.theClientReceivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 2082653,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.theClientReceivesRealmDetails(String\u003e)"
});
formatter.result({
  "duration": 18744564,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 9,
  "name": "client tried to get realm data with an invalid realm id",
  "description": "",
  "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "the client calls /service/user/realm/\u003cinvalidRealmId\u003e",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the client receives status code of 400",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "the client receives message InvalidArgument",
  "keyword": "And "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;",
  "rows": [
    {
      "cells": [
        "invalidRealmId"
      ],
      "line": 15,
      "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;;1"
    },
    {
      "cells": [
        "!@#$%^\u0026*"
      ],
      "line": 16,
      "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;;2"
    },
    {
      "cells": [
        "1!2@3#4$)"
      ],
      "line": 17,
      "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;;3"
    },
    {
      "cells": [
        "99.3456"
      ],
      "line": 18,
      "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;;4"
    },
    {
      "cells": [
        "-1563423"
      ],
      "line": 19,
      "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 16,
  "name": "client tried to get realm data with an invalid realm id",
  "description": "",
  "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "the client calls /service/user/realm/!@#$%^\u0026*",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the client receives status code of 400",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "the client receives message InvalidArgument",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "!@#$%^\u0026*",
      "offset": 37
    }
  ],
  "location": "StepDefinition.theClientCallsServiceUserRealmIdWithRealmId(String)"
});
formatter.result({
  "duration": 35895754,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 35
    }
  ],
  "location": "StepDefinition.theClientReceivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 608738,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "InvalidArgument",
      "offset": 28
    }
  ],
  "location": "StepDefinition.theClientReceivesMessage(String)"
});
formatter.result({
  "duration": 22454297,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "client tried to get realm data with an invalid realm id",
  "description": "",
  "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "the client calls /service/user/realm/1!2@3#4$)",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the client receives status code of 400",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "the client receives message InvalidArgument",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "1!2@3#4$)",
      "offset": 37
    }
  ],
  "location": "StepDefinition.theClientCallsServiceUserRealmIdWithRealmId(String)"
});
formatter.result({
  "duration": 29526937,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 35
    }
  ],
  "location": "StepDefinition.theClientReceivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 914588,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "InvalidArgument",
      "offset": 28
    }
  ],
  "location": "StepDefinition.theClientReceivesMessage(String)"
});
formatter.result({
  "duration": 9109340,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "client tried to get realm data with an invalid realm id",
  "description": "",
  "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;;4",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "the client calls /service/user/realm/99.3456",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the client receives status code of 400",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "the client receives message InvalidArgument",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "99.3456",
      "offset": 37
    }
  ],
  "location": "StepDefinition.theClientCallsServiceUserRealmIdWithRealmId(String)"
});
formatter.result({
  "duration": 26950797,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 35
    }
  ],
  "location": "StepDefinition.theClientReceivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 8852103,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "InvalidArgument",
      "offset": 28
    }
  ],
  "location": "StepDefinition.theClientReceivesMessage(String)"
});
formatter.result({
  "duration": 2412614,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "client tried to get realm data with an invalid realm id",
  "description": "",
  "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-with-an-invalid-realm-id;;5",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 10,
  "name": "the client calls /service/user/realm/-1563423",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "the client receives status code of 400",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "the client receives message InvalidArgument",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "-1563423",
      "offset": 37
    }
  ],
  "location": "StepDefinition.theClientCallsServiceUserRealmIdWithRealmId(String)"
});
formatter.result({
  "duration": 29789261,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 35
    }
  ],
  "location": "StepDefinition.theClientReceivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 3309338,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "InvalidArgument",
      "offset": 28
    }
  ],
  "location": "StepDefinition.theClientReceivesMessage(String)"
});
formatter.result({
  "duration": 5583561,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "client tried to get realm data using an realm id which not exit in database",
  "description": "",
  "id": "get-details-of-an-individual-realm;client-tried-to-get-realm-data-using-an-realm-id-which-not-exit-in-database",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "the client calls /service/user/realm/999999",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "the client receives status code of 404",
  "keyword": "Then "
});
formatter.step({
  "line": 24,
  "name": "the client receives message RealmNotFound",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "999999",
      "offset": 37
    }
  ],
  "location": "StepDefinition.theClientCallsServiceUserRealmIdWithRealmId(String)"
});
formatter.result({
  "duration": 25152402,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 35
    }
  ],
  "location": "StepDefinition.theClientReceivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 934269,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "RealmNotFound",
      "offset": 28
    }
  ],
  "location": "StepDefinition.theClientReceivesMessage(String)"
});
formatter.result({
  "duration": 8839385,
  "status": "passed"
});
});
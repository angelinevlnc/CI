Feature: Categories

Scenario: Send GET request to get all category
  Given I have a valid category endpoints
  When I send a request to get all category
  Then the response status code for get all category request should be 200
Scenario: Send GET request to get category by ID
  Given I have a valid category ID
  When I send a request to get a category by the valid ID
  Then the response status code should be 200 for success get category by id
  And receive valid category information
Scenario: Send GET request to get category by invalid ID
  Given I have an invalid category ID
  When I send a request to get a category by the invalid ID
  Then the response status code should be 404 for unsuccessfull request with invalid ID
Scenario: Delete Category
  Given I have a valid category ID to delete
  When I send a request to delete a category by the valid ID
  Then the response status code should be 200 for success category delete

Scenario: Add a new category
  Given I have valid category data
  When I send a request to create a category
  Then the response status code should be 200 for success add category
Scenario: Add a new category with empty fields
  Given I have empty category data
  When I send a request to create empty category
  Then the response status code should be 404



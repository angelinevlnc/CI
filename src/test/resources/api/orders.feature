Feature: Orders

Scenario: Send GET request to get all orders
  Given I have a valid orders endpoints
  When I send a request to get all orders
  Then the response status code should be 200 for success get request to get all orders
#Scenario: Send GET request to get orders by ID
#  Given I have a valid orders ID
#  When I send a request to get an order by the valid ID
#  Then the response status code should be 200 for valid order request
Scenario: Send GET request to get orders by invalid ID
  Given I have an invalid orders ID
  When I send a request to get an order by the invalid ID
  Then the response status code should be 404 for request with invalid id
Scenario: Add a new orders
  Given I have valid order data
  When I send a request to create an order
  Then the response status code should be 200 for success add order
Scenario: Add a new orders with empty fields
  Given I have empty order data
  When I send a request to create an empty order
  Then the response status code should be 400 for empty order


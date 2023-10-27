Feature: Product

Scenario: Send GET Request to Products
  Given I have a valid API endpoint for products
  When I send a GET request to the products endpoint
  Then I should receive a successful response with status code 200 for success get product request
  And the response should contain a list of products

Scenario: Send GET request to the product endpoint with a valid product ID
  Given I have a valid product ID
  When I send a GET request to the product endpoint with the valid product ID
  Then I should receive a response with status code 200 for success request with valid product ID
  And the response should contain detailed information about the product

Scenario: Add a new product
  Given I have valid details for a new product
  When I send a POST request to the product endpoint
  Then I should receive a response with status code 200

Scenario: Delete Product
  Given I have the ID of an existing product to delete
  When I send a DELETE request to the product endpoint
  Then I should receive a response with status code 200 for success product delete

Scenario: Get Product Comment
  Given I have valid product comment endpoint
  When I request the product comment with a valid ID
  Then the response status code should be 200 for success get comment request

Scenario: Get Product Rating
  Given I have valid product rating endpoint
  When I request the product rating with a valid ID
  Then the response status code should be 200 for success get ratings request

Scenario: Create Comment for product
  Given I have valid comment endpoint to add product
  When I create a product comment with a valid ID
  Then the response status code should be 201 for succesfull request to add comment

Scenario: Create Comment for product with invalid ID
  Given I have invalid comment endpoint to add product
  When I create a product comment with an invalid ID
  Then the response status code should be 404 for failed comment request

Scenario: Create Rating for product
  Given I have valid ratings endpoint to rate product
  When I assign a product rating with a valid ID
  Then the response status code should be 201 for success request to add rating

Scenario: Create rating for product with invalid ID
  Given I have invalid ratings endpoint to rate product
  When I assign a product rating with an invalid ID
  Then the response status code should be 404 for failed request to add rating
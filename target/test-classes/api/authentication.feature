Feature: Authentication

Scenario: Send request to login with empty credentials
  Given I have empty login credentials
  When I send a request to login with empty credentials
  Then the response status code should be 400
Scenario: Send request to login with wrong password
  Given I have valid username and wrong password
  When I send a request to login with wrong password
  Then the response status code should be 400 for wrong password login
Scenario: Send request to register with valid credentials
  Given I have valid registration data
  When I send a request to register with valid credentials
  Then the response status code should be 200 for valid register
  And return valid data
Scenario: Send request to register with empty credentials
  Given I have empty registration data
  When I send a request to register with empty credentials
  Then the response status code should be 400 for register with empty credentials

Scenario: Send request to register with used email
  Given I have registration data with a used email
  When I send a request to register with used email
  Then the response status code should be 400 for Register with used email
Scenario: Get user information
  Given I am authenticated with valid credentials
  When I send a request to get user information
  Then the response status code should be 200 for successesfull get
  And return valid user info


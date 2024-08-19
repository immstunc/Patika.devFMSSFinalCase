Feature: DB Foreign Keys and Columns Verification

  Scenario: Verify User Table Columns
    Given the "user" table exists in the database
    When a new user is created
    Then the "user" table should contain a "user_id" column with data type "UUID"
    And the "user" table should contain a "name" column with data type "VARCHAR(50)"
    And the "user" table should contain a "last_name" column with data type "VARCHAR(50)"
    And the "user" table should contain a "birthdate" column with data type "DATE"
    And the "user" table should contain a "national_id" column with data type "VARCHAR(20)"
    And the "user" table should contain a "phone_number" column with data type "VARCHAR(15)"
    And the "user" table should contain a "email" column with data type "VARCHAR(100)"
    And the "user" table should contain a "password" column with data type "VARCHAR(255)"
    And the "user_id" should be unique for each user


  Scenario: Verify Address Table Foreign Key to User Table
    Given the "address" table exists in the database
    And the "user" table contains a user with "user_id" equal to "123e4567-e89b-12d3-a456-426614174000"
    When a new address is created for this user
    Then the "address" table should contain a "user_id" column with data type "UUID"
    And the "user_id" in the "address" table should reference the "user_id" in the "user" table
    And the "address" table should contain a "street" column with data type "VARCHAR(100)"
    And the "address" table should contain a "city" column with data type "VARCHAR(50)"
    And the "address" table should contain a "postal_code" column with data type "VARCHAR(20)"


  Scenario: Verify Email Uniqueness in User Table
    Given the "user" table exists in the database
    And a user with email "john.doe@email.com" already exists
    When another user attempts to register with the email "john.doe@email.com"
    Then the database should not allow the registration
    And an error message "Email must be unique" should be returned


  Scenario: Verify License Table Foreign Key to User Table
    Given the "license" table exists in the database
    And the "user" table contains a user with "user_id" equal to "123e4567-e89b-12d3-a456-426614174000"
    When a new license is issued for this user
    Then the "license" table should contain a "user_id" column with data type "UUID"
    And the "user_id" in the "license" table should reference the "user_id" in the "user" table
    And the "license" table should contain a "license_number" column with data type "VARCHAR(50)"
    And the "license" table should contain an "issue_date" column with data type "DATE"
    And the "license" table should contain an "expiration_date" column with data type "DATE"


  Scenario: Verify National ID Uniqueness in User Table
    Given the "user" table exists in the database
    And a user with national ID "1234567890" already exists
    When another user attempts to register with the national ID "1234567890"
    Then the database should not allow the registration
    And an error message "National ID must be unique" should be returned

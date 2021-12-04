Feature: Test for PIM tab such as search, add and remove an employee

  Background: User is already authenticated and have access to PIM > EmployeeList tab

    Scenario Outline: Search an employee by name
      Given User can see Employee Information block
      When  User enters employee names <empNames>
      And   User click on search button
      Then  System should populate given name
      And   User should all the details related employee such as <jobTitle> and <empStatus>
      Examples:
      | empNames        | jobTitle              | empStatus             |
      | "David Morris"  | "Account Assistant"   | "Full Time Permanent" |
      | "Dominic Chase" | "VP-Client Service"   | "Full Time Permanent" |
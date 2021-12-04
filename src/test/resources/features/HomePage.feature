Feature: Test case about HRM home page functionality

  Background: HRM homepage must be working as expected

    Scenario: HRM Home page validation
      Given   user is able to open the browser with the valid url
      When    User see homepage
      And     System should verify the page title and current url
      Then    HomePage validation is completed


      Scenario Outline: : HRM Login validation
        Given   user is able to open the browser with the valid url
        When    User enters valid username <username>
        And     User enters the valid password <password>
        And     User clicks the submit button
        Then    System should authenticate user and redirect to Admin Dashboard page
        Examples:
          | username | password |
          | "Admin"  | "admin123" |


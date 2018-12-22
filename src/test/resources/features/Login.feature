#Author: SyntaxTeam

@Temp
Feature: Login feature

 Background:
   Given OrangeHRM logo is displayed
@smoke
 Scenario: Valid login
   When I enter "admin" and "admin123"
   And I click on login button
   Then I successfully logged in
@Regression
 Scenario Outline: Invalid login
   When I enter "<username>" and "<password>"
   And I click on login button
   Then I see error message "<errorMessage>"

   Examples:
     | username | password  | errorMessage             |
     | Admin    | Monkey123 | Invalid credentials      |
     | Monkey   | admin123  | Invalid credentials      |
     | Monkey   | Monkey123 | Invalid credentials      |
     |          | admin123  | Username cannot be empty |
     | Admin    |           | Password cannot be empty |



#Author: SyntaxTeam
Feature: Add, Modify, Delete Employee 

Background:
   And I logged into OrangeHRM
   And I clicked on PIM


 @tag
 Scenario: add employee
   When I navigated to the Add Employee Page
   When I provide the first name "Adam" , middle name "Lane" and last name "Good" of the employee
   Then I successfully added an employee

 @tag
 Scenario: edit employee
   And I navigated to the Employee List Page
   When I search for an added employee "Adam"

   Then I navigated to the employee profile
   And I can edit Employee information

 @tag
 Scenario: delete employee
   And I navigated to the Employee List Page
   When I search for an added employee "Adam" to delete
   Then I should be able to delete that employee

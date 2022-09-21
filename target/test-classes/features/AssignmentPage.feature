Feature: Heading of the assignment page

 Scenario: Validate the heading of the assignment page
 
 Given User is logged on to LMS website -AssignmentPage
 When User is on Manage Assignment page -AssignmentPage
 Then User should see a heading with text "Manage Assignment" on the page -AssignmentPage
 
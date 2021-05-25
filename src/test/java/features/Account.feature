Feature: Portal Login

Background: 
Given validate the browser
When browser is triggered
Then check if browser is started

@portalTest
Scenario: Home page default login
Given User is on Netbacking landing page 
When User login into application with "user_" and "1234" 
Then Home page is populate 
And Cards are displayed "true"

@portalTest
Scenario: Home page default login
Given User is on Netbacking landing page 
When User login into application with "user_2" and "1234" 
Then Home page is populate 
And Cards are displayed "false"


Scenario: Home page default login
Given User is on Netbacking landing page 
When User sign up with following details
| pablo | 12345 | pabloandresarg@gmail.com | Guatemala | 58940222 |
Then Home page is populate 
And Cards are displayed "false"

@portalTest
Scenario Outline: Home page default login
Given User is on Netbacking landing page 
When User login application with <username> and <password> 
Then Home page is populate 
And Cards are displayed "true"

Examples: 
|username |password |
|user1    |pass1    |
|user2    |pass2    |
|user3    |pass3    |
|user4    |pass4    |

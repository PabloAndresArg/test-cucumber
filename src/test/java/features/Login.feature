Feature: Application Login

@WebTest
Scenario: Home page default login
Given User is on Netbacking landing page 
When User login into application with "user_" and "1234" 
Then Home page is populate 
And Cards are displayed "true"

@MobileTest
Scenario: Home page default login
Given User is on Netbacking landing page 
When User login into application with "user_2" and "1234" 
Then Home page is populate 
And Cards are displayed "false"

@SmokeTest
Scenario: Home page default login
Given User is on Netbacking landing page 
When User sign up with following details
| pablo | 12345 | pabloandresarg@gmail.com | Guatemala | 58940222 |
Then Home page is populate 
And Cards are displayed "false"

@WebTest
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

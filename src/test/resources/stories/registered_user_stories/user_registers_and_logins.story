Meta:
@acceptanceSuite

Scenario: Registered user successfully logs into account
Meta:
@smokeSuite


Given login page is opened
When registered user logs into account with <email> and <password>
Then user's account page should be opened
Then user should be logged in as <username>
Then user should be able to logout

Examples:
|email|password|username|
|validemail@gmail.com|11111|Jane Doe|

Scenario: New user registers and creates his account

Given login page is opened
When user fills email field with his email
When user fills personal data fields with his <firstName>, <lastName>, and <password>
When user fills address fields with his <address>, <city>, <state>, <postalCode>, <country>, <phoneNumber>
When user clicks Register button
Then user's account page should be opened
Then user should be logged in as <username>
Then user should be able to logout

Examples:
|firstName|lastName|password|address|city|state|postalCode|country|phoneNumber|username|
|John|Snow|22222|New streeet, 1/1|New York|New York|10001|United States|+12015001292|John Snow|
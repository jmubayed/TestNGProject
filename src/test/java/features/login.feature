Feature: Login into Application

Scenario Outline: Positive test validating login
Given Initizalize the browser with chrome
And Navigate to "http://www.qaclickacademy.com/" Site
And Click on Login link in home page to land on Secure sign in Page
When User enters <username> and <password> and logs in
Then Verify that an error message appeared on the page
And close browser

Examples:

|username        | password|
|test99@gmail.com| 1234    |
|piza@gmail.com  |12545    |
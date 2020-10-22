Feature: To check the response for jira authentication

  Scenario: To verify the response body for a valid jira login
    Given The end point uri to login to Jira
    When user passes the valid credentials "varunisha1998" and "Rumble@12"
    Then verify the status code is "200"
    
     Scenario: To verify the response body for a invalid jira login
    Given The end point uri to login to Jira
    When user passes the valid credentials "varunisha1998" and "Rumble@123"
    Then verify the status code is "401"
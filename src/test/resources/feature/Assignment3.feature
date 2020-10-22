Feature: To create a employee

  Scenario: To verify whether the customer is created using post method
    Given The end point uri to create a employee 
    When user passes the json body using the "POST" method
    Then verify the message "Successfully! Record has been added." is displayed and status code is "201"
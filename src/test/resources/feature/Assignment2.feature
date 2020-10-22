Feature: To check the response for the country Norway

  Scenario: To verify the capital "Oslo" is present inside the response
    Given The end point uri to find the country details
    When user passes the country code as "Norway" using get method
    Then verify the response has the capital "Oslo" is present and status code is "200"
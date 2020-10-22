Feature: To check the response for the given country code

  Scenario: To verify the phrase "Republic of India" is present inside the response
    Given The end point uri to find a country details
    When user passes the country "INDIA" using get method
    Then verify the phrase "Republic of India" is present and status code is "200"

  Scenario: To verify the phrase "Not Found" is present when user pases invlalid country code
    Given The end point uri to find a country details
    When user passes the country "XYZ" using get method
    Then verify the phrase "Not Found" is present and status code is "404"

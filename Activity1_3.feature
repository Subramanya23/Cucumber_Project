@activity1_3
Feature: Posting a job using parameterization

Scenario: Post a job using details passed from the Feature file 
    Given Open browser with Alchemy Jobs site
    When Go to Post a Job page
    Then Enter the "subbu123@gmail.com", "Automation tester", "Bangalore", "This is testing job", "Subbu1234@gmail.com", "IBM India Pvt. Ltd." details and click on the Preview button
    Then Click submit
    Then Go to the Jobs page
    And Confirm job listing "Automation tester" is shown on page
    And Close Browser
@activity1_4
Feature: Using Examples table to post a job

Scenario Outline: Rewrite activity 3 using outline and Examples table to post a job
    Given Open browser with Alchemy Jobs site
    When Go to Post a Job page
    Then Enter the "<email>", "<jobTitle>", "<location>", "<description>", "<applicationEmail>", "<companyName>" details and click on the Preview button
    Then Click submit
    Then Go to the Jobs page
    And Confirm job listing "<jobTitle1>" is shown on page
    And Close Browser

Examples: 
      | email | jobTitle | location | description | applicationEmail | companyName | jobTitle1 |
      | Subramanya@gmail.com | Automation Tester 01 | Bangalore | This is test job | user@gmail.com | IBM India Pvt. Ltd. | Automation Tester 01 |
      | Subramanyahp@gmail.com | Automation Tester 02 | Chennai | This is test job | user23@gmail.com | IBM India Pvt. Ltd. | Automation Tester 02 |
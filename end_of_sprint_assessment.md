# End-of-Sprint Assessment

## Project Overview
This document provides an assessment of the current state of the System Under Test (SUT) at the end of the sprint. 
The assessment is based on the test results obtained using IntelliJ, JUnit5, Selenium, Cucumber, and Gherkin.

## Test Summary
### Test Coverage
- **Total Test Cases**: 6
- **Passed Test Cases**: 6
- **Failed Test Cases**: 0

### Test Execution
- **Automated Tests**: All tests were automated using Selenium and executed through IntelliJ.
- **Manual Tests**: None

### Testing Tools
- **IntelliJ**: Used as the main IDE for writing and executing tests.
- **JUnit5**: Used as the testing framework.
- **Selenium**: Used for browser automation.
- **Cucumber**: Used for BDD testing.
- **Gherkin**: Used for writing test scenarios in a human-readable format.

## Test Results
### Summary of Failed Test Cases
1. **Test Case ID**: TC001
    - **Description**: Adding games successfully to favorites collections.
    - **Expected Result**: user should see the chosen game in user's collections.
    - **Actual Result**: No error message displayed.
    - **Status**: PASSED

2. **Test Case ID**: TC002
    - **Description**: Successful rating addition to a chosen game.
    - **Expected Result**: The selected rating is saved and cannot be changed.
    - **Actual Result**: The selected rating is saved and cannot be changed.
    - **Status**: PASSED

3. **Test Case ID**: TC003
    - **Description**: Successful registration with valid credentials.
    - **Expected Result**: user should be registered successfully and redirected to the home page.
    - **Actual Result**: user was registered successfully and redirected to the home page.
    - **Status**: PASSED

4. **Test Case ID**: TC004
    - **Description**: Unsuccessful registration with invalid credentials.
    - **Expected Result**: user shouldn't be registered successfully.
    - **Actual Result**: user was not registered successfully.
    - **Status**: PASSED

5. **Test Case ID**: TC005
    - **Description**: Successful review addition.
    - **Expected Result**: user should be able to see it where reviews are shown.
    - **Actual Result**: user sees where reviews are shown.
    - **Status**: PASSED

6. **Test Case ID**: TC006
    - **Description**: User can search for board games
    - **Expected Result**: the user should see valid game name in the search results.
    - **Actual Result**: the user sees valid game name in the search results.
    - **Status**: PASSED

### Bug Report
For detailed bug reports, please refer to the `bug_report.md` file in the repository.

## Conclusion
The current state of the SUT indicates that while the majority of the functionalities are working as expected, 
there in one critical area that need immediate attention. 
The test results have been documented and shared with the project authors for further action.




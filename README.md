# Word-Counter

The main purpose of the app is to count how many lines, words and characters are in provided text.

### How to run tests
1. Clean tests
> mvn clean

2. Execute tests
> mvn test

3. Generate report
> allure serve target/allure-results

from folder where you downloaded project or use:
> mvn allure:serve

or use
> mvn allure:report

Report will be generated tо directory: `target/site/allure-maven/index.html`
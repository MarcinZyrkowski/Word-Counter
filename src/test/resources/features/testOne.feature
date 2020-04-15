Feature: test service

  Scenario: Write text to get info about characters in given string
    Given prepare counter and string
    When write text "Play with cucumber" to counter to count characters
    Then The result is 16 characters

  Scenario: Write text to get info about words in given string
    Given prepare counter and string
    When write text "Play with cucumber" to counter to count words
    Then The result is 3 words

  Scenario: Write text to get info about lines in given string
    Given prepare counter and string
    When write first word in string which is "Play" to counter to count lines
    And string has next line with "with"
    And and finally string has next line with "cucumber"
    Then The result is 3 lines
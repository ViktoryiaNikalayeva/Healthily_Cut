Feature: Search bar

  Scenario: Checking search bar

    Given MainPage is opened
    When I type 'pain' in the search bar and click magnifier
    Then All results contain 'pain'

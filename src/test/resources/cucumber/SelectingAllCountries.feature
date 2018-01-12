@FunctionalTest
Feature: Testing a REST API
As a user
I want to be able to see all countries in the world
So that I can then choose which country to see further details about

  Scenario Outline: validate  particular country data
    Given user make a get request to "<URL>"
    When users selects "<country>"
    Then the requested "<country>" and "<capital>" is returned

Examples: 
   | URL | country | capital |
   |https://restcountries.eu/rest/v1/all| India | New Delhi |
   |https://restcountries.eu/rest/v1/all| Mexico | Mexico City |


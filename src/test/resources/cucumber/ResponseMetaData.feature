@MetaDataTest
Feature: Testing a REST API
As a user
I want to be able to see all countries in the world
So that I can then choose which country to see further details about

  Scenario Outline: validate reponse status and content type
    Given user makes a get request to countriesURL "<URL>"
    Then the request status should be <Status_code> and request content type should be "<Request_content>"

Examples: 
   | URL | Status_code | Request_content |
   |https://restcountries.eu/rest/v1/all| 200 | application/json;charset=utf-8 |


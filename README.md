Candidate : MEHER MEKA

PROJECT Background:
There are RESTful services available that show various details about countries in the world. One
example of the implemented service is at:-
https://restcountries.eu/rest/v1/all

1: Write a BDD feature file(s) for the following requirement:
As a user
I want to be able to see all countries in the world
So that I can then choose which country to see further details about
Determine what coverage you would look to achieve through feature tests and what other
techniques you might like to use to test to obtain good test coverage.

2: Implement the more important scenarios (min 2) creating a way of testing them that will allow for
executing in an automated manner. This should demonstrate an understanding of the attributes
that make up a good test framework, using the language/library of your choice Java, Ruby or C#.

3: Annotate how you would trace the features back to the requirement.

Used Libraries:


Types Of Tests which can be done:
Functional Tests
Exploratory Tests
Performance Tests

Reports can be found at --> target--> cucumber --> index.html [for each test run]

Due to time Constraints unable to do reporting part.

Justification:
Used HttpClient library instead of RestAssured library because feature files should be used to demonstrate BDD capability

RestAssured library comes with DSL which does not go hand in hand with Cucumber so used HTTPClient instead
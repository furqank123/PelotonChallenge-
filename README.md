# PELOTON CODING CHALLENGE

It has been a while since I have worked on web automation, do pardon my rustiness on things like css selectors.

This framework  performs various tests on http://www.pelotoncycle.com


#### TASK ONE

Assumption : Unix or Linux environment.

##### PREREQUISITES
The tests are configured to run using chrome driver. Before starting the test execution please execute the following
command through terminal:

*brew cask install chromedriver*

This framework utilizes gradle as the build tool, although a gradle wrapper is available as part of the project
do execute the following:

*brew install gradle*

**If you do not have Homebrew installed please execute the below before the above:**

*/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"*



##### TEST EXECUTION

**To run the tests navigate to TaskOne (cd ../../PelotonChallenge/TaskOne)
directory & simply execute the following command(s):**

*./gradlew clean build*


#### TASK TWO

Assumption : Unix or Linux environment.

This is a very simple shell script that uses a(or a couple) of curl commands in conjunction with jq to process
the json response and extract meaningful data for us.

A Simple shell query that will return minimum and maximum temperature of a city

##### PREREQUISITES

If everything went smoothly as part of task one then all that is required is to install jq using homebrew via
the following command:

*brew install jq*

##### SCRIPT EXECUTION

To execute the script simply navigate to TaskTwo Directory and execute the following:

*sh TaskTwo.sh "enterCity"* or *bash TaskTwo.sh "enterCity"*

Enter the city within the quotations instead of enterCity.







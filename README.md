# Shop Test Automation

## Installation

1. Download and install Visual Studio Code (https://code.visualstudio.com/download)
2. Download and install Node.js (https://nodejs.org/en/download/)
3. Clone this Git repository to your local machine
4. Open Terminal within Visual Studio Code and install the dependencies by running `npm install` from the terminal

## Structure Information

1. Downloads (It contains all files that are downloaded during tests run).
2. Fixture (It contains all tests data that is being used in the tests).
3. Integration (It contains all tests feature files).
4. Plugins (It contains the files that extends the behavior of Cypress).
5. Screenshots (It contains screenshots for the tests failures).
6. Support (It contains all files that have reuseable code).
7. Videos (It contains video recording for test execution).
8. Json files are the Node Project and Cypress configuration files.

## Local Usage

The file 'package.json' contains the commands to run scripts, and these are all declared in 'scripts' object. Each command is run from the terminal and must be prefixed with `npm run`, for example `npm run cypress:open`

1. `cypress:open` Opens the Cypress Test Runner
2. `test-record` Runs the feature file(s) with specified tags in a Chrome browser and records it in the Cypress Dashboard, with Slack integration. Specify tags within "TAGS=" and "--tag" prior to running
3. `test-chrome` Runs the feature file(s) with specified tags in a Chrome browser. Specify tags within "TAGS=" and "--tag" prior to running
4. `test` Runs the feature file(s) with specified tags in a headless Chrome browser. Specify tags within "TAGS=" and "--tag" prior to running
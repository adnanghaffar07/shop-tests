const { After, AfterAll, Before, Status } = require('@cucumber/cucumber');
const Report = require('./Report');
const sanitize = require('sanitize-filename');
const _ = require('lodash');

Before(async function (scenario) {
    console.log("\nRunning Scenario: "+ scenario.pickle.name);
});

After(async function (scenario) {
    if (this.isBrowserOpen) {
        if (scenario.result.status === Status.FAILED) {
            try {
                if (this.debug) console.log('After Hook: ' + scenario.result.status);
                // Taking screenshot
                await this.screenshot.create(sanitize(_.toLower(scenario.pickle.name) + ".png").replace(/ /g, "_"));
            } catch (e) {
                console.error(e);
            }
        }

        await this.driver.quit();
        await this.sleep(500);
    }
});

AfterAll(async function () {
    setTimeout(() => {
        Report.generate();
    }, 1000)
});
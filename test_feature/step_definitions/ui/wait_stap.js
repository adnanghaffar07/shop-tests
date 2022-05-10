const Promise = require(`bluebird`);
const { When } = require('@cucumber/cucumber');

When(/^I wait for '(.+)' seconds$/, async function (seconds) {
    const waitingTime = parseInt(seconds, 10) * 1000;
    await Promise.delay(waitingTime);
});

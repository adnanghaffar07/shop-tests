const { Given } = require('@cucumber/cucumber');
const { waitForElement } = require(`../../../utils/wait`);
const { retry } = require('../../../utils/retry');

Given(/^I navigate to the '(.+)' url$/, async function (navPage) {
    await this.driver.get(navPage);
});

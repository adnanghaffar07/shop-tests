const { When, And, Then } = require('@cucumber/cucumber');
const { expect } = require('chai');
const { setTextBox, clickOnElement } = require('../../../utils/elements');
const { waitForLoader, waitForElement } = require(`../../../utils/wait`);

And(/^I see the home page$/, async function () {
    await waitForElement(this, this.locators.order.homePage);
});


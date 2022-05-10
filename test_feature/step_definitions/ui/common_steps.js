const { When } = require('@cucumber/cucumber');
const { retry } = require('../../../utils/retry');
const { clickOnElement, isElementLocated, elementNotLocated } = require('../../../utils/elements');
const { waitForLoader } = require('../../../utils/wait');

When(/^I click on the '(.+)' (link|tab|button|text)(?: and wait until it (disappear))?/, async function (name, type, disappear) {
    let locator = '';
    if (type === 'link') {
        locator = this.locators.global.link.replace('{txt}', name);
    } else if (type === 'tab') {
        locator = this.locators.global.tabs.replace('{txt}', name);
    } else if (type === 'button') {
        locator = this.locators.global.button.replace('{txt}', name);
    } else {
        locator = this.locators.global.allText.replace('{txt}', name);
    }
    if (name === 'Create Form') {
        locator = this.locators.hiringClientForm.createForm;
    }

    await retry(async () => {
        const isLocated = await isElementLocated(this, locator);
        if (isLocated) {
            await clickOnElement(this, locator);
        }
        if (disappear) {
            await elementNotLocated(this, locator);
        }
    }, 30000, 2000);
    await waitForLoader(this, this.locators.global.commonLoader);
});

When(/^I reload the page$/, async function () {
    await this.driver.navigate().refresh();
});

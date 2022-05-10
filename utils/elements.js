const { By } = require('selenium-webdriver');
const Promise = require(`bluebird`);
const selenium = require('selenium-webdriver');
const { expect } = require('chai');

module.exports = {
  clickOnElement: async (world, locator) => {
    await world.driver.wait(selenium.until.elementLocated(By.xpath(locator)), 30000);
    const element = await world.driver.findElement(By.xpath(locator));
    await element.click();
  },

  setTextBox: async (world, locator, value, postKeyAction = null) => {
    const element = await world.driver.findElement(By.xpath(locator), 30000);

    await element.clear();
    await Promise.delay(500);
    await element.sendKeys(value);

    if (postKeyAction) {
      await element.sendKeys(postKeyAction);
    }
  },

  elementNotLocated: async (world, locator) => {
    const elementLength = await world.driver.findElements(By.xpath(locator))
      .then(el => el.length);
    expect(elementLength).to.equal(0);
  },

  isElementLocated: async (world, locator) => {
    const elementLength = await world.driver.findElements(By.xpath(locator))
      .then(el => el.length);
    if (elementLength > 0) {
      return true;
    } else {
      return false;
    }
  }
};

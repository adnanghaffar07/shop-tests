const { By } = require('selenium-webdriver');
const selenium = require('selenium-webdriver');

module.exports = {
  getElement: async (world, locator) => {
    await world.driver.wait(selenium.until.elementLocated(By.xpath(locator)), 30000);
    const element = await world.driver.findElement(By.xpath(locator));
    return element;
  },

  getTextFromElement: async (world, locator) => {
    await world.driver.wait(selenium.until.elementLocated(By.xpath(locator)), 10000);
    const element = await world.driver.findElement(By.xpath(locator));
    return element.getText();
  },

  getElementsLength: async (world, locator) => {
    const elements = await world.driver.findElements(By.xpath(locator), 5000);
    return elements.length;
  }
};

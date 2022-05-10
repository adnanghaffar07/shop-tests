const Promise = require(`bluebird`);
const { By } = require('selenium-webdriver');
const selenium = require('selenium-webdriver');

module.exports = {

  waitForLoader: async (world, locator, waitForMs = 1000, waitTime = 120) => {
    for(let i = 0; i < waitTime; i+=1) {
        try {
            await world.driver.wait(selenium.until.elementLocated(By.xpath(locator)), waitForMs);
        } catch (e) {
            await Promise.delay(500);
            break;
        }
        await Promise.delay(1000);
    }
  },

  waitForElement: async (world, locator) => {
    await world.driver.wait(selenium.until.elementLocated(By.xpath(locator)), 10000);
  },

  waitForPageLoads: async (world, waitForMs = 2000) => {
    for (let i = 0; i < 100; i += 1) {
      const originalSource = await world.driver.getPageSource();
      await Promise.delay(waitForMs);
      const newSource = await world.driver.getPageSource();
      if (originalSource === newSource) {
        return;
      }
    }
  }
};

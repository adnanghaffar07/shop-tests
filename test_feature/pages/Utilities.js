const { By } = require('selenium-webdriver');
const Promise = require(`bluebird`);
const selenium = require('selenium-webdriver');
const { expect } = require('chai');

class Utilities {
    constructor(world) {
        this.world = world;
    }

    async clickOnElement(locator) {
        await this.world.world.driver.wait(selenium.until.elementLocated(By.xpath(locator)), 30000);
        const element = await this.world.world.driver.findElement(By.xpath(locator));
        await element.click();
    }

    async setTextBox(locator, value, postKeyAction = null) {
        const element = await this.world.world.driver.findElement(By.xpath(locator), 30000);

        await element.clear();
        await Promise.delay(500);
        await element.sendKeys(value);

        if (postKeyAction) {
            await element.sendKeys(postKeyAction);
        }
    }

    async elementNotLocated(locator) {
        const elementLength = await this.world.world.driver.findElements(By.xpath(locator)).then(el => el.length);
        expect(elementLength).to.equal(0);
    }

    async isElementLocated(locator) {
        const elementLength = await this.world.world.driver.findElements(By.xpath(locator)).then(el => el.length);
        if (elementLength > 0) {
            return true;
        } else {
            return false;
        }
    }

    async getElement(locator) {
        await world.driver.wait(selenium.until.elementLocated(By.xpath(locator)), 30000);
        const element = await this.world.world.driver.findElement(By.xpath(locator));
        return element;
    }

    async getTextFromElement(locator) {
        await this.world.world.driver.wait(selenium.until.elementLocated(By.xpath(locator)), 30000);
        const element = await this.world.world.driver.findElement(By.xpath(locator));
        const abc = await element.getText();
        return abc;
    }

    async getTextFromElements(locator) {
        await this.world.world.driver.wait(selenium.until.elementLocated(By.xpath(locator)), 10000);
        const elements = await this.world.world.driver.findElements(By.xpath(locator));
        let texts = [];
        for (const element of elements) {
            texts.push(await element.getText());
        }
        texts = texts.join(`, `);
        return texts;
    }

    async getElementsLength(locator) {
        const elements = await this.world.world.driver.findElements(By.xpath(locator), 5000);
        const length = await elements.length;
        return length;
    }
}

module.exports = Utilities;
const { setWorldConstructor } = require('@cucumber/cucumber');
const requireDir = require('require-dir');
const Promise = require(`bluebird`);
const Screenshot = require('./Screenshot');

class World {

    constructor({ attach }) {

        this.platform = process.env.PLATFORM || "chrome";
        this.url = "https://www.demoblaze.com/";

        this.attach = attach;
        this.screenshot = new Screenshot(this);

        this.locators = requireDir('../../fileResources/locators', { recurse: true });
    }

    get appUrl() {
        
        return this.url;
    }

    sleep(milliseconds) {
        return Promise.delay(milliseconds);
    }
}

setWorldConstructor(World);
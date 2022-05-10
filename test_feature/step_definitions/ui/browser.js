const { Given } = require('@cucumber/cucumber');
const web_driver = require('selenium-webdriver');
const chromedriver = require('chromedriver');

Given(/^I open a browser$/, async function () {
    this.driver = new web_driver.Builder()
        .withCapabilities({
            browserName: this.platform,
            javascriptEnabled: true,
            acceptSslCerts: true,
            chromeOptions: {
                args: ['start-maximized', 'disable-extensions']
            },
            path: chromedriver.path
        }).build();
    this.driver.manage().window().maximize();
    this.isBrowserOpen = true;
});

const { setDefaultTimeout } = require('@cucumber/cucumber');

setDefaultTimeout(parseInt(process.env.DEFAULT_TIMEOUT) || 60000);
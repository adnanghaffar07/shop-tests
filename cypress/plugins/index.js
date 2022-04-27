// ***********************************************************
// This example plugins/index.js can be used to load plugins
//
// You can change the location of this file or turn off loading
// the plugins file with the 'pluginsFile' configuration option.
//
// You can read more here:
// https://on.cypress.io/plugins-guide
// ***********************************************************

// This function is called when a project is opened or re-opened (e.g. due to
// the project's config changing)

const cucumber = require('cypress-cucumber-preprocessor').default;

module.exports = (on) => {
  on('file:preprocessor', cucumber());
  on('before:browser:launch', (browser = {}, launchOptions) => {
    if (browser.name === 'chrome') {
      launchOptions.args.push('--disable-site-isolation-trials');
      launchOptions.args.push('--disable-web-security');
      launchOptions.args.push('--isolate-sites-for-testing=*.com');
      launchOptions.args.push('--site-per-process');
      launchOptions.args.push('--window-size=1980,1080');
      return launchOptions;
    }
  });
};
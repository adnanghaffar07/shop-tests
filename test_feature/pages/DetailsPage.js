const Utilities = require('./Utilities');
const { expect } = require('chai');
const Promise = require(`bluebird`);


class DetailsPage {
  constructor(world) {
    this.world = world;
  }
  getHomePage() {
    return cy.xpath("(//*[contains(text(),'PRODUCT STORE')])[1]");
  }


}
// export default DetailsPage
module.exports = DetailsPage;
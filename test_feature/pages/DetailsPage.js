const Utilities = require('./Utilities');
const { expect } = require('chai');
const Promise = require(`bluebird`);


class DetailsPage {
  constructor(world) {
    this.world = world;
  }
  getHiringClient() {
    return cy.xpath("//div[@class='select-wrapper']//div[contains(@class,'indicatorContainer')]//*[local-name()='svg']");
  }


}
// export default DetailsPage
module.exports = DetailsPage;
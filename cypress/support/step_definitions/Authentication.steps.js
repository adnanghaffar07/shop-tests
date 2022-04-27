/* global Then, cy */

const Admin = require('mongodb/lib/admin');
const login = require('../pages/Login.json');

Given('I visit the app url',()=>{
  cy.visit(Cypress.env('BaseUrl'));
})

When('I see the home page',()=>{
  cy.contains('CATEGORIES').should('be.visible');
})

Then('I click on category: Laptops',()=>{
  cy.contains('Laptops').click();
})

Then('I click on product: MacBook Pro',()=>{
  cy.get('.card-title').first().click();
})

Then('I see product name label',()=>{
  cy.get('.name').should('be.visible');
})

Then('I see product price label',()=>{
  cy.get('.price-container').should('be.visible');
})

Then('I see product description',()=>{
  cy.get('.description').should('be.visible');
})

Then('I click on Add To Cart button and verify popup',()=>{
  cy.on('window:alert', (str) => {
    expect(str).to.equal('Product added')
  })
  cy.contains('Add to cart').click();
})

Then('I click on Place Order button',()=>{
  cy.contains('Place Order').click();
})

Then(/^I enter name : "(.*)"$/,(name)=>{
  cy.get('input#name').type(name);
})

Then(/^I enter Country : "(.*)"$/,(name)=>{
  cy.get('input#country').type(name);
})

Then(/^I enter City : "(.*)"$/,(name)=>{
  cy.get('input#city').type(name);
})

Then(/^I enter Credit Card : "(.*)"$/,(card)=>{
  cy.get('input#card').type(card);
})

Then(/^I enter Month : "(.*)"$/,(month)=>{
  cy.get('input#card').type(month);
})

Then(/^I enter Year : "(.*)"$/,(year)=>{
  cy.get('input#year').type(year);
})

Then('I click on Purchase button',()=>{
  cy.contains('Purchase').click();
})

Then('I see thank you page',()=>{
  cy.contains('Thank you for your purchase!').should('be.visible');
})

Then('I click on Cart menu',()=>{
  cy.get('#cartur').click();
})
const { Then } = require('@cucumber/cucumber');
const { getTextFromElement } = require(`../../../utils/getElements`);
const { elementNotLocated, isElementLocated, setTextBox } = require(`../../../utils/elements`);
const { expect } = require('chai');
const { parseString } = require('../../../utils/parser');

Then(/^the '(.+)' (text|text should not) displays$/, async function (text, type) {
    const parsedText = await parseString(this, text);
    if (type === 'text should not') {
        await elementNotLocated(this, this.locators.global.allText.replace('{txt}', parsedText));
    } else {
        const actualText = await getTextFromElement(
            this,
            this.locators.global.allText.replace('{txt}', parsedText)
        );
        expect(actualText).to.contains(parsedText);
    }
});

Then(/^I see product name label$/,async function (){
    expect(await isElementLocated(this,this.locators.order.productName)).to.equals(true);
})

Then(/^I see product price label$/,async function (){
    expect(await isElementLocated(this,this.locators.order.productPrice)).to.equals(true);
})

Then(/^I see product description$/,async function (){
    expect(await isElementLocated(this,this.locators.order.productDescription)).to.equals(true);
})

Then(/^I see the product '(.+)' available in the cart$/, async function(text){
    const parsedText = await parseString(this, text);
    const actualText = await getTextFromElement(
        this,
        this.locators.global.allText.replace('{txt}', parsedText)
    );
    expect(actualText).to.contains(parsedText);
});

Then(/^I enter payment information :$/, async function (table) {
    const values = table.rowsHash();
    this.name = values.name;
    this.country = values.country;
    this.city = values.city;
    this.creditCard = values.creditCard;
    this.month = values.month;
    this.year = values.year;
    if(values.name) {
        await setTextBox(this, this.locators.order.name, values.name);
    }
    if(values.country) {
        await setTextBox(this, this.locators.order.country, values.country);
    }
    if(values.city) {
        await setTextBox(this, this.locators.order.city, values.city);
    }
    if(values.creditCard) {
        await setTextBox(this, this.locators.order.creditCard, values.creditCard);
    }
    if(values.month) {
        await setTextBox(this, this.locators.order.creditCardMonth, values.month);
    }
    if(values.year) {
        await setTextBox(this, this.locators.order.creditCardYear, values.year);
    }
});
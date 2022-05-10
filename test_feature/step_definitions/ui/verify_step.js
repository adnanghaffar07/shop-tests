const { Then } = require('@cucumber/cucumber');
const { getTextFromElement } = require(`../../../utils/getElements`);
const { elementNotLocated } = require(`../../../utils/elements`);
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

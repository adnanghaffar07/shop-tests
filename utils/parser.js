const get = require(`lodash/get`);

function parseString(world, string) {
    const regularExp = /%{([^}]+)}/;
    let parsed = string;
    let match = parsed.match(regularExp);
    while (match) {
        const line = get(world, match[1]);
        parsed = parsed.replace(regularExp, line);
        match = parsed.match(regularExp);
    }
    return parsed;
}

module.exports = {
    parseString,

    parsePayload: (world, payload) => {
        const parsedString = parseString(world, payload);
        return JSON.parse(parsedString);
    }
}

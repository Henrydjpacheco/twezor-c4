const accountResolver = require('./account_resolver');
const authResolver = require('./auth_resolver');
const communicationsResolver = require('./communications_resolver');
const lodash = require('lodash');
const resolvers = lodash.merge(accountResolver, authResolver,communicationsResolver);
module.exports = resolvers;
//Se llama al typedef (esquema) de cada submodulo
const accountTypeDefs = require('./account_type_defs');
const authTypeDefs = require('./auth_type_defs');
const communicationsTypedefs = require('./communications_type_defs');
//Se unen
const schemasArrays = [authTypeDefs, accountTypeDefs,communicationsTypedefs];
//Se exportan
module.exports = schemasArrays;
const { RESTDataSource } = require('apollo-datasource-rest');

const serverConfig = require('../server');

class CommunicationsApi extends RESTDataSource {
    
    constructor() {
        super();
        this.baseURL = serverConfig.communications_api_url;
    }
    async buscarMensajes(ides){
        let ids = new Object(JSON.parse(JSON.stringify(ides)));
        return await this.get('sala',ids);
    }
    
    async crearMensajes(mensaje){
        let mensajes = new Object(JSON.parse(JSON.stringify(mensaje)))
        return await this.post('sala',mensajes);
    }
}

module.exports = CommunicationsApi;
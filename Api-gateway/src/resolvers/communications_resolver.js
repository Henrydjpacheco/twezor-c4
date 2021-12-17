const CommunicationsResolver ={

    Query:{
        buscarMensajes: (_,{ides}, { dataSources })=> dataSources.mensajesAPI.buscarMensajes(ides)
    },
    
    Mutation:{
        crearMensajes:(_,mensajes, { dataSources})=> dataSources.mensajesAPI.crearMensajes(mensajes)
    }
}
module.exports = CommunicationsResolver;
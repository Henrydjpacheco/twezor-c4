const { gql } = require('apollo-server');

const communicationsTypedefs = gql`
    input ids {
        idRemitente: Int!
        idReceptor: Int!
    }

    input  messageInput{
        remitente: String!
        receptor:Int!
        contenido: String!
        hora_creacion: String!

    }

    type message{ 
        id: String!
        remitente: String!
        receptor: String!
        contenido: String!
        hora_creacion: String!
    }
    
    extend type Query {
        buscarMensajes(ides:ids!):[message]!

    }
    extend type Mutation{
        crearMensajes(mensaje: messageInput!): Boolean!
    }


`;
module.exports = communicationsTypedefs
<template>   
    <div class="logIn_user">
        <div class="titulo">    
            <h1>Twezor.io</h1>
        </div>
            <div class="container_logIn_user">
                <form v-on:submit.prevent="processLogInUser" >
                    <input type="text" v-model="user.username"  placeholder="Username">
                    <input type="password" v-model="user.password"  placeholder="Password">
                    <router-link class="link1" to="/forgotPassword">Forget Password?</router-link>
                    <button type="submit"> login</button> 
                    <router-link class="link1" to="/user/signUp">Don't have an account? Sign UP!</router-link>
                </form>
            </div>    
    </div>   
</template>

<script>
import gql from "graphql-tag";
            
export default {
    name: "LogIn",

    data: function(){
        return {
            user: {
                username:"",
                password:""
            },
        };
    },

    methods: {
        processLogInUser: async function() {
            await this.$apollo
                .mutate({
                    mutation: gql`
                        mutation($credentials: CredentialsInput!) {
                            logIn(credentials: $credentials) {
                                refresh
                                access
                            }
                        }
                    `,
                    variables: {
                        credentials: this.user,
                    },
                })
                .then((result) => {
                    let dataLogIn = {
                        username: this.user.username,
                        token_access: result.data.access,
                        token_refresh: result.data.refresh,
                    };
        
                    this.$emit('completedLogIn', dataLogIn);
                })
                .catch((error) => {
                    alert("ERROR 401: Credenciales Incorrectas.");
                })
        }
    }
}
</script>

<style>


.logIn_user{
    margin: 0;
    padding: 0%;
    height: 100%;
    width: 100%;
    display: flex;
    justify-content: right;
    align-items: center;
}
   
    .titulo h1{
     
        display: flex;
        width: 800px;
        height: 250px;
        font-family: K2D;
        font-style: normal; 
        font-size: 96px;
        text-align: center;
        color: #444444;
        mix-blend-mode: normal;

    }
  
    .container_logIn_user  {    
        border-radius: 10px;
        width: 25%;
        height: 90%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }
    .logIn_user form{
        width: 95%;
        height: 90%;
        margin-right:65%;
    }

    .logIn_user input{
        height: 40px;
        width: 100%;
        box-sizing: border-box;
        padding: 10px 29px;
        margin: 11px 3px;
        font-style: normal;
        font-weight: 300;
        font-size: 18px;
        line-height: 21px;
        border-radius: 10px;
        align-content: right;
        text-align: center;

    }

    .logIn_user button{
        width: 100%;
        height: 40px;
        color: #E5E7E9;
        background: #2A3383;
        border-radius: 50px;
        padding: 10px 25px;
        margin: 5px 0;
    }

    .logIn_user button:hover{
        color: #E5E7E9;
        background: crimson;
        border: 1px solid #283747;
    }
   .link1{
        color: #FFFF;
        text-decoration: underline;
        font-size: 18px;
        padding: 8px;
        border-radius: 5px;
        text-align: center;
        text-decoration:none;
        font-family: 'Roboto', sans-serif;
        
    }
</style>
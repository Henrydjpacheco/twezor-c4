<template>
  <div id="app" class="app">
  <div class="main-component">
    <div class="header">
      </div>
      <!--<h1>TWEZOR.IO</h1>-->
        <nav>
        <button v-if="is_auth" v-on:click="loadHome"> Inicio </button>
        <button v-if="is_auth" v-on:click="loadAccount"> Cuenta </button>
        <button v-if="is_auth" v-on:click="logOut"> Cerrar Sesión </button>
        <!--<button v-if="!is_auth" v-on:click="loadLogIn" > Iniciar Sesión </button>
        <button v-if="!is_auth" v-on:click="loadSignUp" > Registrarse </button>-->
      </nav>    
      <router-view
        v-on:completedLogIn="completedLogIn"
        v-on:completedSignUp="completedSignUp"
      >
      </router-view>
    </div>
    <div class="footer">     
    </div>
  </div>
  
</template>
<script>
export default {
  name: 'App',

  data: function(){
    return{
      is_auth: false
    }
  },
  components: {
  },

  methods:{
    verifyAuth: function() {
      this.is_auth = localStorage.getItem("isAuth") || false;
      if (this.is_auth == false)
        this.$router.push({ name: "init" });
      else
        this.$router.push({ name: "home" });
    },
    loadLogIn: function(){
      this.$router.push({name: "logIn"})
    },
    loadSignUp: function(){
      this.$router.push({name: "signUp"})
    },
    loadHome: function() {
      this.$router.push({ name: "home" });
    },
    loadAccount: function () {
      this.$router.push({ name: "account" });
    },
    logOut: function () {
      localStorage.clear();
      alert("Sesión Cerrada");
      this.verifyAuth();
    },

    completedLogIn: function(data) {
      localStorage.setItem("isAuth", true);
      localStorage.setItem("username", data.username);
      localStorage.setItem("token_access", data.token_access);
      localStorage.setItem("token_refresh", data.token_refresh);
      alert("Autenticación Exitosa");
      this.verifyAuth();
    },
    
    completedSignUp: function(data) {
      alert("Registro Exitoso");
      this.completedLogIn(data);
    }
    },
  
    created: function(){
      this.verifyAuth()

  },
}
</script>

<style>
  body{
    margin: 0 0 0 0;
  }

  .header{
    margin: 0%;
    padding: 0;
    width: 100%;
    height: 10vh;
    min-height: 100px;
    
    color:#0f4d8b ;
    display: flex;
    justify-content: space-between;
    align-items: center;
  }
  .header nav{
    height: 100%;
    width: 20%;
    display: flex;
    justify-content: space-around;
    align-items: center;
    font-size: 20px;
  }
    
  .header nav button{
    color: #E5E7E9;
    background: #283747;

    border: 1px solid #E5E7E9;
    border-radius: 5px;
    padding: 10px 20px;
  }
    
  .header nav button:hover{
    color: #283747;
    background: #E5E7E9;
    border: 1px solid #E5E7E9;
  }
    
  .main-component{
    height: 85vh;
    margin: 0%;
    padding: 0%;
    border-left: 10px solid #0f4d8b;
    border-right: 10px solid #0f4d8b;
    background-image: linear-gradient(to right, white , blue);
  }

  .footer{
    margin:0;
    padding:0;
    width: 100%;
    height: 10vh;
    min-height: 100px;
    background-color: #0f4d8b ; 
  }
</style>
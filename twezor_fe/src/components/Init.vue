<template>  
    <div class="Home">
        <div class="home">            
            <h1>Twezor.io</h1>
            <p>"let us know, how do you want to communicate"</p>                    
        </div>
    </div>
</template>
<script>
export default {
    name : "init",
    methods:{
        prueba(){
            this.$router.push({name: "logIn"}) 
        }
    },
    created(){
    setTimeout(this.prueba,2000)
    }
} 
</script>
<style>
    .home {
        left: 50%;
        position: absolute;
        top: 50%;
        transform: translate(-50%, -50%);
    }
    .home h1{
        font-family: 'K2D', sans-serif;
        font-size: 96px;
        text-align: center;
        line-height: 72px;
        color: #000000 ;
        z-index: 7;        
        mix-blend-mode:normal;
        align-items: center;
        
    }

    .home p{
        
        font-family: 'K2D', sans-serif;
        font-style: normal;
        font-size: 22px;
        text-align: center;
        color: #000000;
        border: 1px solid #0000;
        background-color: transparent; 
        
    }

</style>
<template>
  <b-container id="app" fluid>
    <b-navbar 
      class="customNavbar"
      fixed
      sticky
      >
      <b-navbar-brand href="/">
        <img class="imgSize"src="https://1000logos.net/wp-content/uploads/2023/05/Skull-Emoji.png">
      </b-navbar-brand>
        
      <b-navbar-nav>
        <b-nav-item href="/about">About</b-nav-item>
      </b-navbar-nav>
      
    </b-navbar>
    <hr class="my-0">

      <router-view></router-view>
  </b-container>
</template>

<script >

export default{
  data(){
    return{
      
    }
  
  }
}

</script>

<style scoped>

  #app{
    min-height: 100vh!important;
    background-color: rgb(255, 255, 255)!important;
  }

  .customNavbar{
    padding-left: 12%!important;
    padding-right: 12%!important;
  }

  .imgSize{
    width: 100px;
    height: 60px;
  }

</style>

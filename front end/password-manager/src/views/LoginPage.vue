<template>
    <b-container fluid class="location">

      <b-row>
        <b-col>
          <h1 class="text-center"> TIM ZAPP's FAN CLUB</h1>
        </b-col>
      </b-row>


      <b-row class="mt-5" align-h="center">
        <b-col cols="3">
          <b-card 
            class="px-3 shadow-lg"
            body-class="loginBody"
          >
            <b-row class="mb-3 mt-2">
              <b-col>
                <b-card-title class="text-center">Sign In</b-card-title>
              </b-col>
            </b-row>

            <b-row class="mb-4">
              <b-col>
                <label for="password">Master Password</label>
                <b-form-input
                  id="password"
                  type="password"
                  v-model="enteredPassword"
                  placeholder="Enter your master password."
                  :state="enteredPasssswordState"
                > 
                </b-form-input>
                <b-form-invalid-feedback id="password">
                  Your password was invalid. Please try again.
                </b-form-invalid-feedback>
              </b-col>
            </b-row>
    

            <b-row>
              <b-col >
                <b-button  
                  block
                  variant="primary"
                  @click="authenticatePassword"
                >
                  Login
                </b-button>
              </b-col>
            </b-row>
      
          </b-card>

        </b-col>
      </b-row>
    

  </b-container>



</template>



<script >

import { mapActions } from 'vuex/dist/vuex.cjs.js';
import { PasswordService }  from  '../api/PasswordService.js'


export default{
    data(){
        return{
          enteredPassword: '',
          enteredPasssswordState: null,
        }
    },

    methods: {
      async authenticatePassword(){
        try{
          // const response = await PasswordService.authenticateUser(this.enteredPassssword)
          // change to actual request
          if (this.enteredPassword === 'XD'){
            this.enteredPasssswordState = true;
            localStorage.setItem('token', 'XD')
            this.$router.push({name: 'home'})
          }
          else{
            this.enteredPasssswordState = false;
          }
        
        }
        catch(error){
          this.enteredPasssswordState = false;
        }
      

        
      }
    },

    beforeMount(){
      localStorage.removeItem('token')
    }
}

</script>

<style scoped>
  .location{
    margin: 0;
    position: absolute;
    top: 50%;
    -ms-transform: translateY(-50%);
    transform: translateY(-50%);
  }

  .loginBody{}

</style>
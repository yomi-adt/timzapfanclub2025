<template>
    <b-container fluid class="px-0">
        <b-button
            class="fillHeight px-1"
            variant="primary"
            block
            size="md"
            @click="showModal = true"
            @ok="submit"
        >
        <i class="bi bi-plus-circle"></i>
        New
        </b-button>

        <b-modal
            title="Add New Password"
            v-model="showModal"
            centered
            ok-title="Add"
        >   

        <b-form-group label="URL">
            <b-form-input
            v-model="url"
            placeholder="Enter the URL"
            ></b-form-input>
        </b-form-group>
        
        <b-form-group label="Username">
            <b-form-input
            v-model="username"
            placeholder="Enter the username"
            ></b-form-input>
        </b-form-group>

        <b-form-group label="Password">
            <b-form-input
            type="password"
            v-model="password"
            placeholder="Enter the password"
            ></b-form-input>
        </b-form-group>

        </b-modal>



  </b-container>
</template>



<script >

export default{
    name: 'AddNewPassword', 
    
    data(){
        return{
            showModal: false,
            url: '',
            username: '',
            password: '',

        }
    },


    methods: {
        async submit(){
            
            //make POST api call
        }
    }
}

</script>

<style scoped>

</style>
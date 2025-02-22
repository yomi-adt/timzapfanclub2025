<template>
    <b-container fluid>
        <b-button
            class="fillHeight"
            variant="primary"
            block
            size="md"
        >
        <i class="bi bi-plus-circle"></i>
        New Password
        
        </b-button>

  </b-container>
</template>



<script >

export default{
    name: 'AddNewPassword', 
    
    data(){
        return{

        }
    }
}

</script>

<style scoped>
    .fillHeight{
        min-height: 50px!important;
    }
</style>
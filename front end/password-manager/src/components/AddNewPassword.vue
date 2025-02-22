<template>
    <b-container fluid class="px-0">
        <b-button
            class="fillHeight px-1"
            variant="primary"
            block
            size="md"
            @click="showModal"
        >
        <i class="bi bi-plus-circle"></i>
        New
        </b-button>



  </b-container>
</template>



<script >

export default{
    name: 'AddNewPassword', 
    
    data(){
        return{
            showModal: false,


        }
    }
}

</script>

<style scoped>

</style>
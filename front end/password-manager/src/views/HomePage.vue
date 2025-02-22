<template>
    <b-container fluid class="customPadding">
        <b-row>
            <b-col cols="2">
                <b-card
                    class="sticky"
                    title="Filters"
                >
                <b-card-text></b-card-text>
                </b-card>
            </b-col>
            
            <b-col>
                <b-row class="mb-5">
                    <b-col>
                        <h1 class="display-5">My Passwords</h1>
                    </b-col>
                    <b-col cols="2" class="ml-auto">
                        <AddNewPassword></AddNewPassword>
                    </b-col>
                </b-row>

                <b-row>
                    <b-col>
                        <b-table
                            :items="items"
                            :fields="fields"
                            :current-page="currentPage"
                            :per-page="perPage"
                            show-empty
                            fixed
                            
                        >
                        <template #cell(password)="currRow">
                            <template v-if="showPassword">
                                {{ currRow.value }}
                            </template>
                            <template v-else>
                                ********
                            </template>
                            
                        </template>

                        <template #cell(view)="currRow">
                            <i class="onClick bi bi-eye-fill" @click="showPassword = !showPassword"></i>
                        </template>

                        <template #cell(url)="currRow">
                            <i class="bi bi-globe-americas mr-2"></i>
                            <a class="bold" :href="`https://${currRow.value}`" target="_blank">{{currRow.value}} </a>
                        </template>

                        <template #cell(delete)="currRow">
                            <b-button
                                variant="danger"
                                size="sm"
                                >
                                <i class="bi bi-trash3-fill"></i>
                            </b-button>
                        </template>

                        <template #cell(edit)="currRow">
                            <b-button
                                variant="primary"
                                size="sm"
                                >
                                <i class="bi bi-pencil-square"></i>
                            </b-button>
                        </template>

                        </b-table>
                    </b-col>
                </b-row>
            </b-col>
        </b-row>


  </b-container>
</template>



<script >

import AddNewPassword from '../components/AddNewPassword.vue';

export default{
    components: {
        AddNewPassword
    },

    data(){
        return{
            showPassword: false,

            fields: [
                {
                    key: 'url',
                    sortable: false,
                    label: 'URL'
                },
                {
                    key: 'username',
                    sortable: false,
                    label: 'Username'
                },
                {
                    key: 'view',
                    sortable: false,
                    label: ' ',
                    thStyle: {width: '2%'},
                },
                {
                    key: 'password',
                    sortable: false,
                    label: 'Password',
                    class: 'cutOff'
                },
                {
                    key: 'delete',
                    sortable: false,
                    thStyle: {width: '8%'},
                    label: 'Delete',
                    class: 'text-center'
                },
                {
                    key: 'edit',
                    sortable: false,
                    thStyle: {width: '8%'},
                    label: 'Edit',
                    class: 'text-center'
                }
            ],

            items: [
                {url: "WWW.google.com", username: "qwertzLMAO", password: "XDXDXDXssdsadsadsadsadsadsadsasaaddsadsadsadsadsadsasadsaD"},
                {url: "WWW.google.com", username: "qwertzLMAO", password: "XDXDXDXDXDXDXD"},
            ]

        }
    },

    computed: {
        parseUrl(url){

        }
    }
}

</script>

<style scoped>
    .customPadding{
        padding-left: 8%!important;
        padding-right: 20%!important;
        padding-top:  5%!important;
    }

    .sticky{
        position: sticky!important;
    }

    .b-table tbody td {
        vertical-align: middle;
        height: 60px!important;
    }

    .bold{
        font-weight: bold;
    }

    .onClick:hover{
        cursor: pointer
    }
</style>
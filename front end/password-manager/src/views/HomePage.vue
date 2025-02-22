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
                <b-row class="mb-4" no-gutters>
                    <b-col>
                        <h2 class="display-5">My Passwords</h2>
                    </b-col>
                    <b-col cols="1" class="mr-2">
                        <b-button
                            class="px-2"
                            @click="showPassword = !showPassword"

                        >
                            <i class="bi bi-eye-fill"></i>
                            Show
                        </b-button>
                    </b-col>
                    <b-col cols="1" class="ml-auto">
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

                        <template #cell(copy)="currRow">
                            <i @click="copyToClipboard(currRow.item.password)" class="bi onClick bi-clipboard mr-5"></i>
                        </template>

                        <template #cell(url)="currRow">
                            <i class="bi bi-globe-americas mr-2"></i>
                            <a class="bold" :href="`https://${currRow.value}`" target="_blank">{{currRow.value}} </a>
                        </template>

                        <template #cell(delete)="currRow">
                            <b-button
                                variant="danger"
                                size="sm"
                                @click="deleteButton(currRow.item)"
                                >
                                <i class="bi bi-trash3-fill"></i>
                            </b-button>
                        </template>

                        <template #cell(edit)="currRow">
                            <b-button
                                variant="primary"
                                size="sm"
                                @click="showEdit = true"
                                >
                                <i class="bi bi-pencil-square"></i>
                            </b-button>

                            <b-modal
                                title="Edit New Password"
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
                        </template>

                        </b-table>
                    </b-col>
                </b-row>
            </b-col>
        </b-row>


  </b-container>
</template>



<script >
import { PasswordService }  from  '../api/PasswordService.js'
import AddNewPassword from '../components/AddNewPassword.vue';

export default{
    components: {
        AddNewPassword
    },

    data(){
        return{
            showPassword: false,
            showEdit: false,

            fields: [
            {
                    key: 'id',
                    sortable: false,
                    thStyle: {width: '4%'},
                    label: 'ID'
                },
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
                    key: 'copy',
                    sortable: false,
                    label: ' ',
                    thStyle: {width: '4%'},
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
                {id: '1', url: "WWW.google.com", username: "qwertzLMAO", password: "XDXDXDXssdsadsadsadsadsadsadsasaaddsadsadsadsadsadsasadsaD"},
                {id: '2', url: "WWW.google.com", username: "qwertzLMAO", password: "XDXDXDXDXDXDXD"},
            ]

        }
    },

    methods: {
        async copyToClipboard(password){
            try {
                console.log("XD")
                await navigator.clipboard.writeText(password);
                this.$bvModal.msgBoxOk('The password was copied to clipboard.', {
                    title: 'Copied!',
                    size: 'sm',
                    buttonSize: 'sm',
                    okVariant: 'success',
                    centered: true
                    })

            } catch($e) {

            }
        },

        async deleteButton(item) {
            try {
                console.log("LOL XD")
                
                this.$bvModal.msgBoxOk('Say goodbye to your information', {
                    title: 'Password Deleted!',
                    size: 'sm',
                    buttonSize: 'sm',
                    okVariant: 'success',
                    centered: true
                    })

                    // console.log(item.id)
                    this.items.splice(this.items.indexOf(item), 1)
                    // console.log("After deletion: " + item.id)

            } catch($e) {

            }
        }
    },

    async created(){
        this.items = await PasswordService.getAllPasswords();
        
    }
}

</script>

<style scoped>
    .customPadding{
        padding-left: 8%!important;
        padding-right: 15%!important;
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
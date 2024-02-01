<template>
    <div class="invoice">
        <div class="text"><h5>Invoice</h5></div>
  
        <div class="tbl-section">
            <table class="tbl-style">
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Invoice Amunt</th>
                </tr>


                <tr v-for="row in rows" :key="row.id">
                    <td>{{ row.f_name }}</td>
                    <td>{{ row.l_name }}</td>
                    <td>NOK {{ row.invoice_amount }}</td>
                </tr>
            </table>
        </div>

    </div>
</template>
<script lang="ts">
import {defineComponent} from "vue";
export default defineComponent({

    data(){
        return {
            rows:[
                {id:1,f_name:"Peter",l_name:"Griffin",invoice_amount:"100"},
                {id:2,f_name:"Lois",l_name:"Griffin",invoice_amount:"150"},
                {id:3,f_name:"Joe",l_name:"Swanson",invoice_amount:"300"},
                {id:4,f_name:"Cleveland",l_name:"Brown",invoice_amount:"250"},
            ]
        }
    }
})

</script>
<style>
th,
td {
    padding: 8px;
    text-align: left;
}

tr:hover {
    background-color: var(--primary-color);
}
.tbl-section{
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 16px;
    font-weight: 500;
    color: var(--text-color);
    transition: var(--tran-04);
    white-space: nowrap;
    opacity: 1;
    width: 100%;

}
.tbl-style{
    width: 100%;
    padding: 30px;

}

.invoice h2 .text{
    font-size: 20px;
}

.invoice .text {
    font-size: 16px;
    font-weight: 500;
    color: var(--text-color);
    transition: var(--tran-04);
    white-space: nowrap;
    opacity: 1;
}
</style>
<template>
    <div>
        hello page One
    </div>
    <!-- <router-view/> -->
</template>
<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'HelloWorld',
  props: {
    msg: String,
  },
});
</script>
<template>
	<div class="mt-2">
    <form-header :card-subtitle="subtitle" :card-title="title"></form-header>
  </div>
</template>

<script>
	import FormHeader from "../components/formHeader";

  export default {
		name: "repair_queue",
	  components: {FormHeader},
	  data: function () {
		  return {
			  title: "Repair Queue",
			  subtitle: "Ongoing Repairs"
		  }
	  }
  }
</script>

<style scoped>

</style>

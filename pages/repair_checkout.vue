<template>
	<div class="mt-2">
		<form-header v-bind:card-subtitle="subtitle" v-bind:card-title="title"></form-header>
	</div>
</template>

<script>
	import FormHeader from "../components/formHeader";

	export default {
		name: "repair_checkout",
	  components: {FormHeader},
		data: function () {
			return {
				title: "Checkout",
				subtitle: "Select a SO to check out"
			}
		}
	}
</script>

<style scoped>

</style>

<template>
	<div class="mt-2">
		<form-header v-bind:card-subtitle="subtitle" v-bind:card-title="title"></form-header>
		<repair-listings></repair-listings>
	</div>
</template>

<script>
	import FormHeader from "../components/formHeader";
	import RepairListings from "../components/repairListings";

	export default {
		name: "repair_checkout",
		components: {RepairListings, FormHeader},
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
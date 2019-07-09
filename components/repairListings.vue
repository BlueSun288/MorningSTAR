<template>
	<div>
		<form-header :card-subtitle="subtitle" :card-title="title"></form-header>
		<div class="card" id="repairList">

		</div>
	</div>
</template>

<script>
	import FormHeader from "./formHeader";

	export default {
		name: "repairListings",
		components: {FormHeader},
		data: function () {
			return {
				title: "Repair Listings",
				subtitle: "All repairs are listed here"
			}
		}
	}

</script>

<style scoped>

</style>
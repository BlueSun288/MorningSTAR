<template @onload="loadRepairListings">
	<div>
		<form-header :card-subtitle="subtitle" :card-title="title"></form-header>
		<div class="card" id="repairList">
		</div>
	</div>
</template>

<script>
	import FormHeader from "./formHeader";
	import firebase from "@/plugins/firebase"

	export default {
		name: "repairListings",
		components: {FormHeader},
		data: function () {
			return {
				title: "Repair Listings",
				subtitle: "All repairs are listed here"
			}
		},

		methods: {
			loadRepairListings() {
				let database = firebase.firestore;


			}
		}
	}

</script>

<style scoped>

</style>
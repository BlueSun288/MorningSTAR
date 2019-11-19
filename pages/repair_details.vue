<template>
	<div class="card">

	</div>
</template>

<script>
	import firebase from "@/plugins/firebase"

	export default {
		name: "repair_details",
		props: ['SONum'],
		data: function () {
			return {
				SO: this.SONum,
			}
		},
		methods: {
			getSOInformation() {
				let database = firebase.firestore();
				let repairsRef = database.collection('In Progress Repairs');
				let specificRepair = repairsRef.get(this.SO);
				console.log(specificRepair.data);
			}
		}
	}
</script>

<style scoped>

</style>
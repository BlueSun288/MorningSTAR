<template>
	<div class="mt-2">
		<form-header :card-subtitle="subtitle" :card-title="title"></form-header>
		<repair-listings :repairData="repairData" :repairID="repairID"></repair-listings>
	</div>
</template>

<script>
	import RepairListings from "../components/repairListings";
	import FormHeader from "../components/formHeader";
	import firebase from "@/plugins/firebase";

	export default {
		name: "repair_queue",
		components: {RepairListings, FormHeader},
		async asyncData() {
			let repairData = [
				{
					serviceOrderNumber: "",
					serviceOrderData: {
						customerName: "",
						account: "",
					}
				}
			];

			await firebase
				.firestore()
				.collection("In Progress Repairs")
				.get()
				.then(querySnapshot => {
					querySnapshot.forEach(doc => {
						repairData.push(doc.data());
						repairID.push(doc.id);
					});
				});
			return {
				repairData,
				repairID
			};
		},
		data: function () {
			return {
				title: "Repair Listings",
				subtitle: "All repairs are listed here"
			};
		}
	};
</script>

<style scoped>
</style>
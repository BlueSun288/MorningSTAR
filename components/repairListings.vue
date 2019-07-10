<template>
	<div class="mt-2">
		<form-header :card-subtitle="subtitle" :card-title="title"></form-header>
		<div class="card">
			<div ref="repairList">

			</div>
			<input class="submitButton" type="submit" v-on:click="loadRepairListings()" value="Load Repairs">
		</div>
	</div>
</template>

<script>
	import FormHeader from "./formHeader";
	import firebase from "@/plugins/firebase"
	import ListItem from './listItem'
	import Vue from 'vue'

	export default {
		name: "repairListings",
		components: {ListItem, FormHeader},
		data: function () {
			return {
				title: "Repair Listings",
				subtitle: "All repairs are listed here"
			}
		},

		methods: {
			loadRepairListings() {
				let database = firebase.firestore();
				let repairsRef = database.collection('repairs');
				let allRepairs = repairsRef.get().then(snapshot => {
					snapshot.forEach(doc => {
						console.log(doc.data());
						this.appendToList(doc.data())
					});
				}).catch(error => {
					console.log("error getting documents ", error)
				})
			},
			appendToList(repairEntry) {
				let ComponentClass = Vue.extend(ListItem);
				let instance = new ComponentClass({
					propsData: {
						customerName: repairEntry["Customer Name"],
						accountNumber: repairEntry["Account #"],
						checkinDate: repairEntry["Date Checked in"],
						completionDate: repairEntry["Expected Completion Date"],
						serviceAddress: repairEntry["Service Address"]
					}
				});

				instance.$mount();
				this.$refs.repairList.appendChild(instance.$el);
			}
		}
	}

</script>

<style scoped>

</style>
<template>
	<div class="mt-2">
		<div class="text-center">
			<div ref="repairList" v-on:getSONumber="openWorkflow($event)">

			</div>
			<input class="submitButton hover:shadow" type="submit" v-on:click="loadRepairListings()"
			       value="List All Repairs">
			<input class="submitButton hover:shadow" type="submit" v-on:click="makeListInvisible()"
			       value="Hide Repair Queue">
			<input class="submitButton" type="submit" v-on:click="openWorkflow()" value="Testing workflow">
			<div ref="workflowDiv">

			</div>
		</div>
	</div>
</template>

<script>
	import FormHeader from "./formHeader";
	import firebase from "@/plugins/firebase"
	import ListItem from './listItem'
	import Vue from 'vue'
	import Workflow from "./workflow";

	export default {
		name: "repairListings",
		components: {Workflow, ListItem, FormHeader},
		props: ['collectionName'],
		data: function () {
			return {
				selectedSONumber: String,
				formInvisible: true,
				listInvisible: false
			}
		},

		methods: {
			loadRepairListings() {
				let database = firebase.firestore();
				let repairsRef = database.collection('In Progress Repairs');
				let allRepairs = repairsRef.get().then(snapshot => {
					snapshot.forEach(doc => {
						console.log(doc.data());
						this.appendToList(doc.data(), doc.id)
					});
				}).catch(error => {
					console.log("error getting documents ", error)
				})
			},
			appendToList(repairEntry, docID) {
				let ComponentClass = Vue.extend(ListItem);
				let instance = new ComponentClass({
					propsData: {
						customerName: repairEntry["Customer Name"],
						accountNumber: repairEntry["Account #"],
						checkinDate: repairEntry["Date Checked in"],
						expectedCompletionDate: repairEntry["Expected Completion Date"],
						serviceAddress: repairEntry["Service Address"],
						serviceOrderNumber: docID
					}
				});

				instance.$mount();
				this.$refs.repairList.appendChild(instance.$el);
			},
			makeListInvisible() {
				this.$refs.repairList.style.visibility = 'hidden'
			},
			openWorkflow(event) {
				console.log("Attempting to Open Workflow...");
				let database = firebase.firestore();
				let repairRef = database.collection('In Progress Repairs').doc(docID);
				let getDoc = repairRef.get().then(doc => {
					if (!doc.exists) {
						console.log("Doc doesn't exist");
					} else {
						console.log(doc.data());
						this.appendWorkflowData(doc.data());
					}
				})
					.catch(error => {
						console.log("Error Getting Document", error);
					});
			},
			appendWorkflowData(data) {
				let ComponentClass = Vue.extend(Workflow);
				let instance = new ComponentClass({
					propsData: {
						customerName: data["Customer Name"]
					}
				});
				instance.$mount();
				this.$refs.workflowDiv.appendChild(instance.$el);
			}
		}
	}

</script>

<style scoped>

</style>
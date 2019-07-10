<template>
	<div class="mt-2">
		<form-header v-bind:card-subtitle="subtitle" v-bind:card-title="title"></form-header>
		<form @submit.prevent="sendToFirebase" autocapitalize="on" autocomplete="off" class="card" id="checkinForm">
			<div class="m-2" id="customerInformation">
				<h2 class="gsHeader">Client Information</h2>
				<div class="block" id="topRow">
					<input class="gsTextField focus:outline-none focus:border-gray-700" id="firstName"
					       placeholder="First Name" v-model="firstName">
					<input class="gsTextField focus:outline-none focus:border-gray-700" id="lastName"
					       placeholder="Last Name" v-model="lastName">
					<input class="gsTextField focus:outline-none focus:border-gray-700" id="accountNumber"
					       placeholder="Account #" v-model="account">
				</div>
				<div class="block" id="bottomRow">
					<input class="gsTextField focus:outline-none focus:border-gray-700" id="address"
					       placeholder="Customer Address" v-model="address">
					<input class="gsTextField focus:outline-none focus:border-gray-700" id="phoneNumber" maxlength="11"
					       minlength="10" placeholder="Phone #" v-model="phoneNumber">
					<input class="gsTextField focus:outline-none focus:border-gray-700" id="email"
					       placeholder="Email address" v-model="email">
				</div>
			</div>
			<div class="m-2" id="computerInformation">
				<h2 class="gsHeader">Computer Information</h2>
				<div>
					<select class="focus:outline-none focus:border-gray-700 border-b-2 border-gray-400" id="computerMFG"
					        v-model="computerMFG">
						<option disabled selected>Select Manufacturer</option>
						<option :key="index" v-bind:value="MFGOptions.value"
						        v-for="(MFGOptions, index) in MFGOptions">
							{{ MFGOptions.text }}
						</option>
					</select>
					<input class="gsTextField focus:outline-none focus:border-gray-700" id="modelNumber"
					       placeholder="Model #" type="text" v-model="modelNumber">
					<input class="gsTextField focus:outline-none focus:border-gray-700" id="serialNumber"
					       placeholder="Serial #" type="text" v-model="serialNumber">
				</div>
			</div>
			<div class="m-2" id="repairInformation">
				<h2 class="gsHeader">Repair Information</h2>
				<textarea class="gsTextArea focus:outline-none focus:border-gray-700 max-w-full" cols="50" id="solution"
				          placeholder="Enter QuickFix description" rows="4" v-model="solution"></textarea>
			</div>
			<input class="submitButton" type="submit" value="Submit">
		</form>
	</div>
</template>

<script>
	import FormHeader from "./formHeader";
	import firebase from '@/plugins/firebase'

	export default {
		name: "quickFix",
		components: {FormHeader},
		data: function () {
			return {
				//page data
				title: "Quick Fix Entry",
				subtitle: "For at-the-counter fixes and various other repairs not being checked in",
				//Customer Data
				firstName: "",
				lastName: "",
				address: "",
				phoneNumber: "",
				account: "",
				email: "",
				//Computer Data
				computerMFG: "",
				MFGOptions: [
					{text: "Apple", value: "Apple"},
					{text: "Lenovo", value: "Lenovo"},
					{text: "HP", value: "HP"},
					{text: "Gateway", value: "Gateway"},
					{text: "Toshiba", value: "Toshiba"},
					{text: "MSI", value: "MSI"},
					{text: "Alienware", value: "Alienware"},
					{text: "eMachine", value: "eMachine"},
					{text: "Other", value: "Other"},
				],
				serialNumber: "",
				modelNumber: "",
				//Repair Data
				solution: "",
			}
		},
		mounted() {
		},
		methods: {
			sendToFirebase() {

				const database = firebase.firestore();
				let repair = this.buildDataObject(); //just takes the entered information and puts it in the repair object

				let deviceInformation = {
					"Device MFG": this.computerMFG, //for some reason this doesn't work as a function call, so i'll declare it here
					"Model #": this.modelNumber,
					"Serial #": this.serialNumber,
				};

				database.collection('QuickFixes').add(repair).then(function (docRef) {
					let myId = docRef.id;
					console.log(deviceInformation["Device MFG"]);
					database.collection('QuickFixes').doc(myId).collection('Device Information').add(deviceInformation).then(function (docRef) {
						console.log("Wrote the device Information");
					});
				});

			},
			buildDataObject() {
				let date = new Date();
				const monthNames = ["January", "February", "March", "April", "May", "June",
					"July", "August", "September", "October", "November", "December"
				];
				let myDate = date.getDate() + "/" + monthNames[date.getMonth()] + "/" + date.getFullYear();

				let repair = {
					"Customer Name": this.firstName + " " + this.lastName,
					"Account #": this.account,
					"Service Address": this.address,
					"Phone #": this.phoneNumber,
					"Email": this.email,
					"QuickFix Description": this.solution,
					"Date of Repair": myDate,
					"Repair Completed": true,
				};

				return repair;
			},
		}
	}
</script>

<style scoped>

</style>
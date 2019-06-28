<template>
	<form id="checkinForm" class="card">
		<h1 class="cardHeader">HBC PC Check-In</h1>
		<div id="customerInformation">
			<h2>Enter Customer Information</h2>
			<div id="topRow" class="block">
				<input id="firstName" placeholder="First Name" v-model="firstName" class="textInput">
				<input id="lastName" placeholder="Last Name" v-model="lastName" class="textInput">
				<input id="accountNumber" placeholder="Account #" v-model="account" class="textInput">
			</div>
			<div id="bottomRow">
				<input id="address" placeholder="Customer Address" v-model="address" class="textInput">
				<input id="phoneNumber" placeholder="Phone #" v-model="phone" class="textInput">
				<input id="email" placeholder="Email address" v-model="email" class="textInput">
			</div>
			<div id="computerInformation">
				<h2>Enter Computer Information</h2>
				<div>
					<select id="computerMFG" v-model="computerMFG" class="textInput">
						<option disabled selected>Select Manufacturer</option>
						<option :key="index" v-bind:value="MFGOptions.value"
						        v-for="(MFGOptions, index) in MFGOptions">
							{{ MFGOptions.text }}
						</option>
					</select>
					<input id="modelNumber" placeholder="Model #" type="text" class="textInput">
					<input id="serialNumber" placeholder="Serial #" type="text" class="textInput">
				</div>
			</div>
			<div id="repairInformation">
				<textarea id="problemDescription" placeholder="Describe issues" v-model="problemDescription" class="textInput block text-center mx-auto"></textarea>
				<textarea id="solution" placeholder="Enter repair information" v-model="solution" class="textInput block text-center mx-auto"></textarea>
			</div>
			<div id="accessoryInformation">
				<label for="powerAdapter">Power Adapter?</label>
				<input id="powerAdapter" type="checkbox" v-model="powerCord">
				<label for="bag">Bag?</label>
				<input id="bag" type="checkbox" v-model="bag">
			</div>
		</div>
		<input type="submit" value="Next >" class="nextButton">
	</form>
</template>

<script>
	export default {
		name: "checkin",
		data: function () {
			return {
				//Customer Data
				firstName: "",
				lastName: "",
				address: "",
				phone: "",
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
				//Repair Data
				problemDescription: "",
				solution: "",
				powerCord: "",
				bag:""
			}
		}
	}
</script>

<style scoped>

</style>
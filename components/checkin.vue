<template>
	<div class="mt-2">
		<form-header v-bind:card-subtitle="subtitle" v-bind:card-title="title"></form-header>
		<form class="card" id="checkinForm">
		<div id="customerInformation">
			<h2>Enter Customer Information</h2>
			<div id="topRow">
				<input id="firstName" placeholder="First Name" v-model="firstName">
				<input id="lastName" placeholder="Last Name" v-model="lastName">
				<input id="accountNumber" placeholder="Account #" v-model="account">
			</div>
			<div id="bottomRow">
				<input id="address" placeholder="Customer Address" v-model="address">
				<input id="phoneNumber" placeholder="Phone #" v-model="phone">
				<input id="email" placeholder="Email address" v-model="email">
			</div>
			<div id="computerInformation">
				<h2>Enter Computer Information</h2>
				<div>
					<select id="computerMFG" v-model="computerMFG">
						<option disabled selected>Select Manufacturer</option>
						<option :key="index" v-bind:value="MFGOptions.value"
						        v-for="(MFGOptions, index) in MFGOptions">
							{{ MFGOptions.text }}
						</option>
					</select>
					<input id="modelNumber" placeholder="Model #" type="text">
					<input id="serialNumber" placeholder="Serial #" type="text">
				</div>
			</div>
			<div id="repairInformation">
				<textarea id="problemDescription" placeholder="Describe issues" v-model="problemDescription"></textarea>
				<textarea id="solution" placeholder="Enter repair information" v-model="solution"></textarea>
			</div>
			<div id="accessoryInformation">
				<label for="powerAdapter">Power Adapter?</label>
				<input id="powerAdapter" type="checkbox" v-model="powerCord">
			</div>
			<div id="timeInformation">
				<label for="currentDate">Current Date</label>
				<p id="currentDate">{{new Date().getDate()}}</p>
				<label for="expectedDate">Expected Completion Date</label>
				<input id="expectedDate" type="date">
			</div>
		</div>
	</form>
	</div>
</template>

<script>
    import FormHeader from "./formHeader";

    export default {
		name: "checkin",
        components: {FormHeader},
        data: function () {
			return {
                //page data
                title: "MorningSTAR",
                subtitle: "HBC Computer Check-in",
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
			}
		}
	}
</script>

<style scoped>

</style>
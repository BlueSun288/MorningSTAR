<template>
	<div class="mt-2">
		<form-header v-bind:card-subtitle="subtitle" v-bind:card-title="title"></form-header>
		<form autocapitalize="on" autocomplete="off" class="card" id="checkinForm">
			<div id="customerInformation" class="m-2">
				<h2 class="gsHeader">Apprentice Information</h2>
				<div id="topRow" class="block">
					<input id="firstName" placeholder="First Name" v-model="firstName" class="gsTextField focus:outline-none focus:border-gray-700">
					<input id="lastName" placeholder="Last Name" v-model="lastName" class="gsTextField focus:outline-none focus:border-gray-700">
					<input id="accountNumber" placeholder="Account #" v-model="account" class="gsTextField focus:outline-none focus:border-gray-700">
				</div>
				<div id="bottomRow" class="block">
					<input id="address" placeholder="Customer Address" v-model="address" class="gsTextField focus:outline-none focus:border-gray-700">
					<input id="phoneNumber" placeholder="Phone #" v-model="phone" class="gsTextField focus:outline-none focus:border-gray-700">
					<input id="email" placeholder="Email address" v-model="email" class="gsTextField focus:outline-none focus:border-gray-700">
				</div>
			</div>
			<div id="computerInformation" class="m-2">
				<h2 class="gsHeader">Computer Information</h2>
				<div>
					<select id="computerMFG" v-model="computerMFG" class="focus:outline-none focus:border-gray-700 border-b-2 border-gray-400">
						<option disabled selected>Select Manufacturer</option>
						<option :key="index" v-bind:value="MFGOptions.value"
						        v-for="(MFGOptions, index) in MFGOptions">
							{{ MFGOptions.text }}
						</option>
					</select>
					<input id="modelNumber" placeholder="Model #" type="text" class="gsTextField focus:outline-none focus:border-gray-700">
					<input id="serialNumber" placeholder="Serial #" type="text" class="gsTextField focus:outline-none focus:border-gray-700">
				</div>
			</div>
			<div id="repairInformation" class="m-2">
				<h2 class="gsHeader">Repair Information</h2>
				<textarea id="problemDescription" placeholder="Describe issues" v-model="problemDescription"  cols="50" rows="4" class="gsTextArea focus:outline-none focus:border-gray-700 max-w-full"></textarea>
				<textarea id="solution" placeholder="Enter repair information" v-model="solution" cols="50" rows="4" class="gsTextArea focus:outline-none focus:border-gray-700 max-w-full"></textarea>
			</div>
			<div id="accessoryInformation">
				<label for="powerAdapter">Power Adapter?</label>
				<input id="powerAdapter" type="checkbox" v-model="powerCord">
				<label for="password">Password</label>
				<input id="password" type="text" v-model="password" class="gsTextField focus:outline-none focus:border-gray-700">
			</div>
			<div id="timeInformation">
				<h2 class="gsHeader m-2">Repair Pickup</h2>
				<label for="currentDate" class="font-bold inline">Current Date</label>
				<p id="currentDate" class="inline">{{d = new Date(), d.getDate()}}</p>
				<br>
				<label for="expectedDate" class="inline font-bold">Expected Completion Date</label>
				<input id="expectedDate" class="inline" type="date">
			</div>
			<input type="submit" value="Submit" class="submitButton">
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
	            password: "",
            }
        }
    }
</script>

<style scoped>

</style>
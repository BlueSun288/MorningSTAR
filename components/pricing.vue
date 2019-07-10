<template>
	<div>
		<form-header :card-subtitle="subtitle" :card-title="title"></form-header>
		<form class="card" id="pricingForm">
			<div class="block">
				<ul>
					<li v-for="item in repairOptions" v-model="totalCost"><label v-bind:for="item.text">{{item.text}},
						{{item.priceText}} </label><input type="checkbox" v-bind:id=item.text></li>
				</ul>
		</div>
			<h1 v-model="totalCost">Total Cost: {{totalCost}}</h1>
	</form>
	</div>
</template>

<script>
	import FormHeader from "./formHeader";

	export default {
		name: "pricing",
		components: {FormHeader},
		data: function () {
			return {
				title: "Pricing Information",
				subtitle: "Select Pricing Options",
				repairOptions: [
					{text: "PC Build", priceText: "$140 + Cost of Parts", price: 140},
					{text: "Malware Scans + Diagnostics", priceText: "$70", price: 70},
					{text: "Hardware Install", priceText: "$70", price: 70},
					{text: "Data Transfer", priceText: "$70", price: 70},
					{text: "Networking Issues", priceText: "$25", price: 70},
					{text: "Other/Quick Fix", priceText: "$25", price: 70},
				],
				tax: 0.07375,
			}
			}
		}
	}
</script>

<style scoped>

</style>
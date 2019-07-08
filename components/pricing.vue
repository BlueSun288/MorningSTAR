<template>
	<div>
		<form-header :card-subtitle="subtitle" :card-title="title"></form-header>
		<form class="card" id="pricingForm">
			<div class="block">
				<ul>
					<li v-for="item in repairOptions"><label v-bind:for="item.text">{{item.value}},
						{{item.text}} </label><input type="checkbox" v-bind:id=item.text></li>
				</ul>
		</div>
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
					{text: "PC Build", value: "$140 + Cost of Parts"},
					{text: "Malware Scans + Diagnostics", value: "$70"},
					{text: "Hardware Install", value: "$70"},
					{text: "Networking Issues", value: "$25"},
					{text: "Data Transfer", value: "$70"},
				],
				tax: 0.07375,
				totalCost: "0",
			}
		}
	}
</script>

<style scoped>

</style>
<template>
	<div class="listItemCard mx-auto text-left hover:shadow-lg hover:cursor-pointer" v-on:click="getSONumber()">
		<h1 class="font-bold underline">{{customerName}}</h1>
		<h2 class="font-italic underline"><b>SO:</b>{{serviceOrderNumber}}</h2>
		<ul class="">
			<li><b>Account #:</b> {{accountNumber}}</li>
			<li><b>Service Address:</b> {{serviceAddress}}</li>
			<li><b>Check-in Date:</b> {{checkinDate}}</li>
			<li><b>Expected Completion Date:</b> {{expectedCompletionDate}}</li>
		</ul>
	</div>
</template>

<script>
	export default {
		name: "listItem",
		props: ['customerName', 'accountNumber', 'checkinDate', 'expectedCompletionDate', 'serviceAddress', 'serviceOrderNumber'],
		data: function () {
			return {}
		},
		methods: {
			getSONumber() {
				console.log("Sending Number");
				let temp = this.serviceOrderNumber.toLowerCase();
				//console.log(this.serviceOrderNumber);
				this.$emit("getSONumber", this.serviceOrderNumber);
				//console.log("Emitted SO number: " + this.serviceOrderNumber)
			}
		}
	}
</script>

<style scoped>

</style>
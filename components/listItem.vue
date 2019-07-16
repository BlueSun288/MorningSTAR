<template>
	<div class="listItemCard" v-on:click="getSONumber()">
		<h1 class="font-bold underline">{{customerName}}</h1>
		<nuxt-link class="font-italic underline" :to="{ path:`/serviceorders/${serviceOrderNumber}` }">
			<h2 class="my-2 text-grey-darkest text-lg lg:text-xl">SO: {{ serviceOrderNumber }}</h2>
		</nuxt-link>
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
		props: [
			'customerName', 
			'accountNumber', 
			'checkinDate', 
			'expectedCompletionDate', 
			'serviceAddress', 
			'serviceOrderNumber'
			],
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
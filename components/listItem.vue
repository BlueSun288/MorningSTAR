<template>
	<div class="listItemCard mx-auto text-left">
		<h1 class="font-bold underline">{{customerName}}</h1>
		<ul class="">
			<li><b>Account #:</b> {{accountNumber}}</li>
			<li><b>Service Address:</b>{{serviceAddress}}</li>
			<li><b>Check-in Date:</b>{{checkinDateD}}</li>
			<li><b>Expected Completion Date:</b>{{completionDate}}</li>
		</ul>
	</div>
</template>

<script>
	export default {
		name: "listItem",
		props: ['customerName', 'accountNumber', 'checkinDate', 'completionDate', 'serviceAddress']
	}
</script>

<style scoped>

</style>
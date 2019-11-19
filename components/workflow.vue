<template>
	<div class="card">
		<ul id="customerInformation">
			<li>{{customerName}}</li>
			<li>{{address}}</li>
			<li>{{account}}</li>
			<li>{{email}}</li>
		</ul>
		<ul id="deviceInformation">
			<li>{{computerMFG}}</li>
			<li>{{serialNumber}}</li>
			<li>{{modelNumber}}</li>
		</ul>
		<ul id="repairInformation">
			<li>{{clientDescription}}</li>
			<li>{{wizardDescription}}</li>
			<li>{{password}}</li>
		</ul>
	</div>
</template>

<script>
	export default {
		name: "workflow",
		props: ['customerName', 'address', 'phoneNumber', 'account', 'email', 'computerMFG', 'serialNumber', 'modelNumber', 'clientDescription', 'wizardDescription', 'powerCord', 'password', 'expectedCompletionDate'],
	}
</script>

<style scoped>

</style>
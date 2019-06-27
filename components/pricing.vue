<template>
	<form id="pricingForm">
		<div>
			<label for="1hrLaborFee">1hr Labor Fee ($70)</label>
			<input id="1hrLaborFee" type="checkbox">
			<label for="benchFee">Bench Fee ($25)</label>
			<input id="benchFee" type="checkbox">
			<label for="customFee">Custom Fee</label>
			<input id="customFee" type="number">
		</div>
	</form>
</template>

<script>
	export default {
		name: "pricing"
	}
</script>

<style scoped>

</style>
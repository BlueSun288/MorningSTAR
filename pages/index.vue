<template>
	<div id="container">
		<checkin></checkin>
		<pricing></pricing>
	</div>
</template>

<script>

	import Checkin from "../components/checkin";
	import Pricing from "../components/pricing";

	export default {
		components: {Pricing, Checkin}
	}
</script>

<style>
	html {
		background-color: #FF5722;
	}
</style>

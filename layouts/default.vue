<template>
	<div>
		<navbar></navbar>
		<nuxt/>
	</div>
</template>

<style>
	html {
		background-color: #FF5722;
		font-size: 16px;
		word-spacing: 1px;
		-ms-text-size-adjust: 100%;
		-webkit-text-size-adjust: 100%;
		-moz-osx-font-smoothing: grayscale;
		-webkit-font-smoothing: antialiased;
		box-sizing: border-box;
	}

	*,
	*:before,
	*:after {
		box-sizing: border-box;
		margin: 0;
	}
</style>
<script>
	import Navbar from "../components/navbar";

	export default {
		components: {Navbar},
		methods: {}
	}
</script>
<template>
	<div class="py-4 px-4 bg-navbargray text-white text-center">
		<nuxt-link class="hover:font-bold hover:bg-gray-700 navbar-link" to="/">Home</nuxt-link>
		<nuxt-link class="hover:font-bold hover:bg-gray-700 navbar-link" to="/new_repair">Device Check-In</nuxt-link>
		<nuxt-link class="hover:font-bold hover:bg-gray-700 navbar-link" to="/quick_repair">Quick Fix</nuxt-link>
		<nuxt-link class="hover:font-bold hover:bg-gray-700 navbar-link" to="/repair_queue">Repair Queue</nuxt-link>
		<nuxt-link class="hover:font-bold hover:bg-gray-700 navbar-link" to="/repair_checkout">Check-Out</nuxt-link>
    <search class="inline-flex"></search>
	</div>
</template>

<script>
	import Search from "./search";
  export default {
		name: "navbar",
	  components: {Search}
  }
</script>

<style scoped>

</style>

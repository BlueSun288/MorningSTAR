<template>
	<div class="py-4 px-4 gsNavbar text-white text-center">
		<nuxt-link class="hover:font-bold hover:bg-gray-700 py-4 px-2" to="/">Home</nuxt-link>
		<nuxt-link class="hover:font-bold hover:bg-gray-700 py-4 px-2" to="/new_repair">Device Check-In</nuxt-link>
		<nuxt-link class="hover:font-bold hover:bg-gray-700 py-4 px-2" to="/quick_repair">Quick Fix</nuxt-link>
		<nuxt-link class="hover:font-bold hover:bg-gray-700 py-4 px-2" to="/repair_queue">Repair Queue</nuxt-link>
		<nuxt-link class="hover:font-bold hover:bg-gray-700 py-4 px-2" to="/repair_checkout">Check-Out</nuxt-link>
	</div>
</template>

<script>
	export default {
		name: "navbar"
	}
</script>

<style scoped>

</style>
<template>
	<div class="cardHeader">
		<h1 class="cardHeaderTitle">{{cardTitle}}</h1>
		<h2 class="cardHeaderSubtitle">{{cardSubtitle}}</h2>
	</div>
</template>

<script>
    export default {
        name: "formHeader",
        props: ['cardTitle', 'cardSubtitle'],
        data: function () {
            return {}
        }
    }
</script>

<style scoped>

</style>
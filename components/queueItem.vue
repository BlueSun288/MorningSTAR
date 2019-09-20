<template>
  <div class="card">
    <ul>
      <li>{{docID}}</li>
    </ul>
  </div>
</template>

<script>
	export default {
		name: "queueItem",
      created(){
			this.printLog();
      },
		props: {
			docID: String
	},
		data: function () {
			return {
			}
		},
      methods : {
			printLog(){
          }
      }
	}
</script>

<style scoped>

</style>

<template>
  <div class="card">
    <ul>
      <li>{{serviceOrder}}</li>
      <li>{{clientName}}</li>
      <li>{{accountNumber}}</li>
      <li>{{serviceAddress}}</li>
      <li>{{inDate}}</li>
      <li>{{outDate}}</li>
    </ul>
  </div>
</template>

<script>
	export default {
		name: "queueItem",
		props: ["repair"],
		data: function () {
			return {
				clientName: this.repair['Customer Name'],
				accountNumber: this.repair['Account #'],
				serviceAddress: this.repair['Service Address'],
				inDate: this.repair['Date Checked in'],
				outDate: this.repair['Expected Completion Date'],
			}
		}
	}
</script>

<style scoped>

</style>

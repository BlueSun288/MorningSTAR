<template>
  <div class="card m-2 hover:text-orange-800">
    <ul class="text-left">
      <li class="font-bold">Repair ID : {{repairID}}</li>
      <li>Account #: {{repairData['Account #']}}</li>
      <li>Customer Name: {{repairData['Customer Name']}}</li>
      <li>Check in date: {{repairData['Date Checked in']}}</li>
      <li>Phone Number : {{repairData['Phone #']}}</li>
      <li>Wizard Description of Issue: {{repairData['Wizard Description of Issue']}}</li>
    </ul>
  </div>
</template>

<script>
	export default {
		name: "queueItem",
		props: ['repairID', 'repairData'],
		data: function () {
			return {
			}
		},
      methods : {
      }
	}
</script>

<style scoped>

</style>

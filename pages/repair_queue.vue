<template>
  <div class="mt-2">
    <form-header :card-subtitle="subtitle" :card-title="title"></form-header>
    <div id="repairs">
      <queue-item :key="key" v-for="(repair, key) in repairList"
                  :repairID="repairList[key]['repairID']"
                  :repair-data="repairList[key]['repairData']"
      >

      </queue-item>
    </div>
  </div>

</template>

<script>
	import FormHeader from "../components/formHeader";
	import firebase from '@/plugins/firebase'
  import QueueItem from "../components/queueItem";

	export default {
		name: "repair_queue",
		components: {QueueItem, FormHeader},
      async asyncData(){
			let repairList = [];

	      await firebase
		      .firestore()
		      .collection("In Progress Repairs")
		      .get()
		      .then(querySnapshot => {
			      querySnapshot.forEach(doc => {
			      	repairList.push(
                  {
	                    repairID : doc.id,
                      repairData : doc.data()
                  }
              )
			      });
		      });
	      return {
	      	repairList
	      };
      },
		data: function () {
			return {
				title: "Repair Queue",
				subtitle: "Ongoing Repairs",
          repairList: {},
			}
		},
		methods: {
			createList(){

      }
		}
	}
</script>

<style scoped>

</style>

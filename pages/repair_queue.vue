<template>
  <div class="mt-2">
    <form-header :card-subtitle="subtitle" :card-title="title"></form-header>
    <div id="repairList">
      <queue-item :key="index" v-for="(repairs, index) in async.repairList">{{async.repairList.docID}}</queue-item>
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

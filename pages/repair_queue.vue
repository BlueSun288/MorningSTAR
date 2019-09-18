<template>
	<div class="mt-2">
    <form-header :card-subtitle="subtitle" :card-title="title"></form-header>
    <div id="repairList"></div>
  </div>

</template>

<script>
	import FormHeader from "../components/formHeader";
  import firebase from '@/plugins/firebase'
  import ListItem from '../components/queueItem'
  import Vue from 'vue'

  export default {
		name: "repair_queue",
	  components: {FormHeader},
	  data: function () {
		  return {
			  title: "Repair Queue",
			  subtitle: "Ongoing Repairs"
		  }
	  },
      created(){
			this.fetchRepairs();
      },
	  methods :{
			fetchRepairs(){
				const database = firebase.firestore();
				const repairsRef = database.collection('In Progress Repairs');
		    let allRepairs = repairsRef.get().then(snapshot => {
			  snapshot.forEach(doc => {
				  console.log(doc.data());
				  this.appendToList(doc.data(), doc.id)
			  });
		  }).catch(error => {
			  console.log("error getting documents ", error)
		  })
      },
	    appendToList(repairEntry, docID) {
		    let ComponentClass = Vue.extend(ListItem);
		    let instance = new ComponentClass({
			    propsData: {repairEntry}
		    });
		    instance.$mount();
		    this.$refs.repairList.appendChild(instance.$el);
	    }

    }
  }
</script>

<style scoped>

</style>

<template>
  <div>
    <h1 class="mt-2">Service Order Stuff</h1>
  </div>
</template>

<script>
import firebase from "@/plugins/firebase";

export default {
  async asyncData() {
    let repairData = [];
    let repairID = [];
    // ASYNC FIREBASE DATA FOR THIS SERVICEORDERNUMBER
    
    //     await firebase
    //       .firestore()
    //       .collection("In Progress Repairs")
    //       .get()
    //       .then(querySnapshot => {
    //         querySnapshot.forEach(doc => {
    // 		  repairData.push(doc.data());
    // 		  repairID.push(doc.id);
    //         });
    //       });
    //     return {
    // 	  repairData,
    // 	  repairID
    //     };
  },

  head() {
    return {
      // title: `${this.serviceOrderNumber}`
      title: "Service Order"
    };
  }
};
</script>
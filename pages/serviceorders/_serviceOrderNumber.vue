<template>
  <div class="mt-2">
    <form-header :card-subtitle="subtitle" :card-title="title"></form-header>
  </div>
</template>

<script>
import firebase from "@/plugins/firebase";
import FormHeader from "../../components/formHeader";

export default {
  components: {FormHeader},
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
  data: function () {
    return {
      title: "Service Order Overview",
    }
  },
  head() {
    return {
      // title: `${this.serviceOrderNumber}`
      title: "Service Order"
    };
  }
};
</script>
<template>
  <div class="mt-2">
    <div class="text-center">
      <div id="repairList">
        <List-Item
          :customerName="repair['Customer Name']"
          :accountNumber="repair['Account #']"
          :checkinDate="repair['Date Checked in']"
          :expectedCompletionDate="repair['Expected Completion Date']"
          :serviceAddress="repair['Service Address']"
          :serviceOrderNumber="repairID[key]"
          v-for="(repair, key) in repairData"
          :key="key"
          v-show="!listInvisible"
        />
      </div>

      <!-- <div ref="repairList" v-on:getSONumber="openWorkflow($event)" v-show="!listInvisible"></div> -->
      <button
        @click="listInvisible = !listInvisible"
        v-if="listInvisible"
        class="submitButton hover:shadow"
      >Show Repair Queue</button>
      <button
        @click="listInvisible = !listInvisible"
        v-else
        class="submitButton hover:shadow"
      >Hide Repair Queue</button>
      <input @click="openWorkflow()" class="submitButton" type="submit" value="Testing workflow" />
      <div ref="workflowDiv"></div>
    </div>
  </div>
</template>

<script>
import FormHeader from "./formHeader";
import firebase from "@/plugins/firebase";
import ListItem from "./listItem";
import Vue from "vue";
import Workflow from "./workflow";

export default {
  name: "repairListings",
  components: { Workflow, ListItem, FormHeader },
  props: ["collectionName", "repairID"],
  data: function() {
    return {
      selectedSONumber: String,
      formInvisible: true,
      listInvisible: false
    };
  },

  // CHECK THIS
  mounted() {
    // this.loadRepairListings();
  },
  props: ["repairData", "repairID"],

  methods: {
    // loadRepairListings() {
    //   let database = firebase.firestore();
    //   let repairsRef = database.collection("In Progress Repairs");
    //   let allRepairs = repairsRef
    //     .get()
    //     .then(snapshot => {
    //       snapshot.forEach(doc => {
    //         console.log(doc.data());
    //         // this.appendToList(doc.data(), doc.id);
    //       });
    //     })
    //     .catch(error => {
    //       console.log("error getting documents ", error);
    //     });
    // },
    // appendToList(repairEntry, docID) {
    //   let ComponentClass = Vue.extend(ListItem);
    //   let instance = new ComponentClass({
    //     propsData: {
    //       customerName: repairEntry["Customer Name"],
    //       accountNumber: repairEntry["Account #"],
    //       checkinDate: repairEntry["Date Checked in"],
    //       expectedCompletionDate: repairEntry["Expected Completion Date"],
    //       serviceAddress: repairEntry["Service Address"],
    //       serviceOrderNumber: docID
    //     }
    //   });
    //   instance.$mount();
    //   this.$refs.repairList.appendChild(instance.$el);
    // },
    // openWorkflow(event) {
    //   console.log("Attempting to Open Workflow...");
    // },
    // appendWorkflowData(data) {
    //   let ComponentClass = Vue.extend(Workflow);
    //   let instance = new ComponentClass({
    //     propsData: {
    //       customerName: data["Customer Name"]
    //     }
    //   });
    //   instance.$mount();
    //   this.$refs.workflowDiv.appendChild(instance.$el);
    // }
  }
};
</script>

<style scoped>
</style>
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

  methods: {}
};
</script>

<style scoped>
</style>
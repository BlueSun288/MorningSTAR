import PurgecssPlugin from 'purgecss-webpack-plugin'
import glob from 'glob-all'
import path from 'path'
import purgecss from '@fullhuman/postcss-purgecss'


export default {
  mode: "universal",
  /*
   ** Headers of the page
   */
  head: {
    title: process.env.npm_package_name || "",
    meta: [
      { charset: "utf-8" },
      { name: "viewport", content: "width=device-width, initial-scale=1" },
      {
        hid: "description",
        name: "description",
        content: process.env.npm_package_description || ""
      },
      {name: "theme-color", content="#FF5722"}
    ],
    link: [{ rel: "icon", type: "image/x-icon", href: "/favicon.png" }],
  },
  /*
   ** Customize the progress-bar color
   */
  loading: { color: "#fff" },
  /*
   ** Global CSS
   */
  css: ["~/assets/css/tailwind.css"],
  /*
   ** Plugins to load before mounting the App
   */
  render: {
    maxAge: 600
  },
  plugins: [{ src: "@/plugins/firebase.js" }],
  /*
   ** Nuxt.js modules
   */
  modules: [
    // Doc: https://axios.nuxtjs.org/usage
    "@nuxtjs/axios",
    "@nuxtjs/pwa",
    "nuxt-compress"
  ],
  /*
   ** Axios module configuration
   ** See https://axios.nuxtjs.org/options
   */
  axios: {},
//   DYNAMIC ROUTES
//   generate: {
//     async routes() {
//       const { data: repairs } = await api.get("YOUR API/FIRESTORE DB HERE");
//       return repairs.map(repair => `/serviceorders/${repair.serviceOrderNumber}`);
//     }
//   },
  /*
   ** Build configuration
   */
  build: {
    postcss: {
      plugins: { tailwindcss: "./tailwind.config.js" }
    },
    /*
     ** You can extend webpack config here
     */
    extend(config, ctx) {}
  }
};

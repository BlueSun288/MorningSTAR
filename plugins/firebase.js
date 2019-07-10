import * as firebase from 'firebase';

const firebaseConfig = {
	apiKey: "AIzaSyA6nzSzA7GKmVgWK4oVLubjgUziQBXZkY0",
	authDomain: "hbc-morningstar.firebaseapp.com",
	databaseURL: "https://hbc-morningstar.firebaseio.com",
	projectId: "hbc-morningstar",
	storageBucket: "hbc-morningstar.appspot.com",
	messagingSenderId: "39135870320",
	appId: "1:39135870320:web:71a47946b31a2b36"
};


export default !firebase.apps.length ? firebase.initializeApp(firebaseConfig) : firebase.app();
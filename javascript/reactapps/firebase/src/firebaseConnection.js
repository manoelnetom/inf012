import firebase from 'firebase/app'
import 'firebase/firebase-firestore'
import 'firebase/firebase-auth'

let firebaseConfig = {
    apiKey: "AIzaSyApr4ms-z9mNxBg6R-LrcgefKfvWqminFI",
    authDomain: "inf012.firebaseapp.com",
    projectId: "inf012",
    storageBucket: "inf012.appspot.com",
    messagingSenderId: "541302410071",
    appId: "1:541302410071:web:7bd66803460ce0e9c60c12",
    measurementId: "G-800SXYDMSY"
  };
  // Initialize Firebase
  if(!firebase.apps.length){
    firebase.initializeApp(firebaseConfig);
  }

  export default firebase;
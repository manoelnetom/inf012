import firebase from 'firebase/app'
import 'firebase/firebase-firestore'


 let firebaseConfig = {
    apiKey: "AIzaSyD_j7ZcGXe_wI8CrMcB0YOPwm7oaDrnBFs",
    authDomain: "aulafirebase-b6d62.firebaseapp.com",
    projectId: "aulafirebase-b6d62",
    storageBucket: "aulafirebase-b6d62.appspot.com",
    messagingSenderId: "551176574178",
    appId: "1:551176574178:web:2b096e027cfb251f71fabb",
    measurementId: "G-PN89LH4JZJ"
  };
  // Initialize Firebase
  if(!firebase.apps.length){
    firebase.initializeApp(firebaseConfig);
  }
  export default firebase;
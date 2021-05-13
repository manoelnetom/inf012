import firebase from 'firebase/app';
import 'firebase/auth';
import 'firebase/firebase-firestore';
import 'firebase/storage';

let firebaseConfig = {
    apiKey: "AIzaSyAzRlJF173krhShiWq1b6ZOUrxqDx-b5cA",
    authDomain: "chamados-ec14d.firebaseapp.com",
    projectId: "chamados-ec14d",
    storageBucket: "chamados-ec14d.appspot.com",
    messagingSenderId: "959691341269",
    appId: "1:959691341269:web:5238ce2457396ef8ae515c",
    measurementId: "G-BC4VV476KX"
  };
  // Initialize Firebase

  if(firebase.apps.length===0)
      firebase.initializeApp(firebaseConfig);

 export default firebase;     
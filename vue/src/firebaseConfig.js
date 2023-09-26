// Import the functions you need from the SDKs you need
import { initializeApp } from "firebase/app";
import { getAnalytics } from "firebase/analytics";
// TODO: Add SDKs for Firebase products that you want to use
// https://firebase.google.com/docs/web/setup#available-libraries

// Your web app's Firebase configuration
// For Firebase JS SDK v7.20.0 and later, measurementId is optional
const firebaseConfig = {
  apiKey: "AIzaSyCGEhB9_VVLxZmCt7EF71N1wtW064-m7HM",
  authDomain: "phishing123-2ca57.firebaseapp.com",
  projectId: "phishing123-2ca57",
  storageBucket: "phishing123-2ca57.appspot.com",
  messagingSenderId: "927504730410",
  appId: "1:927504730410:web:6e2a38375f45e5f123b653",
  measurementId: "G-42WFE5MVWE"
};
// Initialize Firebase
const firebaseApp = initializeApp(firebaseConfig);
export default firebaseApp

// export default initializeApp(firebaseConfig);

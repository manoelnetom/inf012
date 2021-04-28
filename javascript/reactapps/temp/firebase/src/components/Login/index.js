import firebase from '../../firebaseConnection'
import { useState,useEffect, useContext } from 'react'
import './login.css'
import {UserContext} from '../../contexts/user'

function Login() {
  const {user, setUser}=useContext(UserContext);
  //const [user, setUser]=useState({});
  const [email, setEmail]=useState('');
  const [senha, setSenha]=useState('');
  const [isLoged, setIsLoged]=useState(false);

  useEffect(()=>{
    async function checkLogin(){
      await firebase.auth().onAuthStateChanged((user)=>{
        if(user){
          setIsLoged(true);
          setUser({
            uid:user.uid,
            email:user.email,
            photoURL:user.photoURL
          })
        }else{
          setIsLoged(false);
          setUser({});
        }
      })
    }
    checkLogin();
  },[setUser]);
  
  

 async function logout(){
   await firebase.auth().signOut()
   .then(()=>{
     alert('Fez logout');
   })
 }

 async function login(){
  await firebase.auth()
  .signInWithEmailAndPassword(email,senha)
  .then((value)=>{
    console.log(value);
  })
  .catch((error)=>{
    console.log(error);
    alert(error.message);
  })
}

async function loginWithGmail(){
  var provider = new  firebase.auth.GoogleAuthProvider();
    provider.addScope('profile');
    provider.addScope('email');
    firebase.auth().signInWithPopup(provider).then( (result) =>{
      // This gives you a Google Access Token.
      //var token = result.credential.accessToken;
      // The signed-in user info.
      //var user1 = result.user;
      //console.log(token);
      //console.log(user1);
    });

}


  return (
    

    <div>
      {isLoged && (
      <div>
        <strong>Seja Bem-Vindo!</strong>
        <span>{user.uid} - {user.email}</span>
      </div>
    )}
      <div className="imgcontainer">
        <img src={user.photoURL} alt="Avatar" className="avatar" />
      </div>
      <div className="conteiner">
        <label><b>Email</b></label>
        <input type="text" placeholder=" email" onChange={(e)=>{setEmail(e.target.value)}} required />

        <label><b>Senha</b></label>
        <input type="password" placeholder=" Senha" onChange={(e)=>{setSenha(e.target.value)}} required />

        <button onClick={()=>{login()}}>Login</button>
        <button onClick={()=>{logout()}}>Logout</button>
        <div className="conteiner">
         <button onClick={()=>{loginWithGmail()}}>Login Google</button>
          <span className="psw">Forgot password?</span>
        </div>
      </div>
    </div>
  );
}

export default Login;
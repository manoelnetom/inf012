import { useState } from "react";
import './usuarios.css'
import firebase from '../../firebaseConnection'

function Usuarios(){
    const [email, setEmail]=useState('');
    const [senha, setSenha]=useState('');
    const [user, setUser]=useState({});
   async function addUser(){
       await firebase.auth()
       .createUserWithEmailAndPassword(email,senha)
       .then((value)=>{
           console.log(value);
           setUser({
               uid:value.user.uid,
               email:value.user.email,
               token:value.user.refreshToken
           }) 
       })
       .catch((error)=>{
        console.log(error.code);
        if(error.code==='auth/invalid-email'){
            alert('O formato de email e invalido');
        }else if (error.code==='auth/email-already-in-use'){
            alert('Esse email ja esta sendo usado');
        }
       })
    }
    return(
        <div className="cadastro">

        <label>Email:</label>
        <input type="text" value={email} onChange={(e)=>{setEmail(e.target.value)}}/>
        <label>Senha:</label>
        <input type="password" value={senha} onChange={(e)=>{setSenha(e.target.value)}}/>
        <button onClick={()=>{addUser()}}>Add User</button>
        <strong>{user.uid} - {user.email}</strong>
        </div>
    );
}

export default Usuarios;
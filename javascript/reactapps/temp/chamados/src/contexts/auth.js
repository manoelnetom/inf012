
import { useState, createContext, useEffect } from 'react'
import { toast } from 'react-toastify';
import firebase from '../services/firebaseConnection';

export const AuthContext = createContext({});

function AuthProvider({children}) {
    const [user, setUser] = useState(null);
    const [loading, setLoading] = useState(false);

    useEffect(()=>{
        function loadUser(){
            const usuarioArmazenado = localStorage.getItem('usuarioLocal');
            if(usuarioArmazenado){
                setUser(JSON.parse(usuarioArmazenado));
            }
        }
        loadUser();
    },[]);

    async function signUp(email, password, nome){
        await firebase.auth().createUserWithEmailAndPassword(email, password)
        .then(async (cadastrado)=>{
            let data ={
                uid:cadastrado.user.uid,
                nome:nome,
                email:email,
                avatarUrl:null
            };
            await firebase.firestore().collection('users')
            .doc(data.uid)
            .set({
                nome:nome,
                avatarUrl:null
            })
            .then(()=>{
                setUser(data);
                localStorage.setItem('usuarioLocal', JSON.stringify(data));
                toast.success('Usuario Cadastrado');
            })
            .catch((error)=>{
                toast.error('Ops erro no Cadastro');
            })
        })
        .catch((error)=>{
            alert(error.code)
            if(error.code==='auth/email-already-in-use')
              toast.error('auth/email-already-in-use');
        })
    }

    async function signOut(){
        await firebase.auth().signOut()
        .then(()=>{
            setUser(null);
            localStorage.removeItem('usuarioLocal');
        })
    }

    async function signIn(email, password){
        await firebase.auth().signInWithEmailAndPassword(email,password)
        .then( async (value) =>{
            let uid= value.user.uid;
            let usuario = await firebase.firestore().collection('users')
            .doc(uid)
            .get();

            let data ={
                uid:uid,
                nome:usuario.data().nome,
                email:email,
                avatarUrl: usuario.data().avatarUrl
            }
            setUser(data);
            localStorage.setItem('usuarioLocal', JSON.stringify(data));
            toast.success('Bem-vindo de Volta!');
        })
        .catch((error)=>{
            toast.error('ops...problema no login');
        })
    }

    return(
        <AuthContext.Provider value={
            {
                signed:!!user,
                loading,
                signUp,
                signOut,
                signIn,
                setUser,
                user
               
                
            }
        }>
            {children}
        </AuthContext.Provider>
    );

} export default AuthProvider;
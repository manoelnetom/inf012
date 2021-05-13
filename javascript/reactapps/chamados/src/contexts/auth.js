import { useState, createContext, useEffect } from 'react'
import firebase from '../services/firebaseConnection'
import { toast } from 'react-toastify';
export const AuthContext = createContext({});

function AuthProvider({ children }) {
    const [user, setUser] = useState(null);
    //const [loadingAuth, setLoadingAuth] = useState(false);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        function loadUser() {
            const storagedUser = localStorage.getItem("usuarioLogado");
            if (storagedUser) {
                setUser(JSON.parse(storagedUser));
                //setLoading(true);
            }
            //setLoading(false);
        }
        loadUser();
    }, []);

    async function signUp(email, password, nome) {
        setLoading(true);
        await firebase.auth().createUserWithEmailAndPassword(email, password)
            .then(async (value) => {
                let data = {
                    uid: value.user.uid,
                    nome: nome,
                    email: email,
                    avatarUrl: null
                };
                await firebase.firestore().collection('users')
                    .doc(data.uid)
                    .set({
                        nome: nome,
                        avatarUrl: null
                    })
                    .then(() => {
                        setUser(data);
                        localStorage.setItem('usuarioLogado', JSON.stringify(data));
                        setLoading(false);
                        toast.success('Usuário Cadastrado');
                    })
                    .catch((error) => {
                        console.log(error);
                        setLoading(false);
                        toast.error('Ops....ocorreu algum erro');
                    })
            })
            .catch((error) => {
                console.log(error);
                setLoading(false);
                toast.error('Ops....ocorreu algum erro');
            })
    }

    async function signIn(email, password) {
        setLoading(true);
        await firebase.auth().signInWithEmailAndPassword(email, password)
            .then(async (value) => {
                let uid = value.user.uid;

                let usuario = await firebase.firestore().collection('users')
                    .doc(uid)
                    .get();
                let data = {
                    uid: uid,
                    nome: usuario.data().nome,
                    email: email,
                    avatarUrl: usuario.data().avatarUrl
                }
                //console.log(usuario.data());
                setUser(data);
                setLocalUser(data);
                setLoading(false);
                toast.success('Bem-vindo de volta!!');
            })
            .catch((error) => {
                console.log(error);
                setLoading(false);
                toast.success('Ops ocorreu algum erro!');
            })
    }


    async function signOut() {
        await firebase.auth().signOut();
        localStorage.removeItem('usuarioLogado');
        setUser(null);
    }

    function setLocalUser(data){
        localStorage.setItem('usuarioLogado', JSON.stringify(data));
    }

    return (
        <AuthContext.Provider value={{
            signed: !!user,
            user,
            signUp,
            signOut,
            signIn,
            loading,
            setUser,
            setLocalUser
        }}>
            {children}
        </AuthContext.Provider>
    );
}
export default AuthProvider;
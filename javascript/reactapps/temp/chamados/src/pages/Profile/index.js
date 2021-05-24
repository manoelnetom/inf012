import { useContext, useState } from 'react';
import { FiSettings, FiUpload } from 'react-icons/fi';
import Header from '../../components/Header';
import Title from '../../components/Title';
import {AuthContext} from '../../contexts/auth';
import avatar from '../../assets/avatar.png';
import './profile.css';
import { toast } from 'react-toastify';
import firebase from '../../services/firebaseConnection';
function Profile(){
    
    const {user, signOut, setUser} = useContext(AuthContext);
    const [avatarUrl, setAvatarUrl]=useState(user && user.avatarUrl)
    const [imageAvatar, setImageAvatar]=useState(null);
    const [nome,setNome]=useState(user && user.nome);
    const [email,setEmail]=useState(user && user.email);

    function handleFile(e){
        const image = e.target.files[0];
        if(image && (image.type==='image/jpeg' || image.type==='image/png')){
            setImageAvatar(image);
            setAvatarUrl(URL.createObjectURL(image));
        }else{
            toast.warning('selecione uma imagem png ou jpeg');
            setImageAvatar(null);
        }
    }

   async function handleSave(e){
        e.preventDefault();
        if(imageAvatar===null&&nome!==''){
            //Salvar apenas o nome
            await firebase.firestore().collection('users')
            .doc(user.uid)
            .update({
                nome:nome
            })
            .then(()=>{
                let data ={
                    ...user,
                    nome:nome
                }
                setUser(data);
                localStorage.setItem('usuarioLocal', JSON.stringify(data));
                toast.success('perfil atualizado com sucesso');
            })
            .catch((error)=>{
                toast.error('ops deu ruim!');
            })
        }else if(imageAvatar!==null&&nome!==''){
            //Salvar os dois
            handleUpload();
        }

    }

    async function handleUpload(){
        const currentUid=user.uid;
        const uploadTask = await firebase.storage()
        .ref(`images/${currentUid}/${imageAvatar.name}`)
        .put(imageAvatar)
        .then(async ()=>{
            toast.success('Foto enviada com sucesso');
            await firebase.storage()
            .ref(`images/${currentUid}`)
            .child(imageAvatar.name).getDownloadURL()
            .then( async (url)=>{
                await firebase.firestore().collection('users')
                .doc(currentUid)
                .update({
                    avatarUrl:url,
                    nome:nome
                })
                .then(()=>{
                    let data={
                        ...user,
                        nome:nome,
                        avatarUrl:url
                    }
                    setUser(data);
                    localStorage.setItem('usuarioLocal', JSON.stringify(data));
                }).catch((error)=>{
                    toast.error('Problema ao salvar nome da imagem no banco');
                })
            })
        }).catch((error)=>{
            toast.error('Problema ao fazer upload');
        })
    }

    return(
    <div>
        <Header/>
        <div className="content">
            <Title nome="Meu Perfil">
                <FiSettings size={25}/>
            </Title>

            <div className="container">
                <form onSubmit={(e)=>handleSave(e)} className="form-profile">
                    <label className="label-avatar">
                        <span>
                            <FiUpload color="#000" size={25}/>
                        </span>
                        <input type="file" accept="image/*" onChange={handleFile}/><br/>
                        {avatarUrl===null ?
                            <img src={avatar} width="250" height="250" alt="Foto de perfil do usuario"/>
                        :
                        <img src={avatarUrl} width="250" height="250" alt="Foto de perfil do usuario"/>
                        }
                    </label>

                    <label>Nome</label>
                    <input type="text" value={nome} onChange={(e)=>setNome(e.target.value)}/>
                    <label>Email</label>
                    <input type="text" value={email} disabled={true}/>
                
                     <button type="submit">Salvar</button>   
                </form>

            </div>
            <div className="container">
            <button className="logout-btn" onClick={ () => signOut() } >
               Sair
            </button>
        </div>
        </div>
    </div>);

}export default Profile;
import { useContext, useState } from 'react';
import { FiSettings, FiUpload } from 'react-icons/fi';
import Header from '../../components/Header';
import Title from '../../components/Title';
import {AuthContext} from '../../contexts/auth';
import avatar from '../../assets/avatar.png';
import './profile.css';
function Profile(){
    
    const {user, signOut, setUser} = useContext(AuthContext);
    const [avatarUrl, setAvatarUrl]=useState(user && user.avatarUrl)
    const [nome,setNome]=useState(user && user.nome);
    const [email,setEmail]=useState(user && user.email);

    function handleFile(){

    }

    return(
    <div>
        <Header/>
        <div className="content">
            <Title nome="Meu Perfil">
                <FiSettings size={25}/>
            </Title>

            <div className="container">
                <form className="form-profile">
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
                    <input type="text" value={email} onChange={(e)=>setEmail(e.target.value)}/>
                
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
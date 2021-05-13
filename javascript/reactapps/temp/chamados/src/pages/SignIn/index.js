import {useContext, useState} from 'react';
import logo from '../../assets/login.png';
import {Link} from 'react-router-dom';
import {AuthContext} from '../../contexts/auth';
import './signin.css';
import { toast } from 'react-toastify';

export default function SignIn() {

    const [email, setEmail]=useState('');
    const [senha, setSenha]=useState('');
    const {signIn}=useContext(AuthContext);
    function handleSubmit(e) {
        e.preventDefault();
        if(email!==''&&senha!==''){
          signIn(email,senha);
        }else{
          toast.error('Preencha todos os campos!');
        }
    }

    return(
        <div className="conteiner-center">
        <div className="login">
         
          <div className="login-area">
            <img src={logo} alt="Logo do Sistema"/>
          </div>
        
          <form onSubmit={(e)=>handleSubmit(e)}>
            <h1>Entrar</h1>
            <input type="text" value={email} placeholder="email@email.com"  onChange={(e)=>{setEmail(e.target.value)}} />
  
            <input type="password" value={senha} placeholder="*****" onChange={(e)=>{setSenha(e.target.value)}}/>
            <button type="submit">Acessar</button>
          </form>
        
          <Link to="/register">Criar uma conta</Link>
      
        </div>
      </div>
    );
 }
 
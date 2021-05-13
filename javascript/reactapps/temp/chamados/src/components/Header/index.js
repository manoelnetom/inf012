import './header.css'
import avatar from '../../assets/avatar.png';
import { Link } from 'react-router-dom';
import {FiHome, FiUser, FiSettings} from 'react-icons/fi';
function Header(){

    return(
        <div className="sidebar">
            <div>
                <img alt="Foto avatar" src={avatar}/>
            </div>
            <Link to="/dashboard">
                <FiHome color="#FFF" size={24}/>
                Chamados
            </Link>
            <Link to="/costumers">
                <FiUser color="#FFF" size={24}/>
                Clientes
            </Link>
            <Link to="/profile">
                <FiSettings color="#FFF" size={24}/>
                Configuracoes
            </Link>
        </div>
    );


}
export default Header;
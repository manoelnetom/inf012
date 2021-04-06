import './index.css';
import {Link} from 'react-router-dom';
function Menu(){


    return(
        <div className="topnav">
            
            <Link className="active" to="/">Home</Link>
            <Link to="/sobre">Sobre</Link>
            
        </div>
    );
}

export default Menu;
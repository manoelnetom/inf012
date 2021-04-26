import {Link} from 'react-router-dom'
import './menu.css'
function Menu() {
    return (
        <div className="topnav">
            <Link to="/">Home</Link>
            <Link to="/login">Login</Link>
        </div>
    );
}
export default Menu;
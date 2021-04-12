import { Link } from 'react-router-dom';
import './menu.css'

function Menu() {
    return (
        <div className="topnav">
            <Link className="active" to="/">Home</Link>
            <Link to="/questao1">Questão 1</Link>
            <Link to="/questao2">Questão 2</Link>
            <Link to="/questao3">Questão 3</Link>
        </div>
    );
}
export default Menu;
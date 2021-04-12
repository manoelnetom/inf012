import { Link } from "react-router-dom";
import './styles.css'
function Menu() {
    return (
        <div className="topnav">
            <Link to="/" className="active">Home</Link>
            <Link to="/questao1">Questão 1</Link>
            <Link to="/questao2">Questão 2</Link>
            <Link to="/questao3">Questão 3</Link>
            <Link to="/questao4">Questão 4</Link>
        </div>
    );
}
export default Menu;
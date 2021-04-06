import './styles.css';
import { Link } from 'react-router-dom';
function Menu() {

    function myFunction() {
        var x = document.getElementById("myTopnav");
        if (x.className === "topnav") {
            x.className += " responsive";
        } else {
            x.className = "topnav";
        }
    }
    return (
        <div className="topnav" id="myTopnav">
            <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"></link>
            <Link className="active" to="/">Cronômetro</Link>
            <Link to="/biscoito">Biscoito da Sorte</Link>
            <a className="icon" onClick={()=>myFunction()}>
                <i className="fa fa-bars"></i>
            </a>
        </div>
    );
}
export default Menu;
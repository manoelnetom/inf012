
import './home.css'
import {Link} from 'react-router-dom';

function Home(){
    return(
        <div className="conteiner">
        <header>Lista de Exercicios 1</header>
         <p>Esse site é uma app web para 
             resolver a lista de exercicios 
             que esta no <a href="https://ads.ifba.edu.br/dl34">site de ADS </a></p>
            <ul>
                <li><Link to="/questao1">Questão 1</Link></li>
                <li><Link to="/questao2">Questão 2</Link></li>
                <li><Link to="/questao3">Questão 3</Link></li>
            </ul>
        </div>
    );
}

export default Home;
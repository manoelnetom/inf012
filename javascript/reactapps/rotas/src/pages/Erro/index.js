import {Link} from 'react-router-dom';
function Erro() {
    return (

       
	<div id="notfound">
    <div className="notfound">
        <div className="notfound-404">
            <h1>404</h1>
        </div>
        <h2>Oops! Página não encontrada</h2>
        <p>Desculpe mas a página solicitada não existe ou pode ter sido movida</p>
        <Link to="/">Volte para o Home desse Site</Link>
    </div>
    </div>
    );

} export default Erro;
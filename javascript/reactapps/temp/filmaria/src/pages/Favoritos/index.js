import {useState, useEffect} from 'react'
import {Link} from 'react-router-dom'
import { toast } from 'react-toastify';
import './favoritos.css'

export default function Favoritos() {
    const [salvos, setSalvos] = useState([]);

    useEffect(()=>{
        let filmesSalvos = JSON.parse(localStorage.getItem("filmes")) || [];
        setSalvos(filmesSalvos);
    },[]);

    function excluirFilme(id){
        let filmes = salvos.filter((item) => {
            return item.id !== id;
        });
        setSalvos(filmes);
        localStorage.setItem("filmes",JSON.stringify(filmes));
        toast.info("Filme Excluido com sucesso");
    }

    return (
        <div className="meus-filmes">
            <h1>Meus Filmes</h1>
            {salvos.length === 0 && <span> Você não possui filmes salvos :(</span>}
            <ul>
            {salvos.map((item) => {
                    return (
                        <li key={item.id}>
                            <span> {item.nome} </span>
                            <div>
                                <Link to={`/filme/${item.id}`}>Ver Detalhes</Link>
                                <button onClick={() => excluirFilme(item.id)}>Excluir</button>
                            </div>
                        </li>
                    );
                })}
            </ul>
        </div>
    );

}
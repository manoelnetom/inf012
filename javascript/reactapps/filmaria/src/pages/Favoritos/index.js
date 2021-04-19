
import { useEffect, useState } from 'react'
import { Link } from 'react-router-dom';
import './favoritos.css'
import {toast} from 'react-toastify'

export default function Favoritos() {

    const [salvos, setSalvos] = useState([]);

    useEffect(() => {
        let filmes = JSON.parse(localStorage.getItem("filmes")) || [];
        setSalvos(filmes);
    }, []);

    function excluirFilmes(id) {
        let filmes = salvos.filter((item) => {
            return item.id !== id;
        });
        setSalvos(filmes);
        localStorage.setItem("filmes", JSON.stringify(filmes));
        toast.success('Filme Excluído com Sucesso!')
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
                                <button onClick={() => excluirFilmes(item.id)}>Excluir</button>
                            </div>
                        </li>
                    );
                })}
            </ul>
        </div>
    );
}
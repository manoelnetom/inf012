import { useState, useEffect } from 'react'
import api from '../../services/api.js'
import { Link } from 'react-router-dom'
import './home.css'

export default function Home() {
    const [filmes, setFilmes] = useState([]);

    useEffect(() => {
        async function loadFilmes() {
            let response = await api.get('r-api/?api=filmes/');
            setFilmes(response.data);
        }
        loadFilmes();
    }, []);

    return (
        <div className="conteiner">
            <div className="lista-filmes">
                {filmes.map((item) => {
                    return (
                        <article key={item.id}>
                            <strong>{item.nome}</strong>
                            <img src={item.foto} alt={item.nome} />
                            <Link to="/">Acessar</Link>
                        </article>

                    );
                })}

            </div>
        </div>
    )
}
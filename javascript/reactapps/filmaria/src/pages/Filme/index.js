
import {useParams, useHistory } from 'react-router-dom'
import { useState, useEffect } from 'react'
import api from '../../services/api.js';
import './filme.css'
import {toast} from 'react-toastify'

export default function Filme() {

    const { id } = useParams();
    const [filme, setFilme] = useState({});
    const [loading, setLoading] = useState(true);
    const history = useHistory();
    useEffect(() => {
        async function loadFilme() {
            const response = await api.get('/r-api/?api=filmes/' + id);
            if(response.data.length===0){
                history.replace('/'); // manda para Home
                return;
            }
            setFilme(response.data);
            setLoading(false);
        }
        loadFilme();
    }, [history,id]);

    function salvarFilme(){
        let filmesSalvos = JSON.parse(localStorage.getItem("filmes"))|| [];
        let hasFilme = filmesSalvos.some((item)=>item.id===filme.id);
        if(hasFilme){
            toast.error('Você ja Salvou esse filme');
            return;
        } 
        filmesSalvos.push(filme);
        localStorage.setItem("filmes", JSON.stringify(filmesSalvos));
        toast.success('Filme salvo com sucesso');
    }


    if (loading) {
        return (
            <div className="filme-info">
                <h1>carregando filme... </h1>
            </div>
        );
    } else {
        return (
            <div className="filme-info">
                <h1> {filme.nome} </h1>
                <img src={filme.foto} alt={filme.nome}/>
                <h3>Sinopse</h3>
                {filme.sinopse}
                <div>
                    <button onClick={()=>salvarFilme()}>Salvar</button>
                    <button>
                        <a target="blank" href={`https://www.youtube.com/results?search_query=${filme.nome} treiler`}>Treiler</a>
                    </button>
                </div>
            </div>
        );
    }
}
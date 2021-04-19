
import api from '../../services/api.js';
import {useEffect, useState} from 'react'
import './index.css'
import { Link } from 'react-router-dom';


function Home() {
    const [filmes, setFilmes]=useState([]);
      useEffect(()=>{
        async function loadFilmes(){
          const response = await api.get('/r-api/?api=filmes');
          setFilmes(response.data);
        }
         loadFilmes();
      },[]);

    return (
      <div className="conteiner">
        <div className="lista-filmes">
          {filmes.map((item)=>{
            return (
              <article key={item.id}>
                <strong>{item.nome}</strong>
                <img src={item.foto} alt={item.nome}/>
                <Link to={`/filme/${item.id}`}>Acessar</Link>
              </article>
            );
          })}
        </div>
      </div>
    );
  }
  
  export default Home;
  
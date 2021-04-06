import { useEffect, useState } from "react";
import './index.css';
import axios from 'axios';
function Nutricao(){
    const [dicas, setDicas] = useState([]);  
    useEffect(()=>{
        let url="https://sujeitoprogramador.com/rn-api/?api=posts";
        axios.get(url).then(response=>{
          let myjason = response.data;
            setDicas(myjason);
          } 
        ).catch((erro)=>{
          alert('Deu erro'+ erro);
        })
    },[]);

    return (
        <div className="container">
          <header>
            <strong>Nutri Dicas</strong>
          </header>
    
          {dicas.map((item)=>{
            return(
              <article key={item.id} className="post">
                <strong className="titulo">{item.titulo}</strong>
    
                <img src={item.capa} alt={item.titulo} className="capa" />
                <p className="subtitulo">
                  {item.subtitulo}
                </p>
                <button className="botao">Acessar</button>
              </article>
            )
          })}
        </div>
      );
}

export default Nutricao;
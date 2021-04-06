import { useEffect, useState } from 'react';
import './styles.css';
import axios from 'axios';

function Nutricao() {

    const [dicas, setDicas] = useState([]);

    useEffect(() => {
        let url = 'https://sujeitoprogramador.com/rn-api/?api=posts';
       /* fetch(url).then((response) => {
            console.log(response);
            return response.json()
        }).then((myjason) => {
            console.log(myjason);
            setDicas(myjason);
        }).catch((error) =>{
            console.log('There has been a problem with your fetch operation: ' + error.message);
          });
         */
          axios.get(url).then(response=>{
            let myjason = response.data;
              setDicas(myjason);
            } 
          ).catch((erro)=>{
            alert('Deu erro'+ erro);
          })
  
          
    }, []);

    return (
        <div className="container">
            <header>
                <strong>React Nutri</strong>
            </header>
            {dicas.map((item) => {
                return (
                    <article key={item.id} className="post">
                        <strong className="titulo">{item.titulo}</strong>
                        <img src={item.capa} alt={item.titulo} className="capa" />
                        <p className="subtitulo">
                            {item.subtitulo}
                        </p>
                        <a className="botao">Acessar</a>
                    </article>
                )
            })}

        </div>

    );


}
export default Nutricao;
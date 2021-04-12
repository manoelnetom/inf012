import { useCallback, useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import '../questoes.css'

function Questao3() {
    const [digitado, setDigitado]=useState(-1);
    const [sorteado, setSorteado]=useState(0);
    const [resultado, setResultado]=useState("");
    const [tentativas,setTentativas]=useState(0);
    useEffect(()=>{
        setSorteado(Math.floor(Math.random()*100));
    },[]);

    let calcular=useCallback(()=>{
        setTentativas(tentativas+1);
        if(digitado>sorteado){
            setResultado("é Maior");
        }else if(digitado<sorteado){
            setResultado("é Menor");
        }else{
            setResultado("Acertou! depois de " + tentativas +" tentativas");
        }
    },[digitado,sorteado, tentativas])

    return (
        <div className="questao">
            <header>Questão 3</header>
            <p>Escreva uma solução web que atenda aos requisitos do jogo
            "zero a cem". Construa o formulário HTML que permita ao
            jogador digitar um numero para tentar adivinhar o número
            sorteado pelo sistema. O programa do lado servidor deve
            receber o número passado e verificar se ele coincide com o
            numero sorteado. Em caso positivo, o usuário deve ser
            informado com a string "parabens vc ganhou", caso contrario
            as informações de “é maior” ou “é menor” devem ser passadas
            para o usuário, e uma nova tentativa pode ser realizada.
            </p>
            <p>OBS.: A 1o vez que rodar o programa: A) sortear o número,
            B)comparar com o numero passado com o numero sorteado,  e C)
            "você acertou" ou "é maior" ou “é menor”.
A partir daí:  repetir se necessário B) e C)</p>
            <div className="formulario">
                <input type="text" value={digitado} onChange={(e)=>setDigitado(e.target.value)}/>
                <button onClick={()=>calcular()}>Jogar</button>
                <p>Resultado: {resultado}</p>
                <Link to="/">Home</Link>
            </div>
        </div>
    );
}

export default Questao3;
import { useCallback, useState } from 'react';
import '../styles.css'

function Questao1() {
    const [peso,setPeso]=useState(0);
    const [altura,setAltura]=useState(0);
    const [resultado, setResultado]=useState("");
     let claculaIMC = useCallback(()=>{
        let imc= peso/(altura**2); 
        if(imc>30){
            setResultado("Obesidade");
        }else if(imc<25){
            setResultado("Peso Normal");
        }else{
            setResultado("Sobrepeso");
        }
     },[peso,altura]);

    return (
        <div>
            <header>Questão 1</header>
            <p>Escreva uma solução web para calcular o índice de massa
            corpórea (IMC) a partir de um formulário web. O formulário
            HTML deve permitir que um usuário digite o peso e a sua
            altura, e o envie para programa que roda no lado servidor
            (Servlet). Quando Servlet for executado, deve receber os
            parâmetros pelo formulário HTML, calcular o IMC e responder
            com um parecer de acordo com a tabela abaixo:</p>
            <p>Se IMC maior que 25 ---- PESO NORMAL</p>
            <p>Se  IMC entre 25 e 30 -- SOBRE PESO</p>
            <p>Se IMC maior 30 ---- OBESIDADE</p>
            <div className="conteiner">
                <input type="text" value={peso} onChange={(e)=>setPeso(e.target.value)}  placeholder="Peso"/>
                <input type="text" value={altura} onChange={(e)=>setAltura(e.target.value)} placeholder="Altura"/>
                <button onClick={()=>claculaIMC()}>Calcular</button>
                <p>Resultado: {resultado}</p>
            </div>
        </div>
    );
}
export default Questao1;
import React, {useState, useEffect, useMemo, useCallback} from "react";


function Tarefa2() {
  const [texto, setTexto] = useState('Digite sua tarefa');
  const [lista, setLista] = useState(['Lavar roupa', 'Varrer quarto']);
  
  useEffect(()=>{
    alert('componete acabou de ser montado');
  },[]);

  useEffect(()=>{
    localStorage.setItem('terfa',JSON.stringify(lista));
  },[lista]);

  let tamanho = useMemo(()=>{
    return lista.length;
  },[lista]);
  /*function addTarefa(){
    setLista([texto,...lista]);
    setTexto("");
  }*/
  const addTarefa = useCallback(()=>{
    setLista([texto,...lista]);
    setTexto("");
  },[texto,lista]); 

  return (
    <div><ul>{lista.map((item) =><li>{item}</li>)}</ul>
                <input type="text" value={texto} onChange={(e) => setTexto(e.target.value)}/>
                <button onClick={addTarefa.bind(this)}>Incluir</button>
                <h1>Você tem {tamanho} tarefas!</h1>
            </div>
  );
}

export default Tarefa2;

import React, {Component} from 'react';

class Tarefa extends Component{
    constructor(props){
        super(props);
        this.state = {
            texto:"",
            lista:['Lavar Pratos','Lavar roupas']
        };
    }


    addTerefa(){
        let estado = this.state;
        estado.lista.push(estado.texto);
        this.setState(estado);
    }

    render(){
        return(
            <div>
                <ul>{this.state.lista.map((item) =><li>{item}</li>)}</ul>
                <input type="text" value={this.state.texto} onChange={(e)=>this.setState({texto:e.target.value})}/>
                <button onClick={()=>this.addTerefa()}>Add Tarefa</button>
                <h1>O numero total de Tarefas é {this.state.lista.length}</h1>
            </div>
        );
    }
}
export default Tarefa;
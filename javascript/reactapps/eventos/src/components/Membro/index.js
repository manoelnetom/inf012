import React, {Component} from 'react';

class Membro extends Component{
    
    constructor(props){
        super(props);
        this.state = {
            nome:props.nome
        }
    }

    logar(valor){
        let state = this.state;
        state.nome=valor;
        this.setState(state);
    }
    
    render(){
        return(
        <div>
            <h2>Seja Bem-Vindo {this.state.nome}</h2>
            <button onClick={()=> this.logar("João")}>Logar Como</button>
            <button onClick={()=> this.setState({nome:""})}>Sair</button>
        </div>
        );
    }
}
export default Membro;
import React, {Component} from 'react';


class Equipe extends Component{
    render(){
        return(
            <div>
                <h2>Nome: {this.props.nome}</h2>
                <h2>Cargo: {this.props.cargo}</h2>
                <h3>Idade: {this.props.idade}</h3>
            </div>
        );
    }
}

export default Equipe;
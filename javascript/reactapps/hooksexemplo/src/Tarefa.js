
import React, { Component } from "react";

class Tarefa extends Component {
    constructor(props) {
        super(props);
        this.state = {
            texto: "",
            lista: ['lavar os pratos', 'arrumar a cama']
        }
    }
    addTarefa() {
        let estado = this.state;
        estado.lista.push(this.state.texto);
        estado.texto = "";
        this.setState(estado);
    }

    render() {
        return (
            <div><ul>{this.state.lista.map((item,index) =><li key={index}>{item}</li>)}</ul>
                <input type="text" value={this.state.texto} onChange={(e) => this.setState({ texto: e.target.value })} />
                <button onClick={this.addTarefa.bind(this)}>Incluir</button>
            </div>
        );
    }
}
export default Tarefa;
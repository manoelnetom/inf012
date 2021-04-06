import React, {Component} from 'react';
import './IMC.css'
class IMC extends Component{
    constructor(props){
        super(props);
        this.state={
            peso:0,
            altura:0,
            imc:""
        };
    }
    calculaIMC(){
        let estado = this.state;
        let resultado = (estado.peso/estado.altura**2);
        estado.imc = "O seu imc é "+resultado;
        this.setState(estado);
    }

    setPeso(evento){
        this.setState({peso:evento.target.value});
    }

    render(){
        return(
        <div className="conteiner">
            <h1>IMC</h1>
             <input type="text" onChange={(ev) =>this.setPeso(ev)} placeholder="Digite seu Peso" value={this.state.peso}/>
             <input type="text" onChange={(ev)=> this.setState({altura:ev.target.value})} placeholder="Digite seu altura" value={this.state.altura}/>
             <button onClick={this.calculaIMC.bind(this)}>Calcular</button>
             <h1>Resultado: {this.state.imc}</h1>
        </div>
        );
    }
}
export default IMC;
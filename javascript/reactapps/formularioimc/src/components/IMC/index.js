import React,{Component} from 'react';

class IMC extends Component{
    constructor(props){
        super(props);
        this.state = {
            peso:0,
            altura:0,
            imc:""
        }
    }
    calcular(){
        let state= this.state;
        let imc=state.peso/state.altura**2;
        state.imc=imc;
        this.setState(state);
    }
    render(){
        return(
        <div>
            Peso: <input type="text" value={this.state.peso} onChange={(e)=> this.setState({peso:e.target.value})}/>
            Altura: <input type="text" value={this.state.altura} onChange={(e)=> this.setState({altura:e.target.value})}/>
            <button onClick={this.calcular.bind(this)}>Calcular</button>
            <br/>
            <h1>{this.state.imc}</h1>
        </div>
        );
    }
}
export default IMC;
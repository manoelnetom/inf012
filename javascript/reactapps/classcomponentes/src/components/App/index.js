import React, {Component} from 'react';
import Equipe from '../Equipe';


class App extends Component{
    render(){
        return(
            <div>
                <h1>Conheça a nossa Equipe:</h1>
                <Equipe nome="Manoel" cargo="Professor" idade="43"/>
            </div>
        );
    }
}

export default App;
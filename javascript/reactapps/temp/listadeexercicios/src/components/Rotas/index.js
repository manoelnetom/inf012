import Home from '../../pages/Home';
import { BrowserRouter, Switch, Route } from "react-router-dom";
import Questao1 from '../../pages/Questao1';
import Questao2 from '../../pages/Questao2';
import Questao3 from '../../pages/Questao3';
import Menu from '../Menu';
function Rotas(){
    return(
        <BrowserRouter>
            <Menu/>
            <Switch>
                <Route exact path="/" component={Home}/>
                <Route exact path="/questao1" component={Questao1}/>
                <Route exact path="/questao2" component={Questao2}/>
                <Route exact path="/questao3" component={Questao3}/>
            </Switch>
        </BrowserRouter>
    );
}
export default Rotas;
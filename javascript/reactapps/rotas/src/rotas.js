import { BrowserRouter, Route, Switch} from 'react-router-dom';
import Cronometro from './pages/Cronometro';
import Biscoito from './pages/Biscoito';
import Erro from './pages/Erro';
import Menu from './componets/Menu';

function Rotas() {
    return (
        <BrowserRouter>
        <Menu/>
            <Switch>
                <Route exact path="/" component={Cronometro} />
                <Route path="/biscoito" component={Biscoito} />
                <Route path="*" component={Erro}/>
            </Switch>
        </BrowserRouter>
    );
}
export default Rotas;
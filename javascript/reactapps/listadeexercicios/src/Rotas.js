import { BrowserRouter, Route, Switch } from "react-router-dom"
import Home from './pages/Home'
import Menu from './components/Menu'
import Questao1 from './pages/Questao1'
import Questao2 from './pages/Questao2'
import Questao3 from './pages/Questao3'
import Questao4 from './pages/Questao4'

function Rotas() {
    return (
        <BrowserRouter>
            <Menu />
            <Switch>
                <Route exact path="/" component={Home} />
                <Route exact path="/questao1" component={Questao1} />
                <Route exact path="/questao2" component={Questao2} />
                <Route exact path="/questao3" component={Questao3} />
                <Route exact path="/questao4" component={Questao4} />
            </Switch>
        </BrowserRouter>
    );
}

export default Rotas;
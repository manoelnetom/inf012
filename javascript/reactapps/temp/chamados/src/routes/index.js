import {Switch} from 'react-router-dom';
import SignIn from '../pages/SignIn';
import Dashboard from '../pages/Dashboard';
import SingUp from '../pages/SignUp';
import Profile from '../pages/Profile';

import Route from './MyRoute'
import Costumers from '../pages/Costumers';
export default function  Rotas() {
    return(
        
        <Switch>
            <Route exact path="/" component={SignIn}/>
            <Route exact path="/register" component={SingUp}/>
            <Route  isPrivate path="/dashboard"  component={Dashboard}/>
            <Route isPrivate path="/profile" component={Profile}/>
            <Route isPrivate path="/costumers" component={Costumers}/>
        </Switch>
      
    );
    
}
import  {Switch} from 'react-router-dom'
import SignIn from '../pages/SignIn'
import SignUp from '../pages/SignUp'
import Dashboard from '../pages/Dashboard'
import Profile from '../pages/Profile'
import Costumers from '../pages/Costumers'
import New from '../pages/New';
import Route from './Routes'

 export default function Routes(){
    return(
       <Switch>
          <Route exact path='/' component={SignIn}/>
          <Route exact path='/register' component={SignUp}/>
          <Route isPrivate exact path='/dashboard' component={Dashboard}/>
          <Route isPrivate exact path='/profile' component={Profile}/>
          <Route isPrivate exact path='/costumers' component={Costumers}/>
          <Route isPrivate exact path='/new' component={New}/>
       </Switch> 
    );
}
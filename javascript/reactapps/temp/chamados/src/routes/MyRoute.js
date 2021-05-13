import {Route, Redirect} from 'react-router-dom';
import {AuthContext} from '../contexts/auth';
import {useContext} from 'react';

export default function RouteWraper(
    {
        component: Component,
        isPrivate,
        ...rest
    }
    
    ){
        const {signed}=useContext(AuthContext);  // vai vir do login
        
        if(!signed&&isPrivate){
            return(
                <Redirect to="/"/>
            );
        }

        if(signed&& (!isPrivate)){
            return(
                <Redirect to="/dashboard"/>
            );
        }

        
     return(
         <Route
         {...rest}
         render={props=>(
             <Component {...props}/>
         )}
         />
     );   
}
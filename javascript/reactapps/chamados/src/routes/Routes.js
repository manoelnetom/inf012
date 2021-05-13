
import {useContext} from 'react'
import {Route, Redirect} from 'react-router-dom'
import {AuthContext} from '../contexts/auth'

export default function RouteWraper(
    {
        component: Component,
        isPrivate,
        ...rest
    }
    ){
        
        const {signed}=useContext(AuthContext);

        
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
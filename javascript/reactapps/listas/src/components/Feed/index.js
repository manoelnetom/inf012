

function Feed(props){
    return(
        <div key={props.id}>
            <h1> {props.nome} </h1>
             <h3> {props.curtidas>1 ?  props.curtidas + ' curtidas' : props.curtidas + ' curtida'}</h3>
             <h3> {props.comentarios>1? props.comentarios+ ' comentarios':props.comentarios+ ' comentario'}</h3>
             <hr/>
        </div>
    );
}
export default Feed;
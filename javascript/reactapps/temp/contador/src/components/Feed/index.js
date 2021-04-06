function Feed(props){
    return(
        <div key={props.id}>
            <h1> {props.nome}</h1>
             <a> {props.curtidas} curtidas</a>
             <a> {props.comentarios} comentarios</a>
             <hr/>
        </div>
    );
 }
 export default Feed;
 
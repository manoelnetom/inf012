import { useParams, Link } from "react-router-dom";

function Sobre(){
    const {id} = useParams();
    return(
    <div>
        <h1>Essa é a página Sobre com id = {id}</h1>
        <Link to="/"> Home  </Link>
    </div>
    );
}

export default Sobre;
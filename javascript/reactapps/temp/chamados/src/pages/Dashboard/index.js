
import { FiHome } from "react-icons/fi";
import Header from "../../components/Header";
import Title from "../../components/Title";


export default function Dashboard() {
   
    
    return(
        <div>
            <Header/>
            <div className="content">
                <Title nome="Chamados">
                    <FiHome size={25}/>
                </Title>
            </div>
         
        </div>
    );
}
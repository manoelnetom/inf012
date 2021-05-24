import { useEffect, useState } from 'react';
import { FiDelete, FiUser } from 'react-icons/fi';
import './costumers.css';
import Header from '../../components/Header';
import Title from '../../components/Title';
import firebase from '../../services/firebaseConnection';
import {toast} from 'react-toastify';


export default function Costumers() {
    const [nome, setNome] = useState('');
    const [cnpj, setCnpj] = useState('');
    const [endereco, setEndereco] = useState('');
    const [clientes, setClientes] = useState([]);

    useEffect(()=>{
        async function loadClientes(){
            await firebase.firestore().collection('costumers')
            .get()
            .then((snapshot)=>{
                let lista = [];
                snapshot.forEach((doc)=>{
                    lista.push({
                        id:doc.id,
                        cnpj:doc.data().cnpj,
                        nome:doc.data().nome,
                        endereco: doc.data().endereco,
                        created:doc.data().created.toDate().toLocaleDateString('pt-BR')
                    });
                });
                setClientes(lista);
                
            })
            .catch((error)=>{
                setClientes([{id:1, nome:"sem cliente", endreco:""}]);
                toast.error('Erro ao carregar clientes');
            })
        }
        loadClientes();
    },[clientes]);

    function handleSubmit(e){
        e.preventDefault();
        if(nome!==''&&cnpj!==''&&endereco!=''){
            firebase.firestore().collection('costumers')
            .add({
                nome:nome,
                cnpj:cnpj,
                endereco:endereco,
                created: new Date()
            })
            .then(()=>{
                setNome('');
                setCnpj('');
                setEndereco('');
                toast.success('Cliente cadastrado!');
            })
            .catch((error)=>{
                console.log('Erro:',error);
                toast.error('Ops...erro ao tentar cadastrar!');
            })

        }else{
            toast.error('Preencha todos os campos!');
        }
    }

   async function excluirCliente(id){
        await firebase.firestore().collection('costumers')
        .doc(id)
        .delete()
        .then(()=>{
            let vet = clientes.filter((cli)=>{
                return cli.id!==id;
            });
            setClientes(vet);
            toast.success('Cliente Excluído!');
        })
        .catch(()=>{
            toast.error('Erro ao excluir!');
        })
    }

    return (

        <div>
            <Header />
            <div className="content">
                <Title nome="Clientes">
                    <FiUser size={25} />
                </Title>

                <div className="container">
                    <form onSubmit={(e)=>{handleSubmit(e)}} className="form-profile costumers">
                    <label>Nome</label>
                    <input placeholder="Digite o Nome Fantasia" type="text" value={nome} onChange={(e)=>setNome(e.target.value)}/>
                    
                    <label>CNPJ</label>
                    <input placeholder="Digite o CNPJ" type="text" value={cnpj} onChange={(e)=>setCnpj(e.target.value)}/>

                    <label>Endereço</label>
                    <input placeholder="Digite o endereço" type="text" value={endereco} onChange={(e)=>setEndereco(e.target.value)}/>
                    
                    <button className="button-costumers" type="submit">Salvar</button>
                    </form>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th scope="col">Cliente</th>
                            <th scope="col">CNPJ</th>
                            <th scope="col">Endereço</th>
                            <th scope="col">Cadastrado em</th>
                            <th scope="col">#</th>
                        </tr>
                    </thead>
                    <tbody>
                        {clientes.map((cliente)=>{
                            return(
                                <tr>
                                    <td data-label="Cliente">{cliente.nome}</td>
                                    <td data-label="CNPJ">{cliente.cnpj}</td>
                                    <td data-label="Endereço">{cliente.endereco}</td>
                                    <td data-label="Cadastrado em">{cliente.created}</td>
                                    <td data-label="#">
                                        <button onClick={()=>{excluirCliente(cliente.id)}} style={{backgroundColor: '#3583f6'}}>
                                            <FiDelete color="#FFF" size={17}/>
                                        </button>
                                    </td>
                                </tr>
                            );
                        })}
                    </tbody>
                </table>
            </div>
        </div>
    );
}
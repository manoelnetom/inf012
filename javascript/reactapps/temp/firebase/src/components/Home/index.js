import firebase from '../../firebaseConnection'
import {useState, useEffect} from 'react'
import './home.css'

function Home() {
  const [titulo, setTitulo]=useState('');
  const [autor, setAutor]=useState('');
  const[posts, setPosts]=useState([]);
  const [id, setId]=useState('');


useEffect(()=>{
  async function loadPosts(){
   await firebase.firestore().collection('posts')
   .onSnapshot((docs)=>{
    let temp=[];
    docs.forEach((doc)=>{
      temp.push({
        id:doc.id,
        titulo:doc.data().titulo,
        autor:doc.data().autor
      })
    })
    setPosts(temp);
   })

  }
  loadPosts();
},[]);  

 async function addPost(){
    await firebase.firestore().collection('posts')
    .add({
      titulo:titulo,
      autor:autor
    })
    .then(()=>{
      alert('Post add com sucesso');
    })
    .catch(()=>{
      alert('Erro');
    })
  }

 /* async function buscarPost(){
    await firebase.firestore().collection('posts')
    .doc('1')
    .get()
    .then((snapshot)=>{
        //console.log(snapshot);
        setTitulo(snapshot.data().titulo);
        setAutor(snapshot.data().autor);
    })
    .catch(()=>{
      alert('Erro')
    })

  }
*/
  async function buscarPosts(){
    await firebase.firestore().collection('posts')
    .get()
    .then((docs)=>{
      let temp=[];
      docs.forEach((doc)=>{
        temp.push({
          id:doc.id,
          titulo:doc.data().titulo,
          autor:doc.data().autor
        })
      })
      setPosts(temp);
    })
  }

async function editPost(){
  await firebase.firestore().collection('posts')
  .doc(id)
  .update({
    titulo:titulo,
    autor:autor
  })
  .then(()=>{
    alert('OK');
  })
  .catch(()=>{
    alert("ERRO");
  })
}

async function excluirPost(postId){
  await firebase.firestore().collection('posts').doc(postId).delete()
  .then(()=>{alert('Apagou')})
  .catch(()=>{alert('deu  ruim')})
}

    return (
      <div className="conteiner">
        <h1>HOME</h1>
        <label>ID:</label>
        <input type="text" value={id} onChange={(e)=>{setId(e.target.value)}}/>
        <label>Titulo:</label>
        <input type="text" value={titulo} onChange={(e)=>{setTitulo(e.target.value)}}/>
        <label>Autor:</label>
        <input type="text" value={autor} onChange={(e)=>{setAutor(e.target.value)}}/>
        <button onClick={()=>{addPost()}}>Add Post</button>
        <button onClick={()=>{buscarPosts()}}>Listar Post</button>
        <button onClick={()=>{editPost()}}>Editar Post</button>
        <ul>
          {posts.map((post)=>{
            return(
              <li> {post.id} - {post.autor} - {post.titulo} <br/><br/> 
              <button onClick={()=>{excluirPost(post.id)}}>excluir</button></li>
              
            );
          })}
        </ul>
      </div>
    );
  }
  
  export default Home;
  
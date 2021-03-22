//var divArea = document.getElementById("area"); 

function calculaIMC(){
    let peso=0;
    let altura=0;
    peso = parseFloat(document.formIMC.txtPeso.value);
    altura = parseFloat(document.formIMC.txtAltura.value);   //document.forms[0].elements[1].value
    return (peso/(altura**2));
}

function imc(){
    let imc = calculaIMC().toFixed(2);
    //alert(resultado);
   
    let resultado="";
    if(imc>30){
        resultado= "Obesidade";
    }else if(imc<25){
        resultado = "Normal";
    }else{
        resultado="Sobrepeso"
    }

    divArea.innerHTML ="IMC = " + imc + " considerado: "+ resultado;
}

function acao(){
    var divArea = document.getElementById("area");
    divArea.innerHTML = "timer: Depois de 4 segundas" ; 
    
}

function spread(){
    var divArea = document.getElementById("area");
    let pessoa={
       nome: 'Manoel',
       idade:43
    };

    let novaPessoa = {
        ...pessoa,
        profissao:'Professor',
        local:'IFBA'
    }

    console.log(novaPessoa);

    divArea.innerHTML = "resultado";
}

function exibeNumeros(){
    const vetor=[1,2,3,4,5,6];

    /*vetor.map(function(item, indice){
        if(indice%2!=0)
         console.log(item);
    });
    
   let soma = vetor.reduce(function(acumulado,valoratual){
       return acumulado+valoratual;
   });
*/
   let procurado= vetor.find(function(item){
     return item===7;
   });


   console.log(procurado);
}

function avaliaIdade(){

    const pessoas =[
        {nome:'Manoel', idade:43},
        {nome:'Maria', idade:24},
        {nome:'Joao', idade:17}
    ];

    let resultado = pessoas.every((item)=> item.idade>=17);
    if(resultado==true){
        alert('Todos tem mais que 17');
    }else{
        alert('alguem tem menos que 17');
    }
}

function soma(p1,p2){
    area.innerHTML='<h1> a soma de p1 com p2 e </h1>' +  (p1+p2);
}

function olaMundo(){
    let area = document.getElementById('area');

    area.innerHTML='<h1> a soma de p1 com p2 e </h1>' + soma(1,7);
}

function nomeCompleto(){
    let nome = document.formNome.nome.value;
    let resultado = `O Nome Completo e:  ${nome}`;
    alert(resultado);
}

function contarLetras(){
    let texto = document.formNome.nome.value;
    let resultado = texto.length;
    alert(resultado);
}

function allStorage() {

    var archive = [],
        keys = Object.keys(localStorage),
        i = 0, key;

    for (; key = keys[i]; i++) {
        archive.push(localStorage.getItem(key));
    }

    return archive;
}

function contaArray(){
    let novoValor = document.formVetor.novoValor.value;
    localStorage.setItem(novoValor,novoValor);    
    let area = document.getElementById('area');
    let allvalues=allStorage();
    area.innerHTML='';
    allvalues.map((item)=>{
        area.innerHTML+='<ul id="'+item+'">'+item+'</ul>';
    });
    
        

   
}
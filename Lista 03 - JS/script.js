
function muda_Cor(cor) {
    
    document.getElementById("pag").style.backgroundColor = cor;
    


    }
function muda_Cor2() {
    
    var cor = document.getElementById("pagCor").value;    
    document.getElementById("pag").style.backgroundColor = cor;
    }

function mostrar_Ocultar(){

    var state = document.getElementById("bt1").value
    if(state == 'Ocultar'){
        document.getElementById("bt1").value = "Mostrar";
        document.getElementById("par1").style.display = 'none';

    }else{
        document.getElementById("bt1").value = "Ocultar";
        document.getElementById("par1").style.display = 'block';
    }
}

function verificaSenha(){
    var senha1 = document.getElementById('senha1').value;
    var senha2 = document.getElementById('senha2').value;
    if(senha1!=senha2){
        document.getElementById('senhaNot').style.display = 'block';
    }else{
        document.getElementById('senhaNot').style.display = 'none';
    }
}

function submeter(){
    var senha1 = document.getElementById('senha1').value;
    var senha2 = document.getElementById('senha2').value;

    if(senha1==senha2){
        alert("Cadastro feito com Sucesso !")
    }else{
        alert("Senhas não correspondentes !")
    }
}

function verifPalin(){
    var p1 = document.getElementById("palavra").value;
    var p2 = p1.split('').reverse().join('');
    if(p1==p2){
        document.getElementById("lb2").innerHTML='Palabra é um palídromo! <br> '
        + 'Palavra Original: ' +p1
        + '<br>Palavra Invertida: '+p2;
    }else {
        document.getElementById("lb2").innerHTML='Palabra não é um palídromo! <br> '
        + 'Palavra Original: ' +p1
        + '<br>Palavra Invertida: '+p2;
    }
}

function invertNomes(){
    var nomes = [];
    
    for (let index = 1; index < 6; index++) {
        var id = "n"+index;        
        nomes.push (document.getElementById(id).value);              
    }        
    var namesINvert = nomes.reverse();    
    for (let index = 1; index < 6; index++) {
        var id = "n"+index;
        document.getElementById(id).value = namesINvert[index-1];        
    }
}

function disableEnable(valor){
    
    if(valor == 'cpf'){
        
        document.getElementById('spCnpj').style.display = 'none';        
        document.getElementById('spCpf').style.display = "block";
    }else{
        document.getElementById('spCnpj').style.display = 'block';
        document.getElementById('spCpf').style.display = "none";
    }
    
}

function intercalarName(){
    palavra1 = document.getElementById("pl01").value;
    palavra2 = document.getElementById("pl02").value;

    palavra1.
}
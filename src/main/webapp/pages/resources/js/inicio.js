function validaInput (){
    if(document.getElementById("ingredientes").value.length < 3){
        alert("Por favor, preencha o campo ingredientes");
        document.getElementById("ingredientes").focus();
        return false;    
    }else{
        window.location.href = "cadastro.html";
    }
    
}
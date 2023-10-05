jQuery(document).ready(function($) {  
	$("#lIsbnPesquisa").attr("readonly", true);
	$("#lIsbnPesquisa").attr("disabled", true);
	$("#lTituloPesquisa").attr("readonly", true);
	$("#lTituloPesquisa").attr("disabled", true);
	
});

/*var select = document.getElementById('opcaoPesquisa');
select.addEventListener('change', carregarCampos());*/

function carregarCampos() {

	select = document.getElementById("opcaoPesquisa");
	var opcaoValor = select.options[select.selectedIndex].value;
	
	if(opcaoValor === "isbn") {
		$("#lIsbnPesquisa").attr("readonly", false);
		$("#lIsbnPesquisa").attr("disabled", false);
		/*console.log("TesteReadCPF: "+document.getElementById("lCpfPesquisa").getAttribute('readonly'));
		console.log("TesteReadNome: "+document.getElementById("lNomePesquisa").getAttribute('readonly'));*/
		//if(document.getElementById("lNomePesquisa").getAttribute('readonly') == null) {
		if(document.getElementById("lTituloPesquisa").value != "") {
			$("#lTituloPesquisa").val("");
		}
		$("#lTituloPesquisa").attr("readonly", true);
		$("#lTituloPesquisa").attr("disabled", true);
		//console.log("teste entrou cpf!");
	} else {
		if(opcaoValor === "titulo") {
			if(document.getElementById("lIsbnPesquisa").value != "") {
				$("#lIsbnPesquisa").val("");
			}
			$("#lIsbnPesquisa").attr("readonly", true)
			$("#lIsbnPesquisa").attr("disabled", true);
			$("#lTituloPesquisa").attr("readonly", false);
			$("#lTituloPesquisa").attr("disabled", false);
			//console.log("teste entrou nome!");
		} else {
			$("#lTituloPesquisa").val("");
			$("#lIsbnPesquisa").val("");
			$("#lIsbnPesquisa").attr("readonly", true);
			$("#lIsbnPesquisa").attr("disabled", true);
			$("#lTituloPesquisa").attr("readonly", true);
			$("#lTituloPesquisa").attr("disabled", true);
			//console.log("teste entrou nada!");
		}
	}
	
	//console.log("teste entrou!");
}


function pesquisar() {
	//console.log($("#opcaoPesquisa").val());
	if($("#opcaoPesquisa").val() == 'isbn') {
		window.location.href = "/pessoa/"+$("#lCpfPesquisa").val();
			//console.log($("#lCpfPesquisa").val());
	} else {
		if($("#opcaoPesquisa").val() == 'titulo') {
			window.location.href = "/pessoas/"+$("#lNomePesquisa").val();
		}
	}
}
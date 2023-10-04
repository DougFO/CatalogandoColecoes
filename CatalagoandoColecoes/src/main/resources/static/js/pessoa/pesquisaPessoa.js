jQuery(document).ready(function($) {  
	$("#lCpfPesquisa").attr("readonly", true);
	$("#lCpfPesquisa").attr("disabled", true);
	$("#lNomePesquisa").attr("readonly", true);
	$("#lNomePesquisa").attr("disabled", true);
	
});

/*var select = document.getElementById('opcaoPesquisa');
select.addEventListener('change', carregarCampos());*/

function carregarCampos() {

	select = document.getElementById("opcaoPesquisa");
	var opcaoValor = select.options[select.selectedIndex].value;
	
	if(opcaoValor === "cpf") {
		$("#lCpfPesquisa").attr("readonly", false);
		$("#lCpfPesquisa").attr("disabled", false);
		/*console.log("TesteReadCPF: "+document.getElementById("lCpfPesquisa").getAttribute('readonly'));
		console.log("TesteReadNome: "+document.getElementById("lNomePesquisa").getAttribute('readonly'));*/
		//if(document.getElementById("lNomePesquisa").getAttribute('readonly') == null) {
		if(document.getElementById("lNomePesquisa").value != "") {
			$("#lNomePesquisa").val("");
		}
		$("#lNomePesquisa").attr("readonly", true);
		$("#lNomePesquisa").attr("disabled", true);
		//console.log("teste entrou cpf!");
	} else {
		if(opcaoValor === "nome") {
			if(document.getElementById("lCpfPesquisa").value != "") {
				$("#lCpfPesquisa").val("");
			}
			$("#lCpfPesquisa").attr("readonly", true)
			$("#lCpfPesquisa").attr("disabled", true);
			$("#lNomePesquisa").attr("readonly", false);
			$("#lNomePesquisa").attr("disabled", false);
			//console.log("teste entrou nome!");
		} else {
			$("#lNomePesquisa").val("");
			$("#lCpfPesquisa").val("");
			$("#lCpfPesquisa").attr("readonly", true);
			$("#lCpfPesquisa").attr("disabled", true);
			$("#lNomePesquisa").attr("readonly", true);
			$("#lNomePesquisa").attr("disabled", true);
			//console.log("teste entrou nada!");
		}
	}
	
	//console.log("teste entrou!");
}


function pesquisar() {
	//console.log($("#opcaoPesquisa").val());
	if($("#opcaoPesquisa").val() == 'cpf') {
		window.location.href = "/pessoa/"+$("#lCpfPesquisa").val();
			//console.log($("#lCpfPesquisa").val());
	} else {
		if($("#opcaoPesquisa").val() == 'nome') {
			window.location.href = "/pessoas/"+$("#lNomePesquisa").val();
		}
	}
}
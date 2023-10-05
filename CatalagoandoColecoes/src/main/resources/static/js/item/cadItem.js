jQuery(document).ready(function($) {  
	$("#manga").attr("checked", false);
	//$("#manga").attr("disabled", true);
	$("#hq").attr("checked", false);
	//$("#hq").attr("disabled", true);
	$("#divManga").css("visibility","hidden");
	$("#divManga").css("position","absolute");
	$("#divHQ").css("visibility","hidden");
	$("#divHQ").css("position","absolute");

	
	
	$("#botaoCad").one("click", function() {

            //if($flagCadPessoa==0){
                        $('#myForm').submit(function(e){
                                e.preventDefault();

                                var dados = jQuery( this ).serialize();
                                //Chamando a função validarFormulário que testa o cpf e se os listOptions estão em branco
                                jQuery.ajax({
                                    type: "POST",                             
                                    url: "/api/v1/item",
                                    async: false,
                                    data: dados,
                                    //encoding:"utf-8",
                                    success: function( data )
                                    {
										if(data != "") {
											$('#botaoCad').attr("disabled",true);
											//$flagCadAssoc = 1;
											//novoCadastro('#myForm');	
	                                        //$(location).attr('href', '/cadastro/sucesso');
	                                        // ------------ Desabilita os inputs -----------------------------------
	                                        $('#myForm input').attr("readonly", true);
	                                        
	                                        
	
	                                              	//$flagCadPessoa = 1;
	
	                                            // ------- Atibuindo o texto "Novo Cadastro" ao botão de cadastro ------
	                                             //$('#botaoCad').html('Novo Cadastro');
	
												//console.log(data);
	                                        	window.location.href = "/item/cadastro/sucesso";
	                                    } else {
											alert("Item já cadastrado!");
										}

                                    }


                                });

                        });
                //}
    });	

});

/*function teste() {
	console.log("Teste: "+$('input[name="opcao"]:checked').val());
}*/


function carregarCampos() {

	
	if(document.querySelector('input[name=opcao]:checked') != null) {
		var radio = document.querySelector('input[name=opcao]:checked').value
		//console.log("testeR: "+radio);
		
	//var opcaoValor = select.options[select.selectedIndex].value;
	
		if(radio === "manga") {
			document.getElementById('tipoManga').value = 0;
			$("#lItemEditoraOriginal").val("");
			$("#lItemPersonagemGrupo").val("");
			$("#divManga").css("visibility","visible");
			$("#divManga").css("position","relative");
			$("#divHQ").css("visibility","hidden");
			$("#divHQ").css("position","absolute");
	
		} else {
			if(radio === "hq") {
				document.getElementById('tipoManga').value = 0;
				$("#lItemEditoraOriginal").val("");
				$("#lItemPersonagemGrupo").val("");
				$("#divManga").css("visibility","hidden");
				$("#divManga").css("position","absolute");
				$("#divHQ").css("visibility","visible");
				$("#divHQ").css("position","relative");
				//console.log("testeS: "+document.getElementById('tipoManga').value)
			} else {
				document.getElementById('tipoManga').value = 0;
				$("#lItemEditoraOriginal").val("");
				$("#lItemPersonagemGrupo").val("");
				$("#divManga").css("visibility","hidden");
				$("#divManga").css("position","absolute");
				$("#divHQ").css("visibility","hidden");
				$("#divHQ").css("position","absolute");
				
			}
		}
	}	
	

}

	/*function salvar() {
		
		window.location.href = "/item/cadastro/sucesso";
		return true;
	}*/

	/*function logSubmit() {
	  //log.textContent = `Formulário Submetido! Time stamp: ${event.timeStamp}`;
	  //event.preventDefault();
	  window.location.href = "/item/cadastro/sucesso";
	}
	
	const form = document.getElementById("myForm");
	//const log = document.getElementById("log");
	form.addEventListener("submit", logSubmit);*/

/*
function pesquisar() {

	if($("#opcaoPesquisa").val() == 'cpf') {
		window.location.href = "/pessoa/"+$("#lCpfPesquisa").val();

	} else {
		if($("#opcaoPesquisa").val() == 'nome') {
			window.location.href = "/pessoas/"+$("#lNomePesquisa").val();
		}
	}
}*/
jQuery(document).ready(function($) {    

    $("#botaoEditar").one("click", function() {

            //if($flagCadPessoa==0){
                        $('#myForm').submit(function(e){
                                e.preventDefault();

                                var dados = jQuery( this ).serialize();
                                //Chamando a função validarFormulário que testa o cpf e se os listOptions estão em branco
                                jQuery.ajax({
                                    type: "PUT",                             
                                    url: "/api/v1/pessoa/"+$('#lPessoaCPF').val(),
                                    async: false,
                                    data: dados,
                                    //encoding:"utf-8",
                                    success: function( data )
                                    {
										if(data != "") {
											$('#botaoEditar').attr("disabled",true);
											//$flagCadAssoc = 1;
											//novoCadastro('#myForm');	
	                                        //$(location).attr('href', '/cadastro/sucesso');
	                                        // ------------ Desabilita os inputs -----------------------------------
	                                        $('#myForm input').attr("readonly", true);
	                                        
	                                        
	
	                                              	//$flagCadPessoa = 1;
	
	                                            // ------- Atibuindo o texto "Novo Cadastro" ao botão de cadastro ------
	                                             //$('#botaoCad').html('Novo Cadastro');
	
												//console.log(data);
	                                        	window.location.href = "/pessoa/editar/sucesso";
	                                    } else {
											alert("Pessoa não cadastrada!");
										}

                                    }


                                });

                        });
                //}
    });	
    
    

    /*console.log("Teste valor cpf: "+$('#lPessoaCPF').val());*/
    
//        function cadastrado() {
		//$(location).attr('href', '/cadastro/sucesso');
  //      window.location.href = "/api/v1/pessoa/cadastro/sucesso";
	//}   
});
jQuery(document).ready(function($) {    

    $("#botaoCad").one("click", function() {

            //if($flagCadPessoa==0){
                        $('#myForm').submit(function(e){
                                e.preventDefault();

                                var dados = jQuery( this ).serialize();
                                //Chamando a função validarFormulário que testa o cpf e se os listOptions estão em branco
                                jQuery.ajax({
                                    type: "POST",                             
                                    url: "/api/v1/pessoa",
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
	                                        	//window.location.href = "/pessoa/cadastro/sucesso";
	                                        	window.location.href = "/pessoa";
	                                    } else {
											alert("Pessoa já cadastrada!");
										}

                                    }


                                });

                        });
                //}
    });	
    
    

    
    
//        function cadastrado() {
		//$(location).attr('href', '/cadastro/sucesso');
  //      window.location.href = "/api/v1/pessoa/cadastro/sucesso";
	//}   
});
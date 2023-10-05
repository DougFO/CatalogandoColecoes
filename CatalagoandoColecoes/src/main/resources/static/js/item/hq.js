$(document).ready( function () {
	 
	 	
            
      	$("#botaoEditar").one("click", function() {


                        $('#myForm').submit(function(e){
                                e.preventDefault();
								console.log("ISBN: "+$('#lItemIsbn').val());
                                var dados = jQuery( this ).serialize();
                                //Chamando a função validarFormulário que testa o cpf e se os listOptions estão em branco
                                jQuery.ajax({
                                    type: "PUT",                             
                                    url: "/api/v1/item/"+$('#lItemIsbn').val(),
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
	                                        	window.location.href = "/item/editar/sucesso";
	                                    } else {
											alert("Item já cadastrado!");
										}

                                    }


                                });

                        });
    				});	 
    				
    				
    				$.ajax({
		                type: "GET",
		                url: "/api/v1/item/"+$('#lItemIsbn').val()+"/manga",
		                async: false,
		                //data: { id: recipient },
		                success: function (manga) {
								//document.getElementById('tipoManga').value = manga.tipo;
								console.log("TIPO MANGA: "+manga.tipo);
								var select = document.querySelector('#tipoManga');
								for (var i = 0; i < select.options.length; i++) {
								    if (select.options[i].text === manga.tipo) {
								        select.selectedIndex = i;
								        break;
								    }
								}
		                }
		
		
		            });
                 
	 

	 

});
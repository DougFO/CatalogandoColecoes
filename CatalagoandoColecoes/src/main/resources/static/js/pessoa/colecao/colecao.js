$(document).ready( function () {
	 
	
    

	 

});

document.addEventListener('DOMContentLoaded', function() {
	preencher();
})
	
 function preencher() {
	$.ajax({
                type: "GET",
                url: "/api/v1/pessoa/"+document.getElementById("lPessoaCPF").value,
                async: false,
                //data: { id: recipient },
                success: function (pessoa) {
					document.getElementById('lColecaoNome').value = pessoa.colecao.nome;
					document.getElementById('lColecaoObservacao').value = pessoa.colecao.observacao;
					document.getElementById('lColecaoDataInicio').value = pessoa.colecao.data_inicio;
					var tbody;
					var tr;
					var td;
					var elementoTabela;
					tbody = document.getElementById("corpoTabela");
                    //var dados = JSON.parse(resposta);
                    pessoa.colecao.itens.forEach(function(item) {
					  //console.log("Teste: "+pessoa.nome);
					  
					  tr = document.createElement("tr");
					  //td = document.createElement("td");
					  //elementoTabela = item.id;
					  //tr.appendChild(elementoTabela);
					  //td.innerHTML = elementoTabela;
					  //tr.appendChild(td);
					  td = document.createElement("td");
					  elementoTabela = item.isbn;
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td); 
					  td = document.createElement("td");
					  elementoTabela = item.titulo;
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td); 
					  td = document.createElement("td");
					  elementoTabela = item.volume;
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td); 
					  td = document.createElement("td");
					  elementoTabela = item.editoraNacional;
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td); 
					  
					  /*td = document.createElement("td");
					  if($tipo == "manga"){
					  	elementoTabela = '<a href="/item/'+item.isbn+'/manga" class="btn btn-primary">Editar</a>';
					  }	
					  if($tipo == "hq"){
					  	elementoTabela = '<a href="/item/'+item.isbn+'/hq" class="btn btn-primary">Editar</a>';
					  }	
					  //elementoTabela = '<a href="/item/'+item.isbn+'?tipo='+$tipo+'" class="btn btn-primary">Editar</a>';
					  //elementoTabela = '<a href="/item/'+item.isbn+'/'+$tipo+'" class="btn btn-primary">Editar</a>';
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td);*/
					  td = document.createElement("td");
					  //$texto = (item.isbn).toString();
					  //console.log($texto);
					  $string = "<button class=";
					  $string = $string+'"btn btn-danger" onclick="remover(';
					  $string = $string+"'";
					  $string = $string+''+item.isbn;
					  $string = $string+"'";
					  $string = $string+')">Excluir</button>';
					  //console.log($string);
					  //elementoTabela = '<a class="btn btn-danger" onclick="remover('+$texto+')">Excluir</a>';
					  elementoTabela = $string;
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td);  
					  tbody.appendChild(tr);
					  
					});                   

                }


            });
 }


 function remover(isbn) {
			//var y;
			//console.log("TesteISBN!"+isbn);
			var r=confirm("Remover?");
			if (r==true)
			{
				   $.ajax({
					   //{cpf}/Colecao/Item/{isbn}
		                type: "DELETE",
		                url: "/api/v1/pessoa/"+document.getElementById('lPessoaCPF').value+"/Colecao/Item"+isbn,
		                async: false,
		                //ta: { id: recipient },
		                success: function (itens) {
							if(itens == null) {
								console.log("Não Excluido!");
							} else {
								//console.log("Excluido!"+itens);
								window.location.reload();	
							}
							
						}
							  
						});
					}
					else
					{
					  //y="Você pressionou Cancelar!";
					  console.log("Cancelada a exclusão!");
					}
}



	 $("#botaoEditar").one("click", function() {

                        $('#myForm').submit(function(e){
                                e.preventDefault();

                                var dados = jQuery( this ).serialize();
                                //Chamando a função validarFormulário que testa o cpf e se os listOptions estão em branco
                                jQuery.ajax({
                                    type: "PUT",                             
                                    url: "/api/v1/pessoa/"+document.getElementById('lPessoaCPF').value+"/Colecao",
                                    async: false,
                                    data: dados,
                                    //encoding:"utf-8",
                                    success: function( data )
                                    {
										if(data != "") {
											//$('#botaoEditar').attr("disabled",true);
											//$flagCadAssoc = 1;
											//novoCadastro('#myForm');	
	                                        //$(location).attr('href', '/cadastro/sucesso');
	                                        // ------------ Desabilita os inputs -----------------------------------
	                                        //$('#myForm input').attr("readonly", true);
	                                        
	                                        
	
	                                              	//$flagCadPessoa = 1;
	
	                                            // ------- Atibuindo o texto "Novo Cadastro" ao botão de cadastro ------
	                                             //$('#botaoCad').html('Novo Cadastro');
	
												//console.log(data);
	                                        	//window.location.href = "/pessoa/editar/sucesso";
	                                        	window.location.reload();
	                                    } else {
											alert("Pessoa não cadastrada!");
										}

                                    }


                                });

                        });
		});	
		
		
		function addItem() {
		
		
			$("#addItem").one("click", function() {
	
			                        $('#myFormAddItem"').submit(function(e){
			                                e.preventDefault();
			
			//{cpf}/Colecao/Item/{isbn}
			                                var dados = jQuery( this ).serialize();
			                                //Chamando a função validarFormulário que testa o cpf e se os listOptions estão em branco
			                                jQuery.ajax({
			                                    type: "post",                             
			                                    url: "/api/v1/pessoa/"+document.getElementById('lPessoaCPF').value+"/Colecao/Item/"+document.getElementById('lIsbnItem').value,
			                                    async: false,
			                                    data: dados,
			                                    //encoding:"utf-8",
			                                    success: function( data )
			                                    {
													if(data != "") {
														console.log("CPF: "+document.getElementById('lPessoaCPF'));
				                                         console.log("ISBN: "+document.getElementById('lIsbnItem').value);
														//$('#botaoEditar').attr("disabled",true);
														//$flagCadAssoc = 1;
														//novoCadastro('#myForm');	
				                                        //$(location).attr('href', '/cadastro/sucesso');
				                                        // ------------ Desabilita os inputs -----------------------------------
				                                        //$('#myForm input').attr("readonly", true);
				                                        
				                                        
				
				                                              	//$flagCadPessoa = 1;
				
				                                            // ------- Atibuindo o texto "Novo Cadastro" ao botão de cadastro ------
				                                             //$('#botaoCad').html('Novo Cadastro');
				
															//console.log(data);
				                                        	//window.location.href = "/pessoa/editar/sucesso";
				                                        	//window.location.reload();
				                                    } else {
														alert("Pessoa não cadastrada!");
													}
			
			                                    }
			
			
			                                });
			
			                        });
					});	
		}
		


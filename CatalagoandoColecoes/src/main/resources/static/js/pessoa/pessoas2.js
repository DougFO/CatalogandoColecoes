jQuery(document).ready(function($) {
	
	

			
			
	          $.ajax({
                type: "GET",
                url: "/api/v1/pessoa",
                async: false,
                //data: { id: recipient },
                success: function (pessoas) {
					var tbody;
					var tr;
					var td;
					var elementoTabela;
					tbody = document.getElementById("corpoTabela");
                    //var dados = JSON.parse(resposta);
                    pessoas.forEach(function(pessoa) {
					  //console.log("Teste: "+pessoa.nome);
					  
					  tr = document.createElement("tr");
					  td = document.createElement("td");
					  elementoTabela = pessoa.id;
					  //tr.appendChild(elementoTabela);
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td);
					  td = document.createElement("td");
					  elementoTabela = pessoa.cpf;
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td); 
					  td = document.createElement("td");
					  elementoTabela = pessoa.nome;
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td); 
					  td = document.createElement("td");
					  elementoTabela = pessoa.email;
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td); 
					  td = document.createElement("td");
					  if(pessoa.colecao != null) {
					  	elementoTabela = pessoa.colecao.nome;
					  } else {
						elementoTabela = "Não tem!";
					  }	
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td);
					  td = document.createElement("td");
					  elementoTabela = '<button href="" class="btn btn-primary" onclick="editar('+pessoa.cpf+')">Editar</button>';
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td);
					  td = document.createElement("td");
					  elementoTabela = '<button href="" class="btn btn-danger" onclick="remover('+pessoa.cpf+')">Remover</button>';
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td);  
					  tbody.appendChild(tr);
					  
					});

                    /*modal.find('.modal-title').text('Dados do Associado: ' + dados[0].nome)
                    $('#nomeEditar').val(dados[0].nome);
                    $('#registroEditar').val(dados[0].registro);
                    $cpfAux = dados[0].cpf;
                    $cpfFormatado = $cpfAux.toString().substring(0,3)+"."+$cpfAux.toString().substring(3,6)+"."+$cpfAux.toString().substring(6,9)+"-"+$cpfAux.toString().substring(9,11);
                    $('#cpfEditar').val($cpfFormatado);
                    $cpfEV = dados[0].cpf;
                    $('#idAssocEditar').val(recipient);
                    $('#rgEditar').val(dados[0].rg);
                    $('#divUFEditar select').val(dados[0].uf);
                    $('#municipioEditar').val(dados[0].municipio);

                    $('#bairroEditar').val(dados[0].bairro);
                    $('#ruaEditar').val(dados[0].rua);
                    $('#numeroEditar').val(dados[0].numero);

                    $('#complementoEditar').val(dados[0].complemento);
                    $('#divPlantaoEditar select').val(dados[0].plantao);
                    $('#divProjetoEditar select').val(dados[0].projeto);

                    $('#telefoneEditar').val(dados[0].telefone);
                    $('#emailEditar').val(dados[0].email);
                    $('#profissaoEditar').val(dados[0].profissao);

                    $('#divQuotaEditar select').val(dados[0].quotas);
                    $('#divBancoEditar select').val(dados[0].banco);

                    $('#agenciaEditar').val(dados[0].agencia);
                    $('#dvAgenciaEditar').val(dados[0].dv_agencia);

                    $('#contaEditar').val(dados[0].conta);
                    $('#dvContaEditar').val(dados[0].dv_conta);*/


                }


            });
            
            
  
});	


	          function editar(cpf) {
				//var x;
				//var r=confirm("Editar!"+cpf);
				//if (r==true)
				//{
				  	$.ajax({
	                type: "GET",
	                url: "/api/v1/pessoa/"+cpf,
	                async: false,
	                //ta: { id: recipient },
	                success: function (pessoas) {
						window.location.href = "../pessoa/"+cpf;
					}
						  
					});
				//}
				//else
				//{
				//  x="Você pressionou Cancelar!";
				//}
				//console.log("Cpf da pessoa "+cpf);
				//window.location.href = "/pessoa/cadastro/sucesso";
				
			}
			
			function remover(cpf) {
				//var y;
				var r=confirm("Remover?");
				if (r==true)
				{
					   $.ajax({
	                type: "DELETE",
	                url: "/api/v1/pessoa/"+cpf,
	                async: false,
	                //ta: { id: recipient },
	                success: function (pessoas) {
						console.log("Excluido!");
						window.location.reload();
					}
						  
					});
				}
				else
				{
				  //y="Você pressionou Cancelar!";
				  console.log("Cancelada a exclusão!");
				}
			}
$(document).ready( function () {
	 
	 $.ajax({
                type: "GET",
                url: "/api/v1/item/itens/"+$('#tituloPesquisado').val(),
                async: false,
                //data: { id: recipient },
                success: function (itens) {
					var tbody;
					var tr;
					var td;
					var elementoTabela;
					tbody = document.getElementById("corpoTabela");
                    //var dados = JSON.parse(resposta);
                    itens.forEach(function(item) {
					  //console.log("Teste: "+pessoa.nome);
					  
					  tr = document.createElement("tr");
					  td = document.createElement("td");
					  elementoTabela = item.id;
					  //tr.appendChild(elementoTabela);
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td);
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
					  if(item.hasOwnProperty('tipo')) {
					  	elementoTabela = "MANGÁ";
					  	$tipo = "manga";
					  } else {
						elementoTabela = "HQ";
						$tipo = "hq";
					  }	
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td);
					  td = document.createElement("td");
					  if($tipo == "manga"){
					  	elementoTabela = '<a href="/item/'+item.isbn+'/manga" class="btn btn-primary">Editar</a>';
					  }	
					  if($tipo == "hq"){
					  	elementoTabela = '<a href="/item/'+item.isbn+'/hq" class="btn btn-primary">Editar</a>';
					  }	
					  //elementoTabela = '<a href="/item/'+item.isbn+'?tipo='+$tipo+'" class="btn btn-primary">Editar</a>';
					  //elementoTabela = '<a href="/item/'+item.isbn+'/'+$tipo+'" class="btn btn-primary">Editar</a>';
					  td.innerHTML = elementoTabela;
					  tr.appendChild(td);
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
	 

	 

});


 function remover(isbn) {
			//var y;
			//console.log("TesteISBN!"+isbn);
			var r=confirm("Remover?");
			if (r==true)
			{
				   $.ajax({
		                type: "DELETE",
		                url: "/api/v1/item/"+isbn,
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
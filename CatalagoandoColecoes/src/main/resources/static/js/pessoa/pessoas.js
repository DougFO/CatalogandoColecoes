$(document).ready( function () {
	 /*var table = $('#tabelaPessoas').DataTable({
			"sAjaxSource": "/api/v1/pessoa",
			"columnDefs": [
                            { "title" : "ID", "targets":0},
                            { "title" : "CPF", "targets":1 },
                            { "title" : "Nome", "targets":2 },
                            { "title" : "Email", "targets":3 },
                            { "title" : "Coleção", "targets":4 },
                            { "title" : "Nível", "targets":5 },
                        ],
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			    { "mData": "id"},
		      	{ "mData": "cpf" },
				  { "mData": "nome" },
				  { "mData": "email" },
				  { "mData": "colecao" },
				   { "mData": "usuario.nivel" },
				   { "defaultContent": "<button class='btn btn-primary'>Editar</button>" }
				  //{ "mData": "phone" },
				  //{ "mData": "active" }
			],
			"language": {
                            lengthMenu: "Mostrar _MENU_ Pessoas por p&aacutegina",
                            info: "Mostrando _START_ a _END_ de _TOTAL_ registros",
                            search: "Pesquisar",
                            infoFiltered: "(filtro aplicado em _MAX_ registros)",
                            "paginate" : {
                                first: "Primeira",
                                previous: "Anterior",
                                next: "Proxima",
                                last: "Ultima",
                            },

                        },
	 })*/
	 

	 

});


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
jQuery(document).ready(function() {
	//const urlParams = new URLSearchParams(window.location.search);
	//const products = urlParams.get("tipo") // livros
	//const author = urlParams.get("autor") // Augusto
	//console.log("TesteU: "+products);
	console.log("testeISBN: "+$('#lItemIsbn').val());
	$.ajax({
                type: "GET",
                url: "/api/v1/item/"+$('#lItemIsbn').val(),
                async: false,
                //data: { id: recipient },
                success: function (item) {
					$('#lItemTitulo').val(item.titulo);
					$('#lItemVolume').val(item.volume);
					$('#lItemAutor').val(item.autor);
					//$('#lItemTitulo').val(item.titulo);
					//$('#lItemTitulo').val(item.titulo);
					//$('#lItemTitulo').val(item.titulo);
					
                }


            });
	 
});  
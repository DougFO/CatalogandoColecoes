function verifica() {
	if(document.getElementById("manga").checked) {
		//alert("Mangá marcado!");
		$("#painelManga").css("visibility","visible");
		$("#painelManga").css("position","relative");
		$("#painelHq").css("visibility","hidden");
		$("#painelHq").css("position","absolute");
	} else {
		if(document.getElementById("hq").checked) {
			$("#painelHq").css("visibility","visible");
			$("#painelHq").css("position","relative");
			$("#painelManga").css("visibility","hidden");
			$("#painelManga").css("position","absolute");
		}
	}
}
function testarExcecao() {

	var valorInformado = $('#txtinput').val();

	// alert(valorInformado);

	$.ajax({
		method : "POST",
		url : "capturarExcecao",
		data : {
			valorParam : valorInformado
		}
	}).done(function(response) { //ok
		alert("Sucesso " + response);
	}).fail(function(xhr,status,errorThrown) { //erro
		alert("Fail:" + xhr.responseText );
	})

}

function carregarpage(){	
	$("#mostrarPaginaFilha").load('paginaFilha.jsp');	
	console.log('teste')	;
	
}

function progressbar(){
	

	let elem = document.querySelector("#myBar");
	let progress = 1;
	let id = setInterval(frame,10);
	
	function frame() {		
		if(progress >= 100){
			clearInterval(id);
		}else {
			progress++;
			elem.style.width = progress + "%";
		}		
	}			
}

$(function(){
var progressbar = $("#progressbar"),
	progresslabel = $(".progress-label");


progressbar.progressbar({
	value: false,
	change: function(){
		progresslabel.text(progressbar.progressbar('value') + "%");
	}, complete: function(){
		progresslabel.text('Completo!');
		
	}
})


function progress(){
	
	var val = progressbar.progressbar("value")||0;
	progressbar.progressbar("value",val+2);
	if(val < 99){
		setTimeout(progress,80);		
	}
	
}
setTimeout(progress,2000);

})



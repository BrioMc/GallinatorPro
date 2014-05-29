/*****************************Quest*****************************/
function recallQuest() {
	Controlador.listQuest(function(tpt){
		trs1 = $('#lista_quest tr').length;
		for(var i=0;i<trs1;i++){
			trs = $('#lista_quest tr').length;
		if(trs>1)
	    {
	        $("#lista_quest tr:last").remove();
	    }}
		$.each(tpt, function(i) {console.log(tpt[i]);
			$nuevodiv= $('<tr><td>'+tpt[i].definicion+'</td><td>'+tpt[i].posX_init+'</td><td>'+tpt[i].posY_init+'</td><td>'+tpt[i].respuesta+'</td><td>'+tpt[i].posX_finish+'</td><td>'+tpt[i].posY_finish+'</td><td>'+tpt[i].points+'</td><td><input type="checkbox" name="seleccion[]" value="'+tpt[i].idQuest+'" /></td><td><button>Modificar</button></td></tr>');
			$('#lista_quest').append($nuevodiv);
		});
	});
};
function clearForm(){
	$("input[name=idQuest]").val("");
	$("textarea[name=definicion]").val("");
	$("input[name=posX_init]").val("");
	$("input[name=posY_init]").val("");
	$("textarea[name=resultado]").val("");
	$("input[name=posX_finish]").val("");
	$("input[name=posY_finish]").val("");
	$("input[name=points]").val("");
	$('#idQuest').val(null);
}
function showForm(){
	if($('#addquest').is(':visible')){
		$('#addquest').hide();
	}
	else{
		$('#addquest').show();
	}
}
function modQuest(id){
	showForm();
	Controlador.seeQuest(id, function(quest){
		$("textarea[name=definicion]").val(quest.definicion);
		$("input[name=posX_init]").val(quest.posX_init);
		$("input[name=posY_init]").val(quest.posY_init);
		$("textarea[name=resultado]").val(quest.respuesta);
		$("input[name=posX_finish]").val(quest.posX_finish);
		$("input[name=posY_finish]").val(quest.posY_finish);
		$("input[name=points]").val(quest.points);
		$('#idQuest').val(quest.idQuest);
	});
}
function addQuest() {

	var quest = new Object();
	quest.idQuest=$("input[name=idQuest]").val();
	quest.definicion = $("textarea[name=definicion]").val();
	quest.posX_init = $("input[name=posX_init]").val();
	quest.posY_init = $("input[name=posY_init]").val();
	quest.respuesta = $("textarea[name=resultado]").val();
	quest.posX_finish = $("input[name=posX_finish]").val();
	quest.posY_finish = $("input[name=posY_finish]").val();
	quest.points = $("input[name=points]").val();
	if(quest.idQuest==null){
	Controlador.addQuest(quest, function() {recallQuest();
	});}
	else{
		Controlador.modQuest(quest, function() {recallQuest();
	});}
	clearForm();
}

/*****************************Enemigos*****************************/
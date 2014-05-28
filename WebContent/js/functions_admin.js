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
			$nuevodiv= $('<tr><td>'+tpt[i].definicion+'</td><td>'+tpt[i].posX_init+'</td><td>'+tpt[i].posY_init+'</td><td>'+tpt[i].respuesta+'</td><td>'+tpt[i].posX_finish+'</td><td>'+tpt[i].posY_finish+'</td><td>'+tpt[i].points+'</td><td><input type="checkbox" name="seleccion[]" value="'+tpt[i].id+'" /></td><td><button>Modificar</button></td></tr>');
			$('#lista_quest').append($nuevodiv);
		});
	});
};
function addQuest() {
	var quest = new Object();
	quest.definicion = $("textarea[name=definicion]").val();
	quest.posX_init = $("input[name=posX_init]").val();
	quest.posY_init = $("input[name=posY_init]").val();
	quest.respuesta = $("textarea[name=resultado]").val();
	quest.posX_finish = $("input[name=posX_finish]").val();
	quest.posY_finish = $("input[name=posX_finish]").val();
	quest.points = $("input[name=points]").val();
	Controlador.addQuest(quest, function() {recallQuest();
	});
}
/*****************************Quest*****************************/
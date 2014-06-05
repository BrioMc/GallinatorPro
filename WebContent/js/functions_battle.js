function closeSession(){
	Controlador.closeSession(function(){location.reload();});
}
/*****************************Quest*****************************/
function showFormQuest(){
	  clearForm();
	if($('#addquest').is(':visible')){
		$('#addquest').hide();
	}
	else{
		$('#addquest').show();
	}
}
function recallQuest() {
	Controlador.listQuest(function(tpt){
		trs1 = $('#lista_quest tr').length;
		for(var i=0;i<trs1;i++){
			trs = $('#lista_quest tr').length;
		if(trs>1)
	    {
	        $("#lista_quest tr:last").remove();
	    }}
		$.each(tpt, function(i) {
			$nuevodiv= $('<tr><td>'+tpt[i].definicion+'</td><td>'+tpt[i].posX_init+'</td><td>'+tpt[i].posY_init+'</td><td>'+tpt[i].respuesta+'</td><td>'+tpt[i].posX_finish+'</td><td>'+tpt[i].posY_finish+'</td><td>'+tpt[i].points+'</td><td><input type="checkbox" name="seleccion[]" value="'+tpt[i].idQuest+'" /></td><td><button onclick="modQuest('+tpt[i].idQuest+')">Modificar</button></td></tr>');
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
function modQuest(id){	
	if(id==$('#idQuest').val() && $('#addquest').is(':visible')){
		$('#addquest').hide();
		}
	else{
		$('#addquest').show();
	}
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
	if(quest.idQuest==""){
	Controlador.addQuest(quest, function() {recallQuest();
	});}
	else{
		Controlador.modQuest(quest, function() {recallQuest();
	});}
	clearForm();
}
function deleteQuest(){
	//Seleccionar los que se desean borrar
	arraySelect=$("input[name='seleccion[]']:checked");
	longitud=arraySelect.length;
	if(longitud>0){
		if(confirm("Seguro que desea borrar las Quest's seleccionadas")){
		$.each(arraySelect, function(i)
			{
				Controlador.deleteQuest(arraySelect[i].value,function(){recallQuest();
				});
		});
	}
	}
	else{
		alert("Seleccione alguna Quest para poder borrar.");
	}
}
/*****************************Enemigos*****************************/
function showFormEnemy(){
	  clearFormEnemy();
	if($('#addenemy').is(':visible')){
		$('#addenemy').hide();
	}
	else{
		$('#addenemy').show();
	}
}
function clearFormEnemy(){
	$("input[name=nombre]").val("");
	$("#cajaimagen").empty();
	$("input[name=daño]").val("");
	$("input[name=sangre]").val("");
	$("input[name=exp]").val("");
	$("input[name=idEnemy]").val("null");
	$("input[name=points]").val("");
}
function modEnemy(id){		
	if(id==$("input[name=idEnemy]").val() && $('#addenemy').is(':visible')){
		$('#addenemy').hide();
		}
	else{
		$('#addenemy').show();
	}
	clearFormEnemy();
	Controlador.seeEnemy(id, function(enemy){
		$("input[name=nombre]").val(enemy.nombre);
		var img = "<img src='../"+enemy.imagen+"'/>";
		$("#cajaimagen").append(img);
		$("input[name=dmg]").val(enemy.dmg);
		$("input[name=sangre]").val(enemy.sangre);
		$("input[name=exp]").val(enemy.exp);
		$("input[name=idEnemy]").val(enemy.id);
		$("input[name=points]").val(enemy.points);
	});
}
function deleteEnemy(){
	//Seleccionar los que se desean borrar
	arraySelect=$("input[name='seleccion[]']:checked");
	longitud=arraySelect.length;
	if(longitud>0){
		if(confirm("Seguro que desea borrar los Enemigos seleccionadas")){
		$.each(arraySelect, function(i)
			{
				Controlador.deleteEnemy(arraySelect[i].value,function(){recallEnemy();
				});
		});
	}
	}
	else{
		alert("Seleccione algún Enemigo para poder borrar.");
	}
}

function recallEnemy() {
	Controlador.listEnemy(function(tpt){
		trs1 = $('#list_enemy tr').length;
		for(var i=0;i<trs1;i++){
			trs = $('#list_enemy tr').length;
		if(trs>1)
	    {
	        $("#list_enemy  tr:last").remove();
	    }}
		$.each(tpt, function(i) {
			$nuevodiv= $('<tr><td>'+tpt[i].nombre+'</td><td><img class="enemyimg" src="../'+tpt[i].imagen+'"/></td><td>'+tpt[i].sangre+'</td><td>'+tpt[i].dmg+'</td><td>'+tpt[i].exp+'</td><td>'+tpt[i].points+'</td><td><input type="checkbox" name="seleccion[]" value="'+tpt[i].id+'" /></td><td><button onclick="modEnemy('+tpt[i].id+')">Modificar</button></td></tr>');
			$('#list_enemy ').append($nuevodiv);
		});
	});
};

/**********************************************************Usuario**********************************************************/
function clearFormUser(){
	$("input[name=user]").val(null);
	$("input[name=pass]").val(null);
	$("input[name=email]").val(null);
	$("input[name=idUser]").val(null);
}
function showFormUser(){
	  clearFormUser();
	if($('#moduser').is(':visible')){
		$('#moduser').hide();
	}
	else{
		$('#moduser').show();
	}
}
function recallUser() {
	Controlador.listUser(function(tpt){
		trs1 = $('#list_user tr').length;
		for(var i=0;i<trs1;i++){
			trs = $('#list_user tr').length;
		if(trs>1)
	    {
	        $("#list_user  tr:last").remove();
	    }}
		$.each(tpt, function(i) {
			$nuevodiv= $('<tr><td>'+tpt[i].user+'</td><td>'+tpt[i].pass+'</td><td>'+tpt[i].email+'</td><td><input type="checkbox" name="seleccion[]" value="'+tpt[i].id+'" /></td><td><button onclick="modEnemy('+tpt[i].id+')">Modificar</button></td></tr>');
			$('#list_user').append($nuevodiv);
		});
	});
};
function modUser(id){		
	if(id==$("input[name=idUser]").val() && $('#moduser').is(':visible')){
		$('#moduser').hide();
		}
	else{
		$('#moduser').show();
	}
	clearFormUser();
	Controlador.seeUser(id, function(user){
		$("input[name=user]").val(user.user);
		$("input[name=pass]").val(user.pass);
		$("input[name=email]").val(user.email);
		$("input[name=idUser]").val(user.id);
			});
}
function deleteUser(){
	//Seleccionar los que se desean borrar
	arraySelect=$("input[name='seleccion[]']:checked");
	longitud=arraySelect.length;
	if(longitud>0){
		if(confirm("Seguro que desea borrar los Usuarios seleccionados?")){
		$.each(arraySelect, function(i)
			{
				Controlador.deleteUser(arraySelect[i].value,function(){recallUser();
				});
		});
	}
	}
	else{
		alert("Seleccione algún usuario para poder borrar.");
	}
}

function pushModUser(){
	var user = new Object();
	user.user=$("input[name=user]").val();
	user.pass=$("input[name=pass]").val();
	user.email=$("input[name=email]").val();
	user.id=$("input[name=idUser]").val();
	Controlador.modUser(user, function(){recallUser();});
}
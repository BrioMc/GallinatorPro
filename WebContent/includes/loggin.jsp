
<link rel="stylesheet" type="text/css" href="style/table.css"
	media="screen" />
<script>
	$(function() {
		$('#signinform').validate({
			rules : {
				email : {
					required : true, //para validar campo vacio
					email : true
				//para validar formato email
				},
				user : {
					required : true,
					minlength : 4, //para validar campo con minimo 4 caracteres
					maxlength : 9
				//para validar campo con maximo 9 caracteres
				},
				alias : {
					required : true,
					minlength : 4, //para validar campo con minimo 4 caracteres
					maxlength : 9
				//para validar campo con maximo 9 caracteres
				},
				pass : {
					minlength : 4,
					required : true,
				//para validar campo solo numeros
				},
				pass1 : {
					equalTo : "#pass",
				//para validar campo solo numeros
				},
				mi_pais : {
					required : true,
				}

			}
		});
	});
</script>
<div id="logginbox">
	<button id="logginbutton">Iniciar sesión</button>
	<button id="signinbutton">Registrarse</button>
	<div id="loggin">
		<h1>Login</h1>
		<form action="ControladorLogin" method="post">
			<label>Usuario:</label> <input type="text" name="user" required /> <label>Contraseña:</label><input
				type="password" name="pass" /> <input type="submit" value="Loggin"
				required> <a></a>
		</form>
	</div>
	<div id="signin">
		<h1>Registro</h1>
		<form id="signinform" action="ControladorRegistro" method="post">
			<table>
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="user" required /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" id="pass" name="pass" required /></td>
				</tr>
				<tr>
					<td>Confirme Password:</td>
					<td><input type="password" name="pass1" required /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" required /></td>
				</tr>
				<tr>
					<td>Nick:</td>
					<td><input type="text" name="alias" required /></td>
				</tr>
				<tr>
					<td>Clase:</td>
					<td><select name="clase" required>
							<option value="warrior">Guerrero</option>
							<option value="mage">Mago</option>
					</select></td>
				</tr>
				<tr>
					<td><a></a></td>
					<td><input type="submit" value="Registrarse" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>


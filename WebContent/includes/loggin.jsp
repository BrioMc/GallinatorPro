
<link rel="stylesheet" type="text/css" href="style/table.css"
	media="screen" />
<div id="logginbox">
	<button id="logginbutton">Iniciar sesión</button>
	<button id="signinbutton">Registrarse</button>
	<div id="loggin">
		<form action="ControladorLogin" method="post">
			<label>Usuario:</label> <input type="text" name="user" /> <label>Contraseña:</label><input
				type="password" name="pass" /> <input type="submit" value="Loggin">
			<button>Olvidé mi contraseña</button>
			<a><img alt="Volver atras" src=""></a>
		</form>
	</div>
	<div id="signin">
		<form action="ControladorRegistro" method="post">
			<table>
				<tr>
					<td>Usuario:</td>
					<td><input type="text" name="user" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="pass" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email" /></td>
				</tr>
				<tr>
					<td>Nick:</td>
					<td><input type="text" name="alias" /></td>
				</tr>
				<tr>
					<td>Clase:</td>
					<td><select name="clase">
							<option value="warrior">Guerrero</option>
							<option value="mage">Mago</option>
					</select></td>
				</tr>
				<tr>
					<td><a class="backey"></a></td>
					<td><input type="submit" value="Registrarse" /></td>
				</tr>
			</table>
		</form>
	</div>
</div>

<div id="player">
	<table>
		<tr>
			<td colspan="2">Nick:</td>
			<td>${SesionPlayer.alias }</td>
		</tr>
		<tr>
			<td>Clase: ${SesionPlayer.clase }</td>
			<td>Exp: ${SesionPlayer.exp }</td>
			<td>Level: ${SesionPlayer.lv }</td>
		</tr>
		<tr>
			<td colspan="3">HP:<progress class="progress" id="progressangre"
					max="${SesionPlayer.maxSangre }" value="${SesionPlayer.sangre }"></progress></td>

		</tr>
		<tr>
			<td colspan="3">MP:<progress class="progress" id="progressmana"
					max="${SesionPlayer.maxMana}" value="${SesionPlayer.mana }"></progress></td>
		</tr>
		<tr>
			<td colspan="2">Fuerza:</td>
			<td>${SesionPlayer.dmgF }</td>
		</tr>
		<tr>
			<td colspan="2">Sabiduria:</td>
			<td>${SesionPlayer.dmgH }</td>
		</tr>
	</table>
	<button onclick="closeSession()">Cerrar Sesión</button>
</div>

package sna.admin.encuestas.portal
{
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.RespuestaDePortal")]
	public class RespuestaDePortal
	{
		public var id:int;
		public var descripcion:String = "ingrese la descripción de la respuesta";
	}
}
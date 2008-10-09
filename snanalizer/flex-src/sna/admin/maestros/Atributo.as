

package sna.admin.maestros
{
	import sna.admin.maestros.DatoMaestro;
	
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.Atributo")]
	public class Atributo
	{
		public var nombre:String;
		public var descripcion:String;
		public var estado:Boolean;
		public var datoMaestro:DatoMaestro;

		public function Atributo()
		{
		}

	}
}
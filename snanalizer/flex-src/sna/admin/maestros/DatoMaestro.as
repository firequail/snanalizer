package sna.admin.maestros
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.DatoMaestro")]
	public class DatoMaestro
	{
		public var descripcion:String;
		public var atributos:ArrayCollection = new ArrayCollection();
		
		public function DatoMaestro()
		{
		}

	}
}
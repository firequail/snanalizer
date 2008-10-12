package sna.admin.encuestas.portal
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.EncuestaDePortal")]
	public class EncuestaDePortal
	{
		public var id:int;
		
		public var nombre:String;
		
		public var preguntas:ArrayCollection = new ArrayCollection();
		
		public function EncuestaDePortal()
		{
		}

	}
}
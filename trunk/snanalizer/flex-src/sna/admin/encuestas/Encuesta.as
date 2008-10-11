package sna.admin.encuestas
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.Encuesta")]
	public class Encuesta
	{
		public var id:int;
		
		public var nombre:String;
		
		public var preguntas:ArrayCollection = new ArrayCollection();
		
		public function Encuesta()
		{
		}

	}
}
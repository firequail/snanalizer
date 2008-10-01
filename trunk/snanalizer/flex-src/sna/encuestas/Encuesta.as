package sna.encuestas
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.Encuesta")]
	public class Encuesta
	{
		public var nombre:String;
		
		public var preguntas:ArrayCollection = new ArrayCollection();
		
		public function Encuesta()
		{
		}

	}
}
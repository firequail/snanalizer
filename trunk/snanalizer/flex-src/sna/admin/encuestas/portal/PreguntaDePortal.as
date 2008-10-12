package sna.admin.encuestas.portal
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.PreguntaDePortal")]
	public class PreguntaDePortal
	{
		public var descripcion:String = "ingrese la descripción de la pregunta";
		
		public var respuestas:ArrayCollection = new ArrayCollection();
		
		public function PreguntaDePortal()
		{
		}

	}
}
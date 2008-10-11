package sna.admin.encuestas
{
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.Pregunta")]
	public class Pregunta
	{
		public var descripcion:String = "ingrese la descripción de la pregunta";
		
		public var maximaIntensidad:int = 5;
		
		public function Pregunta()
		{
		}

	}
}
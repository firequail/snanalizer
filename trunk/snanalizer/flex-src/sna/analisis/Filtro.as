package sna.analisis
{
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.Filtro")]
	public class Filtro
	{
		public var areaId:int = 0;
		public var puestoId:int = 0;
		public var seniorityId:int = 0;
		
		public function Filtro()
		{
		}

		public function isEnabled():Boolean {
			return areaId != 0 || puestoId != 0 || seniorityId != 0;
		}

	}
}
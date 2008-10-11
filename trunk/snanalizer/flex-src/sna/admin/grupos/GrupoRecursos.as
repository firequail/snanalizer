package sna.admin.grupos
{
	import mx.collections.ArrayCollection;
	
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.GrupoRecursos")]
	public class GrupoRecursos
	{
		public var id:int;
		public var descripcion:String;
		public var recursos:ArrayCollection = new ArrayCollection();
		public var estado:Boolean;
		

		public function GrupoRecursos()
		{
		}

	}
}
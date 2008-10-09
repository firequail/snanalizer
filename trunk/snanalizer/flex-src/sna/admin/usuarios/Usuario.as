package sna.admin.usuarios
{
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.Usuario")]
	public class Usuario
	{
		public var email:String;
		public var password:String;
		public var rol:String;
		public var nombre:String;
		public var apellido:String;

		
		public function Usuario()
		{
		}

	}
}


package sna.admin.recursos
{
	import flash.utils.ByteArray;
	import sna.admin.maestros.Atributo;
	import sna.admin.usuarios.Usuario;
	
	[Bindable]
	[RemoteClass(alias="snanalizer.domain.Recurso")]
	public class Recurso
	{
		public var usuario:Usuario;
		public var nombre:String;
		public var apellido:String;
		public var fechaNac:Date;
		public var area:Atributo;
		public var puesto:Atributo;
		public var seniority:Atributo;
		public var estadoCivil:String;
		public var localidad:String;
		public var provincia:Atributo;
		public var titulo:String;
		public var institucion:Atributo;
		public var anioIngreso:int;
		public var anioEgreso:int;
		public var idioma1:Atributo;
		public var idioma2:Atributo;
		public var idioma3:Atributo;
		public var nivelIdioma1:Atributo;
		public var nivelIdioma2:Atributo;
		public var nivelIdioma3:Atributo;
		public var hobbie1:Atributo;
		public var hobbie2:Atributo;
		public var hobbie3:Atributo;
		public var hobbie4:Atributo;
		public var hobbie5:Atributo;
		public var hobbie6:Atributo;
		public var experiencia:String;
		public var estado:Boolean;
		public var picture:ByteArray;

		
			
		
		
		/*
			private Usuario usuario;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private Atributo area;
	private Atributo puesto;
	private Atributo seniority;
	private String estadoCivil;
	private String localidad;
	private Atributo provincia;
	private String titulo;
	private Atributo institucion;
	private Integer anioIngreso;
	private Integer anioEgreso;
	private Atributo idioma1;
	private Atributo idioma2;
	private Atributo idioma3;
	private Atributo nivelIdioma1;
	private Atributo nivelIdioma2;
	private Atributo nivelIdioma3;
	private Atributo hobbie1;
	private Atributo hobbie2;
	private Atributo hobbie3;
	private Atributo hobbie4;
	private Atributo hobbie5;
	private Atributo hobbie6;
	private String experiencia;
	private Boolean estado;
	
	@Basic(fetch=LAZY)
	@Lob @Column(name="PIC")
	private byte[] picture;
		*/
		
		public function Recurso()
		{
		}

	}
}
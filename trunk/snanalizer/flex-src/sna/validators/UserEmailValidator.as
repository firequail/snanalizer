package sna.validators
{
	import mx.events.ValidationResultEvent;
	import mx.validators.EmailValidator;
	import mx.validators.ValidationResult;

	public class UserEmailValidator extends EmailValidator
	{
		private var valid:Boolean = true;
		
		public function set usuario(usuario:Object):void {
			if(usuario != null) {
				valid = false;
			} else {
				valid = true;
			}
		}
		
		public function UserEmailValidator()
		{
			super();
			this.property = "text";
			this.required = true;
		}
		
		public function reset():void {
			valid = true;
			this.dispatchEvent(new ValidationResultEvent(ValidationResultEvent.VALID))
		}
		
		override protected function doValidation(value:Object):Array {
			var results:Array = super.doValidation(value);
			
			if(!valid) {
				results.push(new ValidationResult(true, null, "Email ya existe","La dirección de email ya esta siendo utilizada"));
			}
			
            return results;
		}
	}
}
package sna.validators
{
	import mx.events.ValidationResultEvent;
	import mx.validators.EmailValidator;

	public class UserEmailValidator extends EmailValidator
	{
		public function UserEmailValidator()
		{
			super();
			this.property = "text";
			this.required = true;
		}
		
		
		public function isValid():Boolean {
			var event:ValidationResultEvent = this.validate(null, false); 
            return event.type == ValidationResultEvent.VALID;
		}
		
		public function reset():void {
			this.dispatchEvent(new ValidationResultEvent(ValidationResultEvent.VALID))
		}
		
	}
}
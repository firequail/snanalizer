package sna.validators
{
	import mx.events.ValidationResultEvent;
	import mx.validators.StringValidator;
	import mx.validators.ValidationResult;

	public class RequiredText extends StringValidator
	{
		public var equalTo:Object;
		
		public function RequiredText()
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
		
		override protected function doValidation(value:Object):Array {
			var results:Array = super.doValidation(value);
			
			if(equalTo != null && equalTo.text != value) {
				results.push(new ValidationResult(true, null, "Error de igualdad","Los campos deben ser iguales"));
			}
			
            return results;
		}
		
	}
}
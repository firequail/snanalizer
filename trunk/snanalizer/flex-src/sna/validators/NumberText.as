package sna.validators
{
	import mx.events.ValidationResultEvent;
	import mx.validators.NumberValidator;

	public class NumberText extends NumberValidator
	{
		public function NumberText()
		{
			super();
			this.property = "text";
			this.required = false;
		}
		
		public function reset():void {
			this.dispatchEvent(new ValidationResultEvent(ValidationResultEvent.VALID))
		}		
	}
}
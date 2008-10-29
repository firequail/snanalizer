package sna.validators
{
	import mx.events.ValidationResultEvent;
	import mx.validators.DateValidator;

	public class RequiredDate extends DateValidator
	{
		public function RequiredDate()
		{
			super();
			this.property = "text";
			this.required = true;
		}
		
		public function reset():void {
			this.dispatchEvent(new ValidationResultEvent(ValidationResultEvent.VALID))
		}
	}
}
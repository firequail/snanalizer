package sna.analisis.composite
{
	import flash.events.EventPhase;
	import flash.events.MouseEvent;
	
	import mx.containers.Canvas;
	import mx.controls.Alert;
	
	public class CompositeVisualGraphEventCatcher extends Canvas
	{
		public function CompositeVisualGraphEventCatcher()
		{
			this.addEventListener(MouseEvent.MOUSE_DOWN, handleMouseDown);
			this.addEventListener(MouseEvent.MOUSE_UP, handleMouseUp);
		}
		
		protected function handleMouseDown(event:MouseEvent):void {
			//event.stopImmediatePropagation();
			//EventPhase.CAPTURING_PHASE == 1
			//EventPhase.AT_TARGET == 2
			//EventPhase.BUBBLING_PHASE == 3
			Alert.show(event.eventPhase.toString());
		}
		
		protected function handleMouseUp(event:MouseEvent):void {
			//event.stopImmediatePropagation();
		}
	}
}
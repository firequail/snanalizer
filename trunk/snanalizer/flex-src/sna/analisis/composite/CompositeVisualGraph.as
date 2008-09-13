package sna.analisis.composite
{
	import mx.containers.Canvas;
	import mx.core.UIComponent;
	
	public class CompositeVisualGraph extends Canvas
	{
		public static var instance:Canvas;
		
		public function CompositeVisualGraph()
		{
			instance = this;
		}
	}
}
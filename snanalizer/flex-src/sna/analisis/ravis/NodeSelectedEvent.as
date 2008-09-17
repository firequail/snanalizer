package sna.analisis.ravis
{
	import flash.events.Event;

	public class NodeSelectedEvent extends Event
	{
		public var nodeId:int;
		
		public static const NODE_SELECTED:String = "nodeSelected";
		
		public function NodeSelectedEvent(type:String, nodeId:int)
		{
			super(type);
			this.nodeId = nodeId;
		}
		
		override public function clone():Event {
		   return new NodeSelectedEvent(type, nodeId);
		}
	}
}
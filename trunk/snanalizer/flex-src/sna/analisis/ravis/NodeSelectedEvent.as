package sna.analisis.ravis
{
	import flash.events.Event;
	
	import org.un.cava.birdeye.ravis.graphLayout.visual.IVisualNode;

	public class NodeSelectedEvent extends Event
	{
		public var node:IVisualNode;
		
		public static const NODE_SELECTED:String = "nodeSelected";
		
		public function NodeSelectedEvent(type:String, node:IVisualNode)
		{
			super(type);
			this.node = node;
		}
		
		public function get nodeId():int {
			if (node == null) {
				return 0;
			}
			return node.data.@id;
		}
		
		override public function clone():Event {
		   return new NodeSelectedEvent(type, node);
		}
	}
}
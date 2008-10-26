package sna.analisis.renderers.edges {
	
	import flash.display.Graphics;
	import flash.geom.Point;
	
	import org.un.cava.birdeye.ravis.graphLayout.visual.IVisualEdge;
	import org.un.cava.birdeye.ravis.graphLayout.visual.IVisualNode;
	import org.un.cava.birdeye.ravis.graphLayout.visual.edgeRenderers.BaseEdgeRenderer;


	/**
	 * This is a directed edge renderer, which draws the edges
	 * with arrowheads at the target point.
	 * Please note that for undirected graphs, the actual direction
	 * of the edge might be arbitrary.
	 * */
	public class SNAEdgeRenderer extends BaseEdgeRenderer {
		
		
		/**
		 * The size of the arrowhead in pixel. The distance of the
		 * two points defining the base of the arrowhead.
		 * */
		public var arrowBaseSize:Number = 10;
		
		/**
		 * The distance of the arrowbase from the tip in pixel.
		 * */
		public var arrowHeadLength:Number = 20;
		
		/**
		 * Constructor sets the graphics object (required).
		 * @param g The graphics object to be used.
		 * */
		public function SNAEdgeRenderer(g:Graphics):void {
			super(g);
		}
		
		/**
		 * The draw function, i.e. the main function to be used.
		 * Draws a curved line from one node of the edge to the other.
		 * The colour is determined by the "disting" parameter and
		 * a set of edge parameters, which are stored in an edge object.
		 * 
		 * @inheritDoc
		 * */
		override public function draw(vedge:IVisualEdge):void {
			drawColored(vedge,0xcccccc);
		}
		
		public function drawColored(vedge:IVisualEdge, color:int):void {
			
			/* first get the corresponding visual object */
			var fromNode:IVisualNode = vedge.edge.node1.vnode;
			var toNode:IVisualNode = vedge.edge.node2.vnode;
			
			var fP:Point = fromNode.viewCenter;
			var tP:Point = toNode.viewCenter;
			
			/* apply the line style */
			applyLineStyle(vedge);
			
			/* now we actually draw */
			_g.beginFill(uint(color));
			
			_g.moveTo(fP.x, fP.y);
			_g.lineTo(tP.x, tP.y);
			
			var fromIntensity:int = parseInt(vedge.data.@fromIntensity.toString());
			var toIntensity:int = parseInt(vedge.data.@toIntensity.toString());
			
			if (fromIntensity > 0) {
				drawArrow(fP, tP);
			} 
			
			if (toIntensity > 0) {
				drawArrow(tP, fP);
			}
			
			_g.endFill();
			
			/* if the vgraph currently displays edgeLabels, then
			 * we need to update their coordinates */
			if(vedge.vgraph.displayEdgeLabels) {
				vedge.setEdgeLabelCoordinates(labelCoordinates(vedge));
			}
		}
		
		private function drawArrow(fP:Point, tP:Point):void {
			var edgeAngle:Number = Math.atan2(tP.y - fP.y,tP.x - fP.x);
			
			var mArrowBase:Point = Point.polar(Point.distance(tP,fP) - arrowHeadLength,edgeAngle);
			mArrowBase.offset(fP.x,fP.y);
		
			var lArrowBase:Point = Point.polar(arrowBaseSize / 2.9,(edgeAngle - (Math.PI / 2.0)));
			var rArrowBase:Point = Point.polar(arrowBaseSize / 2.9,(edgeAngle + (Math.PI / 2.0)));
			
			lArrowBase.offset(mArrowBase.x,mArrowBase.y);			
			rArrowBase.offset(mArrowBase.x,mArrowBase.y);
			
			_g.moveTo(tP.x, tP.y);
			_g.lineTo(lArrowBase.x, lArrowBase.y);
			_g.lineTo(rArrowBase.x, rArrowBase.y);
			_g.lineTo(tP.x, tP.y);
		}
	}
}
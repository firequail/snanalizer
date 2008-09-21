package sna
{
	import mx.collections.ArrayCollection;
	import mx.collections.IViewCursor;
	import mx.controls.ComboBox;
	
	public class DataComboBox extends ComboBox {
		
		public var dataField:String = "data";
		private var _unselectedLabel:String;
		
		public function DataComboBox() {
			super();
		}
		
		override public function set dataProvider(value:Object):void {
			if (_unselectedLabel == null || value == null) {
				super.dataProvider = value;
			} else {
				var unselected:Object = new Object();
				unselected[dataField] = null;
				unselected[labelField] = _unselectedLabel;
				super.dataProvider = new PromptArrayCollection([unselected],value as ArrayCollection);
			}
		}
		
		public function set unselectedLabel(value:String):void {
			_unselectedLabel = value;
		}
		
		public function set selectedData(value:Object):void {
			if (value != null && selectedIndex == -1) {
				if (collection && collection.length) {
					var cursor:IViewCursor = collection.createCursor();
					while (!cursor.afterLast) {
						var obj:Object = cursor.current;
						
						if ( obj[dataField] == value ) {
							super.selectedItem = obj;
							return;
						}
						cursor.moveNext();
					}
				}
			}
		}
		
		[Bindable("change")]
	    [Bindable("collectionChange")]
	    [Bindable("valueCommit")]
		public function get selectedData():Object {
			return selectedItem[dataField];
		}
	}
}
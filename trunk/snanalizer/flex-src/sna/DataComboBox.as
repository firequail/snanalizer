package sna
{
	import mx.collections.IViewCursor;
	import mx.controls.ComboBox;
	import mx.utils.ObjectUtil;
	
	public class DataComboBox extends ComboBox {
		
		public var dataField:String = "data";
		
		public function DataComboBox() {
			super();
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
		
		[Bindable]
		public function get selectedData():Object {
			return selectedItem[dataField];
		}
	}
}
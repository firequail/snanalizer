package  sna
{
import mx.collections.ArrayCollection;
import mx.collections.ListCollectionView;
import mx.utils.StringUtil;

public class PromptArrayCollection extends ArrayCollection
{
	private var prompts:ArrayCollection;
	private var original:ArrayCollection;

	public function PromptArrayCollection(prompts:Array, original:ArrayCollection)
	{
		this.prompts = new ArrayCollection(prompts);
		this.original = original;
	}

    override public function getItemAt(index:int, prefetch:int=0):Object
    {
        if (index < 0 || index >= length)
            throw new RangeError("invalid index", index);

		if (index < prompts.length)
			return prompts.getItemAt(index, prefetch);

		return original.getItemAt(index - prompts.length, prefetch);
    }

    override public function get length():int
    {
		return prompts.length + original.length;
    }

	// TO DO:  Implement IList modification methods and support change notification
}

}


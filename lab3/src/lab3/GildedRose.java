package lab3;

class GildedRose {
	private ItemCollection items;

    public GildedRose(Item[] items) {
        this.items = new ItemCollection(items);
    }

    public void updateQuality() {
        items.updateQuality();
    }
}

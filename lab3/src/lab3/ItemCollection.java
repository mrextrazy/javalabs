package lab3;
import java.util.Objects;
public class ItemCollection {
    private Item[] items;
    private ItemQualityManager qualityManager;

    public ItemCollection(Item[] items) {
        this.items = items;
        this.qualityManager = new ItemQualityManager();
    }

    public void updateQuality() {
        for (Integer i = 0; i < items.length; i++) {
            Item item = items[i];
            Boolean isAgedBrie = Objects.equals(item.name, "Aged Brie");
            Boolean isBackstagePass = Objects.equals(item.name, "Backstage passes to a TAFKAL80ETC concert");
            Boolean isSulfuras = Objects.equals(item.name, "Sulfuras, Hand of Ragnaros");

            if (!isAgedBrie && !isBackstagePass && !isSulfuras) {
                qualityManager.decreaseQuality(item);
            }

            if (isAgedBrie || isBackstagePass) {
                qualityManager.increaseQualityIfPossible(item);
            }
            if (isBackstagePass) {
                qualityManager.applyBackstagePassRules(item);
            }
            if (!isSulfuras) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                qualityManager.applyExpiredItemRules(item, isAgedBrie, isBackstagePass, isSulfuras);
            }
        }
    }
}
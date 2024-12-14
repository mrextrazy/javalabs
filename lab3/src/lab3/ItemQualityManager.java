package lab3;

public class ItemQualityManager {
    public void increaseQualityIfPossible(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    public void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    public void applyBackstagePassRules(Item item) {
        if (item.sellIn < 11) {
            increaseQualityIfPossible(item);
        }
        if (item.sellIn < 6) {
            increaseQualityIfPossible(item);
        }
    }

    public void applyExpiredItemRules(Item item, Boolean isAgedBrie, Boolean isBackstagePass, Boolean isSulfuras) {
        if (!isAgedBrie && !isBackstagePass && !isSulfuras) {
            decreaseQuality(item);
        }

        if (isBackstagePass) {
            item.quality = 0;
        }

        if (isAgedBrie) {
            increaseQualityIfPossible(item);
        }
    }
}

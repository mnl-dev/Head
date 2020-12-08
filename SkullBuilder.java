public class SkullBuilder {

    private ItemStack itemStack;
    private SkullMeta skullMeta;

    public SkullBuilder(Material material, int subID) {
        itemStack = new ItemStack(material, 1, (short)subID);
        skullMeta = (SkullMeta) itemStack.getItemMeta();
    }

    public SkullBuilder(Material material) {
        this(material, (short)0);
    }

    public SkullBuilder setDisplayName(String displayName) {
        skullMeta.setDisplayName(displayName);
        return this;
    }

    public SkullBuilder setLore(String... lore) {
        skullMeta.setLore(Arrays.asList(lore));
        return this;
    }

    public SkullBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public SkullBuilder setOwner(String owner) {
        skullMeta.setOwner(owner);
        return this;
    }

    public void addEnchantment(Enchantment enchantment, int lvl) {
        itemStack.addEnchantment(enchantment, lvl);
    }

    public ItemStack build() {
        itemStack.setItemMeta(skullMeta);
        return itemStack;
    }

}

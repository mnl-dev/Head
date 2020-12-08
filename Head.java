package de.mccrimehd.citybuild.heads;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import de.mccrimehd.citybuild.CityBuild;
import de.mccrimehd.citybuild.utils.SkullBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.lang.reflect.Field;
import java.util.UUID;

public class Head {

    private String name;
    private String textures;
    private ItemStack itemStack;

    public Head(String name, String textures) {
        this.name = name;
        this.textures = textures;

        itemStack = new SkullBuilder(Material.getMaterial(397), 3).build();
        SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), null);
        gameProfile.getProperties().put("textures", new Property("textures", textures));

        try {
            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, gameProfile);

        }
        catch (IllegalArgumentException|NoSuchFieldException|SecurityException | IllegalAccessException error) {
            error.printStackTrace();
        }
        itemStack.setItemMeta(skullMeta);
        CityBuild.getInstance().getHeads().put(name, this);

    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}

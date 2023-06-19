package rs.newplugin.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.AbstractVillager;
import org.bukkit.entity.Item;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class VillagerEvents implements Listener {

    @EventHandler
    public void CustomVillagerTrades(VillagerAcquireTradeEvent e){
        // Get the villager you want to change the trades of
        AbstractVillager villager = e.getEntity();
        Villager villager1 = (Villager) villager;
        Villager.Profession p = villager1.getProfession();
        villager1.shakeHead();
        Bukkit.broadcastMessage("Villager Event");
        if(p == Villager.Profession.LIBRARIAN){

            // Create new trades using the MerchantRecipe class
            if(villager1.getVillagerLevel() == 5 && villager1.getRecipeCount() < 15) {
                MerchantRecipe recipe1 = new MerchantRecipe(new ItemStack((Material.INK_SAC), 5), 20);
                recipe1.addIngredient(new ItemStack(Material.EMERALD, 2));
                recipe1.setVillagerExperience(7);
                MerchantRecipe recipe2 = new MerchantRecipe(new ItemStack((Material.NAME_TAG), 1), 20);
                recipe2.addIngredient(new ItemStack(Material.EMERALD, 13));
                recipe2.setVillagerExperience(7);
                MerchantRecipe recipe3 = new MerchantRecipe(new ItemStack((Material.QUARTZ_BLOCK), 15), 10);
                recipe3.addIngredient(new ItemStack(Material.EMERALD, 3));
                recipe3.setVillagerExperience(7);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>(villager1.getRecipes());
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);
            }
            else if(villager1.getVillagerLevel() == 4 && villager1.getRecipeCount() < 12) {

                List<ItemStack> priceAndrecipe = GenerateNormalEnchBook(villager1.getProfession());
                MerchantRecipe recipe1 = new MerchantRecipe(priceAndrecipe.get(0), 5);
                recipe1.addIngredient(priceAndrecipe.get(1));
                recipe1.setVillagerExperience(12);
                MerchantRecipe recipe2 = new MerchantRecipe(new ItemStack((Material.LANTERN), 5), 20);
                recipe2.addIngredient(new ItemStack(Material.EMERALD, 12));
                recipe2.setVillagerExperience(8);
                MerchantRecipe recipe3 = new MerchantRecipe(new ItemStack((Material.EXPERIENCE_BOTTLE), 10), 10);
                recipe3.addIngredient(new ItemStack(Material.EMERALD, 6));
                recipe3.setVillagerExperience(8);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>(villager1.getRecipes());
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);
            }
            else if(villager1.getVillagerLevel() == 3 && villager1.getRecipeCount() < 9) {

                List<ItemStack> priceAndrecipe = GenerateInfinityOrMending();
                MerchantRecipe recipe1 = new MerchantRecipe(priceAndrecipe.get(0), 5);
                recipe1.addIngredient(priceAndrecipe.get(1));
                recipe1.setVillagerExperience(7);
                MerchantRecipe recipe2 = new MerchantRecipe(new ItemStack((Material.WRITABLE_BOOK), 1), 20);
                recipe2.addIngredient(new ItemStack(Material.EMERALD, 3));
                recipe2.setVillagerExperience(7);
                MerchantRecipe recipe3 = new MerchantRecipe(new ItemStack((Material.CLOCK), 1), 10);
                recipe3.addIngredient(new ItemStack(Material.EMERALD, 5));
                recipe3.setVillagerExperience(7);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>(villager1.getRecipes());
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);
            }
            else if(villager1.getVillagerLevel() == 2 && villager1.getRecipeCount() < 6) {

                List<ItemStack> priceAndrecipe = GenerateNormalEnchBook(villager1.getProfession());
                MerchantRecipe recipe1 = new MerchantRecipe(priceAndrecipe.get(0), 5);
                recipe1.addIngredient(priceAndrecipe.get(1));
                recipe1.setVillagerExperience(7);
                MerchantRecipe recipe2 = new MerchantRecipe(new ItemStack((Material.PAPER), 30), 20);
                recipe2.addIngredient(new ItemStack(Material.EMERALD, 4));
                recipe2.setVillagerExperience(7);
                MerchantRecipe recipe3 = new MerchantRecipe(new ItemStack((Material.COMPASS), 1), 10);
                recipe3.addIngredient(new ItemStack(Material.EMERALD, 5));
                recipe3.setVillagerExperience(7);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>(villager1.getRecipes());
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);
            } else if (villager1.getVillagerLevel() == 1  && villager1.getRecipeCount() < 3) {
                MerchantRecipe recipe1 = new MerchantRecipe(new ItemStack((Material.BOOK), 5), 10);
                recipe1.addIngredient(new ItemStack(Material.PAPER, 25));
                recipe1.setVillagerExperience(2);
                MerchantRecipe recipe2 = new MerchantRecipe(new ItemStack((Material.GLASS), 10), 20);
                recipe2.addIngredient(new ItemStack(Material.EMERALD, 3));
                recipe2.setVillagerExperience(2);


                List<ItemStack> priceAndrecipe = GenerateNormalEnchBook(villager1.getProfession());
                MerchantRecipe recipe3 = new MerchantRecipe(priceAndrecipe.get(0), 5);
                recipe3.addIngredient(priceAndrecipe.get(1));
                recipe3.setVillagerExperience(5);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>();
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);

            }


        }
        else if (p == Villager.Profession.ARMORER) {
            // Create new trades using the MerchantRecipe class
            if(villager1.getVillagerLevel() == 5 && villager1.getRecipeCount() < 15) {
                List<ItemStack> priceAndrecipe = GenerateArmor("diamond",2);
                MerchantRecipe recipe1 = new MerchantRecipe(priceAndrecipe.get(0), 20);
                recipe1.addIngredient(priceAndrecipe.get(1));
                recipe1.setVillagerExperience(15);
                priceAndrecipe = GenerateArmor("diamond",3);
                MerchantRecipe recipe2 = new MerchantRecipe(priceAndrecipe.get(0), 20);
                recipe2.addIngredient(priceAndrecipe.get(1));
                recipe2.setVillagerExperience(15);

                MerchantRecipe recipe3 = new MerchantRecipe(new ItemStack((Material.NETHERITE_INGOT), 1), 10);
                recipe3.addIngredient(new ItemStack(Material.EMERALD, 45));
                recipe3.setVillagerExperience(7);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>(villager1.getRecipes());
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);
            }
            else if(villager1.getVillagerLevel() == 4 && villager1.getRecipeCount() < 12) {

                MerchantRecipe recipe1 = new MerchantRecipe(new ItemStack((Material.COPPER_BLOCK), 4), 20);
                recipe1.addIngredient(new ItemStack(Material.EMERALD, 9));
                recipe1.setVillagerExperience(8);
                List<ItemStack> priceAndrecipe = GenerateArmor("diamond",0);
                MerchantRecipe recipe2 = new MerchantRecipe(priceAndrecipe.get(0), 20);
                recipe2.addIngredient(priceAndrecipe.get(1));
                recipe2.setVillagerExperience(15);
                priceAndrecipe = GenerateArmor("diamond",1);
                MerchantRecipe recipe3 = new MerchantRecipe(priceAndrecipe.get(0), 20);
                recipe2.addIngredient(priceAndrecipe.get(1));
                recipe2.setVillagerExperience(15);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>(villager1.getRecipes());
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);
            }
            else if(villager1.getVillagerLevel() == 3 && villager1.getRecipeCount() < 9) {

                MerchantRecipe recipe1 = new MerchantRecipe(new ItemStack(Material.DIAMOND, 1), 10);
                recipe1.addIngredient(new ItemStack(Material.EMERALD, 5));
                recipe1.setVillagerExperience(8);
                MerchantRecipe recipe2 = new MerchantRecipe(new ItemStack((Material.SHIELD), 1), 20);
                recipe2.addIngredient(new ItemStack(Material.EMERALD, 3));
                recipe2.setVillagerExperience(7);
                MerchantRecipe recipe3 = new MerchantRecipe(new ItemStack((Material.TURTLE_HELMET), 1), 10);
                recipe3.addIngredient(new ItemStack(Material.EMERALD, 12));
                recipe3.setVillagerExperience(7);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>(villager1.getRecipes());
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);
            }
            else if(villager1.getVillagerLevel() == 2 && villager1.getRecipeCount() < 6) {

                List<ItemStack> priceAndrecipe = GenerateNormalEnchBook(villager1.getProfession());
                MerchantRecipe recipe1 = new MerchantRecipe(priceAndrecipe.get(0), 5);
                recipe1.addIngredient(priceAndrecipe.get(1));
                recipe1.setVillagerExperience(7);
                MerchantRecipe recipe2 = new MerchantRecipe(new ItemStack((Material.EMERALD), 5), 20);
                recipe2.addIngredient(new ItemStack(Material.IRON_INGOT, 4));
                recipe2.setVillagerExperience(7);
                MerchantRecipe recipe3 = new MerchantRecipe(new ItemStack((Material.BELL), 1), 10);
                recipe3.addIngredient(new ItemStack(Material.EMERALD, 6));
                recipe3.setVillagerExperience(7);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>(villager1.getRecipes());
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);
            } else if (villager1.getVillagerLevel() == 1  && villager1.getRecipeCount() < 3) {
                MerchantRecipe recipe1 = new MerchantRecipe(new ItemStack((Material.COAL), 12), 10);
                recipe1.addIngredient(new ItemStack(Material.EMERALD, 3));
                recipe1.setVillagerExperience(2);

                List<ItemStack> priceAndrecipe = GenerateArmor("iron",0);
                MerchantRecipe recipe2 = new MerchantRecipe(priceAndrecipe.get(0), 20);
                recipe2.addIngredient(priceAndrecipe.get(1));
                recipe2.setVillagerExperience(5);
                priceAndrecipe = GenerateArmor("iron",0);
                MerchantRecipe recipe3 = new MerchantRecipe(priceAndrecipe.get(0), 5);
                recipe3.addIngredient(priceAndrecipe.get(1));
                recipe3.setVillagerExperience(5);

                // Add the trades to the villager's trading list
                List<MerchantRecipe> recipes = new ArrayList<MerchantRecipe>();
                recipes.add(recipe1);
                recipes.add(recipe2);
                recipes.add(recipe3);
                villager1.setRecipes(recipes);

                e.setCancelled(true);

            }
        }
        //Villager with CopyPaste are extenable for every profession
        e.setCancelled(true);

    }
    public  List<ItemStack> GenerateTools(String resource) {
        List<ItemStack> recipeAndPrice = new ArrayList<>();
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemStack price = new ItemStack(Material.EMERALD);
        EnchantmentStorageMeta enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
        int emeraldprice = 1;

        int result = RandomNumber(0, 3);

        if (resource.equals("iron")) {
            switch (result) {
                case 0:
                    item.setType(Material.IRON_AXE);
                    break;
                case 1:
                    item.setType(Material.IRON_SHOVEL);
                    break;
                case 2:
                    item.setType(Material.IRON_PICKAXE);
                    break;
                default:
                    item.setType(Material.IRON_HOE);
                    break;
            }
            emeraldprice = 4;
        }else if (resource.equals("diamond")) {
            switch (result) {
                case 0:
                    item.setType(Material.DIAMOND_AXE);
                    enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
                    item.setItemMeta(EnchantArmor(enchStoreMeta));
                    break;
                case 1:
                    item.setType(Material.DIAMOND_SHOVEL);
                    enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
                    item.setItemMeta(EnchantArmor(enchStoreMeta));
                    break;
                case 2:
                    item.setType(Material.DIAMOND_PICKAXE);
                    enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
                    item.setItemMeta(EnchantArmor(enchStoreMeta));
                    break;
                default:
                    item.setType(Material.DIAMOND_HOE);
                    enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
                    item.setItemMeta(EnchantArmor(enchStoreMeta));
                    break;
            }
            emeraldprice = 25;

        }
        price.setAmount(emeraldprice);
        recipeAndPrice.add(item);
        recipeAndPrice.add(price);
        return recipeAndPrice;
    }
    public EnchantmentStorageMeta EnchantTools(EnchantmentStorageMeta enchMeta){
        int result = RandomNumber(0, 3);
        int Level = 0;
        switch (result) {
            case 0:
                Level = RandomNumber(3, 6);
                enchMeta.addStoredEnchant(Enchantment.DURABILITY, Level, true);
                break;
            case 1:
                Level = RandomNumber(3, 6);
                enchMeta.addStoredEnchant(Enchantment.DIG_SPEED, Level, true);
                break;
            case 2:
                Level = RandomNumber(3, 6);
                enchMeta.addStoredEnchant(Enchantment.SILK_TOUCH, 1, true);
                break;
            default:
                Level = RandomNumber(1, 4);
                enchMeta.addStoredEnchant(Enchantment.LOOT_BONUS_BLOCKS, Level, true);
                break;
        }
        return enchMeta;
    }
    public  List<ItemStack> GenerateArmor(String resource, Integer diamondGearPiece){
        List<ItemStack> recipeAndPrice = new ArrayList<>();
        ItemStack item = new ItemStack(Material.BARRIER);
        ItemStack price = new ItemStack(Material.EMERALD);
        EnchantmentStorageMeta enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
        int emeraldprice = 1;

        int result = RandomNumber(0, 3);

        if(resource.equals("iron")){
            switch (result){
                case 0:
                    item.setType(Material.IRON_HELMET);
                    break;
                case 1:
                    item.setType(Material.IRON_CHESTPLATE);
                    break;
                case 2:
                    item.setType(Material.IRON_LEGGINGS);
                    break;
                default:
                    item.setType(Material.IRON_BOOTS);
                    break;
            }
            emeraldprice = 4;
        }
        else if(resource.equals("chain")){
            switch (result){
                case 0:
                    item.setType(Material.CHAINMAIL_HELMET);
                    break;
                case 1:
                    item.setType(Material.CHAINMAIL_CHESTPLATE);
                    break;
                case 2:
                    item.setType(Material.CHAINMAIL_LEGGINGS);
                    break;
                default:
                    item.setType(Material.CHAINMAIL_BOOTS);
                    break;
            }
            emeraldprice = 7;
        }
        else if(resource.equals("diamond")){
            switch (diamondGearPiece){
                case 0:
                    item.setType(Material.DIAMOND_HELMET);
                    enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
                    item.setItemMeta(EnchantArmor(enchStoreMeta));
                    break;
                case 1:
                    item.setType(Material.DIAMOND_CHESTPLATE);
                    enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
                    item.setItemMeta(EnchantArmor(enchStoreMeta));
                    break;
                case 2:
                    item.setType(Material.DIAMOND_LEGGINGS);
                    enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
                    item.setItemMeta(EnchantArmor(enchStoreMeta));
                    break;
                default:
                    item.setType(Material.DIAMOND_BOOTS);
                    enchStoreMeta = (EnchantmentStorageMeta) item.getItemMeta();
                    item.setItemMeta(EnchantArmor(enchStoreMeta));
                    break;
            }
            emeraldprice = 25;
        }

        price.setAmount(emeraldprice);
        recipeAndPrice.add(item);
        recipeAndPrice.add(price);
        return recipeAndPrice;
    }
    public EnchantmentStorageMeta EnchantArmor(EnchantmentStorageMeta enchMeta){
        int result = RandomNumber(0, 10);
        int Level = 0;
        switch (result) {
            case 0:
                Level = RandomNumber(3, 6);
                enchMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Level, true);
                break;
            case 1:
                Level = RandomNumber(3, 6);
                enchMeta.addStoredEnchant(Enchantment.PROTECTION_PROJECTILE, Level, true);
                break;
            case 2:
                Level = RandomNumber(3, 6);
                enchMeta.addStoredEnchant(Enchantment.PROTECTION_EXPLOSIONS, Level, true);
                break;
            case 3:
                Level = RandomNumber(3, 6);
                enchMeta.addStoredEnchant(Enchantment.PROTECTION_FIRE, Level, true);
                break;
            case 4:
                Level = RandomNumber(3, 6);
                enchMeta.addStoredEnchant(Enchantment.THORNS, Level, true);
                break;
            default:
                Level = RandomNumber(1, 4);
                enchMeta.addStoredEnchant(Enchantment.DURABILITY, Level, true);
                break;
        }
        return enchMeta;
    }
    public  List<ItemStack> GenerateInfinityOrMending(){
        List<ItemStack> recipeAndPrice = new ArrayList<>();
        ItemStack price = new ItemStack(Material.EMERALD);
        int emeraldprice = 1;
        ItemStack EnchBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta enchStoreMeta = (EnchantmentStorageMeta) EnchBook.getItemMeta();

        int result = RandomNumber(0, 1);

        if(result == 1){
            enchStoreMeta.addStoredEnchant(Enchantment.ARROW_INFINITE, 1, true);
            emeraldprice = 23;
        }
        else {
            enchStoreMeta.addStoredEnchant(Enchantment.MENDING, 1, true);
            emeraldprice = 31;
        }
        price.setAmount(emeraldprice);
        EnchBook.setItemMeta(enchStoreMeta);
        recipeAndPrice.add(EnchBook);
        recipeAndPrice.add(price);
        return recipeAndPrice;
    }
    public List<ItemStack> GenerateNormalEnchBook(Villager.Profession prof) {
        //FIXME Following Echantments to add to the concrete Villagers:
        // - Looting, SilkTouch & Fortune to Toolsmith
        // - Sharpness, BaneOfAthropods & Smite + Knockback & Sweeping Edge to Weaponsmith
        // - Power, Multishot, QuickCharge & Punch + Impaling & Piercing to Fletcher
        // - FireProt, ExplosProt & ProjProt + Thorns to Armorsmith
        // - Loyalty, Flame, FireAspect, SoulSpeed, FrostWalker, DepthStrider, Channeling to Librarian
        // - Mending & Infinity to Libririan Level 2/3/4
        // - Lure & Luck of the Sea + AquaAffinity + Respiration to Fisher
        // - All Books set upped, must only be integrated into the Trades

        List<ItemStack> recipeAndPrice = new ArrayList<ItemStack>();
        ItemStack price = new ItemStack(Material.EMERALD);
        int emeraldprice = 1;
        ItemStack EnchBook = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta enchStoreMeta = (EnchantmentStorageMeta) EnchBook.getItemMeta();

        if (prof == Villager.Profession.LIBRARIAN) {
            int result = RandomNumber(0, 10);
            int Level = 0;
            switch (result) {
                case 0:
                    Level = RandomNumber(1, 4);
                    enchStoreMeta.addStoredEnchant(Enchantment.DURABILITY, Level, true);
                    emeraldprice = 12 + 4 * Level;
                    break;
                case 1:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Level, true);
                    emeraldprice = 10 + 5 * Level;
                    break;
                case 2:
                    enchStoreMeta.addStoredEnchant(Enchantment.CHANNELING, 1, true);
                    emeraldprice = 16;
                    break;
                case 3:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.PROTECTION_FALL, Level, true);
                    emeraldprice = (21 + 5 * Level);
                    break;
                case 4:
                    enchStoreMeta.addStoredEnchant(Enchantment.ARROW_FIRE, 1, true);
                    emeraldprice = (24);
                    break;
                case 5:
                    Level = RandomNumber(1, 3);
                    enchStoreMeta.addStoredEnchant(Enchantment.FIRE_ASPECT, Level, true);
                    emeraldprice = (12 + 6 * Level);
                    break;
                case 6:
                    Level = RandomNumber(1, 3);
                    enchStoreMeta.addStoredEnchant(Enchantment.SOUL_SPEED, Level, true);
                    emeraldprice = (8 + 7 * Level);
                    break;
                case 7:
                    Level = RandomNumber(1, 3);
                    enchStoreMeta.addStoredEnchant(Enchantment.FROST_WALKER, Level, true);
                    emeraldprice = (8 + 7 * Level);
                    break;
                case 8:
                    Level = RandomNumber(1, 4);
                    enchStoreMeta.addStoredEnchant(Enchantment.DEPTH_STRIDER, Level, true);
                    emeraldprice = (8 + 5 * Level);
                    break;
                case 9:
                    enchStoreMeta.addStoredEnchant(Enchantment.LOYALTY, 1, true);
                    emeraldprice = (16);
                    break;
                default:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.DIG_SPEED, Level, true);
                    emeraldprice = (5 * Level);
                    break;
            }
        }
        else if (prof == Villager.Profession.TOOLSMITH) {
            int result = RandomNumber(0, 2);
            int Level = 0;
            switch (result) {
                case 0:
                    Level = RandomNumber(1, 4);
                    enchStoreMeta.addStoredEnchant(Enchantment.LOOT_BONUS_MOBS, Level, true);
                    emeraldprice = 12 + 8 * Level;
                    break;
                case 1:
                    Level = RandomNumber(1, 4);
                    enchStoreMeta.addStoredEnchant(Enchantment.LOOT_BONUS_BLOCKS, Level, true);
                    emeraldprice = 14 + 7 * Level;
                    break;
                default:
                    enchStoreMeta.addStoredEnchant(Enchantment.SILK_TOUCH, 1, true);
                    emeraldprice = 20;
                    break;
            }
        }
        else if (prof == Villager.Profession.WEAPONSMITH) {
            int result = RandomNumber(0, 4);
            int Level = 0;
            switch (result) {
                case 0:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.DAMAGE_ALL, Level, true);
                    emeraldprice = 4 + 7 * Level;
                    break;
                case 1:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.DAMAGE_ARTHROPODS, Level, true);
                    emeraldprice = 4 + 5 * Level;
                    break;
                case 2:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.DAMAGE_UNDEAD, Level, true);
                    emeraldprice = 4 + 5 * Level;
                    break;
                case 3:
                    Level = RandomNumber(1, 3);
                    enchStoreMeta.addStoredEnchant(Enchantment.KNOCKBACK, Level, true);
                    emeraldprice = 3 + 7 * Level;
                    break;
                default:
                    Level = RandomNumber(1, 4);
                    enchStoreMeta.addStoredEnchant(Enchantment.SWEEPING_EDGE, Level, true);
                    emeraldprice = 7 + 6 * Level;
                    break;
            }
        }
        else if (prof == Villager.Profession.FLETCHER) {
            int result = RandomNumber(0, 5);
            int Level = 0;
            switch (result) {
                case 0:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.ARROW_DAMAGE, Level, true);
                    emeraldprice = 6 + 8 * Level;
                    break;
                case 1:
                    enchStoreMeta.addStoredEnchant(Enchantment.MULTISHOT, 1, true);
                    emeraldprice = 18;
                    break;
                case 2:
                    Level = RandomNumber(1, 4);
                    enchStoreMeta.addStoredEnchant(Enchantment.QUICK_CHARGE, Level, true);
                    emeraldprice = 5 + 6 * Level;
                    break;
                case 3:
                    Level = RandomNumber(1, 3);
                    enchStoreMeta.addStoredEnchant(Enchantment.ARROW_KNOCKBACK, Level, true);
                    emeraldprice = 5 + 8 * Level;
                    break;
                case 4:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.IMPALING, Level, true);
                    emeraldprice = 4 + 5 * Level;
                    break;
                default:
                    Level = RandomNumber(1, 5);
                    enchStoreMeta.addStoredEnchant(Enchantment.PIERCING, Level, true);
                    emeraldprice = 3 + 7 * Level;
                    break;
            }
        }
        else if (prof == Villager.Profession.ARMORER) {
            int result = RandomNumber(0, 4);
            int Level = 0;
            switch (result) {
                case 0:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, Level, true);
                    emeraldprice = 8 + 4 * Level;
                    break;
                case 1:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.PROTECTION_FIRE, Level, true);
                    emeraldprice = 11 + 6 * Level;
                    break;
                case 2:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.PROTECTION_EXPLOSIONS, Level, true);
                    emeraldprice = 11 + 6 * Level;
                    break;
                case 3:
                    Level = RandomNumber(1, 6);
                    enchStoreMeta.addStoredEnchant(Enchantment.PROTECTION_PROJECTILE, Level, true);
                    emeraldprice = 11 + 6 * Level;
                    break;
                default:
                    Level = RandomNumber(1, 4);
                    enchStoreMeta.addStoredEnchant(Enchantment.THORNS, Level, true);
                    emeraldprice = 7 + 7 * Level;
                    break;
            }
        }
        else if (prof == Villager.Profession.FISHERMAN) {
            int result = RandomNumber(0, 2);
            int Level = 0;
            switch (result) {
                case 0:
                    Level = RandomNumber(1, 5);
                    enchStoreMeta.addStoredEnchant(Enchantment.LURE, Level, true);
                    emeraldprice = 8 + 5 * Level;
                    break;
                case 1:
                    Level = RandomNumber(1, 4);
                    enchStoreMeta.addStoredEnchant(Enchantment.LUCK, Level, true);
                    emeraldprice = 7 + 6 * Level;
                    break;
                case 2:
                    Level = RandomNumber(1, 4);
                    enchStoreMeta.addStoredEnchant(Enchantment.OXYGEN, Level, true);
                    emeraldprice = 11 + 6 * Level;
                    break;
                default:
                    enchStoreMeta.addStoredEnchant(Enchantment.WATER_WORKER, 1, true);
                    emeraldprice = 19;
                    break;
            }
        }
        price.setAmount(emeraldprice);
        EnchBook.setItemMeta(enchStoreMeta);
        recipeAndPrice.add(EnchBook);
        recipeAndPrice.add(price);
        return recipeAndPrice;
    }
    public int RandomNumber(int low, int high){
        Random rnd = new Random();
        int level = rnd.nextInt(high-low) + low;
        return level;
    }



}



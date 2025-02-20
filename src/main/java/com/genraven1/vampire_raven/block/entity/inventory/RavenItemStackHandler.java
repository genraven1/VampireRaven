package com.genraven1.vampire_raven.block.entity.inventory;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import org.apache.commons.lang3.ArrayUtils;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.IntStream;

@EqualsAndHashCode(callSuper = true)
@Data
public class RavenItemStackHandler extends ItemStackHandler {
    private final Runnable onContentsChanged;
    private final Map<Integer, Integer> slotSizeMap;
    private BiFunction<Integer, ItemStack, Boolean> slotValidator = null;
    private int maxStackSize = 64;
    private int[] outputSlots = null;

    public RavenItemStackHandler(int size) {
        this(size, null);
    }

    public RavenItemStackHandler(int size, Runnable onContentsChanged) {
        super(size);
        this.onContentsChanged = onContentsChanged;
        this.slotSizeMap = new HashMap<>();
    }

    @Override
    public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
        return getOutputSlots() != null && ArrayUtils.contains(getOutputSlots(), slot) ? stack : super.insertItem(slot, stack, simulate);
    }

    @Override
    public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
        return getOutputSlots() != null && !ArrayUtils.contains(getOutputSlots(), slot) ? ItemStack.EMPTY : super.extractItem(slot, amount, simulate);

    }

    @Override
    public int getSlotLimit(int slot) {
        return getSlotSizeMap().containsKey(slot) ? getSlotSizeMap().get(slot) : getMaxStackSize();
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        return getSlotValidator() == null || getSlotValidator().apply(slot, stack);
    }

    @Override
    protected void onContentsChanged(int slot) {
        if (getOnContentsChanged() != null) {
            getOnContentsChanged().run();
        }
    }

    public ItemStack insertItemSuper(int slot, ItemStack stack, boolean simulate) {
        return super.insertItem(slot, stack, simulate);
    }

    public ItemStack extractItemSuper(int slot, int amount, boolean simulate) {
        return super.extractItem(slot, amount, simulate);
    }

    public void setDefaultSlotLimit(int size) {
        this.maxStackSize = size;
    }

    public void addSlotLimit(int slot, int size) {
        this.slotSizeMap.put(slot, size);
    }

    public Container toIInventory() {
        return new SimpleContainer(this.stacks.toArray(new ItemStack[0]));
    }

    /**
     * Creates a deep copy of this BaseItemStackHandler, including new copies of the items
     *
     * @return the copy of this BaseItemStackHandler
     */
    public RavenItemStackHandler copy() {
        final RavenItemStackHandler ravenItemStackHandler = new RavenItemStackHandler(this.getSlots(), getOnContentsChanged());

        ravenItemStackHandler.setMaxStackSize(getMaxStackSize());
        ravenItemStackHandler.setSlotValidator(getSlotValidator());
        ravenItemStackHandler.setOutputSlots(getOutputSlots());

        getSlotSizeMap().forEach(ravenItemStackHandler::addSlotLimit);

        IntStream.range(0, this.getSlots()).forEach(i -> ravenItemStackHandler.setStackInSlot(i, this.getStackInSlot(i).copy()));

        return ravenItemStackHandler;
    }

    public static RavenItemStackHandler create(int size) {
        return create(size, builder -> {
        });
    }

    public static RavenItemStackHandler create(int size, Consumer<RavenItemStackHandler> builder) {
        return create(size, null, builder);
    }

    public static RavenItemStackHandler create(int size, Runnable onContentsChanged, Consumer<RavenItemStackHandler> builder) {
        final RavenItemStackHandler handler = new RavenItemStackHandler(size, onContentsChanged);
        builder.accept(handler);
        return handler;
    }
}
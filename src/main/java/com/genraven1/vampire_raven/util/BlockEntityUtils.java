package com.genraven1.vampire_raven.util;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

public final class BlockEntityUtils {
    public static void dispatchToNearbyPlayers(final BlockEntity tile) {
        var level = tile.getLevel();
        if (level == null)
            return;

        var packet = tile.getUpdatePacket();
        if (packet == null)
            return;

        var pos = tile.getBlockPos();

        level.players().stream().filter(player -> player instanceof ServerPlayer)
                .map(player -> (ServerPlayer) player)
                .filter(mPlayer -> isPlayerNearby(mPlayer.getX(), mPlayer.getZ(), pos.getX() + 0.5, pos.getZ() + 0.5))
                .forEach(mPlayer -> mPlayer.connection.send(packet));
    }

    public static void dispatchToNearbyPlayers(Level level, int x, int y, int z) {
        var tile = level.getBlockEntity(new BlockPos(x, y, z));
        if (tile != null) {
            dispatchToNearbyPlayers(tile);
        }
    }

    private static boolean isPlayerNearby(double x1, double z1, double x2, double z2) {
        return Math.hypot(x1 - x2, z1 - z2) < 64;
    }
}

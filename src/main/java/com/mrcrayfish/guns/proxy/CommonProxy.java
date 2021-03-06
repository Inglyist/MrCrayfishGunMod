package com.mrcrayfish.guns.proxy;

import com.mrcrayfish.guns.GunConfig;
import com.mrcrayfish.guns.event.CommonEvents;
import com.mrcrayfish.guns.network.PacketHandler;
import com.mrcrayfish.guns.network.message.MessageSyncProperties;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class CommonProxy
{
	public void preInit()
	{
		MinecraftForge.EVENT_BUS.register(new CommonEvents());
		MinecraftForge.EVENT_BUS.register(this);
		GunConfig.SERVER.aggroMobs.setExemptionClasses();
	}

	public void init() {}

	public void postInit() {}

	public void spawnParticle(EnumParticleTypes type, boolean ignoreRange, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {}

	public void showMuzzleFlash() {}

	public void playClientSound(SoundEvent sound) {}

	public void playClientSound(double posX, double posY, double posZ, SoundEvent event, SoundCategory category, float volume, float pitch) {}

	@SubscribeEvent
	public void onClientConnect(PlayerEvent.PlayerLoggedInEvent event)
	{
		if(event.player instanceof EntityPlayerMP)
		{
			PacketHandler.INSTANCE.sendTo(new MessageSyncProperties(), (EntityPlayerMP) event.player);
		}
	}

	public void createExplosionStunGrenade(double x, double y, double z) {}

	public boolean canShoot()
	{
		return false;
	}

	public boolean isZooming()
	{
		return false;
	}

	public void startReloadAnimation() {}
}

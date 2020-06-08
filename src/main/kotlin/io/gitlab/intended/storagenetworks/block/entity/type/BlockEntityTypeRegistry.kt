package io.gitlab.intended.storagenetworks.block.entity.type

import io.gitlab.intended.storagenetworks.block.BlockRegistry
import io.gitlab.intended.storagenetworks.block.ModBlock
import io.gitlab.intended.storagenetworks.block.entity.CableBlockEntity
import io.gitlab.intended.storagenetworks.block.entity.LinkCableBlockEntity
import io.gitlab.intended.storagenetworks.block.entity.MasterBlockEntity
import io.gitlab.intended.storagenetworks.block.entity.RequestBlockEntity
import net.minecraft.block.Block
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.util.registry.Registry
import java.util.function.Supplier

object BlockEntityTypeRegistry {

    val MASTER = c(BlockRegistry.MASTER) { MasterBlockEntity() }
    val REQUEST = c(BlockRegistry.REQUEST) { RequestBlockEntity() }

    val CABLE = c(BlockRegistry.CABLE) { CableBlockEntity() }
    val LINK_CABLE = c(BlockRegistry.LINK_CABLE) { LinkCableBlockEntity() }

    fun init() {
        r(BlockRegistry.MASTER, MASTER)
        r(BlockRegistry.REQUEST, REQUEST)

        r(BlockRegistry.CABLE, CABLE)
        r(BlockRegistry.LINK_CABLE, LINK_CABLE)
    }

    private fun r(modBlock: ModBlock, blockEntityType: BlockEntityType<out BlockEntity>) {
        Registry.register(Registry.BLOCK_ENTITY_TYPE, modBlock.id, blockEntityType)
    }

    private fun <T : BlockEntity> c(block: Block, function: () -> T): BlockEntityType<T> {
        return BlockEntityType.Builder.create(Supplier(function), block).build(null)
    }

}

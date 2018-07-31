package qwyll.bmbookrepair;

import com.google.common.eventbus.EventBus;
import net.minecraftforge.fml.common.*;

import java.util.Arrays;

public class BookRepairModContainer extends DummyModContainer {
    public BookRepairModContainer() {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = "bookrepair";
        meta.name = "BookRepair";
        meta.description = "Repairs Guide Api GuiBase Class";
        meta.version = "2.1.6";
        meta.authorList = Arrays.asList("Qwyll");
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller) {
        bus.register(this);
        return true;
    }

}

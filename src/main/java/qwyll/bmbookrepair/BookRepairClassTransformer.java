package qwyll.bmbookrepair;

import net.minecraft.launchwrapper.IClassTransformer;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class BookRepairClassTransformer implements IClassTransformer {

    private static final String[] classesBeingTransformed = {
            "amerifrance.guideapi.gui.GuiBase",
            "amerifrance.guideapi.GuideMod"
    };

    /**
     * Runs the class transformer when the current class is GuiBase or GuiMod
     * @return modified class byte array
     */
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        boolean isObfuscated = !name.equals(transformedName);
        int index = Arrays.asList(classesBeingTransformed).indexOf(transformedName);
        return index != -1 ? transform(index, basicClass, isObfuscated) : basicClass;
    }

    /**
     * Replaces version 2.1.6 GuiBase with 2.1.5 GuiBase.
     * @param index
     * @param classBeingTransformed
     * @param isObfuscated
     * @return
     */
    private static byte[] transform(int index, byte[] classBeingTransformed, boolean isObfuscated)
    {
        if (index == 0) { //Patch 2.1.6 GuiBase with 2.1.5 GuiBase
            System.out.println("[Qwyll Coremod] Transforming: " + classesBeingTransformed[index]);
            final String externalGuiBase = "GuiBaseObf.class";
            byte[] modifiedGuiBase = null;
            InputStream is = BookRepairClassTransformer.class.getResourceAsStream("/"+externalGuiBase); // Loads the 2.1.5 GuiBase from the JarFile

            try {
                modifiedGuiBase = org.apache.commons.io.IOUtils.toByteArray(is);
            } catch (IOException ignored) {
            }

            if (modifiedGuiBase == null) throw new NullPointerException();
            return modifiedGuiBase;
        } else if (index == 1) { //check if GuideMod is version 1.12-2.1.6-61 and crash if it's not.
            int versionStringOffset = 172;
            int versionStringLength = 13;
            byte[] versionStringBytes = Arrays.copyOfRange(classBeingTransformed,versionStringOffset, versionStringOffset+versionStringLength);
            String versionString = new String(versionStringBytes);
            if (!versionString.equals("1.12-2.1.6-61"))
                throw new RuntimeException("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                        "The mod BookRepair only works with GuideAPI version 1.12-2.1.6-61 as that is the only affected " +
                        "version. Please remove BookRepair to continue." +
                        "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
        return classBeingTransformed;
    }
}

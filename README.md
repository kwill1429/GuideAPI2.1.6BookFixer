This mod fixes a bug in GuideAPI version 2.1.6 where opening certain pages in a book would crash the game. 
This was caused by the removal of the methods renderToolTip and onGuiClosed between versions 2.1.5 and 2.1.6.
As these methods where removed and their respective base methods are not visible to external code (due to protected modifier),
it should be safe to re-add them with no issues. 

To re-add these methods, I simple replaced the 2.1.6 GuiBase.class with the 2.1.5 GuiBase.class since the only changes
between the versions were the removal of the methods.

Should this mod be used on a version of GuideAPI that isn't 2.1.6, the mod will crash and put a message in the log informing
the user to remove the mod.

The released jar is signed. The public key and signature can be found with the release. To verify the jar has
not been modified, [follow these instructions](https://docs.oracle.com/javase/tutorial/deployment/jar/verify.html). 
package com.stardust.quicksetting.reboot;

import com.stardust.quicksetting.tile.NoStateTileService;
import com.stardust.quicksetting.tool.Shell;

/**
 * Created by Stardust on 2017/1/20.
 */

public class RebootTileService extends NoStateTileService {

    public void onClick() {
        reboot();
    }

    private void reboot() {
        Shell.execCommand("reboot", true);
    }
}

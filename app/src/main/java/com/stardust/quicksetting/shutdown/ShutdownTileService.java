package com.stardust.quicksetting.shutdown;

import com.stardust.quicksetting.tile.NoStateTileService;

import java.io.IOException;

/**
 * Created by Stardust on 2017/1/20.
 */

public class ShutdownTileService extends NoStateTileService {

    public void onClick() {
        try {
            //FIXME not working!!!
            Runtime.getRuntime().exec(new String[]{"su", "-c", "reboot","-p"});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

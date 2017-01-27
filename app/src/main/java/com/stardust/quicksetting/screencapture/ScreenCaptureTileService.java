package com.stardust.quicksetting.screencapture;

import com.stardust.quicksetting.tile.NoStateTileService;

/**
 * Created by Stardust on 2017/1/19.
 */

public class ScreenCaptureTileService extends NoStateTileService {


    public void onClick() {
        ScreenCapture.captureByConfigMethod(this);
    }

}

package com.stardust.quicksetting.screenlock;

import com.stardust.quicksetting.tile.NoStateTileService;

/**
 * Created by Stardust on 2017/1/20.
 */

public class LockScreenTileService extends NoStateTileService {

    public void onClick() {
        lockScreen();
    }

    private void lockScreen() {
        ScreenLock.lockByDeviceManager(this);
    }
}

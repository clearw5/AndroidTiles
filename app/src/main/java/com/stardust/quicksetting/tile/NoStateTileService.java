package com.stardust.quicksetting.tile;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

/**
 * Created by Stardust on 2017/1/20.
 */

public class NoStateTileService extends TileService {

    private final boolean mState;

    public NoStateTileService(boolean stateToKeep){
        mState = stateToKeep;
    }

    public NoStateTileService(){
        this(true);
    }

    @Override
    public void onStartListening() {
        Tile tile = getQsTile();
        tile.setState(mState ? Tile.STATE_ACTIVE : Tile.STATE_INACTIVE);
        tile.updateTile();
    }

}

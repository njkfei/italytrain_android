package niejinkun.com.italytrain.utils;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Looper;

import niejinkun.com.italytrain.base.ConstantString;

import java.io.File;

/**
 * 用于保存图片后刷新图片媒体库
 */
public class MediaScannerConnectionClient implements MediaScannerConnection
        .MediaScannerConnectionClient {

    private boolean isSmallPic;
    private File newFile;
    private MediaScannerConnection mediaScannerConnection;

    public MediaScannerConnectionClient(boolean isSmallPic, File newFile) {
        this.isSmallPic = isSmallPic;
        this.newFile = newFile;
    }

    public void setMediaScannerConnection(MediaScannerConnection mediaScannerConnection) {
        this.mediaScannerConnection = mediaScannerConnection;
    }

    @Override
    public void onMediaScannerConnected() {
        mediaScannerConnection.scanFile(newFile.getAbsolutePath(),null);
    }

    @Override
    public void onScanCompleted(String path, Uri uri) {
        Looper.prepare();
        if (isSmallPic) {
            ShowToast.Short(ConstantString.SAVE_SMALL_SUCCESS + " \n相册" + File.separator + CacheUtil
                    .FILE_SAVE + File.separator + newFile.getName());
        } else {
            ShowToast.Short(ConstantString.SAVE_SUCCESS + " \n相册" + File.separator + niejinkun.com.italytrain.utils.CacheUtil
                    .FILE_SAVE + File.separator + newFile.getName());
        }
        Looper.loop();
    }
}
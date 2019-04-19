package com.umdcs4995.whiteboard;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;

import java.io.IOException;

import com.umdcs4995.whiteboard.uiElements.ErrorToast;

/**
 * This class will handle interfacing the camera with the app.
 * Created by Rob on 2/2/2016.
 */
public class CameraWb extends SurfaceView implements SurfaceHolder.Callback {

    //Private data members
    private Context context; //Contains a reference to the current application.  Set in constructor.
    private boolean cameraAvailable; //Flag to see if camera is available.
    private Camera camera; //Instance of the camera.
    private SurfaceHolder surfaceHolder; //This instan

    /**
     * Default constructor for the Camera class.  Please pass in a call to getApplicationContext()
     * method.
     * @param context
     */
    public CameraWb(Context context) {
        super(context); //Call the surface view to place the context.
        this.context = context;
        this.cameraAvailable = checkCameraAvailability(context);
        if(cameraAvailable) {
            try {
                if (Camera.getNumberOfCameras() > 1) {
                    camera = Camera.open(1);
                } else {
                    camera = Camera.open();
                }
            }catch(RuntimeException e) {
                Log.d("CameraError", "Runtime exception has occurred", e);
                camera = null;
            }
            catch (Exception e){
                Log.d("Error","Unexpected error has occurred while trying create the camera");
                Log.getStackTraceString(e);
                if(camera == null){
                    // do nothing
                }
                else{
                    // Stop the camera and release it to the system
                    camera.stopPreview();
                    camera.release();
                }

            }
        } else {
            camera = null;
        }

        // Install a SurfaceHolder.Callback so we get notified when the
        // underlying surface is created and destroyed.
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        // deprecated setting, but required on Android versions prior to 3.0
        surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);


    }


    /** Check if this device has a camera */
    private boolean checkCameraAvailability(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }


    //================ SURFACE METHODS ============================
    //These methods handle the view (the UI element) and handle how to display the camera.

    public void surfaceCreated(SurfaceHolder holder) {
        if(!cameraAvailable || camera == null) return; //Camera isn't working / on this device, so bail.

        // The Surface has been created, now tell the camera where to draw the preview.
        try {
            camera.setPreviewDisplay(holder);
            camera.startPreview();          // may throw IOException
        } catch (IOException e) {
            //the camera is not available (in use or does not exist)
            new ErrorToast(context, "Exception in CameraWB::surfaceCreated(..)");
        }
    }

    /**
     * called when the surface is destroyed
     * @param holder the surface holder that contains the camera view
     */
    public void surfaceDestroyed(SurfaceHolder holder) {
        // Called when the activity is destroyed.
        if(!cameraAvailable || camera == null) return; //Camera isn't working / on this device, so bail.

        camera.stopPreview();
        camera.release();
    }

    /**
     * called when the the surface is changed or rotated
     * @param holder
     * @param format
     * @param w
     * @param h
     */
    public void surfaceChanged(SurfaceHolder holder, int format, int w, int h) {
        if(!cameraAvailable || camera == null) return; //Camera isn't working / on this device, so bail.

        // If your preview can change or rotate, take care of those events here.
        // Make sure to stop the preview before resizing or reformatting it.

        if (surfaceHolder.getSurface() == null){
            // preview surface does not exist
            return;
        }

        // stop preview before making changes
        try {
            camera.stopPreview();
        } catch (Exception e){
            // ignore: tried to stop a non-existent preview
        }

        // set preview size and make any resize, rotate or
        // reformatting changes here
        Camera.Parameters parameters = camera.getParameters();
        Display display = ((WindowManager)context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();

        if(display.getRotation() == Surface.ROTATION_0)
        {
            parameters.setPreviewSize(h, w);
            camera.setDisplayOrientation(90);
        }

        if(display.getRotation() == Surface.ROTATION_90)
        {
            parameters.setPreviewSize(w, h);
        }

        if(display.getRotation() == Surface.ROTATION_180)
        {
            parameters.setPreviewSize(h, w);
        }

        if(display.getRotation() == Surface.ROTATION_270)
        {
            parameters.setPreviewSize(w, h);
            camera.setDisplayOrientation(180);
        }

        // start preview with new settings
        try {
            //Rotate the camera appropriately.
            camera.setPreviewDisplay(surfaceHolder);
            camera.startPreview();

        } catch (Exception e){
            //if an exception is thrown then stop the camera and release the camera back to the system
            camera.stopPreview();
            camera.release();
            new ErrorToast(context, "Exception in CameraWb::surfaceChanged(..)");
        }
    }

    /**
     * Coordinates the camera orientation with the display orientation.
     * @param degrees
     */
    public void setCameraOrientation(int degrees) {
        if(camera != null) {camera.setDisplayOrientation(degrees);}
        else {return;}
    }
}
